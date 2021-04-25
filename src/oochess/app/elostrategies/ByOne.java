package oochess.app.elostrategies;

import oochess.app.jogador.Jogador;

public class ByOne implements EloStrategy {
	
	
	public void execute(Jogador j1,Jogador j2,String resultado) {

		if(resultado.equals("VITORIA")) {
			j1.setElo(j1.getElo()+1);
			j2.setElo(j2.getElo()-1);
			
		}else if(resultado.equals("DERROTA")) {
			j2.setElo(j2.getElo()+1);
			j1.setElo(j1.getElo()-1);	
		}		
	}		
}
