package oochess.app.elostrategies;

import oochess.app.modelo.jogador.Jogador;
import oochess.app.modelo.partida.Partida;

public class TenPercent implements EloStrategy {

    private static final double INITIAL_ELO = 50;

    public void execute(Jogador jogadorCorrente, Partida partida) {
        double value_standard = (Math.abs(jogadorCorrente.getElo() - partida.getOtherJogador(jogadorCorrente).getElo()) * 0.1) + 5;
        double value_empate = Math.abs(jogadorCorrente.getElo() - partida.getOtherJogador(jogadorCorrente).getElo()) * 0.05;

        switch (partida.getResultado()){
            case "VITORIA":
                jogadorCorrente.increaseElo(value_standard);
                partida.getOtherJogador(jogadorCorrente).decreaseElo(value_standard);
                break;

            case "DERROTA":
                jogadorCorrente.decreaseElo(value_standard);
                partida.getOtherJogador(jogadorCorrente).increaseElo(value_standard);
                break;

            case "EMPATE":
                partida.getJogadorHighElo().decreaseElo(value_empate);
                partida.getJogadorLowElo().increaseElo(value_empate);

            default:

        }
    }

    @Override
    public double getInitialElo() {
        return INITIAL_ELO;
    }
}
