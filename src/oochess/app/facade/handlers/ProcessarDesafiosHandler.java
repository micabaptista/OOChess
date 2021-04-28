package oochess.app.facade.handlers;

import oochess.app.modelo.partida.CatalogoPartidas;
import oochess.app.modelo.desafio.Desafio;
import oochess.app.facade.dto.DesafioDTO;
import oochess.app.modelo.jogador.Jogador;
import oochess.app.modelo.partida.Partida;
import oochess.app.modelo.partida.PartidaDesafio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessarDesafiosHandler {

    private Jogador jogadorCorrente;
    private Desafio desafioCorrente;

    public ProcessarDesafiosHandler(Jogador jogador) {
        this.jogadorCorrente = jogador;
    }

    public List<DesafioDTO> consultarDesafiosPendentes() {
        return jogadorCorrente
                .getListaDesafiosPendentes()
                .stream()
                .map(u -> new DesafioDTO(u.getCodigo(), u.getMensagem(), u.getDataPartida()))
                .collect(Collectors.toList());
    }

    public void respondeADesafio(String codigo, boolean resposta) {
        this.desafioCorrente = jogadorCorrente.getDesafio(codigo);
        desafioCorrente.setResposta(resposta);
        createPartida();
    }

    private void createPartida() {
        CatalogoPartidas.getInstance()
                .addPartida(new PartidaDesafio(desafioCorrente));
    }

    public void indicaNovaData(LocalDateTime datahora) {
        desafioCorrente.setDataPartida(datahora);
    }

}
