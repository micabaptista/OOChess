package oochess.app.facade;

import oochess.app.Jogador;
import oochess.app.facade.handlers.DesafiarHandler;
import oochess.app.facade.handlers.ProcessarDesafiosHandler;
import oochess.app.facade.handlers.RegistarResultadoHandler;

public class Sessao {

    public Sessao() {

    }

    public DesafiarHandler getDesafioParaPartidaHandler() {
		return new DesafiarHandler(); // TODO
	}

	public RegistarResultadoHandler getRegistarResultadoDePartida() {
		return new RegistarResultadoHandler(); // TODO
	}

	public ProcessarDesafiosHandler getProcessarDesafios() {
		return new ProcessarDesafiosHandler(); // TODO
	}
}
