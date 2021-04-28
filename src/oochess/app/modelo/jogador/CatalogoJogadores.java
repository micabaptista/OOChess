package oochess.app.modelo.jogador;

import oochess.app.facade.dto.JogadorDTO;

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


    /**
     * Get list of valid jogadores with the given delta
     *
     * @param jogadorCorrente jogador Corrente
     * @param delta           max difference of elo
     * @return list of valid jogadores with the given delta
     */
    public List<JogadorDTO> getJogadoresDelta(Jogador jogadorCorrente, int delta) {
        List<Jogador> listaDelta = new ArrayList<>();

        catalogoJogadores.forEach((k, v) -> {
            if (v.isValidDifferenceElo(jogadorCorrente.getElo(), delta)) {
                listaDelta.add(catalogoJogadores.get(k));
            }
        });

        return listaDelta
                .stream()
                .filter(x -> x != jogadorCorrente)
                .map(u -> new JogadorDTO(u.getUsername(), u.getDiscordUsername(), u.getElo()))
                .collect(Collectors.toList());
    }

}
