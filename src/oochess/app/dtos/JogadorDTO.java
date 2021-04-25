package oochess.app.dtos;

public class JogadorDTO {

    private String username;
    private String discordUsername;
    private int elo;


    public JogadorDTO(String username, String discordUsername, int elo) {
        this.username = username;
        this.discordUsername = discordUsername;
        this.elo = elo;

    }

    public String getUsername() {
        return username;
    }

    public String getDiscordUsername() {
        return discordUsername;
    }

    public int getElo() {
        return elo;
    }
}
