package oochess.app;

public class Jogador {
    private String username;
    private String password;
    private String discordUsername;
    private int elo;

    public Jogador(String username, String password, String discordUsername) {
        this.username = username;
        this.password = password;
        this.discordUsername = discordUsername;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDiscordUsername() {
        return discordUsername;
    }

    public int getElo() {
        return elo;
    }
}
