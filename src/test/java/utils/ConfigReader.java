package utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	
	static {
		try {
			prop =new Properties();
			FileInputStream file = new FileInputStream("config.properties");
			prop.load(file);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static String get(String key) {
		return prop.getProperty(key);
	}

}
