package oochess.app.facade.handlers;

import oochess.app.desafio.Desafio;
import oochess.app.dtos.DesafioDTO;
import oochess.app.jogador.Jogador;

import java.time.LocalDateTime;
import java.util.List;

public class ProcessarDesafiosHandler {

    private Jogador jogadorCorrente;
    private Desafio desafioCorrente;

    public ProcessarDesafiosHandler(Jogador jogador) {
        this.jogadorCorrente = jogador;
    }

    public List<DesafioDTO> consultarDesafiosPendentes() {
        return jogadorCorrente.getListaDesafios();
    }

    public void respondeADesafio(String codigo, boolean resposta) {
        this.desafioCorrente = jogadorCorrente.getDesafio(codigo);
        desafioCorrente.setResposta(resposta);
    }

    public void indicaNovaData(LocalDateTime datahora) {
        desafioCorrente.setDataPartida(datahora);
    }

}
