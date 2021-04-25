package oochess.app.elostrategies;

import oochess.app.jogador.Jogador;

public interface EloStrategy {
	
	public void execute(Jogador j1,Jogador j2,String resultado);

}
