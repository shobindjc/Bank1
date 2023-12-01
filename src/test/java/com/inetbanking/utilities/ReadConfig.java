package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig(){
		File fs = new File("./Configuration/config.properties");
		try {
		FileInputStream fis = new FileInputStream(fs);
		pro = new Properties();		
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getBaseurl() {
		return pro.getProperty("baseurl");
	}
	
	public String userName() {
		return pro.getProperty("userName");
		
	}
	
	public String Password() {
		return pro.getProperty("pass");
		
	}
	
	public String chromepath() {
		return pro.getProperty("chromepath");
		
	}
	
	public String firefoxpath() {
		return pro.getProperty("firefoxpath");
		
	}
	public String edgepath() {
		return pro.getProperty("edgepath");
		
	}
	
	

}
