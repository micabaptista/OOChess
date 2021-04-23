package oochess.app.desafio;

import java.time.LocalDateTime;

public interface DesafioBuilderInterface {


	//falta novos atributos

    public DesafioBuilder withMensagem(String mensagem);

    public DesafioBuilder withDataPartida(LocalDateTime dataPartida);

    public DesafioBuilder withResposta(boolean resposta);

    public DesafioBuilder withCodigo(String codigo);

    public Desafio build();

}
