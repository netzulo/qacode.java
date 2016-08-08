package ntz.tests;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.pages.IPage;
import ntz.exceptions.TrandashaException;
import ntz.testlink.TestlinkBase;
import ntz.exceptions.PageException;
import ntz.exceptions.TestlinkException;
import ntz.tests.errors.ITestErrorMessage;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public interface ITestInfo extends ITestErrorMessage{
	
	///BOTS
	
	TrandashaBase botInit(TrandashaBase bot) throws TrandashaException;
	
	TrandashaBase botInit(TrandashaBase bot, boolean isLogin) throws  TrandashaException;
		
	void botFinish(TrandashaBase bot);
	
	///Pages
	
	IPage pageInit(TrandashaBase bot,IPage page);
	
	
	
	///Commons
	
	void pauseFor(long byMiliSecs);
	void onErrorAtFinish(Throwable e) throws PageException;
	
	///Test Asserts

	void tryAssertEquals(int actual, int expected, PageException exception) throws PageException;
	void tryAssertEquals(String actual, String expected, PageException exception) throws PageException ;	
	void tryAssertEquals(boolean actual, boolean expected, PageException exception) throws PageException;
	void tryAssertEquals(Object actual, Object expected, PageException exception) throws PageException;
	
	
	void tryAssertNotEquals(int actual, int expected, PageException exception) throws PageException;
	void tryAssertNotEquals(String actual, String expected, PageException exception) throws PageException;
	void tryAssertNotEquals(boolean actual, boolean expected, PageException exception) throws PageException;
	void tryAssertNotEquals(Object actual, Object expected, PageException exception) throws PageException;

	void logBeforeClass(String className);
	void logAfterClass(String className);

	TestlinkBase testlinkInit(TestlinkBase _testlink) throws TestlinkException;

	void reportAll(String logLevel, String logMessage, TestCase testcase, ExecutionStatus passed);

	void reportAll(String logLevel, String logMessage);	
}
