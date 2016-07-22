package ntz.drivers.navs.elements;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.drivers.modules.IJscripts;
import ntz.exceptions.ControlException;
import ntz.tests.errors.ITestErrorMessage;

/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public abstract class AControl implements IControl {
	/**Fields************************************************************************************/	

	protected WebElement element;
	protected WebDriver driver;
	protected JavascriptExecutor driverJS;
	//---
	protected String tagName;
	//---
	protected Hashtable<String,String> eventsJS = new Hashtable<>();	
	protected TakesScreenshot screenShot;
	protected byte[] screenShotAsBytes;
	protected String screenShotAsBase64;
	
	//---
	protected String text;
	
	//---
	//Atributos HTML comunes a TODOS los elementos	
	protected String id;
	protected String className;
	protected String style;	
	
	/**Constructors******************************************************************************/
	

	/**
	 * Try to create an instance of BOT using WebElement param
	 * verify what WebElement it's not null
	 * */
	public AControl(WebElement currentEle) throws ControlException{
		if(currentEle == null){ throw new ControlException("[BOT][ERROR]: Constructor, element param it's null"); }
		else{
			this.element = currentEle;			
			this.tagName = this.element.getTagName();	
			
			readTagText();			
		}
	}	

	public AControl(WebDriver driver, String cssSelector) throws ControlException{
		this(driver.findElement(By.cssSelector(cssSelector)));		
	}

	/********************************************************************************/
	@Override
	public void readAttributes() {
		id = this.element.getAttribute("id");
		className = this.element.getAttribute("class");
		style = this.element.getAttribute("style");		
	}
	
	
	@Override
	public void loadControl() {
		// TODO carga la configuracion para el control this
		
	}
	/********************************************************************************/
	
	@Override
	public void click() throws ControlException {
		if(element != null){
			try {
				element.click();
			} catch (Exception e) {
				throw new ControlException(ITestErrorMessage.ERROR_clickEle);
			}
		}
	}
	
	@Override
	public void clickJS() throws ControlException {
		if(element != null){
			try {
				this.driverJS.executeScript(IJscripts.js_click, element);
			} catch (Exception e) {
				throw new ControlException(ITestErrorMessage.ERROR_clickEle);
			}
		}
	}

	@Override
	public void textClear() throws ControlException {
		if(element != null){
			try {
				element.clear();
			} catch (Exception e) {
				throw new ControlException(ITestErrorMessage.ERROR_clearEle);
			}
		}		
	}

	@Override
	public void textWrite(String text) throws ControlException {
		if(element != null){
			try {				
				element.sendKeys(text);
			} catch (Exception e) {
				throw new ControlException(ITestErrorMessage.ERROR_writeEle);
			}
		}
	}

	@Override
	public void textClearAndWrite(String text) throws ControlException {
		if(element != null){
			this.textClear();
			this.textWrite(text);			
		}		
	}

	@Override
	public WebElement childrenByCss(String selector) {
		return this.element.findElement(By.cssSelector(selector));		
	}
	
	@Override
	public List<WebElement> childrensByCss(String selector){
		return this.element.findElements(By.cssSelector(selector));
	}
	
	@Override
	public WebElement childrenByXPath(String selector) {
		return this.element.findElement(By.xpath(selector));		
	}
	
	@Override
	public List<WebElement> childrensByXPath(String selector){
		return this.element.findElements(By.xpath(selector));
	}

	@Override
	public String readTagText() {
		String tagText = "";
		if(this.tagName.contains("input")) {
			tagText = this.text = this.element.getAttribute("value");
		}
		else{
			tagText = this.text = this.element.getText();
		}	
		return tagText;
	}
	

	@Override
	public boolean takeScreenShot() {
		return this.takeScreenShot(this.driver);
	}

	@Override
	public boolean takeScreenShot(WebDriver driver) {
		boolean isTaked;
		try {
			this.screenShot = (TakesScreenshot) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			this.screenShotAsBytes = (byte[]) ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			this.screenShotAsBase64 = (String) ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			isTaked = true;
		} catch (Exception e) {
			isTaked = false;
		}
		return isTaked;	
	}
	
	/**GETs & SETs methods****************************************************************************/
	@Override
	public WebElement getElement() {
		return this.element;
	}

	@Override
	public String getText() {
		return this.text;		
	}

	@Override
	public TakesScreenshot getScreenShot() {
		return screenShot;
	}

	@Override
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
