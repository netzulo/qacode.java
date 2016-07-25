package ntz.app;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ntz.drivers.TrandashaBase;
import ntz.drivers.ITrandasha.BrowserMode;
import ntz.drivers.ITrandasha.DriverType;
import ntz.drivers.navs.pages.IPage;
import ntz.drivers.navs.pages.PageBase;
import ntz.drivers.navs.pages.models.IModel;
import ntz.drivers.navs.pages.models.ModelBase;
import ntz.exceptions.PageException;
import ntz.exceptions.TrandashaException;
import ntz.logs.Log;
import ntz.tests.ITestInfo;
import ntz.tests.TestInfoBase;
/**
* @author netzulo.com
* @since 2016-07-25
* @version 0.5.2
* @update FIX 0.5.4_a
* 
* <p></p>
* <p></p>
* <p></p>
*/
public class DemoQATest extends TestInfoBase implements ITestInfo{
	
	private IPage page;

	@BeforeClass
	public void OpenSuite() throws TrandashaException, PageException {
		try {
			this.logBeforeClass(this.getClass().getName());
			this.bot = new TrandashaBase(DriverType.LOCAL, BrowserMode.CHROME);
			this.page = this.pageInit(bot, new PageBase(bot,"http://demoqa.com/",true));			
		} catch (Exception | AssertionError e) { onErrorAtFinish(e);}			
	}
	
	@AfterClass
	public void CloseSuite() throws PageException{
		try {
			this.botFinish(bot);			
			this.logAfterClass(this.getClass().getName());				
		} catch (Exception | AssertionError e) { onErrorAtFinish(e);}	
	}

	@Test
	public void LoadPageControls_after_model_creation() throws PageException {
		try {						
			this.page.addModel(new ModelBase(bot));
			this.page.addControlsToModel(
					"#site_navigation > div > div.collapse.navbar-collapse.navbar-ex1-collapse",
					"#post-9 > div > div:nth-child(1)",
					"#post-9 > div > div:nth-child(2)",
					"#post-9 > div > div:nth-child(3)",
					"#post-9 > div > div.col-md-6.tabcontents"
			);			
			@SuppressWarnings("unused")
			List<IModel> models = this.page.getModels();							
			Log.info("----------------------------------------------");
			Log.info("Page.toJson: "+ page.toString());
			Log.info("----------------------------------------------");
		} catch (Exception | AssertionError e) { 
			onErrorAtFinish(e);
		}
	}
}
