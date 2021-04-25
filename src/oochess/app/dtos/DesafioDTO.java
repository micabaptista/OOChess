package oochess.app.dtos;

import oochess.app.torneio.Torneio;

import java.time.LocalDateTime;

public class DesafioDTO {

    private String codigo;
    private String mensagem;
    private LocalDateTime dataPartida;
    private boolean resposta;

    public DesafioDTO(String codigo, String mensagem, LocalDateTime dataPartida, boolean resposta) {
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

    public boolean isResposta() {
        return resposta;
    }
}