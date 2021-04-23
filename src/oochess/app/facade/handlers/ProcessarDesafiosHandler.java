package oochess.app.facade.handlers;

import oochess.app.desafio.Desafio;
import oochess.app.jogador.Jogador;

import java.time.LocalDateTime;
import java.util.List;

public class ProcessarDesafiosHandler {

    private Jogador jogadorCurrente;
    private Desafio desafioCurrente;

    public ProcessarDesafiosHandler(Jogador jogador) {
        this.jogadorCurrente = jogador;
    }

    public List<Desafio> consultarDesafiosPendentes() {
        return jogadorCurrente.getListaDesafios();
    }

    public void respondeADesafio(String codigo, boolean resposta) {
        this.desafioCurrente = jogadorCurrente.getDesafio(codigo);
        desafioCurrente.setResposta(resposta);
    }

    public void indicaNovaData(LocalDateTime datahora) {
        desafioCurrente.setDataPartida(datahora);
    }

}
