package oochess.app.facade.handlers;

import oochess.app.desafio.Desafio;
import oochess.app.jogador.Jogador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProcessarDesafiosHandler {

    private Jogador jogadorCurrente;
    private Desafio desafio;

    public ProcessarDesafiosHandler(Jogador jogador) {
        this.jogadorCurrente = jogador;
    }

    public List<Desafio> consultarDesafiosPendentes() {
        return jogadorCurrente.getListaDesafios();
    }

    public void respondeADesafio(String codigo, boolean resposta) {
        this.desafio = jogadorCurrente.getDesafio(codigo);
        desafio.setResposta(resposta);
    }

    public void indicaNovaData(LocalDateTime datahora) {
        desafio.setDataPartida(datahora);
    }

}
