package oochess.app.discordintegration;

import net.padroesfactory.Channel;
import net.padroesfactory.Discord4JMock;

public class Discord4JAdapter implements EnviaNotificacao {

	@Override
	public void envia(String token, String user, String msg) {
		Discord4JMock c = new Discord4JMock(token);
		Channel canalDoDestinatario = c.getChannel(user);
		canalDoDestinatario.sendMessage(msg);
	}
}
