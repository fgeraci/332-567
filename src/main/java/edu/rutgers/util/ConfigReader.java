package edu.rutgers.util;

import java.util.Properties;

import edu.rutgers.util.LoggerFactory.LOGGER_TYPE;
import edu.rutgers.util.LoggerFactory.Logger;

public class ConfigReader {
	
	private final static String gPropsFile = "app.properties";
	private Logger gLogger;
	private static Properties gProperties;
	private volatile static ConfigReader instance;
	
	private ConfigReader() {
		gProperties = new Properties();
		gLogger = LoggerFactory.getLogger(LOGGER_TYPE.CONSOLE);
		try {
			gProperties.load(ConfigReader.class.getClassLoader().getResourceAsStream(ConfigReader.gPropsFile));
		} catch (Exception e) {
			gLogger.log("Error loading application's general properties");
		}
	}
	
	public synchronized static ConfigReader getInstance() {
		if(ConfigReader.instance == null) {
			ConfigReader.instance = new ConfigReader();
		}
		return ConfigReader.instance;
	}
}
