package com.reqres.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
	
	public int RESPONSE_STATUS_CODE_200 = 200;
	public int RESPONSE_STATUS_CODE_201 = 201;
	public int RESPONSE_STATUS_CODE_204 = 204;
	public int RESPONSE_STATUS_CODE_400 = 400;
	public int RESPONSE_STATUS_CODE_401 = 401;
	public int RESPONSE_STATUS_CODE_404 = 404;
	public int RESPONSE_STATUS_CODE_405 = 405;
	public int RESPONSE_STATUS_CODE_500 = 500;
	
	public Properties prop;
	
	// Below is constructor & Created of base class which invoke(call) every time whenever any test script run
	
	public BaseClass() {
				
		try {
			Properties prop = new Properties();
			FileInputStream ip = new FileInputStream (System.getProperty("user.dir")+"/src/main/java/com/reqres/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
