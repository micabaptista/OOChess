package oochess.app.facade.handlers;

import oochess.app.CatalogoPartidas;
import oochess.app.desafio.Desafio;
import oochess.app.dtos.DesafioDTO;
import oochess.app.jogador.Jogador;
import oochess.app.partida.Partida;
import oochess.app.partida.PartidaDesafio;

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
        createPartida();
    }

    private void createPartida(){
        Partida newPartida = new PartidaDesafio(desafioCorrente);
        CatalogoPartidas.getInstance().addPartida(newPartida);
    }

    public void indicaNovaData(LocalDateTime datahora) {
        desafioCorrente.setDataPartida(datahora);
    }

}
