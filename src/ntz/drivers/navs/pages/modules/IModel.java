package ntz.drivers.navs.pages.modules;

import java.util.List;

import ntz.drivers.navs.elements.IControl;
import ntz.exceptions.ModelException;
/**
* @author netzulo.com
* @since 2016-07-22
* @version 0.5.2
* 
* <p></p>
* <p></p>
* <p></p>
*/
public interface IModel {
	
	/***/
	enum ActionType{}
	/***/
	void actionControl(int actionId, IControl control) throws ModelException;
	/***/
	void actionControl(ActionType action, IControl control) throws ModelException;
	/***/
	void actionControl(int actionId, int controlPosition) throws ModelException;
	/***/
	void actionControl(ActionType action, int controlPosition) throws ModelException;
	
	/***/
	IControl getControl(int position) throws ModelException;
	/***/
	List<IControl> getControls(int... positions) throws ModelException;
	/***/
	List<IControl> getControls(List<Integer> positions) throws ModelException;	
	/***/
	boolean runModel() throws ModelException;
}
