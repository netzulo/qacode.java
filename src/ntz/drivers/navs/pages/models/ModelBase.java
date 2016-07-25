package ntz.drivers.navs.pages.models;
/**
* @author netzulo.com
* @since 2016-07-25
* @version 0.5.4
* @update FIX 0.5.4_a
* 
* <p></p>
* <p></p>
* <p></p>
*/
import ntz.drivers.ITrandasha;
import ntz.drivers.navs.elements.IControl;
import ntz.exceptions.ModelException;
import ntz.exceptions.NavException;

public class ModelBase extends AModel implements IModel {
	
	public ModelBase(ITrandasha _bot) {
		super(_bot);
	}

	public ModelBase(ITrandasha _bot,String... _selectors) throws ModelException, NavException {
		super(_bot, _selectors);
	}

	public ModelBase(ITrandasha _bot, IControl... _controls) throws ModelException {
		super(_bot, _controls);
	}

}
