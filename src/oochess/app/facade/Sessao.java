package oochess.app.facade;

import oochess.app.CatalogoJogadores;
import oochess.app.CatalogoPartidas;
import oochess.app.CatalogoTorneios;
import oochess.app.OOChess;
import oochess.app.facade.handlers.DesafiarHandler;
import oochess.app.facade.handlers.ProcessarDesafiosHandler;
import oochess.app.facade.handlers.RegistarResultadoHandler;
import oochess.app.jogador.Jogador;

public class Sessao {
    private Jogador jogadorCorrente;

    public Sessao(Jogador jogadorCorrente) {
        this.jogadorCorrente = jogadorCorrente;
    }

    public DesafiarHandler getDesafioParaPartidaHandler() {
        return new DesafiarHandler(CatalogoTorneios.getInstance(), CatalogoJogadores.getInstance(), jogadorCorrente);

    }

    public RegistarResultadoHandler getRegistarResultadoDePartida() {
        return new RegistarResultadoHandler(jogadorCorrente);
    }

    public ProcessarDesafiosHandler getProcessarDesafios() {
        return new ProcessarDesafiosHandler(jogadorCorrente);
    }
}
