package edu.rutgers.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
	
	/**
	 * String representation of a current time stamp in DD/MM/YYYY HH:MM:SS format
	 * @return String date representation
	 */
	public static String getDataStampString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(new Date());
	}
	
}
