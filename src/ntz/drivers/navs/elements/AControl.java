package ntz.drivers.navs.elements;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.drivers.modules.IJscripts;
import ntz.exceptions.ControlException;
/**
* @author netzulo.com
* @since 2016-07-25
* @version 0.5.5
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
	protected String text;
	/***/
	protected TakesScreenshot screenShot;
	/***/
	protected byte[] screenShotAsBytes;
	/***/
	protected String screenShotAsBase64;	
	//---
	/***/
	protected Hashtable<String,String> eventsJS;
	/***/
	protected Hashtable<String,String> stylesHTML;
	/***/	
	protected Hashtable<String,String> stylesCSS;
	/**Constructors******************************************************************************/
	public AControl(WebDriver driver) throws ControlException{		
		if(driver == null){throw new ControlException();}
		else{
			this.driver = driver;
			eventsJS = new Hashtable<>();
			stylesHTML = new Hashtable<>();
			stylesCSS = new Hashtable<>();		
		}
	}
	public AControl(WebDriver driver,String selector) throws ControlException {
		this(driver);
		
		if(selector.length() <= 0){throw new ControlException();}
		else{
			this.selector = selector;
			this.element = driver.findElement(By.cssSelector(selector));
			if(this.element == null){throw new ControlException("Can't found element");}
			else{
				//init element
				this.Init();
			}
		}
	}
	public AControl(WebDriver driver,WebElement element)throws ControlException {
		this(driver);
		
		if(element == null){throw new ControlException();}
		else{
			this.selector = "NOTLOADED";
			this.element = element;
			if(this.element == null){throw new ControlException("Can't found element");}
			else{
				//init element
				this.Init();
			}
		}
	}	
	
	/**Commons **********************************************************************************/
	
	@Override
	public IControl Init() throws ControlException {		
		Init(SearchMode.ELEMENT);
		Init(SearchMode.HTML);
		Init(SearchMode.CSS);
		Init(SearchMode.JS);
		return this;
	}
	@Override
	public IControl Init(int searcherTypeInt) throws ControlException {
		switch (searcherTypeInt) {
		case 0:
			InitElement();
			break;
		case 1:
			InitHTML();
			break;
		case 2:
			InitCSS();
			break;
		case 3:			
			InitJS();
			break;
		default:
			throw new ControlException();
		}
		return this;
	}
	@Override
	public IControl Init(SearchMode searcher) throws ControlException {
		return Init(searcher.ordinal());		
	}
	@Override
	public IControl InitElement() throws ControlException {
		this.tagName = this.element.getTagName();
		this.text = this.element.getText();
		return this;
	}
	@Override
	public IControl InitHTML() throws ControlException {
		this.stylesHTML.put("id", this.element.getAttribute("id"));
		this.stylesHTML.put("class", this.element.getAttribute("class"));
		this.stylesHTML.put("style", this.element.getAttribute("style"));		
		return this;
	}
	@Override
	public IControl InitCSS() throws ControlException {		
		//Margins
		this.stylesCSS.put("margin-top", this.element.getCssValue("margin-top"));
		this.stylesCSS.put("margin-right", this.element.getCssValue("margin-right"));
		this.stylesCSS.put("margin-bottom", this.element.getCssValue("margin-bottom"));
		this.stylesCSS.put("margin-left", this.element.getCssValue("margin-left"));
		//Paddings
		this.stylesCSS.put("padding-top", this.element.getCssValue("padding-top"));
		this.stylesCSS.put("padding-right", this.element.getCssValue("padding-right"));
		this.stylesCSS.put("padding-bottom", this.element.getCssValue("padding-bottom"));
		this.stylesCSS.put("padding-left", this.element.getCssValue("padding-left"));
		return this;
	}
	@Override
	public IControl InitJS() throws ControlException {
		@SuppressWarnings("unused")
		String allEleEvents = "";
		try {
			allEleEvents = ((JavascriptExecutor)this.driver).executeScript(IJscripts.js_getAllEventListeners, this.element).toString();
		} catch (Exception e) {}
		
		this.eventsJS.put("", this.element.getCssValue("margin-left"));
		
		return this;
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
	
	//**DEBUG*/
	
	@Override
	public String toString() {
		return "AControl {'driver':" + driver + ", 'element':" + element + ", 'selector':" + selector + ", 'tagName':" + tagName
				+ ", 'screenShot':" + screenShot + ", 'screenShotAsBytes':" + Arrays.toString(screenShotAsBytes)
				+ ", 'screenShotAsBase64':" + screenShotAsBase64 + ", 'eventsJS':" + eventsJS + ", 'stylesHTML':" + stylesHTML
				+ ", 'stylesCSS':" + stylesCSS + "}";
	}
	
}
