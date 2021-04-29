package oochess.app.modelo.partida;

import oochess.app.facade.dto.PartidaDTO;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CatalogoPartidas {

    private static CatalogoPartidas instance = null;
    private Map<String, Partida> catalogoPartida;

    private CatalogoPartidas() {
        catalogoPartida = new HashMap<>();
    }


    public static CatalogoPartidas getInstance() {
        if (CatalogoPartidas.instance == null) {
            instance = new CatalogoPartidas();
        }
        return instance;
    }

    /**
     * Get list of all partidas (dto)
     *
     * @return list of  all partidas (dto)
     */
    public List<PartidaDTO> getCatalogoPartida() {
        return this.catalogoPartida
                .values()
                .stream()
                .map(x -> new PartidaDTO(x.getCodigo(), x.getData(), x.getResultado()))
                .collect(Collectors.toList());
    }


    /**
     * Get list of all partidas espontâneas (dto)
     *
     * @return list of  all partidas espontâneas (dto)
     */
    private List<PartidaEspontanea> getPartidasEspontaneas() {
        return catalogoPartida
                .values()
                .stream()
                .filter(Partida::isEspontanea)
                .map(x -> (PartidaEspontanea) x)
                .collect(Collectors.toList());
    }

    /**
     * Get list of all partidas associated to a desafio (dto)
     *
     * @return list of  all partidas espontâneas (dto)
     */
    private List<PartidaDesafio> getPartidasDesafio() {
        return catalogoPartida
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

    public PartidaDesafio getPartida(String cod) {
        return getPartidasDesafio()
                .stream()
                .filter(x -> x.getDesafio().getCodigo().equals(cod))
                .limit(1)
                .collect(Collectors.toList())
                .get(0);
    }


    public void addPartida(Partida partida) {
        catalogoPartida.put(partida.getCodigo(), partida);
    }

}
