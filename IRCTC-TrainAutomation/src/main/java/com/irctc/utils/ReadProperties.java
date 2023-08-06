package com.irctc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.Properties;

// class to read Configuration file
public class ReadProperties {

	public static Properties getProperties() {

		Properties properties = new Properties();
		String projectPath = System.getProperty("user.dir");
		try (FileInputStream fis = new FileInputStream(new File(projectPath + "\\Resources\\input\\Configuration.properties"))) {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
