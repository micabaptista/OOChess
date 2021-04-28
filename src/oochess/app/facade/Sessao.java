package oochess.app.facade;

import oochess.app.modelo.jogador.CatalogoJogadores;
import oochess.app.modelo.torneio.CatalogoTorneios;
import oochess.app.facade.handlers.DesafiarHandler;
import oochess.app.facade.handlers.ProcessarDesafiosHandler;
import oochess.app.facade.handlers.RegistarResultadoHandler;
import oochess.app.modelo.jogador.Jogador;

public class Sessao {
    private Jogador jogadorCorrente;

    public Sessao(Jogador jogadorCorrente) {
        this.jogadorCorrente = jogadorCorrente;
    }

    public DesafiarHandler getDesafioParaPartidaHandler() {
        return new DesafiarHandler(jogadorCorrente);

    }

    public RegistarResultadoHandler getRegistarResultadoDePartida() {
        return new RegistarResultadoHandler(jogadorCorrente);
    }


    public ProcessarDesafiosHandler getProcessarDesafios() {
        return new ProcessarDesafiosHandler(jogadorCorrente);
    }
}
