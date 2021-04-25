package oochess.app.discordintegration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//singleton
public class MyConfiguration {
	private static MyConfiguration INSTANCE = null;
	private Properties properties = new Properties();
	
	
	private MyConfiguration() {
		try {
			FileInputStream file = new FileInputStream(new File("src/default.properties"));
			properties.load(file);
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	public static MyConfiguration getINSTANCE() {
		if(INSTANCE == null){
            INSTANCE =  new MyConfiguration();
        }
        return INSTANCE;
	}
	
		
	 public String getString(String key){
	        return properties.getProperty(key);
	 }
		
		
}
