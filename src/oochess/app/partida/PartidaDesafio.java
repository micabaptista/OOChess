package oochess.app.partida;

import oochess.app.desafio.Desafio;
import oochess.app.jogador.Jogador;

import java.time.LocalDateTime;

public class PartidaDesafio extends Partida {
    private Desafio desafio;

    public PartidaDesafio(Desafio d) {
        super();
        this.desafio = d;

    }

    public Desafio getDesafio() {
        return desafio;
    }

    @Override
    public Jogador getOtherJogador(Jogador jogador) {
        if (jogador.equals(desafio.getJogadorDesafiado())) {
            return desafio.getJogadorDesafiante();
        } else {
            return desafio.getJogadorDesafiado();
        }
    }

    @Override
    public boolean isEspontanea() {
        return false;
    }

    @Override
    public Jogador getJogadorDesafiado() {
        return desafio.getJogadorDesafiado();
    }

    @Override
    public Jogador getJogadorDesafiante() {
        return desafio.getJogadorDesafiante();
    }

    @Override
    public LocalDateTime getData() {
        return desafio.getDataPartida();
    }


}