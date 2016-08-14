package ntz.app;


import org.testng.annotations.Test;

import ntz.drivers.TrandashaBase;
import ntz.drivers.ITrandasha.BrowserMode;
import ntz.drivers.ITrandasha.DriverType;
import ntz.drivers.navs.pages.PageBase;
import ntz.exceptions.PageException;
import ntz.tests.ITestInfo;
import ntz.tests.TestInfoBase;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class TrandashaTest extends TestInfoBase implements ITestInfo{

	/*** Test Dependencies fields******************************************************************/
	
	/*** Test-NG VARs *****************************************************************************/
	/*** Test-NG Methods***************************************************************************/
	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}
	
	@DataProvider(name="browsersDP")
	public Object[][] browsersDP(){
		return new Object[][]{
//			{DriverType.LOCAL,BrowserMode.FIREFOX},
//			{DriverType.LOCAL,BrowserMode.CHROME},					
//			{DriverType.LOCAL,BrowserMode.IEXPLORER},			
//			{DriverType.LOCAL,BrowserMode.PHANTHOMJS},
//			{DriverType.LOCAL,BrowserMode.OPERA},
//			{DriverType.LOCAL,BrowserMode.EDGE},
//			{DriverType.LOCAL,BrowserMode.IPHONE},
//			{DriverType.LOCAL,BrowserMode.IPAD},
//			{DriverType.LOCAL,BrowserMode.ANDROID},
//			{DriverType.REMOTE,BrowserMode.FIREFOX}, 
			{DriverType.REMOTE,BrowserMode.CHROME},					
//			{DriverType.REMOTE,BrowserMode.IEXPLORER},	
//			{DriverType.REMOTE,BrowserMode.OPERA},
//			{DriverType.REMOTE,BrowserMode.PHANTHOMJS},			
//			{DriverType.REMOTE,BrowserMode.EDGE},
//			{DriverType.REMOTE,BrowserMode.IPHONE},
//			{DriverType.REMOTE,BrowserMode.IPAD},
//			{DriverType.REMOTE,BrowserMode.ANDROID}
		};
	}
	/*** Data Providers****************************************************************************/

	/** TESTs **********************************************************************************  ***/
	
	
	
	@Test(dataProvider="browsersDP")
	public void TestCase_IPage(DriverType type,BrowserMode browser) throws PageException {
		String url = "http://192.168.0.100:11000/wd/hub";
		try {
			if(type == DriverType.REMOTE) this.bot = new TrandashaBase(type,browser,url);
			else this.bot = new TrandashaBase(type,browser,url);
			
			this.pageInit(bot, new PageBase(bot,"http://google.com",true));
			
			this.botFinish(bot);
		} catch (Exception | AssertionError e) { onErrorAtFinish(e);}		
	}
	
	/*** Private methods***************************************************************************/
	/*** GETs & SETs*******************************************************************************/

}

