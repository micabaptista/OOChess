package oochess.app.partida;

import java.time.LocalDateTime;

import oochess.app.jogador.Jogador;

public class PartidaEspontanea extends Partida {
	private Jogador j1;
	private Jogador j2; 
	private LocalDateTime data;
	 
	public PartidaEspontanea(LocalDateTime data, Jogador j1, Jogador j2) {
		super();
		this.data = data;
		this.j1 = j1;
		this.j2 = j2;
		
	}
}
