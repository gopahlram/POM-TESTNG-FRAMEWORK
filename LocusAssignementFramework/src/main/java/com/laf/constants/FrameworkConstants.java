package com.laf.constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	
	
	public static int waitTime = 5;
	public static int midWaitTime = 20;
	public static int longWaitTime = 30;

	
	private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCEPATH+"/executables/chromedriver";
	private static final String CONFIGFILEPATH = RESOURCEPATH+"/config/env.properties";

	
	public static String getCHROMEDRIVERPATH() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

}
