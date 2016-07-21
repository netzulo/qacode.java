package ntz.drivers.navs.pages;

import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.elements.ControlTable;
import ntz.exceptions.PageException;

public class PageLogin extends APageLogin {

	public PageLogin() throws PageException {
		super();
	}

	public PageLogin(TrandashaBase bot, String url) throws PageException {
		super(bot, url);
		
	}

	public PageLogin(TrandashaBase bot, String url, boolean navigateCurrentUrl) throws PageException {
		super(bot, url, navigateCurrentUrl);
	}

	@Override
	public boolean setLogin(String[] selectors) throws PageException {		
		return super.setLogin(selectors);
	}

	@Override
	public boolean login(String username, String password) throws PageException {
		return super.login(username, password);		
	}

	@Override
	public void searchCustom(String[] selectors) throws PageException {
		super.searchControls(selectors);
	}

	/** DON'T WORK*/
	@Override
	public ControlTable tableData() throws PageException {
		super.tableData(null);
		return null;
	}

	@Override
	public void searchCustomByJS(String textJS, String... selectores) throws PageException {
		// TODO Auto-generated method stub
		
	}

}
