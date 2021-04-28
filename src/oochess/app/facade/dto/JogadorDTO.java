package oochess.app.facade.dto;

public class JogadorDTO {

    private String username;
    private String discordUsername;
    private double elo;


    public JogadorDTO(String username, String discordUsername, double d) {
        this.username = username;
        this.discordUsername = discordUsername;
        this.elo = d;

    }

    public String getUsername() {
        return username;
    }

    public String getDiscordUsername() {
        return discordUsername;
    }

    public double getElo() {
        return elo;
    }
}
