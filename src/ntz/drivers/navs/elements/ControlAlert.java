package ntz.drivers.navs.elements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.security.UserAndPassword;

import ntz.exceptions.ControlException;
import ntz.tests.errors.ITestErrorMessage;

/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class ControlAlert extends ControlBase implements IControl{
	/**Fields************************************************************************************/
	protected Alert elementAlert;
	protected Credentials creeds;	
	
	/**Constructors******************************************************************************/
		
	public ControlAlert(WebElement currentEle) throws ControlException {
		super(currentEle);
		elementAlert = driver.switchTo().alert();
	}

	public ControlAlert(WebDriver driver, String cssSelector) throws ControlException {
		super(driver, cssSelector);		
	}
	
	public void accept() throws ControlException{
		try {
			elementAlert.accept();;
		} catch (Exception e) {
			throw new ControlException(ITestErrorMessage.ERROR_alertAccept);
		}
	}
	
	public void cancel() throws ControlException{			
		try {
			elementAlert.dismiss();
		} catch (Exception e) {
			throw new ControlException(ITestErrorMessage.ERROR_alertCancel);
		}
	}
	
	public void authenticate(String username, String password) throws ControlException{
		try {
			creeds = new UserAndPassword(username, password);		
			elementAlert.authenticateUsing(creeds);
		} catch (Exception e) {
			throw new ControlException(ITestErrorMessage.ERROR_alertAuth);
		}
	}
	
	@Override
	public void textWrite(String textWrite){
		elementAlert.sendKeys(textWrite);
	}
	
	@Override
	public String getText(){
		return elementAlert.getText();		
	}
}
