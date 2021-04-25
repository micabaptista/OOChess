package oochess.app.desafio;

import java.time.LocalDateTime;

import oochess.app.jogador.Jogador;
import oochess.app.torneio.Torneio;

public interface DesafioBuilderInterface {


	//falta novos atributos

    public DesafioBuilder withMensagem(String mensagem);

    public DesafioBuilder withDataPartida(LocalDateTime dataPartida);

    public DesafioBuilder withTorneio(Torneio torneio);
    
    public DesafioBuilder withDesafiante(Jogador desafiante);

    public DesafioBuilder withDesafiado(Jogador desafiado);

    public DesafioBuilder withCodigo(String codigo);

    public Desafio build();

	
	

}
