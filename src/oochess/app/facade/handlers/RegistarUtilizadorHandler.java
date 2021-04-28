package oochess.app.facade.handlers;

import oochess.app.modelo.jogador.CatalogoJogadores;
import oochess.app.modelo.jogador.Jogador;
import oochess.app.modelo.jogador.JogadorBuilder;

public class RegistarUtilizadorHandler {

    private final CatalogoJogadores catalogoJogadores = CatalogoJogadores.getInstance();

    /**
     * Regista um utilizador normal.
     *
     * @param username        username no OOChess
     * @param password        password no OOChess
     * @param discordUsername username do Discord
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
