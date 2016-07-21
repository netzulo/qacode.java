package ntz.drivers.navs.pages;

import ntz.exceptions.PageException;
/**
* @author netzulo.com
* @since 2016-03-31
* @version 0.5.1
*/
public interface IPageMenu {

	boolean setSideMenu(String[] selectors) throws PageException;
	boolean clickSideMenu(int pos) throws PageException;
	
	boolean setMainMenu(String[] selectors) throws PageException;
	boolean clickMainMenu(int pos) throws PageException;
	
	boolean setHeaderMenu(String[] selectors) throws PageException;
	boolean clickHeaderMenu(int pos) throws PageException;
}
