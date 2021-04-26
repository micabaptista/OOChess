package oochess.app.elostrategies;

import oochess.app.jogador.Jogador;
import oochess.app.partida.Partida;

public interface EloStrategy {
	
    void execute(Jogador jogadorCorrente, Partida partida);

    double getInitialElo();
}
