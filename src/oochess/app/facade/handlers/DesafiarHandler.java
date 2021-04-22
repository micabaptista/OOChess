package oochess.app.facade.handlers;

import java.time.LocalDateTime;
import java.util.List;

import oochess.app.CatalogoJogadores;
import oochess.app.CatalogoTorneios;
import oochess.app.desafio.Desafio;
import oochess.app.jogador.Jogador;
import oochess.app.torneio.Torneio;

public class DesafiarHandler {
	private CatalogoTorneios ct;
	private CatalogoJogadores cj;
	private Jogador jogadorCorrente;
	private Jogador jogadorDesafiado; // jogadoerDTO???? OU STRING
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


	// DEVOLVER JOGADORDTO
	public List<Jogador> indicaDeltaElo(int delta) {
		return cj.getJogadoresDelta(jogadorCorrente.getElo(), delta);
	}

	public void indicaJogador(String nome) {
		this.jogadorDesafiado = cj.getJogador(nome);

	}

	public String indicaDetalhes(LocalDateTime datahora, String msg) {

		// ver se faz sentido desafio falar com o discod para enviar

		//fazer com builder
		//Desafio d = new Desafio(datahora, msg, jogadorCorrente, jogadorDesafiado /* ou user discord ou user normal ou jogador dto */, tr);
		//jogadorCorrente.adicionaDesafioEnviado(d);
		//jogadorDesafiado.adicionaDesafioRecebido(d);

		return null;
	}
}
