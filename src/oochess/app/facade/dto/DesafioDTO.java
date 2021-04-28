package oochess.app.facade.dto;

import java.time.LocalDateTime;

public class DesafioDTO {

    private String codigo;
    private String mensagem;
    private LocalDateTime dataPartida;

    public DesafioDTO(String codigo, String mensagem, LocalDateTime dataPartida) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.dataPartida = dataPartida;
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

}