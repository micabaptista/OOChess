package oochess.app.facade.handlers;

import oochess.app.Jogador;
import oochess.app.OOChess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistarUtilizadorHandler {

    private final Map<String, Jogador> catalogoJogadores;

    public RegistarUtilizadorHandler(Map<String, Jogador> catalogoJogadores) {
        this.catalogoJogadores = catalogoJogadores;
    }

    /**
     * Regista um utilizador normal.
     *
     * @param discordUsername username do Discord
     * @param username        username no OOChess
     * @param password        password no OOChess
     * @ensures existe um utilizador com esse username
     */
    public void registarUtilizador(String username, String password, String discordUsername) {
        Jogador jogador = new Jogador(username, password, discordUsername);
        this.catalogoJogadores.put(jogador.getUsername(), jogador);
    }

    public boolean isJogadorRegistado(String username) {
        return catalogoJogadores.containsKey(username);
    }

}
