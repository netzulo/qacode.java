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
public interface IPageSearch extends IPageForm{	
	
	/***/
	boolean formSearchFill(String...selectors) throws PageException;
	/***/
	boolean formSearchFill(IControl... controls) throws PageException;
	/***/
	boolean formSearchFill(List<IControl> controls) throws PageException;

	//---
	/***/
	boolean formSearchSubmit(String...texts);
	/***/
	boolean formSearchSubmit(String[] texts,ValidationType...validationtypes);
}
