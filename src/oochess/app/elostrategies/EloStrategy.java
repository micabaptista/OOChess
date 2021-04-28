package oochess.app.elostrategies;

import oochess.app.modelo.jogador.Jogador;
import oochess.app.modelo.partida.Partida;

public interface EloStrategy {

    void execute(Jogador jogadorCorrente, Partida partida);

    double getInitialElo();
}
