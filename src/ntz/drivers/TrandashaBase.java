package ntz.drivers;

import ntz.exceptions.TrandashaException;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class TrandashaBase extends ATrandasha implements ITrandasha{

	public TrandashaBase(BrowserMode browser) throws TrandashaException {
		super(browser);
	}
 
	public TrandashaBase(DriverType type, BrowserMode browser, String _serverUrl) throws TrandashaException {
		super(type, browser, _serverUrl);
	}

	public TrandashaBase(DriverType type, BrowserMode browser) throws TrandashaException {
		super(type, browser);
	}

	public TrandashaBase(int type, int browser, String _serverUrl) throws TrandashaException {
		super(type, browser, _serverUrl);
	}

	public TrandashaBase(int type, int browser) throws TrandashaException {
		super(type, browser);
	}

	public TrandashaBase(int browser) throws TrandashaException {
		super(browser);
	}
	
}
