package oochess.app.elostrategies;

import oochess.app.jogador.Jogador;

public class TenPercent implements EloStrategy {

public void execute(Jogador j1,Jogador j2,String resultado) {
		double dirElo;
		dirElo = (Math.abs(j1.getElo()-j2.getElo())*0.1) +5;
				
		if(resultado.equals("VITORIA")) {
			j1.setElo(j1.getElo()+dirElo);
			j2.setElo(j2.getElo()-dirElo);
			
		}else if(resultado.equals("DERROTA")) {
			j2.setElo(j2.getElo()+dirElo);
			j1.setElo(j1.getElo()-dirElo);
			
		}else {
			if(j1.getElo()>j2.getElo()) {
				j2.setElo(j2.getElo()+(Math.abs(j1.getElo()-j2.getElo())*0.05) );
				j1.setElo(j1.getElo()-(Math.abs(j1.getElo()-j2.getElo())*0.05) );
			}else {
				j1.setElo(j1.getElo()+(Math.abs(j1.getElo()-j2.getElo())*0.05) );
				j2.setElo(j2.getElo()-(Math.abs(j1.getElo()-j2.getElo())*0.05) );
			}		
		}	
	}
}
