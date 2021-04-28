package oochess.app.modelo.partida;

import oochess.app.generator.RandomCode;
import oochess.app.modelo.jogador.Jogador;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Partida {
    private String codigo;
    private String resultado;


    protected Partida() {
        this.codigo = RandomCode.getInstance().createNewCode();
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getResultado() {
        return this.resultado;
    }

    /**
     * Check if partida is espontanea
     *
     * @return true if its espontanea, otherwise false
     */
    public abstract boolean isEspontanea();

    /**
     * Given a jogador, return the other jogador from partida
     *
     * @param jogador jogador
     * @return return the other jogador from partida
     */
    public abstract Jogador getOtherJogador(Jogador jogador);

    /**
     * Get jogador who have highest elo
     *
     * @return jogador who have highest elo
     */
    public abstract Jogador getJogadorHighElo();

    /**
     * Get jogador who have lowest elo
     *
     * @return jogador who have lowest elo
     */
    public abstract Jogador getJogadorLowElo();

    public abstract Jogador getJogadorDesafiado();

    public abstract Jogador getJogadorDesafiante();

    public abstract LocalDateTime getData();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partida)) return false;
        Partida partida = (Partida) o;
        return Objects.equals(codigo, partida.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}