package ntz.drivers.navs.elements;

import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.exceptions.ControlException;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class ControlBase extends AControl implements IControl{
	/**Fields************************************************************************************/		
	/**Constructors******************************************************************************/
		
	
	public ControlBase(WebElement currentEle) throws ControlException{
		super(currentEle);
	}	

	public ControlBase(WebDriver driver, String cssSelector) throws ControlException{
		super(driver,cssSelector);		
	}
			
	/**Public methods****************************************************************************/
	
	@Override
	public void click() throws ControlException{
		super.click();
	}
	
	@Override
	public void clickJS() throws ControlException{
		super.clickJS();
	}
	
	@Override
	public void textClear() throws ControlException{
		super.textClear();
	}
	
	@Override
	public void textWrite(String text) throws ControlException{
		super.textWrite(text);
	}
	
	@Override
	public void textClearAndWrite(String text) throws ControlException{
		super.textClearAndWrite(text);
	}
	
	
	@Override
	public WebElement childrenByCss(String selector){
		return super.childrenByCss(selector);
	}
	
	@Override
	public List<WebElement> childrensByCss(String selector){
		return super.childrensByCss(selector);
	}
	
	
	@Override
	public WebElement childrenByXPath(String selector) {
		return super.childrenByXPath(selector);
	}

	@Override
	public List<WebElement> childrensByXPath(String selector) {
		return super.childrensByXPath(selector);
	}
	@Override
	public boolean takeScreenShot(){
		return super.takeScreenShot();
	}
	@Override
	public boolean takeScreenShot(WebDriver driver){
		return super.equals(driver);
	}

	/** "Private" methods***************************************************************************/
	
	@Override
	public String readTagText() {
		return super.readTagText();
	}

	
	@Override
	public void readAttributes(){
		super.readAttributes();		
	}
	
	
	@Override
	public void loadControl() {
		super.loadControl();
	}

	/**Protected methods*************************************************************************/
	/**GETs & SETs*******************************************************************************/
	@Override
	public WebElement getElement() {
		return super.getElement();
	}
	@Override
	public String getText(){
		return super.getText();
	}
	@Override
	public TakesScreenshot getScreenShot(){
		return super.getScreenShot();
	}	
	
	@Override
	public void setDriver(WebDriver driver){
		super.setDriver(driver);
	}
}
