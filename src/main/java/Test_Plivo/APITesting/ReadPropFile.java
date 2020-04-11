package Test_Plivo.APITesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {
	
	public static String getProValue(String uriData) throws IOException {
	
		Properties prop ;
		FileInputStream fis = null;
		String uri = null;
		
	
		
		try {
			fis = new FileInputStream("./data/Testdata.properties");
			prop = new Properties();
			prop.load(fis);
			uri = prop.getProperty(uriData);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return uri;	
	}

}
