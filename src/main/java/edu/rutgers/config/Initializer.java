package edu.rutgers.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

import edu.rutgers.model.impl.DataManager;
import edu.rutgers.util.ConfigReader;
import edu.rutgers.util.LoggerFactory;
import edu.rutgers.util.enums.LOGGER_TYPE;
import edu.rutgers.util.enums.PROPERTIES;

/**
 * Will run on app initialization in web container. Main objective is to instantiate all singletons which will provide facilities
 * across the applications.
 *
 */
public class Initializer implements WebApplicationInitializer {
	
	/**
	 * Initializes singleton instances for properties, logging and data access.
	 */
	public void onStartup(ServletContext arg0) throws ServletException {
		try {
			LOGGER_TYPE loggerType;
			if(ConfigReader.getInstance().getStr(PROPERTIES.LOGGER).equalsIgnoreCase("console")) {
				loggerType = LOGGER_TYPE.CONSOLE;
			} else {
				loggerType = LOGGER_TYPE.TEXT;
			}
			LoggerFactory.getLogger(loggerType);
			DataManager.getInstance();
		} catch (Exception e) { // temporary catch all for initializer 
			System.out.println("FATAL ERROR: onStartup of Initializer");
		}
	}

}
