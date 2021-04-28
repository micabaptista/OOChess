package oochess.app.modelo.torneio;

import java.util.HashMap;
import java.util.Map;

public class CatalogoTorneios {

    private static CatalogoTorneios instance = null;
    private Map<String, Torneio> catalogoTorneios;

    private CatalogoTorneios() {
        catalogoTorneios = new HashMap<>();
    }


    public static CatalogoTorneios getInstance() {
        if (CatalogoTorneios.instance == null) {
            instance = new CatalogoTorneios();
        }
        return instance;
    }
    
    public void addTorneio(Torneio t) {
		this.catalogoTorneios.put(t.getNome(), t);
	}

    public Torneio getTorneio(String nome) {
        return catalogoTorneios.get(nome); 
    }


}
