package oochess.app;

import oochess.app.dtos.JogadorDTO;
import oochess.app.jogador.Jogador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Jogador getJogador(String user) {
        return catalogoJogadores.get(user);
    }

    public void putJogador(Jogador jogador) {
        catalogoJogadores.put(jogador.getUsername(), jogador);
    }

    public boolean existsJogador(String username) {
        return catalogoJogadores.containsKey(username);
    }
    
    public List<JogadorDTO> getJogadoresDelta(int elo, int delta) {
		List<Jogador> listaDelta = new ArrayList<>();    

		catalogoJogadores.forEach((k, v) -> {
            if(v.eloNecessario(elo, delta)) {
            	listaDelta.add(catalogoJogadores.get(k));
            }
        });
		
		return listaDelta.stream().map(u -> new JogadorDTO(u.getUsername(), u.getDiscordUsername(), u.getElo())).collect(Collectors.toList());
	}
    
}
