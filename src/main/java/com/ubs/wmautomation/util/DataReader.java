package com.ubs.wmautomation.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataReader {


	public static Properties loadConfig() throws Exception {
		String filePath=System.getProperty("user.dir")+"//src/main//resources//config//main.properties";
		File file=new File(filePath);
		FileInputStream fis=new FileInputStream(file);		
		Properties prop=new Properties();
		prop.load(fis);

		System.out.println("selected active env-"+prop.getProperty("active.env"));
		String activefilePath=System.getProperty("user.dir")
				+"//src/main//resources//config//"+prop.get("active.env")+".properties";
		File activeenvfile=new File(activefilePath);
		FileInputStream ative_fis=new FileInputStream(activeenvfile);	
		Properties active_env_file=new Properties();
		System.out.println("loading config file for seleleced active env-"+activefilePath);
		
		active_env_file.load(ative_fis);
		return active_env_file;
	}

}
