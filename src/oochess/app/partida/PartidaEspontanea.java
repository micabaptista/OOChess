package oochess.app.partida;

import java.time.LocalDateTime;

import oochess.app.jogador.Jogador;

public class PartidaEspontanea extends Partida {
    private Jogador jogadorDesafiante;
    private Jogador jogadorDesafiado;
    private LocalDateTime data;

    public PartidaEspontanea(LocalDateTime data, Jogador jogadorDesafiante, Jogador jogadorDesafiado) {
        super();
        this.data = data;
        this.jogadorDesafiante = jogadorDesafiante;
        this.jogadorDesafiado = jogadorDesafiado;

    }

    @Override
    public boolean isEspontanea() {
        return true;
    }

    @Override
    public Jogador getJogadorDesafiado() {
        return jogadorDesafiado;
    }

    @Override
    public Jogador getOtherJogador(Jogador jogador) {
        if (jogador.equals(jogadorDesafiante)) {
            return jogadorDesafiado;
        } else {
            return jogadorDesafiante;
        }
    }

    public Jogador getJogadorDesafiante() {
        return jogadorDesafiante;
    }

    @Override
    public LocalDateTime getData() {
        return data;
    }

}
