package oochess.app.elostrategies;

import oochess.app.modelo.jogador.Jogador;
import oochess.app.modelo.partida.Partida;

public class ByOne implements EloStrategy {
    private static final double INITIAL_ELO = 5;
    private static final double VALUE_DEFAULT = 1;

    public void execute(Jogador jogadorCorrente, Partida partida) {

        switch (partida.getResultado()) {
            case "VITORIA":
                jogadorCorrente.increaseElo(VALUE_DEFAULT);
                partida.getOtherJogador(jogadorCorrente).decreaseElo(VALUE_DEFAULT);
                break;

            case "DERROTA":
                jogadorCorrente.decreaseElo(VALUE_DEFAULT);
                partida.getOtherJogador(jogadorCorrente).decreaseElo(VALUE_DEFAULT);
                break;

            case "EMPATE":
                break;

            default:
                throw new IllegalArgumentException("O resultado dado não é valido!");
        }
    }

    @Override
    public double getInitialElo() {
        return INITIAL_ELO;
    }
}
