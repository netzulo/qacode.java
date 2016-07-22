package ntz.drivers.navs.pages;

import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.elements.ControlTable;
import ntz.exceptions.PageException;
/**
* @author netzulo.com
* @since 2016-03-31
* @version 0.5.1
*/
public class PageBase extends APage {

	public PageBase() throws PageException {
		super();
	}

	public PageBase(TrandashaBase bot, String url) throws PageException {
		super(bot, url);
	}

	public PageBase(TrandashaBase bot, String url, boolean navigateCurrentUrl) throws PageException {
		super(bot, url, navigateCurrentUrl);
	}

	@Override
	public void searchCustom() throws PageException {
		throw new PageException("[Page.searchCustom][ERROR-3xx]: not implemented");
	}
	
	@Override
	public void searchCustom(String[] selectors) throws PageException {
		this.searchControls(selectors);		
	}	
	
	@Override
	public void searchCustomByJS(String textJS, String...selectores) throws PageException {
		this.searchCustomByJS(textJS, selectores);		
	}

	@Override
	public ControlTable tableData() throws PageException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
