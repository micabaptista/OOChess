package oochess.app;

import java.util.Optional;

import oochess.app.facade.Sessao;
import oochess.app.facade.handlers.RegistarUtilizadorHandler;

/**
 * Esta é a classe do sistema.
 */
public class OOChess {

	public RegistarUtilizadorHandler getRegistarUtilizadorHandler() {
		return new RegistarUtilizadorHandler();
	}
	
	/**
	 * Returns an optional Session representing the authenticated user.
	 * @param username
	 * @param password
	 * @return
	 */
	public Optional<Sessao> autenticar(String username, String password) {
		return Optional.of(new Sessao()); // TODO Autenticação
	}

	
	
}
