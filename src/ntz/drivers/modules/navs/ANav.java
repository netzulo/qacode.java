package ntz.drivers.modules.navs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import ntz.drivers.modules.IJscripts;
import ntz.drivers.navs.elements.IControl;
import ntz.exceptions.NavException;
import ntz.logs.Log;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
/**
 *@author netzulo.com
* @since 2016-08-06
* @version 0.5.7
* 
* <p></p>
* <p></p>
* <p></p>
*/
public abstract class ANav implements INav {


	/**Fields************************************************************************************/		
	private WebDriver driver = null;
	private JavascriptExecutor driverJS = null;
	/**Constructors******************************************************************************/


	/**
	 * DENIED CONSTRUCTOR
	 * @throws NavException 
	 * */
	public ANav() throws NavException {
		throw new NavException("[WebNav][ERROR]: Constructor denied, need to use an constructor with parameters");
	}
	
	public ANav(WebDriver driver) throws NavException{
		if(driver == null){
			throw new NavException("[WebNav][ERROR]: Error at build webNav driver, NULL driver");
		}else{
			this.driver = driver;
			this.driverJS = (JavascriptExecutor) driver;			
		}
	}
	
	/**Public methods****************************************************************************/
	@Override
	public boolean goToUrl(String url) throws NavException {
		Log.info("[NAV.goToUrl][INIT]: nagivate to"+ url);
		try {
			this.driver.navigate().to(url);
			Log.info("[NAV.goToUrl][DONE]: nagivate to"+ url);
		} catch (Exception e) {
			Log.error("[NAV.goToUrl][ERROR]: nagivate to"+ url +" |"+ e.getStackTrace());	
			return false;
		}
		
		return true;
	}

	@Override
	public boolean goBack() throws NavException {
		Log.info("[NAV.goBack][INIT]: nagivate to back");
		try {
			this.driver.navigate().back();
			Log.info("[NAV.goBack][DONE]: nagivate to back");
		} catch (Exception e) {
			Log.error("[NAV.goBack][ERROR]: nagivate to back |"+ e.getStackTrace());	
			return false;
		}
		
		return true;
	}

	@Override
	public boolean goRefresh() throws NavException {
		Log.info("[NAV.goRefresh][INIT]: refresh page");
		try {
			this.driver.navigate().refresh();
			Log.info("[NAV.goRefresh][DONE]: refresh page");
		} catch (Exception e) {
			Log.error("[NAV.goRefresh][ERROR]: refresh page |"+ e.getStackTrace());	
			return false;
		}
		
		return true;
	}

	@Override
	public boolean tabOpen() throws NavException {
		Log.info("[NAV.tabOpen][INIT]: open new tab");
		try {
			this.driver.findElement(By.tagName("html")).sendKeys(Keys.CONTROL + "t");
			Log.info("[NAV.tabOpen][DONE]: open new tab");
		} catch (Exception e) {
			Log.error("[NAV.tabOpen][ERROR]: open new tab |"+ e.getStackTrace());	
			return false;
		}
		
		return true;
	}

	@Override
	public boolean tabReOpenClosed() throws NavException {
		Log.info("[NAV.tabOpen][INIT]: open new tab");
		try {
			this.driver.findElement(By.tagName("html")).sendKeys(Keys.CONTROL + "" + Keys.LEFT_SHIFT + "" + "w");
			Log.info("[NAV.tabOpen][DONE]: open new tab");
		} catch (Exception e) {
			Log.error("[NAV.tabOpen][ERROR]: open new tab |"+ e.getStackTrace());	
			return false;
		}
		
		return true;
	}

	@Override
	public boolean tabClose() throws NavException {
		Log.info("[NAV.tabOpen][INIT]: open new tab");
		try {
			this.driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "w");
			Log.info("[NAV.tabOpen][DONE]: open new tab");
		} catch (Exception e) {
			Log.error("[NAV.tabOpen][ERROR]: open new tab |"+ e.getStackTrace());	
			return false;
		}
		
		return true;
	}

	@Override
	public boolean tabChange(int numTab) throws NavException {
		Log.info("[NAV.tabOpen][INIT]: open new tab");
		try {
			this.driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + ""+numTab);
			Log.info("[NAV.tabOpen][DONE]: open new tab");
		} catch (Exception e) {
			Log.error("[NAV.tabOpen][ERROR]: open new tab |"+ e.getStackTrace());	
			return false;
		}
		
		return true;
	}

	@Override
	public boolean eleClick(IControl control) throws NavException {
		Log.info("[NAV.eleClick][INIT]: click element");
		try {
			control.getElement().click();
			Log.info("[NAV.eleClick][DONE]: click element");
		} catch (Exception e) {
			Log.error("[NAV.eleClick][ERROR]: click element |"+ e.getStackTrace());	
			return false;
		}		
		return true;
	}
	

	@Override
	public boolean eleClear(IControl control) throws NavException {
		Log.info("[NAV.eleClear][INIT]: clear text on element");
		try {
			control.getElement().clear();
			Log.info("[NAV.eleClear][DONE]: clear text on element");
		} catch (Exception e) {
			Log.error("[NAV.eleClear][ERROR]: clear text on element |"+ e.getStackTrace());	
			return false;
		}		
		return true;
	}

	@Override
	public boolean eleClickJS(IControl control) throws NavException {
		try {
			if (control.getElement().isEnabled() && control.getElement().isDisplayed()) {
				Log.info("[NAV.clickJS][INIT]: Clicking on element with using java script click");
				this.driverJS.executeScript(IJscripts.js_click, control.getElement());
				Log.info("[NAV.clickJS][DONE]: Clicking on element with using java script click");
			} else {
				Log.error("[NAV.clickJS][ERROR]: Unable to click on element");
				return false;
			}
		} catch (StaleElementReferenceException e) {
			Log.error("[NAV.clickJS][INIT]: Element is not attached to the page document |"+ e.getStackTrace());			
			return false;
		} catch (NoSuchElementException e) {
			Log.error("[NAV.clickJS][ERROR]: Element was not found in DOM |"+ e.getStackTrace());
			return false;
		} catch (Exception e) {
			Log.error("[NAV.clickJS][ERROR]: Unable to click on element |"+ e.getStackTrace());
			return false;
		}
		return true;
	}
	
	@Override
	public String text(IControl control) throws NavException {
		String text = "";
		Log.info("[NAV.text][INIT]: get text on element |");
		try {
			text = control.getElement().getText();
			Log.info("[NAV.text][DONE]: get text on element |");
		} catch (Exception e) {
			Log.error("[NAV.text][ERROR]: Unable to get text on element |"+ e.getStackTrace());
		}		
		return text;
	}

	@Override
	public boolean text(IControl control, String setText) throws NavException {
		boolean isExecuted = false;
		Log.info("[NAV.text][INIT]: send text on element ");
		try {
			control.getElement().sendKeys(setText);
			isExecuted = true;
			Log.error("[NAV.text][DONE]: send text on element");
		} catch (Exception e) {
			Log.error("[NAV.text][ERROR]: Unable to send text on element |"+ e.getStackTrace());
		}
		return isExecuted;
	}

	@Override
	public boolean textJS(IControl control) throws NavException {
		try {
			//TODO: do it
			throw new NotImplementedException();
		} catch (Exception e) {
			Log.error("[NAV.text][ERROR]: Unable to send text on element By JS |"+ e.getStackTrace());
		}
		return false;
	}

	@Override
	public boolean textJS(IControl control, String setText) throws NavException {
		try {
			//TODO: do it
			throw new NotImplementedException();
		} catch (Exception e) {
			Log.error("[NAV.text][ERROR]: Unable to send text on element By JS |"+ e.getStackTrace());
		}
		return false;
	}

	@Override
	public String attribute(IControl control, String getAttrName) throws NavException {
		String attr = "";	
		try {
			//TODO: do it 
			attr = control.getElement().getAttribute(getAttrName);
		} catch (Exception e) {
			Log.error("[NAV.text][ERROR]: Unable to send text on element By JS |"+ e.getStackTrace());
		}
		return attr;
	}

	@Override
	public boolean attributeJS(IControl control, String getAttrName) throws NavException {
		try {
			//TODO: do it
			throw new NotImplementedException();
		} catch (Exception e) {
			Log.error("[NAV.attributeJS][ERROR]: Unable to send text on element By JS |"+ e.getStackTrace());
		}
		return false;
	}

	@Override
	public boolean attributeJS(IControl control, String getAttrName, String setAttrValue) throws NavException {
		
		Log.info("[NAV.attributeJS][INIT]: set attribute by JS ");
		try {
			//TODO: do it
			throw new NotImplementedException();
			//Log.info("[NAV.attributeJS][DONE]: set attribute by JS");
		} catch (Exception e) {
			Log.error("[NAV.attributeJS][ERROR]: Unable to set attribute by JS |"+ e.getStackTrace());
		}
		return false;
	}

	@Override
	public boolean checkbox(IControl control, boolean newState) throws NavException {
		try {
			//TODO: do it
			throw new NotImplementedException();
		} catch (Exception e) {
			Log.error("[NAV.text][ERROR]: Unable to send text on element By JS |"+ e.getStackTrace());
		}
		return false;
	}

	@Override
	public boolean checkboxJS(IControl control, boolean newState) throws NavException {
		try {
			//TODO: do it
			throw new NotImplementedException();
		} catch (Exception e) {
			Log.error("[NAV.text][ERROR]: Unable to send text on element By JS |"+ e.getStackTrace());
		}
		return false;
	}

	@Override
	public WebDriver getDriver() throws NavException {
		return this.driver;
	}
	
	@Override
	public boolean setDriver(WebDriver driver) throws NavException {
		if(driver != null){return false;}			
		else{this.driver = driver;return true;}				
	}
		
	@Override
	public String getCurrentUrl() throws NavException{
		String currUrl = "";		
		Log.info("[NAV.getCurrentUrl][INIT]: get current url");
		try {
			currUrl = this.driver.getCurrentUrl();
			Log.info("[NAV.getCurrentUrl][DONE]: get current url");
		} catch (Exception e) {
			Log.error("[NAV.getCurrentUrl][ERROR]: Unable to get current url |"+ e.getStackTrace());
		}		
		return  currUrl;
	}

	@Override
	public boolean maximize() throws NavException{
		Log.info("[NAV.maximize][INIT]: maximize browser window ");
		try {
			this.getDriver().manage().window().maximize();
			Log.info("[NAV.maximize][DONE]: maximize browser window ");
		} catch (Exception e) {
			Log.error("[NAV.maximize][ERROR]: Unable to maximize browser window |"+ e.getStackTrace());
		}
		
		return false;
	}
}
