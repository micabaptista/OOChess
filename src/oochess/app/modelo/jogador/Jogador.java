package oochess.app.modelo.jogador;

import oochess.app.modelo.partida.CatalogoPartidas;
import oochess.app.OOChess;
import oochess.app.modelo.desafio.Desafio;
import oochess.app.facade.dto.DesafioDTO;
import oochess.app.facade.dto.PartidaDTO;
import oochess.app.modelo.partida.Partida;
import oochess.app.modelo.torneio.Torneio;

import java.util.*;
import java.util.stream.Collectors;

public class Jogador {
    private String username;
    private String password;
    private String discordUsername;
    private double elo;

    private final Map<String, Desafio> desafiosRecebidos = new HashMap<>();
    private final List<Desafio> desafiosCriados = new ArrayList<>();

    private final List<Partida> allPartidas = new ArrayList<>();
    private final List<Torneio> allTorneios = new ArrayList<>();
    // acho que nao faz sentido pq quando nos criamos uma partida nao estamos a adiciona-la aqui,
    // e anyway se for preciso bastar usar streams para ir buscar as partidas associadas a um jogador!


    public Jogador(String username, String password, String discordUsername) {
        this.username = username;
        this.password = password;
        this.discordUsername = discordUsername;
        this.elo = OOChess.getStrategy().getInitialElo();
    }

    public String getUsername() {
        return username;
    }

    public String getDiscordUsername() {
        return discordUsername;
    }

    public String getPassword() {
        return password;
    }

    public double getElo() {
        return elo;
    }

    public List<PartidaDTO> getLastFivePartidas() {
        return CatalogoPartidas.getInstance()
                .getCatalogoPartida()
                .stream()
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Desafio> getListaDesafiosPendentes() {
        return desafiosRecebidos.values()
                .stream()
                .filter(x -> !x.getResposta())
                .collect(Collectors.toList());
    }


    public Desafio getDesafio(String codigo) {
        return desafiosRecebidos.get(codigo);
    }

    public void setElo(double elo) {
        this.elo = elo;
    }

    public void increaseElo(double elo) {
        this.elo += elo;
    }

    public void decreaseElo(double elo) {
        this.elo -= elo;
    }


    public boolean eloNecessario(double d, int delta) {
        return Math.abs(d - this.elo) < delta;
    }

    public void adicionaDesafioEnviado(Desafio d) {
        desafiosCriados.add(d);
    }

    public void adicionaDesafioRecebido(Desafio d) {
        desafiosRecebidos.put(d.getCodigo(), d);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Jogador)) {
            return false;
        }

        Jogador jogador2 = (Jogador) obj;

        return this.username.equals(jogador2.getUsername());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + Objects.hash(username);
    }
}
