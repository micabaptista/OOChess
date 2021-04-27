package oochess.app.discordintegration;

import oochess.app.jogador.Jogador;

import java.time.LocalDateTime;

public class Notificacao {

    private Jogador jogadorDesafiante;
    private LocalDateTime data;
    private String mensagem;

    public Notificacao(Jogador jogadorDesafiante, LocalDateTime data, String mensagem) {
        this.jogadorDesafiante = jogadorDesafiante;
        this.data = data;
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "O jogador " + jogadorDesafiante.getUsername() + " convidou-o para uma partida de xadrez em "
                + data.toString() + ":" + mensagem;
    }
}
