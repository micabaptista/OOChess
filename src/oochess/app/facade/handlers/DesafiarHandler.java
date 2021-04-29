package oochess.app.facade.handlers;

import java.time.LocalDateTime;
import java.util.List;


import oochess.app.discordintegration.Notificacao;
import oochess.app.modelo.jogador.CatalogoJogadores;
import oochess.app.modelo.torneio.CatalogoTorneios;
import oochess.app.modelo.desafio.Desafio;
import oochess.app.modelo.desafio.DesafioBuilder;
import oochess.app.discordintegration.EnviaNotificacao;
import oochess.app.discordintegration.EnviaNotificacaoFactory;
import oochess.app.OOChessConfiguration;
import oochess.app.facade.dto.JogadorDTO;
import oochess.app.modelo.jogador.Jogador;
import oochess.app.modelo.torneio.Torneio;

public class DesafiarHandler {
    private final CatalogoTorneios catalogoTorneios = CatalogoTorneios.getInstance();
    private final CatalogoJogadores catalogoJogadores = CatalogoJogadores.getInstance();
    private Jogador jogadorCorrente;
    private Jogador jogadorDesafiado;
    private Torneio torneio = null;


    public DesafiarHandler(Jogador jogador) {
        this.jogadorCorrente = jogador;
    }

    /**
     * Update the name of Torneio
     *
     * @param nome nome Torneio
     * @requires {@code  jogadorCorrente != null}
     * @ensures Seja torneio: Torneio, tal que torneio.nomeTorneio = nome
     */
    public void indicaTorneio(String nome) {
        this.torneio = catalogoTorneios.getTorneio(nome);
    }


    /**
     * Get list of valid players with the given delta
     *
     * @param delta delta
     * @return list of all players
     * @requires {@code  jogadorCorrente != null}
     */
    public List<JogadorDTO> indicaDeltaElo(int delta) {
        return catalogoJogadores.getJogadoresDelta(jogadorCorrente, delta);
    }

    /**
     * Select jogador
     *
     * @param nome username of jogador
     * @requires {@code  jogadorCorrente != null}
     * @ensures Seja jogadorDesafiado : Jogador, tal que jogadorDesafiado.username = user
     */
    public void indicaJogador(String nome) {
        this.jogadorDesafiado = catalogoJogadores.getJogador(nome);
    }

    /**
     * Choose some details to invite a player and return the code of partida
     *
     * @param datahora data partida
     * @param msg      mensagem opcional
     * @return code of partida
     * @requires {@code  jogadorCorrente != null && jogadorDesafiado != null && datahora >= atual}
     * @ensures É criado d: Desafio tal que é criada uma associação de d a jogadorCorrente
     * através de "cria" e é criada uma associação de d a jogadorDesafiado estão atraves de
     * "recebe"
     */
    public String indicaDetalhes(LocalDateTime datahora, String msg) {

        enviaNotificacao(new Notificacao(jogadorCorrente, datahora, msg)
                .toString());

        Desafio desafio = new DesafioBuilder()
                .withDataPartida(datahora)
                .withMensagem(msg)
                .withDesafiado(jogadorDesafiado)
                .withDesafiante(jogadorCorrente)
                .withTorneio(torneio)
                .build();


        jogadorCorrente.adicionaDesafioEnviado(desafio);
        jogadorDesafiado.adicionaDesafioRecebido(desafio);

        return desafio.getCodigo();
    }

    private void enviaNotificacao(String msg) {
        String token = OOChessConfiguration.getInstance().getString("DISCORD_TOKEN");
        EnviaNotificacao e = EnviaNotificacaoFactory.getINSTANCE().getEnviaNotificacao();
        e.envia(token, jogadorDesafiado.getDiscordUsername(), msg);
    }

}
