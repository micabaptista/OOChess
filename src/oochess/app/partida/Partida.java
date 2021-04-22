package oochess.app.partida;

import oochess.app.extras.RandomString;

public abstract class Partida {
	private String codigo;
	private String resultado;
	
	
	protected Partida() {
		this.codigo = new RandomString(8).nextString();
	}
	
	protected void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	protected String getCodigo() {
		return this.codigo;
	}
	
	protected String getResultado() {
		return this.resultado;
	}
}

//falta implemetar classe para partida torneio