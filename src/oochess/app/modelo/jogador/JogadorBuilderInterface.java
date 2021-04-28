package oochess.app.modelo.jogador;

public interface JogadorBuilderInterface {

    JogadorBuilder withUsername(String username);

    JogadorBuilder withPassword(String password);

    JogadorBuilder withDiscordUsername(String discordUsername);

    Jogador build();

}
