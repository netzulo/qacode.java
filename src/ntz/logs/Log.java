package ntz.logs;

import org.apache.log4j.Logger;

import ntz.exceptions.LogException;
/**
* @author netzulo.com
* @since 2016-03-31
* @version 0.5.1
*/
public class Log {
	/**Fields************************************************************************************/	
	
	/**
	 * InitLog4j logs
	 * */
	 private static Logger Log = Logger.getLogger(Log.class.getName());
	 
	/**Enums*************************************************************************************/	
	/**Constructors******************************************************************************/
	 
	/** 
	 * @throws LogException 
	 * */
	public Log() throws LogException {
		throw new LogException("[Log][ERROR]: Log can not be instantiated");
	}
	
	/**Public methods****************************************************************************/
	 public static void info(String message) {Log.info(message);}
	 
	 public static void warn(String message) {Log.warn(message);}
	 
	 public static void error(String message) {Log.error(message);}
	 
	 public static void fatal(String message) {Log.fatal(message);}
	 
	 public static void debug(String message) {Log.debug(message);} 
	 
	 
	/*Private methods***************************************************************************/
	/**Protected methods*************************************************************************/
	/**GETs & SETs*******************************************************************************/
	 
}
