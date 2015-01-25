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
			return new ConsoleLogger();
		case TEXT:
			return new TextLogger();
		default:
			return null;
		}
	}
	
	/**
	 * Implements Logger, logs to a text file specified in the app.properties file.
	 */
	private static class TextLogger implements Logger {

		protected TextLogger() {
			// TODO - implement initialization of text properties here
		}
		
		public void log(String pstrMessage) {
			// TODO Auto-generated method stub
			
		}

		public void log(String pstrMessage, LOG_TYPE penmType) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * Implements Logger. Simply logs to console during the application's runtime.
	 */
	private static class ConsoleLogger implements Logger {

		
		protected ConsoleLogger() {
			System.out.println(LOG_TYPE.GRAL.strVal+"Console log initialized");
		}
		
		public void log(String pstrMessage) {
			// TODO Auto-generated method stub
			
		}

		public void log(String pstrMessage, LOG_TYPE penmType) {
			// TODO Auto-generated method stub
			
		}
	}
	
	/**
	 * Permits logging messages to different sources depending on the instance invoked which implements this interface. 
	 */
	public static interface Logger {
		
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
		public void log(final String pstrMessage);
		
		/**
		 * Logs a messages with the specified type.
		 * @param pstrMessage
		 * @param penmType
		 */
		public void log(final String pstrMessage, LOG_TYPE penmType);
		
	}
}
