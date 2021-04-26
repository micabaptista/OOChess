package oochess.app.elostrategies;

import oochess.app.jogador.Jogador;
import oochess.app.partida.Partida;

public class ByOne implements EloStrategy {
    private static final double INITIAL_ELO = 5;
    private static final double VALUE_DEFAULT = 1;

    public void execute(Jogador jogadorCorrente, Partida partida) {

        if (partida.getResultado().equals("VITORIA")) {
            jogadorCorrente.increaseElo(VALUE_DEFAULT);
            partida.getOtherJogador(jogadorCorrente).decreaseElo(VALUE_DEFAULT);

        } else if (partida.getResultado().equals("DERROTA")) {
            jogadorCorrente.decreaseElo(VALUE_DEFAULT);
            partida.getOtherJogador(jogadorCorrente).decreaseElo(VALUE_DEFAULT);
        }
    }

    @Override
    public double getInitialElo() {
        return INITIAL_ELO;
    }
}
