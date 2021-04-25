package oochess.app.facade.handlers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import oochess.app.CatalogoPartidas;
import oochess.app.OOChess;
import oochess.app.discordintegration.MyConfiguration;
import oochess.app.jogador.Jogador;
import oochess.app.partida.Partida;
import oochess.app.partida.PartidaEspontanea;


public class RegistarResultadoHandler {
	
	private String codigo;
	private Jogador corrente;
	private Partida partida;
	private CatalogoPartidas cp;
	
	
	
	public RegistarResultadoHandler(Jogador jogadorCorrente,CatalogoPartidas cp) {
		corrente = jogadorCorrente;
		this.cp = cp;
		
	}

	public void indicaDesafio(String codigoDesafio) {
		this.partida = cp.getPartida(codigoDesafio);
		
	}

	public List<Partida> indicaPartidaEspontanea() {
		//TODO
		//return corrente.getPartidas();
		return null;
	}
	
	public void indicaDetalhes(String username, LocalDateTime datahora) {
		partida = cp.getPartida(username, datahora);	
	}

	public double indicarResultado(String resultado) {
		partida.setResultado(resultado);		
		OOChess.getSTRATEGY().execute(corrente, partida.getOponente(), resultado);
		
		return corrente.getElo();
		
	}
	
	
	
	
	
}
