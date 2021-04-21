package oochess.app.facade.handlers;

import oochess.app.CatalogoJogadores;
import oochess.app.jogador.Jogador;
import oochess.app.jogador.JogadorBuilder;

import java.util.Map;

public class RegistarUtilizadorHandler {

    private final CatalogoJogadores catalogoJogadores;

    public RegistarUtilizadorHandler(CatalogoJogadores catalogoJogadores) {
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
        Jogador jogador = new JogadorBuilder()
                .withUsername(username)
                .withPassword(password)
                .withDiscordUsername(discordUsername)
                .build();

        this.catalogoJogadores.putJogador(jogador);
    }

    public boolean isJogadorRegistado(String username) {
        return catalogoJogadores.existsJogador(username);
    }

}
