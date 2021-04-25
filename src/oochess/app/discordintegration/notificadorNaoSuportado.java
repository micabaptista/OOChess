package oochess.app.discordintegration;

public class notificadorNaoSuportado implements EnviaNotificacao {

	@Override
	public void envia(String token, String user, String msg) {
		System.out.println("nao envia nada"); //nao sei se faco algo deste genero ou lanco erro
	}

	

}
