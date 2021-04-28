package oochess.app.modelo.torneio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Torneio {
    private String nome;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Torneio(String nomeTorneio, LocalDateTime inicio, LocalDateTime fim) {
        this.nome = nomeTorneio;
        this.dataInicio = inicio;
        this.dataFim = fim;
    }

    public String getNome() {
        return this.nome;

    }

    public LocalDateTime getDataInicio() {
        return this.dataInicio;
    }

    public LocalDateTime getDataFim() {
        return this.dataFim;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Torneio)) return false;
        Torneio torneio = (Torneio) o;
        return Objects.equals(nome, torneio.nome) &&
                Objects.equals(dataInicio, torneio.dataInicio) &&
                Objects.equals(dataFim, torneio.dataFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataInicio, dataFim);
    }
}