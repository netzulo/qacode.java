package ntz.tests;

import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.pages.IPage;
import ntz.exceptions.BotException;
import ntz.exceptions.PageException;
import ntz.tests.errors.ITestErrorMessage;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public interface ITestInfo extends ITestErrorMessage{
	
	///BOTS
	
	TrandashaBase botInit(TrandashaBase bot) throws BotException;
	
	TrandashaBase botInit(TrandashaBase bot, boolean isLogin) throws  BotException;
		
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
}
