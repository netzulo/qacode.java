package ntz.app.demos;

import org.testng.annotations.Test;

import ntz.drivers.TrandashaBase;
import ntz.drivers.ITrandasha.BrowserMode;
import ntz.drivers.ITrandasha.DriverType;
import ntz.drivers.navs.elements.ControlBase;
import ntz.drivers.navs.pages.IPage;
import ntz.drivers.navs.pages.PageBase;
import ntz.exceptions.ControlException;
import ntz.exceptions.NavException;
import ntz.exceptions.PageException;
import ntz.exceptions.TrandashaException;
import ntz.logs.Log;
import ntz.tests.TestInfoBase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class SeleniumJavaScriptTest extends TestInfoBase{
	private IPage pageDemo;
	private ControlBase control;
	
	@BeforeClass
	public void beforeClass(){
		
		Log.info("------------------------------------------------------------------");
		Log.info("Starting Test Suite ");
		Log.info("------------------------------------------------------------------");
		try {
			this.bot = this.botInit(new TrandashaBase(DriverType.LOCAL, BrowserMode.CHROME));
			this.pageDemo = this.pageInit(this.bot, new PageBase(this.bot, "http://demoqa.com/", true));
		} catch (TrandashaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public void afterClass(){		
		Log.info(this.control.toString());
		this.botFinish(this.bot);
		Log.info("------------------------------------------------------------------");
		Log.info("FINISH Test Suite ");
		Log.info("------------------------------------------------------------------");
	}
	

	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	       { ".entry-title" },
	    };
	  }

  
	  @Test(dataProvider = "dp")
	  public void Test_Javascript(String selector) throws TrandashaException, ControlException, NavException {
		  JavascriptExecutor driverJS = this.bot.getDriverJsExec();
		  //this.control = new ControlBase(this.bot.webNav.getDriver(), selector);
		  WebElement ele = bot.webNav.getDriver().findElement(By.cssSelector(selector));
		  Object returned = null;
		  
		  try {
			  returned  = driverJS.executeScript("alert(arguments[0])", ele);
		  } catch (Exception e) {
			  Log.error(e.getMessage());
		  }
		  
		  Log.info("RETURNED: "+((WebElement)returned).toString());		  
	  }
}
