package oochess.app;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import oochess.app.elostrategies.ByOne;
import oochess.app.elostrategies.EloStrategy;
import oochess.app.facade.Sessao;
import oochess.app.facade.handlers.RegistarUtilizadorHandler;
import oochess.app.modelo.jogador.CatalogoJogadores;

/**
 * Esta é a classe do sistema.
 */
public class OOChess {

    private static EloStrategy strategy;
    private CatalogoJogadores catalogoJogadores;


    public OOChess() {
        this.catalogoJogadores = CatalogoJogadores.getInstance();
        setStrategy();
    }

    /**
     * Returns an optional Session representing the authenticated user.
     *
     * @param username username OOChess
     * @param password password OOChess
     * @return an optional session representing the authenticated user.
     */
    public Optional<Sessao> autenticar(String username, String password) {
        boolean userExists = this.catalogoJogadores.existsJogador(username);
        if (!userExists) {
            return Optional.empty();
        }
        String userPassword = this.catalogoJogadores.getJogador(username).getPassword();
        return password.equals(userPassword) ? Optional.of(
                new Sessao(catalogoJogadores.getJogador(username))) : Optional.empty();
    }


    public RegistarUtilizadorHandler getRegistarUtilizadorHandler() {
        return new RegistarUtilizadorHandler();
    }

    /**
     * S
     *
     */
    @SuppressWarnings("unchecked")
    private static void setStrategy() {
        String estrategia = OOChessConfiguration.getInstance().getString("STRATEGY_CLASS");
        try {
            Class<EloStrategy> estrategiaClass = (Class<EloStrategy>) Class.forName(estrategia);
            strategy = estrategiaClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException |
                InvocationTargetException e1) {
            strategy = new ByOne();
        }
    }

    public static EloStrategy getStrategy() {
        return strategy;
    }

}
