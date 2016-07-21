package ntz.drivers;

import ntz.exceptions.BotException;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class TrandashaBase extends ATrandasha implements ITrandasha{

	public TrandashaBase(BrowserMode browser) throws BotException {
		super(browser);
	}
 
	public TrandashaBase(DriverType type, BrowserMode browser, String _serverUrl) throws BotException {
		super(type, browser, _serverUrl);
	}

	public TrandashaBase(DriverType type, BrowserMode browser) throws BotException {
		super(type, browser);
	}

	public TrandashaBase(int type, int browser, String _serverUrl) throws BotException {
		super(type, browser, _serverUrl);
	}

	public TrandashaBase(int type, int browser) throws BotException {
		super(type, browser);
	}

	public TrandashaBase(int browser) throws BotException {
		super(browser);
	}
	
}
