package ntz.drivers.navs.pages.models;

import java.util.List;

import ntz.drivers.navs.elements.IControl;
import ntz.exceptions.ModelException;
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
public interface IModel {
	/***/
	IControl getControl(int position) throws ModelException;
	/***/
	List<IControl> getControls(int... positions) throws ModelException;
	/***/
	List<IControl> getControls(List<Integer> positions) throws ModelException;	
	/***/
	boolean runModel() throws ModelException;
	
	/***/
	void addControl(IControl control);
}
