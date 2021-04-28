package oochess.app.modelo.jogador;

import oochess.app.modelo.desafio.Desafio;

import java.util.List;
import java.util.Map;

public class JogadorBuilder  implements  JogadorBuilderInterface{

    private String username;
    private String password;
    private String discordUsername;
    private List<Desafio> desafiosRecebidos;//é preciso?????
    private Map<String, Desafio> desafiosCriados;//é preciso?????

    @Override
    public JogadorBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public JogadorBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public JogadorBuilder withDiscordUsername(String discordUsername) {
        this.discordUsername = discordUsername;
        return this;
    }

    @Override
    public Jogador build() {
        return new Jogador(username,password,discordUsername);
    }
    
}
