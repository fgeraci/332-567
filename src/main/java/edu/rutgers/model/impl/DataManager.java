package edu.rutgers.model.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import edu.rutgers.model.api.ModelManager;
import edu.rutgers.util.ConfigReader;
import edu.rutgers.util.LoggerFactory;
import edu.rutgers.util.ConfigReader.PROPERTIES;
import edu.rutgers.util.LoggerFactory.LOGGER_TYPE;
import edu.rutgers.util.LoggerFactory.Logger;
import edu.rutgers.util.LoggerFactory.Logger.LOG_TYPE;

/**
 * Singleton implementation of ModelManager for data read/write
 *
 */
public class DataManager implements ModelManager {
	
	private Logger gLogger;
	private static String gstrConnection;
	private static String gstrDBName;
	private static String gstrDBUser;
	private static String gstrDBPassword;
	
	private DataManager() throws Exception {
		initializeManager();
	}
	
	private static DataManager instance;
	
	public void initializeManager() throws Exception {
		gLogger = LoggerFactory.getLogger(LOGGER_TYPE.CONSOLE);
		ConfigReader configs = ConfigReader.getInstance();
		Connection con = null;
		gstrConnection = configs.getStr(PROPERTIES.DB_CONNECTION);
		gstrDBName = configs.getStr(PROPERTIES.DB_NAME);
		gstrDBUser = configs.getStr(PROPERTIES.DB_USER);
		gstrDBPassword = configs.getStr(PROPERTIES.DB_PASSWORD);
		gstrConnection = gstrConnection + File.separator + gstrDBName;
		try {
			Class.forName(gstrConnection);
			con = DriverManager.getConnection(gstrConnection,gstrDBUser,gstrDBPassword);
		} catch (Exception e) {
			gLogger.log("FAILED TO INITIALIZE DataManager", LOG_TYPE.FATAL_ERROR);
		} finally {
			if(con != null) con.close();
		}
	}
	
	/**
	 * Returns a single instance of DataManager
	 * @return DataManager singleton instance
	 * @throws Exception 
	 */
	public static DataManager getInstance() throws Exception {
		if(DataManager.instance == null) {
			DataManager.instance = new DataManager();
		}
		return DataManager.instance;
	}
	
	/**
	 * Returns a single connection to the MySQL instance specified in the app.properties file
	 * @return
	 */
	public Connection borrowConnection() {
		return null;
	}
}
