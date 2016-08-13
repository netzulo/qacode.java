package ntz.core.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import ntz.drivers.ITrandasha.BrowserMode;
import ntz.drivers.ITrandasha.DriverType;
import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.pages.IPage;
import ntz.exceptions.PageException;
import ntz.exceptions.TestInfoException;
import ntz.exceptions.TestlinkException;
import ntz.files.FileManager;
import ntz.testlink.TestlinkBase;
import ntz.tests.TestInfoBase;
import ntz.tests.errors.ITestErrorMessage;
import ntz.core.PLogin;

public class PLoginTest extends TestInfoBase{
	
	private IPage page;

  @BeforeClass
  public void beforeClass() throws TestInfoException {
	  super.logBeforeClass(PLogin.class.getName());
	  try {
		  TrandashaBase _bot = new TrandashaBase(DriverType.LOCAL, BrowserMode.CHROME);
		  bot = this.botInit(_bot);	
	  } catch (Exception e) {
		  throw new TestInfoException("Bot error");
	  }
	  try {
		  this.testlink = this.testlinkInit(new TestlinkBase(FileManager.PATH_TESTLINK));	
	  } catch (Exception e) {
		  throw new TestInfoException("Testlink error");
	  }
	  
  }

  @AfterClass
  public void afterClass() throws TestInfoException {
	  super.logAfterClass(PLogin.class.getName());	  
	  try {
		  bot.navs.getDriver();		
	  } catch (Exception e) {
		  throw new TestInfoException("Bot error");
	  }
	  try {		  
		  this.testlink.apiExecResults();
	  } catch (Exception e) {
		  throw new TestInfoException("Bot error");
	  }
  }
  
  
  	@Test
  	public void webdata_login_OK() throws PageException, TestlinkException {  		  		  		
  		TestCase testcase = this.testlink.getTestCaseByExtId("wd-1");  		
  		testcase.setExecutionStatus(ExecutionStatus.BLOCKED);
  		try {  			
  			this.reportAll("INIT","starting test");
  			//----
  			this.page = new PLogin(bot,"http://192.168.0.150:8585/login.aspx",true, true);
  			
  			((PLogin)this.page).login("wose", "patata");
  			
  			this.tryAssertEquals(this.page.getCurrentUrl(), "http://192.168.0.150:8585/main.aspx", new PageException(ITestErrorMessage.ERROR_url));
  			
  			//----
  			this.reportAll("DONE","logged", testcase, ExecutionStatus.PASSED);  			  			  		
		} catch (Exception e) {
			this.reportAll("ERROR","Failed testcase | "+ e.getMessage(), testcase, ExecutionStatus.FAILED);
			//--				
			this.onErrorAtFinish(e);
		}  		  		
  	}	
  	
  	

	@Test
  	public void webdata_login_KO() throws PageException {
		TestCase testcase = this.testlink.getTestCaseByExtId("wd-2");  		
  		testcase.setExecutionStatus(ExecutionStatus.BLOCKED);
  		try {  			
  			this.reportAll("INIT","starting test");
  			//----
  			this.page = this.pageInit(bot, new PLogin(bot,"http://192.168.0.150:8585/login.aspx",true, true));
  			
  			((PLogin)this.page).login("ERROR", "ERROR");
  			  			
  			this.tryAssertEquals(this.page.getCurrentUrl(), "http://192.168.0.150:8585/Default.aspx?error=true", new PageException(ITestErrorMessage.ERROR_url));
  			//----
  			this.reportAll("DONE","logged", testcase, ExecutionStatus.PASSED);  			  			  		
		} catch (Exception e) {
			this.reportAll("ERROR","Failed testcase | "+ e.getMessage(), testcase, ExecutionStatus.FAILED);
			//--				
			this.onErrorAtFinish(e);
		}  		  		  		 
  	}	  
}
