package ntz.drivers.navs.elements;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.exceptions.ControlException;
/**
* @author netzulo.com
* @since 2016-07-23
* @version 0.5.3
* 
* <p></p>
* <p></p>
* <p></p>
*/
public class AControl implements IControl {

	/**Fields************************************************************************************/
	/***/
	protected WebDriver driver;
	/***/
	protected WebElement element;
	/***/
	protected String selector;	
	//---
	/***/
	protected String tagName;
	/***/
	protected TakesScreenshot screenShot;
	/***/
	protected byte[] screenShotAsBytes;
	/***/
	protected String screenShotAsBase64;	
	//---
	/***/
	protected Hashtable<String,String> eventsJS = new Hashtable<>();
	/***/
	protected Hashtable<String,String> stylesHTML = new Hashtable<>();
	/***/	
	protected Hashtable<String,String> stylesCSS = new Hashtable<>();		
	/**Constructors******************************************************************************/
	public AControl(WebDriver driver) throws ControlException{		
		if(driver == null){throw new ControlException();}
		else{
			this.driver = driver;
		}
	}
	public AControl(WebDriver driver,String selector) throws ControlException {
		this(driver);
		
		if(selector.length() <= 0){throw new ControlException();}
		else{
			this.element = driver.findElement(By.cssSelector(selector));
			if(this.element == null){
				throw new ControlException("Can't found element");
			}
		}
	}
	public AControl(WebDriver driver,WebElement element)throws ControlException {
		this(driver);
		
		if(element == null){throw new ControlException();}
		else{
			this.element = element;
		}
	}	
	
	/**Commons **********************************************************************************/
	
	@Override
	public IControl Init() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public IControl Init(int searcherTypeInt) throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public IControl Init(SearchMode searcher) throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public IControl InitElement() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public IControl InitHTML() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public IControl InitCSS() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public IControl InitJS() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public boolean runControl() throws ControlException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean eleScreenShot() throws ControlException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean eleWrite(String text) throws ControlException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean eleWrite(String text, boolean isClear) throws ControlException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean eleClear() throws ControlException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void eleClick() throws ControlException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eleClickByJS() throws ControlException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public IControl eleChild() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public IControl eleChildByPos(int... childsPosition) throws ControlException{
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public IControl eleChildFirst() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public IControl eleChildLast() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public List<IControl> eleChildren() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public List<IControl> eleChildrenByPos(int... childsPosition) throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public IControl eleNext() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public IControl elePrevious() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public IControl eleParent() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public WebDriver getDriver() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public String getSelector() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public String getTagName() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public TakesScreenshot getScreenshot() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public byte[] getScreenshotAsBytes() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public String getScreenshotAsBase64() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
	@Override
	public WebElement getElement() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("Funtion not defined");
	}
}
