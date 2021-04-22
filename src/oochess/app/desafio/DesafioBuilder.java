package oochess.app.desafio;

import java.time.LocalDateTime;

import oochess.app.jogador.Jogador;
import oochess.app.torneio.Torneio;

public class DesafioBuilder implements DesafioBuilderInterface {
    private String mensagem;
    private LocalDateTime dataPartida;
    private boolean resposta;
    
    //novos atributos
    private Torneio torneio; //ver se necessario, depende da classe Desafio
    private Jogador jogadorDesafiante;
    private Jogador jogadorDesafiado;

    
    	//falta metodos para os novos atributos
    @Override
    public DesafioBuilder withMensagem(String mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    @Override
    public DesafioBuilder withDataPartida(LocalDateTime dataPartida) {
        this.dataPartida = dataPartida;
        return this;
    }

    @Override
    public DesafioBuilder withResposta(boolean resposta) {
        this.resposta = resposta;
        return this;
    }

    @Override
    public Desafio build() {
        return new Desafio(dataPartida, mensagem, jogadorDesafiante, jogadorDesafiado, torneio ,resposta);
    }
}
