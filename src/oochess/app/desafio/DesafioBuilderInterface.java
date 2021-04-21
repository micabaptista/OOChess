package oochess.app.desafio;

import java.time.LocalDateTime;

public interface DesafioBuilderInterface {

    public DesafioBuilder withCodigo(String codigo);

    public DesafioBuilder withMensagem(String mensagem);

    public DesafioBuilder withDataPartida(LocalDateTime dataPartida);

    public DesafioBuilder withResposta(boolean resposta);


    public Desafio build();

}
