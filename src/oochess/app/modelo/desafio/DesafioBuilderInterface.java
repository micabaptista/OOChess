package oochess.app.modelo.desafio;

import java.time.LocalDateTime;

import oochess.app.modelo.jogador.Jogador;
import oochess.app.modelo.torneio.Torneio;

public interface DesafioBuilderInterface {


    DesafioBuilder withMensagem(String mensagem);

    DesafioBuilder withDataPartida(LocalDateTime dataPartida);

    DesafioBuilder withTorneio(Torneio torneio);

    DesafioBuilder withDesafiante(Jogador desafiante);

    DesafioBuilder withDesafiado(Jogador desafiado);


    Desafio build();


}
