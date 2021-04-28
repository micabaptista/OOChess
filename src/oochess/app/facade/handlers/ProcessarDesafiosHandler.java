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

    /**
     * Get list of all not accepted desafios (dto)
     *
     * @return list of all not accepted desafios  (dto)
     * @requires {@code jogadorCorrente != null}
     */
    public List<DesafioDTO> consultarDesafiosPendentes() {
        return jogadorCorrente
                .getListaDesafiosPendentes()
                .stream()
                .map(u -> new DesafioDTO(u.getCodigo(), u.getMensagem(), u.getDataPartida()))
                .collect(Collectors.toList());
    }

    /**
     * Update resposta of current desafio
     *
     * @param codigo   codigo
     * @param resposta resposta
     * @requires {@code jogadorCorrente != null}
     */
    public void respondeADesafio(String codigo, boolean resposta) {
        try {
            this.desafioCorrente = jogadorCorrente.getDesafio(codigo);
            desafioCorrente.setResposta(resposta);
            if (resposta) {
                createPartida();
            }
        } catch (NullPointerException e) {
            System.out.println("Infelizmente o desafio dado não é valido");
        }
    }

    /**
     * Create PartidaDesafio
     */
    private void createPartida() {
        CatalogoPartidas.getInstance()
                .addPartida(new PartidaDesafio(desafioCorrente));
    }

    /**
     * Update data of desafio
     *
     * @param datahora data
     * @requires {@code jogadorCorrente != null && desafio != null}
     */
    public void indicaNovaData(LocalDateTime datahora) {
        desafioCorrente.setDataPartida(datahora);
    }

}
