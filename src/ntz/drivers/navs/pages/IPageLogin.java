package ntz.drivers.navs.pages;

import ntz.exceptions.PageException;
/**
 * Best Web Scrapper ever
 * @author netzulo.com
 * @since 2016-04-01
 * @version 0.5.1
 */
public interface IPageLogin extends IPage {

	boolean setLogin(String[] selectors) throws PageException;
	boolean login(String username, String password) throws PageException;
}
