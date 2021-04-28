package oochess.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OOChessConfiguration {
    private static OOChessConfiguration instance = null;
    private Properties properties = new Properties();


    private OOChessConfiguration() {
        try {
            FileInputStream file = new FileInputStream(new File("preferences.properties"));
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static OOChessConfiguration getInstance() {
        if (instance == null) {
            instance = new OOChessConfiguration();
        }
        return instance;
    }


    public String getString(String key) {
        return properties.getProperty(key);
    }


}
