package ntz.app.unitaries;

import org.testng.annotations.Test;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import ntz.drivers.ITrandasha.BrowserMode;
import ntz.drivers.ITrandasha.DriverType;
import ntz.core.PLogin;
import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.elements.ControlBase;
import ntz.drivers.navs.elements.IControl;
import ntz.drivers.navs.pages.IPage;
import ntz.files.FileManager;
import ntz.testlink.TestlinkBase;
import ntz.exceptions.PageException;
import ntz.exceptions.TestInfoException;
import ntz.tests.TestInfoBase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterClass;

public class IControlTest extends TestInfoBase{
	private IPage page;
	private IControl control;
	
	  @BeforeClass
	  public void beforeClass() throws TestInfoException {
		  super.logBeforeClass(IControlTest.class.getName());
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
		  super.logAfterClass(IControlTest.class.getName());	  
		  try {
			  bot.close();			  
		  } catch (Exception e) {
			  throw new TestInfoException("Bot error");
		  }
		  try {		  
			  this.testlink.apiExecResults();
		  } catch (Exception e) {
			  throw new TestInfoException("Bot error");
		  }
	  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  
  	@Test
  	public void test_0001() throws PageException{
  		String pageUrl = "http://demoqa.com/registration/"; 
  		String selector= "[id='name_3_firstname']";
  		
  		TestCase testcase = this.testlink.getTestCaseByExtId("lc-2");  		
  		testcase.setExecutionStatus(ExecutionStatus.BLOCKED);	  
	  
  		try {  			
  			this.reportAll("INIT","starting test");
  			//----
  			this.bot.navs.goToUrl(pageUrl);
  			
  			this.control = new ControlBase(this.bot,selector);
  			
  			this.reportAll("NTZ", this.control.eleAttrs().toString());
  			
  			//----
  			this.reportAll("DONE","logged", testcase, ExecutionStatus.PASSED);  			  			  		
  		} catch (Exception e) {
  			this.reportAll("ERROR","Failed testcase | "+ e.getMessage(), testcase, ExecutionStatus.FAILED);
  			//--				
  			this.onErrorAtFinish(e);
  		}  		  	
  	}
  	
  	
}
