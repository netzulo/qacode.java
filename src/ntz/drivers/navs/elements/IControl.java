package ntz.drivers.navs.elements;

import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.exceptions.ControlException;

/**
* @author netzulo.com
* @since 2016-07-22
* @version 0.5.1
* 
* <p></p>
* <p></p>
* <p></p>
*/
public interface IControl {
	
	 void click() throws ControlException;
	 void clickJS() throws ControlException;		
	 
	 void textClear() throws ControlException;
	 
	 void textWrite(String text) throws ControlException;
	
	 void textClearAndWrite(String text) throws ControlException;
	 
	 WebElement childrenByCss(String selector);
	 List<WebElement> childrensByCss(String selector);
	 WebElement childrenByXPath(String selector);
	 List<WebElement> childrensByXPath(String selector);
	 String readTagText();
	 
	 /**
	  * Need to be defined on inherit classes,sets values for properties of WebElement to IControl inherit class
	  * @author netzulo.com
	  * @since 2013-01-1
	  * @version 0.5.1
	  */
	 void readAttributes();		
	
	 /**
	  * Need to be defined on inherit classes,sets values for properties of WebElement to IControl inherit class
	  * @author netzulo.com
	  * @since 2013-01-1
	  * @version 0.5.1
	  */
	 void loadControl();
	 
	 boolean takeScreenShot();
	 
	 boolean takeScreenShot(WebDriver driver);
	 	 
	 
	/**GETs & SETs*******************************************************************************/
	 WebElement getElement();
	 String getText();
	 TakesScreenshot getScreenShot();
	 void setDriver(WebDriver driver);
	
	


	
	 
}
