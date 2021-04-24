package oochess.app.dtos;

public class JogadorDTO {

    private String username;
    private String discordUsername;


    public JogadorDTO(String username, String discordUsername) {
        this.username = username;
        this.discordUsername = discordUsername;
    }

    public String getUsername() {
        return username;
    }

    public String getDiscordUsername() {
        return discordUsername;
    }
}
