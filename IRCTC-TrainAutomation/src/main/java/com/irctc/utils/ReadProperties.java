package com.irctc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.Properties;

public class ReadProperties {
	
	public static Properties getProperties() {

		Properties properties = new Properties();
		try (FileInputStream fis = new FileInputStream(new File(
				"C:\\Users\\2282212\\OneDrive - Cognizant\\Desktop\\java GH\\SeleniumLearnings\\IRCTC-TrainAutomation\\Resources\\Configuration.properties"))) {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
