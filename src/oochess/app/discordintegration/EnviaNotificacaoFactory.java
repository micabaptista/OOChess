package oochess.app.discordintegration;

import java.lang.reflect.InvocationTargetException;

public class EnviaNotificacaoFactory {
	private static EnviaNotificacaoFactory INSTANCE = null;
	
	private EnviaNotificacaoFactory() {
	}
	public static EnviaNotificacaoFactory getINSTANCE() {
			if (INSTANCE == null) {
				INSTANCE = new EnviaNotificacaoFactory();
			}
			return INSTANCE;
	}
	

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
