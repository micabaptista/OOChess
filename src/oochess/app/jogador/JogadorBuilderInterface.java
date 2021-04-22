package oochess.app.jogador;

public interface JogadorBuilderInterface {

    public JogadorBuilder withUsername(String username);

    public JogadorBuilder withPassword(String password);

    public JogadorBuilder withDiscordUsername(String discordUsername);

    public Jogador build();
 
}
