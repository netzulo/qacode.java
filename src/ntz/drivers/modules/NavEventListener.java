package ntz.drivers.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import ntz.exceptions.BotException;
import ntz.logs.Log;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class NavEventListener implements WebDriverEventListener {
	
	private WebDriver driver;
	
	public NavEventListener(WebDriver driver) throws BotException {
		if(driver == null){
			throw new BotException("[EventDriverListener.constructor][ERROR]: Error at build EventDriverListener with NULL driver");
		}else{
			this.driver = driver;
		}
	}

	public void afterChangeValueOf(WebElement ele, WebDriver drv) {
		drv = getDriver();
 
		Log.info("[EVENT][afterChangeValueOf]: inside method afterChangeValueOf on " + ele.toString());
	}

	public void afterClickOn(WebElement ele, WebDriver drv) {
		drv = getDriver();
		Log.info("[EVENT][afterClickOn]: inside method afterClickOn on " + ele.toString());
	}
 
	public void afterFindBy(By locator, WebElement ele, WebDriver drv) {
		drv = getDriver();
		
		Log.info("[EVENT][afterFindBy]: Find happened on " + ele.toString() + " Using method " + locator.toString());
	}
 
	public void afterNavigateBack(WebDriver drv) {
		drv = getDriver();
 
		Log.info("[EVENT][afterNavigateBack]: Inside the after navigateback to " + drv.getCurrentUrl());
	}
 
	public void afterNavigateForward(WebDriver drv) {
		drv = getDriver();
		
		Log.info("[EVENT][afterNavigateForward]: Inside the afterNavigateForward to " + drv.getCurrentUrl());
	}
 
	public void afterNavigateTo(String url, WebDriver drv) {
		drv = getDriver();
		
		Log.info("[EVENT][afterNavigateTo]: Inside the afterNavigateTo to " + url);
	}
 
	public void afterScript(String scriptJS, WebDriver drv) {
		drv = getDriver();
		
		Log.info("[EVENT][afterScript]: Inside the afterScript to, Script is " + drv);
	}
 
	public void beforeChangeValueOf(WebElement ele, WebDriver drv) {
		drv = getDriver();
 
		Log.info("[EVENT][beforeChangeValueOf]: Inside the beforeChangeValueOf method");
	}
 
	public void beforeClickOn(WebElement ele, WebDriver drv) {
		drv = getDriver();
		
		Log.info("[EVENT][beforeClickOn]: About to click on the " + ele.toString());
 
	}
 
	public void beforeFindBy(By locator, WebElement ele, WebDriver drv) {
		drv = getDriver();
		
		Log.info("[EVENT][beforeFindBy]: Just before finding element " + ele.toString());
 
	}
 
	public void beforeNavigateBack(WebDriver drv) {
		drv = getDriver();
		
		Log.info("[EVENT][beforeNavigateBack]: Just before beforeNavigateBack " + drv.getCurrentUrl());
 
	}
 
	public void beforeNavigateForward(WebDriver drv) {
		drv = getDriver();
		
		Log.info("[EVENT][beforeNavigateForward]: Just before beforeNavigateForward " + drv.getCurrentUrl());
 
	}
 
	public void beforeNavigateTo(String url, WebDriver drv) {
		drv = getDriver();
		
		Log.info("[EVENT][beforeNavigateTo]: Just before beforeNavigateTo " + url);
	}
 
	public void beforeScript(String scriptJS, WebDriver drv) {
		drv = getDriver();
		
		Log.info("[EVENT][beforeScript]: Just before beforeScript " + scriptJS);
	}
 
	public void onException(Throwable exception, WebDriver drv) {
		drv = getDriver();
		
		Log.info("[EVENT][onException]: Exception occured at " + exception.getMessage());
	}

	private WebDriver getDriver() {
		WebDriver returnDriver;
		
		if(this.driver == null){
			returnDriver = null;
		}else{
			returnDriver = this.driver;
		}
		
		return returnDriver;
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
