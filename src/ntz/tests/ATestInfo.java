package ntz.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.pages.IPage;
import ntz.exceptions.BotException;
import ntz.exceptions.PageException;
import ntz.exceptions.WebNavException;
import ntz.logs.Log;
import ntz.tests.errors.ITestErrorMessage;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public abstract class ATestInfo implements ITestInfo {

	/**@FIELDs***********************************************************************************/
	protected TrandashaBase bot;	
	/**@CONSTRUCTORs***********************************************************************************/
	
	public ATestInfo() {}
	/**@throws WebNavException 
	 * @throws BotException 
	 * @Public_methods***************************************************************************/
	
	@SuppressWarnings("null")
	@Override
	public TrandashaBase botInit(TrandashaBase bot) throws BotException{
		Log.info("[TESTs][INIT]: starting bot");
		try {
			
			if(bot == null) throw new BotException();
			
			Log.info("[TESTs][DONE]: started bot");			
		} catch (BotException e) {
			Log.error("[TESTs][ERROR]: can't start bot");
			bot.close();
			throw new BotException(e);
			}
		return bot;
	} 
	
	@Override
	public TrandashaBase botInit(TrandashaBase bot, boolean isLogin) throws BotException{
		throw new BotException(ITestErrorMessage.ERROR_notImplemented);
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
	
	@Override
	public IPage pageInit(TrandashaBase bot,IPage page){
		Log.info("[TESTs][INFO]: Loading IPage");
		IPage myPage = page;
		PageFactory.initElements(bot.webNav.getDriver(), myPage);
		Log.info("[TESTs][DONE]: Loaded IPage");
		return myPage;
	}
	
	
	
	/**@Commons***************************************************************************/
	
	@Override
	public void onErrorAtFinish(Throwable e) throws PageException{
		String msg = e.getMessage();
		
		switch (msg) {		
			case ERROR_unknown:
				throw new PageException(ERROR_unknown);
			default:
				throw new PageException(ERROR_unknown);			
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
}
