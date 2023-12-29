package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

	private Properties property;
	
	public void propertiesInit(String filePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getData(String key) {
		return property.getProperty(key);
	}
}
