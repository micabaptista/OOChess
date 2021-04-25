package oochess.app.desafio;


import java.time.LocalDateTime;

import oochess.app.extras.RandomString;
import oochess.app.jogador.Jogador;
import oochess.app.torneio.Torneio;

//TALVEZ JOGADOR DTO
public class Desafio {
	private Jogador desafiado;
	private Jogador desafiante;
	private RandomString rd = new RandomString(); 
	private Torneio torneio = null; 
    private String codigo;
    private String mensagem; 
    private LocalDateTime dataPartida;
    private boolean resposta;

    
    ///builder
    public Desafio(  LocalDateTime dataPartida, String mensagem, Jogador jogadorDesafiante , Jogador jogadorDesafiado , Torneio torneio ) {
        this.codigo = rd.nextString();
        this.mensagem = mensagem;
        this.dataPartida = dataPartida;
        this.desafiado = jogadorDesafiado;
		this.desafiante = jogadorDesafiante;
		this.torneio = torneio;

    }


	public String getCodigo() {
        return codigo;
    }
    
    
    public String getMensagem() {
        return mensagem;
    }
    
    public LocalDateTime getDataPartida() {
        return dataPartida;
    }
    
    public boolean getResposta() {
        return resposta;
    }

    public void setResposta(boolean resposta) {
        this.resposta = resposta;
    }

    public void setDataPartida(LocalDateTime dataPartida) {
        this.dataPartida = dataPartida;
    }
    
    public Torneio getTorneio() {
    	return torneio;
    }


	public Jogador getOponente() {
		return desafiado;
	}
    
}
