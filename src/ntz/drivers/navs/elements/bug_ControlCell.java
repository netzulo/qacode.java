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
public class bug_ControlCell extends ControlBase implements IControl{
	
	public bug_ControlCell(WebElement currentEle) throws ControlException {
		super(currentEle);			
	}
	public bug_ControlCell(WebDriver driver, String cssSelector) throws ControlException{
		super(driver,cssSelector);		
	}
}
