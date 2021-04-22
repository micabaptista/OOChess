package oochess.app.torneio;

import java.time.LocalDateTime;

public class Torneio {
	private String nome;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	
	public Torneio(String nomeTorneio,LocalDateTime inicio,LocalDateTime fim){
		this.nome = nomeTorneio;
		this.dataInicio = inicio;
		this.dataFim = fim;
	}
	
	public String getNome() {
		return this.nome;
		
	}
	
	public LocalDateTime getDataInicio() {
		return this.dataInicio;
	}
	
	public LocalDateTime getDataFim() {
		return this.dataFim;
	}
}