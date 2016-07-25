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
/**
* @author netzulo.com
* @since 2016-07-25
* @version 0.5.4
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
			Log.error("[NAV.goToUrl][ERROR]: nagivate to"+ url);	
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
			Log.error("[NAV.goBack][ERROR]: nagivate to back");	
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
			Log.error("[NAV.goRefresh][ERROR]: refresh page");	
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
			Log.error("[NAV.tabOpen][ERROR]: open new tab");	
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
			Log.error("[NAV.tabOpen][ERROR]: open new tab");	
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
			Log.error("[NAV.tabOpen][ERROR]: open new tab");	
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
			Log.error("[NAV.tabOpen][ERROR]: open new tab");	
			return false;
		}
		
		return true;
	}

	@Override
	public boolean click(IControl control) throws NavException {
		Log.info("[NAV.tabOpen][INIT]: open new tab");
		try {
			control.eleClick();
			Log.info("[NAV.tabOpen][DONE]: open new tab");
		} catch (Exception e) {
			Log.error("[NAV.tabOpen][ERROR]: open new tab");	
			return false;
		}		
		return true;
	}

	@Override
	public boolean clickJS(IControl control) throws NavException {
		String errCode;
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
			errCode = "[NAV.clickJS][INIT]: Element is not attached to the page document";
			Log.error(errCode);			
			return false;
		} catch (NoSuchElementException e) {
			Log.error("[NAV.clickJS][ERROR]: Element was not found in DOM "+ e.getStackTrace());
			return false;
		} catch (Exception e) {
			Log.error("[NAV.clickJS][ERROR]: Unable to click on element "+ e.getStackTrace());
			return false;
		}
		return true;
	}

	@Override
	public boolean text(IControl control) throws NavException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean text(IControl control, String setText) throws NavException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean textJS(IControl control) throws NavException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean textJS(IControl control, String setText) throws NavException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean attribute(IControl control, String getAttrName) throws NavException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean attributeJS(IControl control, String getAttrName) throws NavException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean attributeJS(IControl control, String getAttrName, String setAttrValue) throws NavException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkbox(IControl control, boolean newState) throws NavException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkboxJS(IControl control, boolean newState) throws NavException {
		// TODO Auto-generated method stub
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
}
