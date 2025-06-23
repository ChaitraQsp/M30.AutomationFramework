package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of generic methods related to Java
 * @author Chaitra M
 *
 */
public class JavaUtility {
	
	/**
	 * This method will capture the current system date in required
	 * format and return it to Caller
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss"); 
		String date = sdf.format(d);
		return date;
	}

}
