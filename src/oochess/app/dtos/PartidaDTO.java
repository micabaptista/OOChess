package oochess.app.dtos;

import java.time.LocalDateTime;

public class PartidaDTO {

    private String codigo;
    private LocalDateTime data;
    private String resultado;

    public PartidaDTO(String codigo, LocalDateTime data, String resultado) {
        this.codigo = codigo;
        this.data = data;
        this.resultado = resultado;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getResultado() {
        return resultado;
    }
}
