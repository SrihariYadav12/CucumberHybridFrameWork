package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	public static Properties intilizeProperties() {
		Properties prop = new Properties();
		File f = new File(System.getProperty("user.dir") + "/Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);

		} catch (Throwable e) {

		}
		return prop;
	}

}
