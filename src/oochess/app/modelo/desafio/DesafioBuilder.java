package oochess.app.modelo.desafio;

import java.time.LocalDateTime;

import oochess.app.modelo.jogador.Jogador;
import oochess.app.modelo.torneio.Torneio;

public class DesafioBuilder implements DesafioBuilderInterface {
    private String mensagem;
    private LocalDateTime dataPartida;

    private Torneio torneio; 
    private Jogador jogadorDesafiante;
    private Jogador jogadorDesafiado;


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
    public DesafioBuilder withTorneio(Torneio torneio) {
        this.torneio = torneio;
        return this;
    }
    
    @Override
    public DesafioBuilder withDesafiante(Jogador desafiante) {
        this.jogadorDesafiante = desafiante;
        return this;
    }
    
    @Override
    public DesafioBuilder withDesafiado(Jogador desafiado) {
        this.jogadorDesafiado = desafiado;
        return this;
    }

    @Override
    public Desafio build() {
        return new Desafio(dataPartida, mensagem, jogadorDesafiante, jogadorDesafiado, torneio);
    }
}
