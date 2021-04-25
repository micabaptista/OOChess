package oochess.app;

import oochess.app.partida.Partida;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CatalogoPartidas {

    private static CatalogoPartidas instance = null;
    private Map<String, Partida> catalogoPartidas;

    private CatalogoPartidas() {
        catalogoPartidas = new HashMap<>();
    }


    public static CatalogoPartidas getInstance() {
        if (CatalogoPartidas.instance == null) {
            instance = new CatalogoPartidas();
        }
        return instance;
    }

    
    public Partida getPartida(String user, LocalDateTime data) {
        return null; // TODO
    }

    public Partida getPartida(String cod) {
    	return catalogoPartidas.get(cod); //TODO
    }


}
