package ntz.app.demos;

import org.testng.annotations.Test;

import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.pages.IPage;
import ntz.drivers.navs.pages.PageBase;
import ntz.exceptions.TrandashaException;
import ntz.exceptions.PageException;
import ntz.drivers.ITrandasha.BrowserMode;
import ntz.drivers.ITrandasha.DriverType;
import ntz.tests.ITestInfo;
import ntz.tests.TestInfoBase;

public class StoreTest extends TestInfoBase implements ITestInfo{
	private IPage page;	
	@Test
	public void LoadPage() throws TrandashaException, PageException {
		try {
			this.bot = new TrandashaBase(DriverType.LOCAL, BrowserMode.CHROME);
			this.page =	this.pageInit(bot, new PageBase(bot,"http://store.demoqa.com/",true));			
		} catch (Exception | AssertionError e) { onErrorAtFinish(e);}				
	}
	
	
}
