package oochess.app.modelo.desafio;


import java.time.LocalDateTime;
import java.util.Objects;

import oochess.app.generator.RandomCode;
import oochess.app.modelo.jogador.Jogador;
import oochess.app.modelo.torneio.Torneio;

//TALVEZ JOGADOR DTO
public class Desafio {
    private Jogador jogadorDesafiado;
    private Jogador jogadorDesafiante;

    private Torneio torneio;

    private String codigo;
    private String mensagem;
    private LocalDateTime dataPartida;
    private boolean resposta;


    ///builder
    public Desafio(LocalDateTime dataPartida, String mensagem, Jogador jogadorDesafiante, Jogador jogadorDesafiado, Torneio torneio) {
        this.codigo = RandomCode.getInstance().createNewCode();
        this.mensagem = mensagem;
        this.dataPartida = dataPartida;
        this.jogadorDesafiado = jogadorDesafiado;
        this.jogadorDesafiante = jogadorDesafiante;
        this.torneio = torneio;

    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataPartida() {
        return dataPartida;
    }

    public boolean getResposta() {
        return resposta;
    }

    public void setResposta(boolean resposta) {
        this.resposta = resposta;
    }

    public void setDataPartida(LocalDateTime dataPartida) {
        this.dataPartida = dataPartida;
    }

    public Torneio getTorneio() {
        return torneio;
    }

    public Jogador getJogadorDesafiado() {
        return jogadorDesafiado;
    }

    public Jogador getJogadorDesafiante() {
        return jogadorDesafiante;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;


        if (!(o instanceof Desafio)) return false;


        Desafio desafio = (Desafio) o;
        return Objects.equals(jogadorDesafiado, desafio.jogadorDesafiado) &&
                Objects.equals(jogadorDesafiante, desafio.jogadorDesafiante) &&
                Objects.equals(torneio, desafio.torneio) &&
                Objects.equals(codigo, desafio.codigo);
    }
}
