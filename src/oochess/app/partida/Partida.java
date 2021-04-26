package oochess.app.partida;

import oochess.app.extras.RandomCode;
import oochess.app.jogador.Jogador;

import java.time.LocalDateTime;

public abstract class Partida {
    private String codigo;
    private String resultado;


    protected Partida() {
        this.codigo = RandomCode.getInstance().createCode();
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

    public abstract Jogador getOtherJogador(Jogador jogador);

    public abstract boolean isEspontanea();

    public abstract Jogador getJogadorDesafiado();

    public abstract Jogador getJogadorDesafiante();

    public abstract LocalDateTime getData();


}

//falta implemetar classe para partida torneio