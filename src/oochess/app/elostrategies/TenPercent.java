package oochess.app.elostrategies;

import oochess.app.jogador.Jogador;
import oochess.app.partida.Partida;

public class TenPercent implements EloStrategy {

    private static final double INITIAL_ELO = 50;


    public void execute(Jogador jogadorCorrente, Partida partida) {
        double dirElo;
        dirElo = (Math.abs(jogadorCorrente.getElo() - partida.getOtherJogador(jogadorCorrente).getElo()) * 0.1) + 5;

        if (partida.getResultado().equals("VITORIA")) {
            jogadorCorrente.setElo(jogadorCorrente.getElo() + dirElo);
            partida.getOtherJogador(jogadorCorrente).setElo(partida.getOtherJogador(jogadorCorrente).getElo() - dirElo);

        } else if (partida.getResultado().equals("DERROTA")) {
            partida.getOtherJogador(jogadorCorrente).setElo(partida.getOtherJogador(jogadorCorrente).getElo() + dirElo);
            jogadorCorrente.setElo(jogadorCorrente.getElo() - dirElo);

        } else {
            if (jogadorCorrente.getElo() > partida.getOtherJogador(jogadorCorrente).getElo()) {
                partida.getOtherJogador(jogadorCorrente).setElo(partida.getOtherJogador(jogadorCorrente).getElo() + (Math.abs(jogadorCorrente.getElo() - partida.getOtherJogador(jogadorCorrente).getElo()) * 0.05));
                jogadorCorrente.setElo(jogadorCorrente.getElo() - (Math.abs(jogadorCorrente.getElo() - partida.getOtherJogador(jogadorCorrente).getElo()) * 0.05));
            } else {
                jogadorCorrente.setElo(jogadorCorrente.getElo() + (Math.abs(jogadorCorrente.getElo() - partida.getOtherJogador(jogadorCorrente).getElo()) * 0.05));
                partida.getOtherJogador(jogadorCorrente).setElo(partida.getOtherJogador(jogadorCorrente).getElo() - (Math.abs(jogadorCorrente.getElo() - partida.getOtherJogador(jogadorCorrente).getElo()) * 0.05));
            }
        }

    }

    @Override
    public double getInitialElo() {
        return INITIAL_ELO;
    }
}
