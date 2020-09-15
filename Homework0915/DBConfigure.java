package newssystem.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfigure {
	
	private final static String dbResource = "database.properties";
	private static Properties dbProperties = new Properties();

	static {
		InputStream resStream = DBConfigure.class.getClassLoader().getResourceAsStream(dbResource);

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
