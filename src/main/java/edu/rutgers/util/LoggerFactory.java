package edu.rutgers.util;

/**
 * Provides factory method to retrieve the requested type of Logger.
 *
 */

public class LoggerFactory {
	
	public enum LOGGER_TYPE {
		CONSOLE,
		TEXT;
	}
	
	/**
	 * Factory method which returns the specified logger's instance.
	 * @param penmLoggerType
	 * @return
	 */
	public static Logger getLogger(final LOGGER_TYPE penmLoggerType) {
		switch(penmLoggerType) {
		case CONSOLE:
			return ConsoleLogger.getInstance();
		case TEXT:
			return TextLogger.getInstance();
		default:
			return null;
		}
	}
	
	/**
	 * Implements Logger, logs to a text file specified in the app.properties file.
	 */
	private static class TextLogger extends Logger {

		private static Logger instance;
		
		public static Logger getInstance() {
			if(TextLogger.instance == null) {
				TextLogger.instance = new TextLogger();
			}
			return TextLogger.instance;
		}
		
		protected TextLogger() {
			// TODO - implement initialization of text properties here
		}
		
	}
	
	/**
	 * Implements Logger. Simply logs to console during the application's runtime.
	 */
	private static class ConsoleLogger extends Logger {

		private static Logger instance;
		
		public static Logger getInstance() {
			if(ConsoleLogger.instance == null) {
				ConsoleLogger.instance = new ConsoleLogger();
			}
			return ConsoleLogger.instance;
		}
		
		protected ConsoleLogger() {
			System.out.println(LOG_TYPE.GRAL.strVal+"Console log initialized");
		}
	}
	
	/**
	 * Permits logging messages to different sources depending on the instance invoked which implements this interface. 
	 */
	public static abstract class Logger {
		
		/**
		 * Type of message to be logged.
		 */
		public enum LOG_TYPE {
			DEBUG("DEBUG: "),
			ERROR("ERROR: "),
			FATAL_ERROR("FATAL ERROR: "),
			GRAL("GENERAL: ");
			
			private String strVal;
			
			private LOG_TYPE(final String pstrMessage) {
				strVal = pstrMessage;
			}
		}
		
		/**
		 * Logs a message with GENERAL default type.
		 * @param pstrMessage
		 */
		public void log(String pstrMessage) {
			System.out.println(Utilities.getDataStampString()+" - "+LOG_TYPE.GRAL.strVal+pstrMessage);
		}

		/**
		 * Logs a messages with the specified type.
		 * @param pstrMessage
		 * @param penmType
		 */
		public void log(String pstrMessage, LOG_TYPE penmType) {
			String header;
			switch(penmType) {
			case DEBUG:
				header = LOG_TYPE.DEBUG.strVal;
				break;
			case ERROR:
				header = LOG_TYPE.ERROR.strVal;
				break;
			case FATAL_ERROR:
				header = LOG_TYPE.FATAL_ERROR.strVal;
				break;
			default:
				header = LOG_TYPE.GRAL.strVal;
			}
			System.out.println(Utilities.getDataStampString()+" - "+header+pstrMessage);
		}
	}
}
