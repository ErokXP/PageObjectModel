package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileProcessor {
	
	//read properties file
	public static String readPropertiesFile(String key, String file) {
		
		try(FileInputStream inputStream = new FileInputStream(file)) {
			
			Properties propFile = new Properties();
			propFile.load(inputStream);
			
			return propFile.getProperty(key);
			
		}catch(IOException e) {
			System.out.println("Nu am putut citi fisierul");
			e.printStackTrace();
			return null;
		}
	}
	
}
