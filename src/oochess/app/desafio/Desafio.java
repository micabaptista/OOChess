package oochess.app.desafio;


import java.time.LocalDateTime;

public class Desafio {
    private String codigo;
    private String mensagem;
    private LocalDateTime dataPartida;
    private boolean resposta;

    public Desafio(String codigo, String mensagem, LocalDateTime dataPartida, boolean resposta) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.dataPartida = dataPartida;
        this.resposta = resposta;

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
}
