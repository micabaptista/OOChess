package oochess.app.jogador;

import oochess.app.desafio.Desafio;

import java.util.List;
import java.util.Map;

public class JogadorBuilder  implements  JogadorBuilderInterface{

    private String username;
    private String password;
    private String discordUsername;
    private List<Desafio> desafiosRecebidos;
    private Map<String, Desafio> desafiosCriados;

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
