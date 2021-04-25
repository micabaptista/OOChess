package oochess.app.desafio;

import java.time.LocalDateTime;

import oochess.app.jogador.Jogador;
import oochess.app.torneio.Torneio;

public class DesafioBuilder implements DesafioBuilderInterface {
    private String mensagem;
    private LocalDateTime dataPartida;
    private boolean resposta;
    
   
    private Torneio torneio; 
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
    
    @Override // este é opcinoal
    public DesafioBuilder withTorneio(Torneio torneio) {
        this.torneio = torneio;
        return this;
    }
    
    @Override // este é opcinoal
    public DesafioBuilder withDesafiante(Jogador desafiante) {
        this.jogadorDesafiante = desafiante;
        return this;
    }
    
    @Override // este é opcinoal
    public DesafioBuilder withDesafiado(Jogador desafiado) {
        this.jogadorDesafiado = desafiado;
        return this;
    }

    @Override
    public Desafio build() {
        return new Desafio(dataPartida, mensagem, jogadorDesafiante, jogadorDesafiado, torneio);
    }
}
