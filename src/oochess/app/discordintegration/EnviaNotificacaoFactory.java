package oochess.app.discordintegration;

import java.lang.reflect.InvocationTargetException;

public class EnviaNotificacaoFactory {
	private static EnviaNotificacaoFactory instance = null;
	
	private EnviaNotificacaoFactory() {
	}
	public static EnviaNotificacaoFactory getInstance() {
			if (instance == null) {
				instance = new EnviaNotificacaoFactory();
			}
			return instance;
	}
	

	@SuppressWarnings("unchecked")
	public EnviaNotificacao getEnviaNotificacao() {
		String type= MyConfiguration.getINSTANCE().getString("DISCORD_CLASS");
		
		try {
			Class<EnviaNotificacao> notificadorClass = (Class<EnviaNotificacao>) Class.forName(type); 
			return notificadorClass.getDeclaredConstructor().newInstance();
			
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException |
                InvocationTargetException e1) {
            return new notificadorNaoSuportado(); 
        } 
			
		
	}
	
}
