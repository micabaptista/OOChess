package oochess.app.discordintegration;

import com.chavetasfechadas.JDAMock;
import com.chavetasfechadas.JDAMockBuilder;

public class JDAAdapter implements EnviaNotificacao{

	@Override
	public void envia(String token, String user, String msg) {
		JDAMock c = new JDAMockBuilder()
                .createDefault(token)
                .disableCache(true)
                .setCompression(true)
                .setActivity("Playing chess")
                .build();

		c.sendMessage(user, msg);
	}
}
