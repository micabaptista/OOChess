package oochess.app.facade.handlers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import oochess.app.CatalogoJogadores;
import oochess.app.CatalogoTorneios;
import oochess.app.desafio.Desafio;
import oochess.app.desafio.DesafioBuilder;
import oochess.app.discordintegration.Discord4JAdapter;
import oochess.app.discordintegration.EnviaNotificacao;
import oochess.app.discordintegration.EnviaNotificacaoFactory;
import oochess.app.discordintegration.JDAAdapter;
import oochess.app.discordintegration.MyConfiguration;
import oochess.app.discordintegration.notificadorNaoSuportado;
import oochess.app.dtos.JogadorDTO;
import oochess.app.jogador.Jogador;
import oochess.app.torneio.Torneio;

public class DesafiarHandler {
	private CatalogoTorneios ct;
	private CatalogoJogadores cj;
	private Jogador jogadorCorrente;
	private Jogador jogadorDesafiado;
	private Torneio tr = null;
		
	
	// builder?? 
	public DesafiarHandler(CatalogoTorneios ct, CatalogoJogadores cj, Jogador jogador) {
		this.ct = ct;
		this.cj = cj;
		this.jogadorCorrente = jogador;
	}
	
	
	public void indicaTorneio(String nome) {
		this.tr = ct.getTorneio(nome);
	}


	
	public List<JogadorDTO> indicaDeltaElo(int delta) {
		return cj.getJogadoresDelta(jogadorCorrente.getElo(), delta);
	}

	public void indicaJogador(String nome) {
		this.jogadorDesafiado = cj.getJogador(nome);

	}
	
	public String indicaDetalhes(LocalDateTime datahora, String msg) {

		enviaNotificacao(msg);	

		Desafio d =new DesafioBuilder()
                .withDataPartida(datahora)
                .withMensagem(msg)
                .withDesafiado(jogadorDesafiado)
                .withDesafiante(jogadorCorrente)
                .withTorneio(tr)
                .build();
		
        jogadorCorrente.adicionaDesafioEnviado(d);
		jogadorDesafiado.adicionaDesafioRecebido(d);
		
		return d.getCodigo();	
	}
	
	private void enviaNotificacao(String msg) {
		String token = MyConfiguration.getINSTANCE().getString("DISCORD_TOKEN");
		EnviaNotificacao e = EnviaNotificacaoFactory.getINSTANCE().getEnviaNotificacao();
		e.envia(token, jogadorDesafiado.getDiscordUsername(), msg);
	}
	
}
