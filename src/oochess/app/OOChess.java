package oochess.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import oochess.app.facade.Sessao;
import oochess.app.facade.handlers.RegistarUtilizadorHandler;

/**
 * Esta é a classe do sistema.
 */
public class OOChess {

    private Map<String, Jogador> catalogoJogadores;

    public OOChess() {
        this.catalogoJogadores = new HashMap<>();
    }

    public RegistarUtilizadorHandler getRegistarUtilizadorHandler() {
        return new RegistarUtilizadorHandler(catalogoJogadores);
    }


    /**
     * Returns an optional Session representing the authenticated user.
     *
     * @param username username OOChess
     * @param password password OOChess
     * @return an optional session representing the authenticated user.
     */
    public Optional<Sessao> autenticar(String username, String password) {
        boolean userExists = this.catalogoJogadores.containsKey(username);
        if (!userExists) {
            return Optional.empty();
        }
        String userPassword = this.catalogoJogadores.get(username).getPassword();
        return password.equals(userPassword) ? Optional.of(new Sessao()) : Optional.empty();
    }
}
