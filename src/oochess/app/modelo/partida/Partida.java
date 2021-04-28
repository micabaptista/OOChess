package oochess.app.modelo.partida;

import oochess.app.generator.RandomCode;
import oochess.app.modelo.jogador.Jogador;

import java.time.LocalDateTime;

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

    public abstract boolean isEspontanea();

    public abstract Jogador getOtherJogador(Jogador jogador);

    public abstract Jogador getJogadorDesafiado();

    public abstract Jogador getJogadorDesafiante();

    public abstract Jogador getJogadorHighElo();

    public abstract Jogador getJogadorLowElo();

    public abstract LocalDateTime getData();


}

//falta implemetar classe para partida torneio