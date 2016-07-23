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
public interface IPageForm {
	enum ValidationType{TEXT,NUMERIC,DATE,PHONE,EMAIL}
	
	
	/***/
	boolean formFill(String...selectors) throws PageException;
	/***/
	boolean formFill(IControl... controls) throws PageException;
	/***/
	boolean formFill(List<IControl> controls) throws PageException;

	//---
	
	/***/
	boolean formSubmit(String...texts);
	/***/
	boolean formSubmit(String[] texts,ValidationType...validationTypes);
	
}
