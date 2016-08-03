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
			{DriverType.LOCAL,BrowserMode.FIREFOX},//OK: 15-06-2016
			{DriverType.LOCAL,BrowserMode.CHROME},//OK: 15-06-2016					
			{DriverType.LOCAL,BrowserMode.IEXPLORER},//OK: 15-06-2016			
			{DriverType.LOCAL,BrowserMode.PHANTHOMJS},//OK: 15-06-2016
			{DriverType.LOCAL,BrowserMode.OPERA},// ?
			{DriverType.LOCAL,BrowserMode.EDGE},// ?
			{DriverType.LOCAL,BrowserMode.IPHONE},// KO
			{DriverType.LOCAL,BrowserMode.IPAD},// KO
			{DriverType.LOCAL,BrowserMode.ANDROID},// KO
			{DriverType.REMOTE,BrowserMode.FIREFOX}, //ERROR: 15-06-2016
			{DriverType.REMOTE,BrowserMode.CHROME},//OK: 15-06-2016					
			{DriverType.REMOTE,BrowserMode.IEXPLORER},//OK: 15-06-2016		
			{DriverType.REMOTE,BrowserMode.PHANTHOMJS},//OK: 15-06-2016
			{DriverType.REMOTE,BrowserMode.OPERA},//ERROR: 15-06-2016
			{DriverType.REMOTE,BrowserMode.EDGE},// ?
			{DriverType.REMOTE,BrowserMode.IPHONE},// KO
			{DriverType.REMOTE,BrowserMode.IPAD},// KO
			{DriverType.REMOTE,BrowserMode.ANDROID}// ?
		};
	}
	/*** Data Providers****************************************************************************/

	/** TESTs *************************************************************************************/
	
	
	
	@Test(dataProvider="browsersDP", timeOut=45000)
	public void TestCase_IPage(DriverType type,BrowserMode browser) throws PageException {
		String url = "http://192.168.0.100:11001/wd/hub";
		try {
			if(type == DriverType.REMOTE) this.bot = new TrandashaBase(type,browser,url);
			else this.bot = new TrandashaBase(type,browser,url);
			
			this.pageInit(bot, new PageBase(bot,"http://google.com"));
			
			this.botFinish(bot);
		} catch (Exception | AssertionError e) { onErrorAtFinish(e);}		
	}
	
	/*** Private methods***************************************************************************/
	/*** GETs & SETs*******************************************************************************/

}

