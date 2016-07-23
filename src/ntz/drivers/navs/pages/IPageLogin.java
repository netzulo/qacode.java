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
public interface IPageLogin extends IPageForm {

	/***/
	boolean formLoginFill(String...selectors) throws PageException;
	/***/
	boolean formLoginFill(IControl... controls) throws PageException;
	/***/
	boolean formLoginFill(List<IControl> controls) throws PageException;

	//---
	/***/
	boolean formLoginSubmit(String...texts);
	/***/
	boolean formLoginSubmit(String[] texts,ValidationType...validationtypes);
	
}
