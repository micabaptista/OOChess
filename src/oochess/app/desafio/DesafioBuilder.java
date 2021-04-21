package oochess.app.desafio;

import java.time.LocalDateTime;

public class DesafioBuilder implements DesafioBuilderInterface {
    private String codigo;
    private String mensagem;
    private LocalDateTime dataPartida;
    private boolean resposta;


    @Override
    public DesafioBuilder withCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

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
        return new Desafio(codigo,mensagem,dataPartida,resposta);
    }
}
