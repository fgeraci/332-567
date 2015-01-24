package edu.rutgers.util;

public class LoggerFactory {
	
	public enum LOGGER_TYPE {
		CONSOLE,
		TEXT;
	}
	
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
	
	private static class ConsoleLogger implements Logger {

		public void log(String pstrMessage) {
			// TODO Auto-generated method stub
			
		}

		public void log(String pstrMessage, LOG_TYPE penmType) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static interface Logger {
		
		public enum LOG_TYPE {
			DEBUG,
			ERROR,
			FATAL_ERROR,
			GRAL;
		}
		
		public void log(final String pstrMessage);
		public void log(final String pstrMessage, LOG_TYPE penmType);
		
	}
}
