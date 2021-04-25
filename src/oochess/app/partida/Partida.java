package oochess.app.partida;

import oochess.app.extras.RandomString;
import oochess.app.jogador.Jogador;

public abstract class Partida {
	private String codigo;
	private String resultado;
	
	
	protected Partida() {
		this.codigo = new RandomString().nextString();
	}
	
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	protected String getCodigo() {
		return this.codigo;
	}
	
	protected String getResultado() {
		return this.resultado;
	}
	
	public abstract boolean isEspontanea();

	public abstract Jogador getOponente();
	
	
	
}

//falta implemetar classe para partida torneio