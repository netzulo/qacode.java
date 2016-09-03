package ntz.tests;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.pages.IPage;
import ntz.exceptions.NavException;
import ntz.exceptions.PageException;
import ntz.exceptions.TestlinkException;
import ntz.exceptions.TrandashaException;
import ntz.files.FileManager;
import ntz.logs.Log;
import ntz.testlink.TestlinkBase;
import ntz.tests.errors.ITestErrorMessage;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public abstract class ATestInfo implements ITestInfo {

	/**@FIELDs***********************************************************************************/
	protected TrandashaBase bot;	
	protected TestlinkBase testlink;
	/**@CONSTRUCTORs***********************************************************************************/
	
	public ATestInfo() {}
	/**@throws TestlinkException 
	 * @throws WebNavException 
	 * @throws TrandashaException 
	 * @Public_methods***************************************************************************/
	
	@Override
	public TestlinkBase testlinkInit(TestlinkBase _testlink) throws TestlinkException{
		Log.info("[TESTLINK][INIT]: starting testlink API");
		try {			
			if(_testlink == null || _testlink.api == null){
				Hashtable<String,String> props = FileManager.readProperties(FileManager.PATH_TESTLINK, "url","devkey");
				this.testlink = new TestlinkBase(props.get("url"), props.get("devkey"));			
			}else{
				this.testlink = _testlink;
			}
			Log.info("[TESTLINK][DONE]: started testlink API");
		} catch (Exception e) {
			Log.error("[TESTLINK][ERROR]: can't start testlink API");
			throw new TestlinkException();
		}
		return this.testlink;
	}
	
	@Override
	public TrandashaBase botInit(TrandashaBase bot) throws TrandashaException{
		Log.info("[TESTs][INIT]: starting bot");
		try {
			
			if(bot == null) throw new TrandashaException();
			else{
				this.bot = bot;
			}
			
			Log.info("[TESTs][DONE]: started bot");			
		} catch (TrandashaException e) {
			Log.error("[TESTs][ERROR]: can't start bot");
			try {
				this.bot.close();
			} catch (NavException e1) {	e1.printStackTrace();}
			throw new TrandashaException(e);
			}
		return this.bot;
	} 
	
	@Override
	public TrandashaBase botInit(TrandashaBase bot, boolean isLogin) throws TrandashaException{
		throw new TrandashaException(ITestErrorMessage.ERROR_notImplemented);
	} 
	
	@Override
	public void botFinish(TrandashaBase bot){
		Log.info("[TESTs][INIT]: closing bot");
		try {
			bot.close();
			Log.info("[TESTs][DONE]: closed bot");
		} catch (Exception e) {
			Log.info("[TESTs][ERROR]: can't close bot");
			bot = null;
		}
	}

	/**@Pages******************************************************************************/
	
	/***/
	@Override
	public IPage pageInit(TrandashaBase bot,IPage page){
		Log.info("[TESTs][INFO]: Loading IPage");
		IPage myPage = page;
		try {
			PageFactory.initElements(bot.navs.getDriver(), myPage);
		} catch (NavException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.error("[TESTs][ERROR]: NOT Loaded IPage");
		}
		Log.info("[TESTs][DONE]: Loaded IPage");
		return myPage;
	}
	
	
	
	/**@Commons***************************************************************************/
	
	@Override
	public void reportAll(String logLevel, String logMessage){
		//Loggers
		switch (logLevel) {
		case "INFO":
		case "INIT":
		case "DONE":
			Reporter.log("[INFO]"+logMessage);
			Log.info("["+logLevel+"]: "+logMessage);
			break;
		case "WARNING":
			Reporter.log("[WARNING]"+logMessage);
			Log.warn(logMessage);
			break;
		case "ERROR":
			Reporter.log("[ERROR]"+logMessage);
			Log.error(logMessage);
			break;
		case "DEBUG":
			Reporter.log("[DEBUG]"+logMessage);
			Log.debug(logMessage);
			break;
		default:			
			break;
		}
	}
	
	
	/***/
	@Override
	public void reportAll(String logLevel, String logMessage, TestCase testcase, ExecutionStatus status) {
		//Loggers
		switch (logLevel) {
		case "INFO":
		case "INIT":
		case "DONE":
			Reporter.log("["+testcase.getName()+"][INFO]"+logMessage);
			Log.info("["+logLevel+"]: "+logMessage);
			break;
		case "WARNING":
			Reporter.log("["+testcase.getName()+"][WARNING]"+logMessage);
			Log.warn(logMessage);
			break;
		case "ERROR":
			Reporter.log("["+testcase.getName()+"][ERROR]"+logMessage);
			Log.error(logMessage);
			break;
		case "DEBUG":
			Reporter.log("["+testcase.getName()+"][DEBUG]"+logMessage);
			Log.debug(logMessage);
			break;
		default:			
			break;
		}
		
		//Testlink reporter
		try {
			testcase.setExecutionStatus(status);
			this.testlink.apiAddResult(testcase);	
		} catch (Exception e) {
			Log.error("[TESTLINK]: can't set or add to executed testcase this testlink testcase | "+ testcase.toString());
		}
	}
	
	
	/***/
	@Override
	public void onErrorAtFinish(Throwable e) throws PageException{
		String msg = e.getMessage();
		Log.error(msg);
		switch (msg) {		
			case ERROR_unknown:
				throw new PageException(ERROR_unknown);
			default:
				throw new PageException(ERROR_unknown + "| "+ e.getMessage());			
		}
		
	}
	

	@Override
	public void pauseFor(long byMiliSecs){
		try { Thread.sleep(byMiliSecs); } catch (Exception e) {}
	}
	/**@TestAsserts***************************************************************************/
	
	@Override
	public void tryAssertEquals(int actual, int expected, PageException exception) throws PageException {
		try { Assert.assertEquals(actual, expected); }
		 catch (AssertionError e) { throw new PageException(exception.getMessage()); }
		
	}

	@Override
	public void tryAssertEquals(String actual, String expected, PageException exception) throws PageException {
		try { Assert.assertEquals(actual, expected); }
		 catch (AssertionError e) { throw new PageException(exception.getMessage()); }
		
	}

	@Override
	public void tryAssertEquals(boolean actual, boolean expected, PageException exception) throws PageException {
		try { Assert.assertEquals(actual, expected); }
		 catch (AssertionError e) { throw new PageException(exception.getMessage()); }
		
	}

	@Override
	public void tryAssertEquals(Object actual, Object expected, PageException exception) throws PageException {
		try { Assert.assertEquals(actual, expected); }
		 catch (AssertionError e) { throw new PageException(exception.getMessage()); }
		
	}

	@Override
	public void tryAssertNotEquals(int actual, int expected, PageException exception) throws PageException {
		try { Assert.assertEquals(actual, expected); }
		 catch (AssertionError e) { throw new PageException(exception.getMessage()); }
		
	}

	@Override
	public void tryAssertNotEquals(String actual, String expected, PageException exception) throws PageException {
		try { Assert.assertEquals(actual, expected); }
		 catch (AssertionError e) { throw new PageException(exception.getMessage()); }
		
	}

	@Override
	public void tryAssertNotEquals(boolean actual, boolean expected, PageException exception) throws PageException {
		try { Assert.assertEquals(actual, expected); }
		 catch (AssertionError e) { throw new PageException(exception.getMessage()); }
		
	}

	@Override
	public void tryAssertNotEquals(Object actual, Object expected, PageException exception) throws PageException {
		try { Assert.assertEquals(actual, expected); }
		 catch (AssertionError e) { throw new PageException(exception.getMessage()); }
		
	}
	
	
	@Override
	public void logBeforeClass(String className){
		Log.info("-----------------------------------------------");
		Log.info("Starting test suite for: "+ className);
		Log.info("-----------------------------------------------");
	}
	@Override
	public void logAfterClass(String className){
		Log.info("-----------------------------------------------");
		Log.info("Finished test suite for: "+ className);
		Log.info("-----------------------------------------------");
	}
}
