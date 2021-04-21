package oochess.app;

import oochess.app.jogador.Jogador;

import java.util.HashMap;
import java.util.Map;

public class CatalogoJogadores {

    private static CatalogoJogadores instance = null;
    private Map<String, Jogador> catalogo;


    private CatalogoJogadores() {
        this.catalogo = new HashMap<>();
    }

    public static CatalogoJogadores getInstance() {
        if (CatalogoJogadores.instance == null) {
            instance = new CatalogoJogadores();
        }
        return instance;
    }

    public Jogador getJogador(String user) {
        return catalogo.get(user);
    }

    public void putJogador(Jogador jogador) {
        catalogo.put(jogador.getUsername(), jogador);
    }

    public boolean existsJogador(String username) {
        return catalogo.containsKey(username);
    }
}
