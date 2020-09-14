package gamesetting;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class gameConfig {

	private final static String dbResource = "player.properties";
	private static Properties dbProperties = new Properties();
	
	static {
		
		InputStream resStream = gameConfig.class.getClassLoader().getResourceAsStream(dbResource);
		
		try {
			dbProperties.load(resStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String  getProperty(String propertyKey) {
		return dbProperties.getProperty(propertyKey);
	}
	
}
