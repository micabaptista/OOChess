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
	private Torneio tr = null;
		
	
	public DesafiarHandler(Jogador jogador) {
		this.jogadorCorrente = jogador;
	}
	
	
	public void indicaTorneio(String nome) {
		this.tr = catalogoTorneios.getTorneio(nome);
	}


	public List<JogadorDTO> indicaDeltaElo(int delta) {
		return catalogoJogadores.getJogadoresDelta(jogadorCorrente, delta);
	}

	public void indicaJogador(String nome) {
		this.jogadorDesafiado = catalogoJogadores.getJogador(nome);

	}
	
	public String indicaDetalhes(LocalDateTime datahora, String msg) {

		enviaNotificacao(new Notificacao(jogadorCorrente,datahora,msg)
                        .toString());

		Desafio desafio =new DesafioBuilder()
                .withDataPartida(datahora)
                .withMensagem(msg)
                .withDesafiado(jogadorDesafiado)
                .withDesafiante(jogadorCorrente)
                .withTorneio(tr)
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
