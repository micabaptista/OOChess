package oochess.app;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import oochess.app.discordintegration.MyConfiguration;
import oochess.app.elostrategies.ByOne;
import oochess.app.elostrategies.EloStrategy;
import oochess.app.facade.Sessao;
import oochess.app.facade.handlers.RegistarUtilizadorHandler;

/**
 * Esta é a classe do sistema.
 */
public class OOChess {

    private static EloStrategy strategy;
    private CatalogoJogadores catalogoJogadores;
    //outos catalogos?

    public OOChess() {
        this.catalogoJogadores = CatalogoJogadores.getInstance();
        setSTRATEGY();
        //outos catalogos?

    }

    public static EloStrategy getStrategy() {
        return strategy;
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
        boolean userExists = this.catalogoJogadores.existsJogador(username);
        if (!userExists) {
            return Optional.empty();
        }
        String userPassword = this.catalogoJogadores.getJogador(username).getPassword();
        return password.equals(userPassword) ? Optional.of(
                new Sessao(catalogoJogadores.getJogador(username))) : Optional.empty();
    }

    @SuppressWarnings("unchecked")
    private static void setSTRATEGY() {
        String estrategia = MyConfiguration.getINSTANCE().getString("STRATEGY_CLASS");
        try {
            Class<EloStrategy> estrategiaClass = (Class<EloStrategy>) Class.forName(estrategia);
            strategy = estrategiaClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException |
                InvocationTargetException e1) {
            //Default
            strategy = new ByOne();
        }

    }

}
