package oochess.app.jogador;

import oochess.app.desafio.Desafio;
import oochess.app.dtos.DesafioDTO;
import oochess.app.partida.PartidaEspontanea;
import oochess.app.torneio.Torneio;

import java.util.*;
import java.util.stream.Collectors;

public class Jogador {
    private String username;
    private String password;
    private String discordUsername;
    private int elo;

    private final Map<String, Desafio> desafiosRecebidos =  new HashMap<>();
    private final List<Desafio> desafiosCriados = new ArrayList<>();
    
    private final List<PartidaEspontanea> partidas = new ArrayList<>(); 
    private final List<Torneio> torneios = new ArrayList<>();
    

    public Jogador(String username, String password, String discordUsername) {
        this.username = username;
        this.password = password;
        this.discordUsername = discordUsername;
        //falta ver elo
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

    public int getElo() {
        return elo;
    }

    //ver se devolver o codigo é boa ideia associar com o get desafio
    public List<DesafioDTO> getListaDesafios() {
        return desafiosRecebidos.values()
                .stream()
                .filter(x -> !x.getResposta())
                .map(u -> new DesafioDTO(u.getCodigo(),u.getMensagem(),u.getDataPartida(),u.getResposta()))
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
