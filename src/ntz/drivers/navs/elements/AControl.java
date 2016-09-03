package ntz.drivers.navs.elements;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.drivers.ITrandasha;
import ntz.drivers.TrandashaBase;
import ntz.drivers.modules.IJscripts;
import ntz.exceptions.ControlException;
import ntz.exceptions.NavException;
/**
* @author netzulo.com
* @since 2016-07-25
* @version 0.5.5
* 
* 
* @TODO: change driver for bot instance
* <p></p>
* <p></p>
* <p></p>
*/
public class AControl implements IControl {
	
	/**Fields************************************************************************************/
	/***/
	protected ITrandasha bot;
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
	public AControl(ITrandasha bot) throws ControlException{		
		if(bot == null){throw new ControlException();}
		else{
			this.bot = bot;
			eventsJS = new Hashtable<>();
			stylesHTML = new Hashtable<>();
			stylesCSS = new Hashtable<>();		
		}
	}
	public AControl(ITrandasha bot,String selector) throws ControlException {
 		this(bot);		
			if(selector.length() <= 0){throw new ControlException();}
			else{
				this.selector = selector;		
				this.element = this.getDriver().findElement(By.cssSelector(selector));
				if(this.element == null){throw new ControlException("[AControl][ERROR]: Can't found element");}
				else{
					//init element
					this.Init();
				}
			}
		
	}
	public AControl(ITrandasha bot,WebElement element)throws ControlException {
		this(bot);
		
		if(element == null){throw new ControlException();}
		else{
			this.selector = "NOTLOADED";
			this.element = element;
			if(this.element == null){throw new ControlException("[AControl][ERROR]: Can't found element");}
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
			allEleEvents = ((JavascriptExecutor)this.getDriver()).executeScript(IJscripts.js_getAllEventListeners, this.element).toString();
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
	public String eleRead() throws ControlException {
		// TODO Auto-generated method stub
		return null;
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
		boolean isCleared = false;
		try {
			((TrandashaBase)this.bot).navs.eleClear(this);
		} catch (NavException e) {
			throw new ControlException("["+this.selector+"]: Error at click element| " + e.getStackTrace().toString());
		}
		return isCleared;
	}
	@Override
	public void eleClick() throws ControlException {
		try {
			((TrandashaBase)this.bot).navs.eleClick(this);
		} catch (NavException e) {
			throw new ControlException("["+this.selector+"]: Error at click element| " + e.getStackTrace().toString());
		}
	}
	@Override
	public void eleClickByJS() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("[AControl][WARNING]: Function not defined");		
	}
	
	@Override
	public Hashtable<String,String> eleAttrs() throws ControlException{
		return this.stylesHTML;
	}
	
	@Override
	public IControl eleAttr(String attrName) throws ControlException {
		try {
			String attr = "";
			//Validate non-existent attributes
			try {
				attr = this.element.getAttribute(attrName).toString();
			} catch (Exception e) {}
			//Redefine attr if null
			attr = (attr.equalsIgnoreCase(""))? "undefined" : attr;
			
			this.stylesHTML.put(attrName, attr);
		} catch (Exception e) {
			throw new ControlException("["+this.selector+"]: Error at get HTML tag attribute from element| " + e.getStackTrace().toString());
		}
 		return this;
	}
	@Override
	public IControl eleChild() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("[AControl][WARNING]: Function not defined");
	}
	@Override
	public IControl eleChildByPos(int... childsPosition) throws ControlException{
		// TODO Auto-generated method stub
		throw new ControlException("[AControl][WARNING]: Function not defined");
	}
	@Override
	public IControl eleChildFirst() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("[AControl][WARNING]: Function not defined");
	}
	@Override
	public IControl eleChildLast() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("[AControl][WARNING]: Function not defined");
	}
	@Override
	public List<IControl> eleChildren() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("[AControl][WARNING]: Function not defined");
	}
	@Override
	public List<IControl> eleChildrenByPos(int... childsPosition) throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("[AControl][WARNING]: Function not defined");
	}
	@Override
	public IControl eleNext() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("[AControl][WARNING]: Function not defined");
	}
	@Override
	public IControl elePrevious() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("[AControl][WARNING]: Function not defined");
	}
	@Override
	public IControl eleParent() throws ControlException {
		// TODO Auto-generated method stub
		throw new ControlException("[AControl][WARNING]: Function not defined");
	}
	@Override
	public WebDriver getDriver() throws ControlException {
		try {
			return ((TrandashaBase)this.bot).navs.getDriver();		
		} catch (Exception e) {
			if(e instanceof NavException){
				throw new ControlException("[AControl][ERROR]: can't load driver from navs.getDriver()");
			}
			else{
				throw new ControlException("[AControl][ERROR]: unkown error | "+ e.getStackTrace());
			}
		}		
	}	
	@Override
	public String getSelector() throws ControlException {
		return this.selector;
	}
	@Override
	public String getTagName() throws ControlException {
		return this.tagName;
	}
	@Override
	public TakesScreenshot getScreenshot() throws ControlException {
		return this.screenShot;
	}
	@Override
	public byte[] getScreenshotAsBytes() throws ControlException {
		return this.screenShotAsBytes;
	}
	@Override
	public String getScreenshotAsBase64() throws ControlException {
		return this.screenShotAsBase64;
	}
	@Override
	public WebElement getElement() throws ControlException {
		return this.element;
	}	
	@Override
	public String getText() throws ControlException {
		return this.text;
	}
	
	//**DEBUG*/	
	@Override
	public String toString() {
		try {
			return "AControl {'driver':" + this.getDriver().toString() + ", 'element':" + element + ", 'selector':" + selector + ", 'tagName':" + tagName
					+ ", 'screenShot':" + screenShot + ", 'screenShotAsBytes':" + Arrays.toString(screenShotAsBytes)
					+ ", 'screenShotAsBase64':" + screenShotAsBase64 + ", 'eventsJS':" + eventsJS + ", 'stylesHTML':" + stylesHTML
					+ ", 'stylesCSS':" + stylesCSS + "}";
		} catch (ControlException e) { e.printStackTrace();	}
		return "[AControl.toString][ERROR]: Error at toString";
	}	
}
