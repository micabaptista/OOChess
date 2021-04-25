package oochess.app.partida;

import java.time.LocalDateTime;

import oochess.app.jogador.Jogador;

public class PartidaEspontanea extends Partida {
	private Jogador jogadorCorrente;
	private Jogador oponente; 
	private LocalDateTime data;
	 
	public PartidaEspontanea(LocalDateTime data, Jogador j1, Jogador j2) {
		super();
		this.data = data;
		this.jogadorCorrente = j1;
		this.oponente = j2;
		
	}

	@Override
	public boolean isEspontanea() {
		return true;
	}

	@Override
	public Jogador getOponente() {
		return oponente;
	}
}
