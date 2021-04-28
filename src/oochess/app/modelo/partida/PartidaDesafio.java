package oochess.app.modelo.partida;

import oochess.app.modelo.desafio.Desafio;
import oochess.app.modelo.jogador.Jogador;

import java.time.LocalDateTime;
import java.util.Objects;

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
    public Jogador getJogadorHighElo() {
        if (desafio.getJogadorDesafiado().getElo() > desafio.getJogadorDesafiante().getElo()) {
            return desafio.getJogadorDesafiado();
        }
        return desafio.getJogadorDesafiante();
    }

    @Override
    public Jogador getJogadorLowElo() {
        if (desafio.getJogadorDesafiado().getElo() > desafio.getJogadorDesafiante().getElo()) {
            return desafio.getJogadorDesafiante();
        }
        return desafio.getJogadorDesafiado();
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Partida)) {
            return false;
        }

        Partida p = (PartidaDesafio) o;

        return p.getCodigo().equals(this.getCodigo());
    }
}