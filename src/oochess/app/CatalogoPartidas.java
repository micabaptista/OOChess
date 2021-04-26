package oochess.app;

import oochess.app.dtos.JogadorDTO;
import oochess.app.dtos.PartidaDTO;
import oochess.app.partida.Partida;
import oochess.app.partida.PartidaDesafio;
import oochess.app.partida.PartidaEspontanea;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CatalogoPartidas {

    private static CatalogoPartidas instance = null;
    private Map<String, Partida> catalogoPartidas;

    private CatalogoPartidas() {
        catalogoPartidas = new HashMap<>();
    }


    public static CatalogoPartidas getInstance() {
        if (CatalogoPartidas.instance == null) {
            instance = new CatalogoPartidas();
        }
        return instance;
    }

    public List<PartidaDTO> getCatalogoPartidas() {
        return this.catalogoPartidas
                .values()
                .stream()
                .map(x -> new PartidaDTO(x.getCodigo(), x.getData(), x.getResultado()))
                .collect(Collectors.toList());
    }


    private List<PartidaEspontanea> getPartidasEspontaneas() {
        return catalogoPartidas
                .values()
                .stream()
                .filter(Partida::isEspontanea)
                .map(x -> (PartidaEspontanea) x)
                .collect(Collectors.toList());
    }

    private List<PartidaDesafio> getPartidasDesafio() {
        return catalogoPartidas
                .values()
                .stream()
                .filter(x -> !x.isEspontanea())
                .map(x -> (PartidaDesafio) x)
                .collect(Collectors.toList());
    }

    public Optional<PartidaEspontanea> getPartida(String user, LocalDateTime data) {
        return getPartidasEspontaneas()
                .stream()
                .filter(x -> x.getData().equals(data) && x.getJogadorDesafiado().getUsername().equals(user))
                .findAny();
    }

    public Optional<PartidaDesafio> getPartida(String cod) {
        return getPartidasDesafio()
                .stream()
                .filter(x -> x.getDesafio().getCodigo().equals(cod))
                .findAny();
    }


    public void addPartida(Partida partida) {
        catalogoPartidas.put(partida.getCodigo(), partida);
    }

}
