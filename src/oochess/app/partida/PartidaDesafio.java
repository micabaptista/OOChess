package oochess.app.partida;

import oochess.app.desafio.Desafio;
import oochess.app.jogador.Jogador;

public class PartidaDesafio extends Partida {
	private Desafio desafio;
	
	public PartidaDesafio(Desafio d) {
		super();
		this.desafio = d;
		
	}

	@Override
	public boolean isEspontanea() {
		return false;
	}

	@Override
	public Jogador getOponente() {
		return desafio.getOponente();
	}
}