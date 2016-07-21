package ntz.drivers.navs.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.exceptions.ControlException;

/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class ControlCell extends ControlBase implements IControl{
	
	public ControlCell(WebElement currentEle) throws ControlException {
		super(currentEle);			
	}
	public ControlCell(WebDriver driver, String cssSelector) throws ControlException{
		super(driver,cssSelector);		
	}
}
