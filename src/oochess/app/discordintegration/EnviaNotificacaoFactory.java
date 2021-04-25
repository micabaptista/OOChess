package oochess.app.discordintegration;

import sun.security.krb5.Config;

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
		
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e1) {
            return new Calculadora(); //ver se é a padrao
        } 
			
		
	}
	
}
