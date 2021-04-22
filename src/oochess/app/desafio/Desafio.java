package oochess.app.desafio;


import java.time.LocalDateTime;

import oochess.app.extras.RandomString;
import oochess.app.jogador.Jogador;
import oochess.app.torneio.Torneio;

public class Desafio {
	private Jogador desafiado;
	private Jogador desafiante;
	//provavelmente retirar
	private /*static???*/final int randomLength = 8;
	private RandomString rd = new RandomString(randomLength);
	private Torneio torneio; // pode começar a null???
	
    private String codigo;
    private String mensagem; //nao sei se era para tar em atributo
    private LocalDateTime dataPartida;
    private boolean resposta;

    public Desafio(  LocalDateTime dataPartida, String mensagem, Jogador jogadorDesafiante , Jogador jogadorDesafiado , Torneio torneio , boolean resposta) {
        this.codigo = rd.nextString();
        this.mensagem = mensagem;
        this.dataPartida = dataPartida;
        this.desafiado = jogadorDesafiado;
		this.desafiante = jogadorDesafiante;
		//verificar o null ou se setter
		this.torneio = torneio;
       // nao é melhor deixar isto para o setter 
        this.resposta = resposta;

    }


	public String getCodigo() {
        return codigo;
    }
    
    //nao sei se é preciso
    public String getMensagem() {
        return mensagem;
    }
    
    //nao sei se é preciso
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
}
