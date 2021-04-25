package oochess.app.discordintegration;

import com.chavetasfechadas.JDAMock;
import com.chavetasfechadas.JDAMockBuilder;

public class JDAAdapter implements EnviaNotificacao{

	@Override
	public void envia(String token, String user, String msg) {
		// ver outros param
		JDAMock c = new JDAMockBuilder().createDefault(token /*ficheiro*/).disableCache(true).setCompression(true).setActivity("Playing chess").build();
		//verificar message
		c.sendMessage(user, msg);
		
	}

	

}
