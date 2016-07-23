package ntz.drivers.modules;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ntz.drivers.navs.elements.ControlBase;
import ntz.exceptions.ControlException;
import ntz.exceptions.WebNavException;
import ntz.logs.Log;

/**
 * Store List<WebControl> controls of a website scrapped by searchers
 * @author netzulo.com
 * @since 2013-01-1
 * @version 0.5.1
 */
public class Nav {
	/**Fields************************************************************************************/	
	private List<ControlBase> controls ;
	private WebDriver driver;
	private JavascriptExecutor driverJS;
	/**Constructors******************************************************************************/

	public Nav(WebDriver driver) throws WebNavException{
		if(driver == null){
			throw new WebNavException("[WebNav][ERROR]: Error at build webNav driver, NULL driver");
		}else{
			this.driver = driver;
			this.driverJS = ((JavascriptExecutor)driver);
			controls = new ArrayList<>();
		}
	}
	
	/**Public methods****************************************************************************/
	
	/**
	 * DENIED CONSTRUCTOR
	 * @throws WebNavException 
	 * */
	public Nav() throws WebNavException {
		throw new WebNavException("[WebNav][ERROR]: Constructor denied, need to use an constructor with parameters");
	}

	/**
	 * Cleans controls list
	 * */
	public boolean searchCleaner()throws WebNavException{
		boolean isCleaned = false;
		String err099 = "[WebNav.searchCleaner][ERROR-099]: Error at clear controls list";
		try {
			//if controls list not empty and have more than 0 elements :P
			if(this.controls.size() > 0 || !(this.controls.isEmpty())){
				Log.debug("[WebNav.searchCleaner][DEBUG]: INIT");
				//this.controls.clear();
				this.controls =  new ArrayList<>();
				isCleaned = true;
				Log.debug("[WebNav.searchCleaner][DEBUG]: DONE");
			}			
		} catch (Exception e) {
			Log.fatal(err099+","+e.getMessage());
			throw new WebNavException(err099+","+e.getMessage());
		}
		
		return isCleaned;
	}
	
	public boolean searchAndAdd(String selector)throws WebNavException{
		boolean isFound = false;//subChecks
		boolean isAdded = false;//subChecks
		boolean isResult = false;//return
		WebElement currentEle = null;		
		//Search element
		try {
			
			currentEle = this.driver.findElement(By.cssSelector(selector));
			isFound = true;
			
			if(isFound){
				Log.debug("[WebNav.searchAndAdd][DEBUG]: element found BY CSS| "+ selector);
				isAdded = this.controls.add(new ControlBase(currentEle));
				
				if(isAdded){
					Log.debug("[WebNav.searchAndAdd][DEBUG]: element ADDED to list| "+ selector);
					isResult = true;
				}//added
				else{
					Log.warn("[WebNav.searchAndAdd][ERROR]: Webelement NOT ADDED to list| "+ selector);
					throw new WebNavException("[WebNav.searchAndAdd][ERROR]: Webelement not Added| "+ selector);	
				}
			}//found
			else{
				Log.warn("[WebNav.searchAndAdd][ERROR]: element not found BY CSS| "+ selector);
				throw new WebNavException("[WebNav.searchAndAdd][ERROR]: Webelement not found BY CSS| "+ selector);
			}
		} catch (Exception e) {
			Log.fatal("[WebNav.searchAndAdd][ERROR]: Exception don't expected | for: "+selector);
			throw new WebNavException("[WebNav.searchAndAdd][ERROR]: Exception don't expected | for: "+selector,e);
		}		
		return isResult;
	}
	
	public boolean searchAndAdd(String selector,boolean isValidNULL) throws ControlException{
		boolean found;
		boolean isAdded = false;
		try {
			found = this.searchAndAdd(selector);
			
			if(!found){
				isAdded = this.controls.add(new ControlBase(null));
			}
		} catch (WebNavException e) {			
			isAdded = this.controls.add(new ControlBase(null));		
		}
		return isAdded;
	}
	
	public boolean searchAndAdd(WebElement element)throws WebNavException{
		boolean isAdded = false;//subChecks
		boolean isResult = false;//return		
		//Search element
		try {
			if(element !=null){
				Log.debug("[WebNav.searchAndAdd][DEBUG]: element found");
				isAdded = this.controls.add(new ControlBase(element));				
				if(isAdded){
					Log.debug("[WebNav.searchAndAdd][DEBUG]: element ADDED to list");
					isResult = true;
				}//added
				else{
					Log.warn("[WebNav.searchAndAdd][ERROR]: Webelement NOT Added to list");
					throw new WebNavException("[WebNav.searchAndAdd][ERROR]: Webelement not Added to list");	
				}
			}//found
			else{
				Log.warn("[WebNav.searchAndAdd][ERROR]: Webelement NOT found, NULL");
				throw new WebNavException("[WebNav.searchAndAdd][ERROR]: Webelement NOT found, NULL");
			}
		} catch (Exception e) {
			Log.fatal("[WebNav.searchAndAdd][ERROR]: Exception don't expected");
			throw new WebNavException("[WebNav.searchAndAdd][ERROR]: Exception don't expected",e);
		}		
		return isResult;	
	}	
	
	public String getCurrentUrl() throws WebNavException {
		String err100 = "[WebNav.getCurrentUrl][ERROR-100]: url found it's empty";
		String err101 = "[WebNav.getCurrentUrl][ERROR-101]: url found it's invalid";
		String currentUrl;
		try{
			if(this.driver.getCurrentUrl().equals("") == true){
				Log.fatal(err100);
				throw new WebNavException(err100);
			}
		}catch(Exception e){
			Log.fatal(err101);
			throw new WebNavException(err101, e);
		}		
		Log.debug("[WebNav.getCurrentUrl][DEBUG]: INIT");
		currentUrl = this.driver.getCurrentUrl();
		Log.debug("[WebNav.getCurrentUrl][DEBUG]: DONE");
		
		return currentUrl;
	}
	
	public void navigate(String _url) throws WebNavException {
		String err102 = "[WebNav.navigate][ERROR-102]: url received it's invalid";
		String err103 = "[WebNav.navigate][ERROR-103]: url received found it's invalid";
		
		if(_url.equals("")==true || _url ==null){
			Log.warn(err102);
			throw new WebNavException(err102);
		}
		else{
			try{			
				Log.debug("[WebNav.navigate][DEBUG]: INIT");
				this.driver.get(_url);
				Log.debug("[WebNav.navigate][DEBUG]: DONE");
			}catch(Exception e){
				Log.warn(err103);
				throw new WebNavException(err103, e);
			}								
		}		
	}

	public void tabOpen() throws WebNavException{
		try{	
			Log.debug("[WebNav.tabOpen][DEBUG]: INIT");
			this.driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");
			Log.debug("[WebNav.tabOpen][DEBUG]: DONE");
		}catch(Exception e){
			throw new WebNavException("[WebNav.getCurrentUrl][ERROR-104]: url found it's invalid", e);
		}			
	}
	
	public void tabOpenClosedTab() throws WebNavException{
		try{		
			Log.debug("[WebNav.tabOpenClosedTab][DEBUG]: INIT");
			this.driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "" + Keys.LEFT_SHIFT + "" + "w");
			Log.debug("[WebNav.tabOpenClosedTab][DEBUG]: DONE");
		}catch(Exception e){
			throw new WebNavException("[WebNav.getCurrentUrl][ERROR-105]: keyboard command failed CONTROL+LEFT_SHIFT+W", e);
		}			
	}
	
	public void tabClose() throws WebNavException{
		String err106 = "[WebNav.getCurrentUrl][ERROR-106]: keyboard command failed CONTROL+W";
		try{			
			Log.debug("[WebNav.tabClose][DEBUG]: INIT");
			this.driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "w");
			Log.debug("[WebNav.tabClose][DEBUG]: DONE");
		}catch(Exception e){
			Log.fatal(err106);
			throw new WebNavException(err106, e);
		}			
	}
	
	public void tabChange(int numTab) throws WebNavException{
		String err107 = "[WebNav.getCurrentUrl][ERROR-107]: keyboard command failed CONTROL+"+numTab;
		try{			
			Log.debug("[WebNav.tabChange][DEBUG]: INIT");
			this.driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + ""+numTab);
			Log.debug("[WebNav.tabChange][DEBUG]: DONE");
		}catch(Exception e){
			Log.fatal(err107);
			throw new WebNavException(err107,e);
		}			
	}
	
	/**
	 * DON'T TESTED WELL, DON'T LOG ANYTHING
	 * @throws Exception
	 * */
	public void clickJS(WebElement element) {
		String errCode;
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				Log.info("Clicking on element with using java script click");
				this.driverJS.executeScript(IJscripts.js_click, element);
			} else {
				Log.error("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			errCode = "Element is not attached to the page document";
			Log.error(errCode);			
			
		} catch (NoSuchElementException e) {
			Log.error("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			Log.error("Unable to click on element "+ e.getStackTrace());
		}
		//throw new WebNavException("[WebNav.getCurrentUrl][ERROR-105]: keyboard command failed CONTROL+LEFT_SHIFT+W", e);
	}
	
	/**
	 * Verifica si esta chequeado o no y lo chequea en caso de ser corrrecta la validacion de un elemento
	 * compuesto por
	 * <br>
	 * -SPAN
	 * ---- INPUT : attr = disabled 
	 * ---- LABEL
	 * */
	public void checkbox(WebElement ele , boolean isChecked){
		//String currChk = ele.getAttribute("checked");
		if(true){//currChk.endsWith("true")
			if(isChecked){
				ele.click();
			}
			else{
				// No hace nada por que el checkbox ya esta deshabilitado
			}
		}
	}
	
	/**
	 * Verifica si esta chequeado o no y lo chequea en caso de ser corrrecta la validacion de un elemento
	 * compuesto por
	 * <br>
	 * -SPAN
	 * ---- INPUT : attr = disabled 
	 * ---- LABEL
	 * */
	public void checkboxByJs(WebElement ele , boolean isChecked){
		String currChk = ele.getAttribute("checked");
		if(currChk != null){
			if(currChk.endsWith("true")){
				if(isChecked){
					this.clickJS(ele);
				}
				else{
					// No hace nada por que el checkbox ya esta deshabilitado
				}
			}
			else{
				//El checkbox esta deshabilitado
			}
		}
	}
	
	
	
	/**Private methods***************************************************************************/
	/**Protected methods*************************************************************************/
	/**GETs & SETs*******************************************************************************/
	public List<ControlBase> getControls() {
		return controls;
	}

	public void setControls(List<ControlBase> controls) {
		this.controls = controls;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
