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

    public Jogador(String username, String password, String discordUsername) {
        this.username = username;
        this.password = password;
        this.discordUsername = discordUsername;
        this.elo = OOChess.getStrategy().getInitialElo();
    }

    /**
     * Get last five matches played by the jogador
     *
     * @return list of last five matches played by the jogador
     * @ensures {@code getLastFivePartidas().size() > -1}
     */
    public List<PartidaDTO> getLastFivePartidas() {
        return CatalogoPartidas.getInstance()
                .getCatalogoPartida()
                .stream()
                .limit(5)
                .collect(Collectors.toList());
    }

    /**
     * Get all desafios that have not yet been accepted
     *
     * @return all desafios that have not yet been accepted
     * @ensures {@code getListaDesafiosPendentes().size() > -1}
     */
    public List<Desafio> getListaDesafiosPendentes() {
        return desafiosRecebidos.values()
                .stream()
                .filter(x -> !x.getResposta())
                .collect(Collectors.toList());
    }

    /**
     * @param codigo code
     * @return desafio with the given code.
     */
    public Desafio getDesafio(String codigo) {
        return desafiosRecebidos.get(codigo);
    }

    /**
     * Increase elo ranking with the given elo
     *
     * @param elo value which will be increased
     * @requires {@code elo > 0}
     */
    public void increaseElo(double elo) {
        this.elo += elo;
    }

    /**
     * Decrease elo ranking with the given elo
     *
     * @param elo value which will be increased
     * @requires {@code elo > 0}
     */
    public void decreaseElo(double elo) {
        this.elo -= elo;
    }

    /**
     * Check if the difference between elo is valid
     *
     * @param elo   elo from another jogador
     * @param delta max difference of elo
     * @return true if the difference between the players is less than delta
     */
    boolean isValidDifferenceElo(double elo, int delta) {
        return Math.abs(elo - this.elo) < delta;
    }

    public void adicionaDesafioEnviado(Desafio d) {
        desafiosCriados.add(d);
    }

    public void adicionaDesafioRecebido(Desafio d) {
        desafiosRecebidos.put(d.getCodigo(), d);
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
