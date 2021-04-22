package oochess.app;

import oochess.app.jogador.Jogador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogoJogadores {

    private static CatalogoJogadores instance = null;
    private Map<String, Jogador> catalogoJogadores;


    private CatalogoJogadores() {
        this.catalogoJogadores = new HashMap<>();
    }

    public static CatalogoJogadores getInstance() {
        if (CatalogoJogadores.instance == null) {
            instance = new CatalogoJogadores();
        }
        return instance;
    }

    //ver se dto ou private 
    public Jogador getJogador(String user) {
        return catalogoJogadores.get(user);
    }

    public void putJogador(Jogador jogador) {
        catalogoJogadores.put(jogador.getUsername(), jogador);
    }

    public boolean existsJogador(String username) {
        return catalogoJogadores.containsKey(username);
    }
    
    public List<Jogador> getJogadoresDelta(int elo, int delta) {
		List<Jogador> listaDelta = new ArrayList<>();    
		// ver se da com stream
		catalogoJogadores.forEach((k, v) -> {
            if(v.eloNecessario(elo, delta)) {
            	listaDelta.add(catalogoJogadores.get(k));
            }
            
        });
		
		return listaDelta;
	}
    
}
