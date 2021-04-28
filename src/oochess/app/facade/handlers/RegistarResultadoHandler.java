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

    public void indicaDesafio(String codigoDesafio) {
        catalogoPartidas.getPartida(codigoDesafio)
                .ifPresent(x -> this.partida = x);

    }

    public List<PartidaDTO> indicaPartidaEspontanea() {
        return corrente.getLastFivePartidas();
    }

    public void indicaDetalhes(String username, LocalDateTime datahora) {
        createPartidaEspontanea(username, datahora);
        catalogoPartidas.getPartida(username, datahora)
                .ifPresent(x -> this.partida = x);
    }

    private void createPartidaEspontanea(String username, LocalDateTime datahora) {
        Partida newPartida = new PartidaEspontanea(datahora, corrente, CatalogoJogadores.getInstance().getJogador(username));
        catalogoPartidas.addPartida(newPartida);
    }


    public double indicarResultado(String resultado) {
        partida.setResultado(resultado);
        OOChess.getStrategy().execute(corrente, partida);

        return corrente.getElo();
    }


}
