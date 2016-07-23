package ntz.drivers.navs.pages;

import java.util.List;

import ntz.drivers.navs.elements.IControl;
import ntz.exceptions.PageException;

/**
* @author netzulo.com
* @since 2016-07-22
* @version 0.5.2
* 
* <p></p>
* <p></p>
* <p></p>
*/
public interface IPageMenu {
	/***/
	boolean menuHeader(String...selectors) throws PageException;
	/***/
	boolean menuHeader(IControl... controls) throws PageException;
	/***/
	boolean menuHeader(List<IControl> controls) throws PageException;
	/***/
	boolean menuHeaderClick(int controlPosition) throws PageException;
	
	/***/
	boolean menuSide(String...selectors) throws PageException;
	/***/
	boolean menuSide(IControl... controls) throws PageException;
	/***/
	boolean menuSide(List<IControl> controls) throws PageException;
	/***/
	boolean menuSideClick(int controlPosition) throws PageException;
	
	/***/
	boolean menuFooter(String...selectors) throws PageException;
	/***/
	boolean menuFooter(IControl... controls) throws PageException;
	/***/
	boolean menuFooter(List<IControl> controls) throws PageException;
	/***/
	boolean menuFooterClick(int controlPosition) throws PageException;
	
}
