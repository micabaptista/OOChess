package oochess.app.jogador;

import oochess.app.desafio.Desafio;

import java.util.*;
import java.util.stream.Collectors;

public class Jogador {
    private String username;
    private String password;
    private String discordUsername;
    private int elo;

    private Map<String, Desafio> desafiosRecebidos;
    private List<Desafio> desafiosCriados;

    public Jogador(String username, String password, String discordUsername) {

        this.username = username;
        this.password = password;
        this.discordUsername = discordUsername;
        this.desafiosRecebidos = new HashMap<>();
        this.desafiosCriados = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    protected String getDiscordUsername() {
        return discordUsername;
    }

    public String getPassword() {
        return password;
    }

    protected int getElo() {
        return elo;
    }

    public List<Desafio> getListaDesafios() {
        return desafiosRecebidos.values()
                .stream()
                .filter(x -> !x.getResposta())
                .collect(Collectors.toList());
    }


    public Desafio getDesafio(String codigo) {
        return desafiosRecebidos.get(codigo);
    }


    public boolean eloNecessario(int elo, int delta) {
        return Math.abs(elo - this.elo) < delta;
    }

    public void adicionaDesafioEnviado(Desafio d) {
        desafiosCriados.add(d);
    }

    public void adicionaDesafioRecebido(Desafio d) {
        desafiosRecebidos.put(d.getCodigo(), d);
    }

    //nao sei se vai ser usada ou util
    public void removeDesafioRecebido(Desafio d /*ou String*/) {
        desafiosCriados.add(d);
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

        return this.username.equals(jogador2.getUsername())
                && this.password.equals(jogador2.getPassword())
                && this.discordUsername.equals(jogador2.getDiscordUsername())
                && this.elo == jogador2.getElo()
                && this.desafiosRecebidos.equals(jogador2.desafiosRecebidos)
                && this.desafiosCriados.equals(jogador2.desafiosCriados);
    }
}
