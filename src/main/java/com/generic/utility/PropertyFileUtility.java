package com.generic.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	public String getDataFromPropertiesFile(String KEY) throws IOException {
		FileInputStream file = new FileInputStream(IConstantsUtility.PROPERTIESFILEPATH);
		Properties properties = new Properties();
		properties.load(file);
		String value = properties.getProperty(KEY);
		return value;
	}
}
