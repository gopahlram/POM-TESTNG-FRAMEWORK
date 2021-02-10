package com.laf.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.laf.constants.FrameworkConstants;

public final class ReadProperties {
	
	
	private ReadProperties() {
		
	}
	
	
	public static String getValue(String key) throws IOException {
		
		Properties property = new Properties();
		FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath());
		property.load(file);
		return property.getProperty(key);	}

}
