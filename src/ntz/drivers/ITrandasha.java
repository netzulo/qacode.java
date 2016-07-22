package ntz.drivers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ntz.drivers.modules.NavEventListener;
import ntz.exceptions.BotException;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public interface ITrandasha {
	//ENUMS
	public enum DriverType {
		/**
		 * WebDriver driver executed locally
		 * @author netzulo.com
		 * @since 2013-01-1
		 * @version 0.5.1
		 * */
		LOCAL,
		/**
		 * RemoteDriver driver executed on url of hub server
		* @author netzulo.com
		* @since 2013-01-1
		* @version 0.5.1
		 * */
		REMOTE,
		/**
		 * WebDriverBackedSelenium driver executed on url of hub server with selenium 1.0 functionality
		 * @exception DON'T TESTED
		 * @author netzulo.com
		 * @since 2013-01-1
		 * @version 0.5.1
		 * */
		GRIDONE,		
		};
	public enum BrowserMode {
		/**
		 * Firefox browser
		 * @author netzulo.com
		 * @since 2013-01-1
		 * @version 0.5.1
		 * */
		FIREFOX,
		/**
		 * Chrome browser
		 * */
		CHROME,
		/**
		 * InternetExplore browser
		 * @exception DON'T WORK�
		 * @author netzulo.com
		 * @since 2013-01-1
		 * @version 0.5.1
		 * */
		IEXPLORER,
		/**
		 * Phantom JS driver
		 * @author netzulo.com
		 * @since 2013-01-1
		 * @version 0.5.1
		 * */
		PHANTHOMJS,
		/**
		 * Opera web browser
		 * @author netzulo.com
		 * @since 2013-01-1
		 * @version 0.5.1
		 * */
		OPERA,
		/**
		 * Edge browser
		 * @author netzulo.com
		 * @since 2013-01-1
		 * @version 0.5.1
		 * */
		EDGE,				
		/**
		 * Iphone browser
		 * @exception DON'T WORK
		 * @author netzulo.com
		 * @since 2013-01-1
		 * @version 0.5.1
		 * */
		IPHONE,
		/**
		 * Ipad browser
		 * @exception DON'T WORK
		 * @author netzulo.com
		 * @since 2013-01-1
		 * @version 0.5.1
		 * */
		IPAD,
		/**
		 * Android browser
		 * @exception DON'T WORK
		 * @author netzulo.com
		 * @since 2013-01-1
		 * @version 0.5.1
		 * */
		ANDROID
	};	
	
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	void open(int browser) throws BotException;
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	void openRemote(int browser) throws BotException;
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	Capabilities getCaps(int browser) throws BotException;
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	void close();
	//---
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	WebDriver getDriverLocal()throws BotException;
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	WebDriver getDriverRemote()throws BotException;
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	RemoteWebDriver getDriverAsRemote() throws BotException;
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	WebDriver getDriverEvent() throws BotException;
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	EventFiringWebDriver getDriverAsEvent() throws BotException;
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	JavascriptExecutor getDriverJsExec() throws BotException;
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	NavEventListener getDriverListener() throws BotException;
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	WebDriverWait getDriverWait() throws BotException;
	//---
	
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	void openFirefox();
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	void openChrome();
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	void openIExplorer();
	
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	void openPhantomJS();
	
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	void openOpera();
	
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	void openEdge();	
	//--
	
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	Capabilities capsFirefox();
	
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	Capabilities capsChrome();
	
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	Capabilities capsIExplorer();
	
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	Capabilities capsPhantomJS();
	
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	Capabilities capsOpera();
	
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	Capabilities capsEdge();	
		
	//--
		
	/**
	* Checks with boolean[] if all drivers was loaded rightly
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	int isDriversReady();
	
	/**
	* Load anothers instances for webdriver
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	void loadDrivers() throws BotException;
	
	/**
	* @author netzulo.com
	* @since 2013-01-1
	* @version 0.5.1
	*/
	void loadModules() throws BotException;
	
}