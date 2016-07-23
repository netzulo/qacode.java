package ntz.drivers.navs.elements;

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
public class ControlCell extends ControlBase implements IControl{
	
	public ControlCell(WebElement currentEle) throws ControlException {
		super(currentEle);			
	}
	public ControlCell(WebDriver driver, String cssSelector) throws ControlException{
		super(driver,cssSelector);		
	}
}
