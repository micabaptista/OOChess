package oochess.app.facade.handlers;

import java.time.LocalDateTime;
import java.util.List;

import oochess.app.modelo.jogador.CatalogoJogadores;
import oochess.app.modelo.partida.CatalogoPartidas;
import oochess.app.OOChess;
import oochess.app.facade.dto.PartidaDTO;
import oochess.app.modelo.jogador.Jogador;
import oochess.app.modelo.partida.Partida;
import oochess.app.modelo.partida.PartidaEspontanea;


public class RegistarResultadoHandler {

    private String codigo;
    private Jogador corrente;
    private Partida partida;
    private final CatalogoPartidas catalogoPartidas = CatalogoPartidas.getInstance();


    public RegistarResultadoHandler(Jogador jogadorCorrente) {
        corrente = jogadorCorrente;
    }

    /**
     * Update partida
     *
     * @param codigoDesafio desafio code
     * @requires {@code corrente != null}
     * @ensures Seja d: desafio, tal que d.codigo = cod e d e jogadorCorrente estao associados
     */
    public void indicaDesafio(String codigoDesafio) {
        this.partida = catalogoPartidas.getPartida(codigoDesafio);

    }

    /**
     * Get last five matches played by the jogador corrente
     *
     * @return list of last five matches played by the jogador
     * @ensures {@code indicaPartidaEspontanea().size() > -1}
     */
    public List<PartidaDTO> indicaPartidaEspontanea() {
        return corrente.getLastFivePartidas();
    }

    /**
     * Select some details such as data and player name.
     *
     * @param username player name
     * @param datahora data
     * @requires {@code corrente != null}
     */
    public void indicaDetalhes(String username, LocalDateTime datahora) {
        createPartidaEspontanea(username, datahora);
        catalogoPartidas.getPartida(username, datahora)
                .ifPresent(x -> this.partida = x);
    }

    /**
     * Create partida espontanea
     *
     * @param username username
     * @param datahora data
     * @requires {@code corrente != null}
     */
    private void createPartidaEspontanea(String username, LocalDateTime datahora) {
        Partida newPartida = new PartidaEspontanea(datahora, corrente, CatalogoJogadores.getInstance().getJogador(username));
        catalogoPartidas.addPartida(newPartida);
    }

    /**
     * Update partida result
     *
     * @param resultado resultado
     * @requires {@code corrente != null}
     * @ensures Definimos prt. resultado = result e jogadorCorrente.elo = eloAtualizado
     */
    public double indicarResultado(String resultado) {
        partida.setResultado(resultado);
        OOChess.getStrategy().execute(corrente, partida);
        return corrente.getElo();
    }


}
