package ntz.drivers.navs.pages.modules;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ntz.drivers.ITrandasha;
import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.elements.ControlBase;
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
public abstract class AModel implements IModel {
	
	/**Fields************************************************************************************/
	
	/***/
	private ITrandasha bot;
	
	/***/
	private List<IControl> controls;
	/**Constructors******************************************************************************/
	
	/***/
	public AModel(ITrandasha _bot){
		this.bot = _bot;
		controls = new ArrayList<>();
	}
	
	/***/
	public AModel(ITrandasha _bot, String[] _selectors) throws ModelException{
		this(_bot);
		for (String selector : _selectors) {
			if(selector == null){throw new ModelException();}
			else{
				WebElement ele = ((TrandashaBase)this.bot).webNav.getDriver().findElement(By.cssSelector(selector));
				try {
					this.controls.add(new ControlBase(ele));
					
				} catch (Exception e) {throw new ModelException("Error at try to load element");}
			}
		}//foreach
			
	}
	
	/***/
	public AModel(ITrandasha _bot, IControl[] _controls) throws ModelException{
		this(_bot);
		for (IControl control : _controls) {
			if(control == null){throw new ModelException();}
			else{				
				this.controls.add(control);
			}
		}//foreach
	}
	
	/**Overrides*********************************************************************************/
	
	
	@Override
	public void actionControl(int actionId, IControl control) throws ModelException {
		switch (actionId) {
		case 0:
			//TODO: action to on control with this actionID
			break;
		case 1:
			//TODO: action to on control with this actionID
			break;
		case 2:
			//TODO: action to on control with this actionID
			break;
		default:
			
			throw new ModelException("Not defined action for control");			
		}
		
	}

	@Override
	public void actionControl(ActionType action, IControl control) throws ModelException {
		this.actionControl(action.ordinal(), control);
	}

	
	//---
	@SuppressWarnings("unused")
	@Override
	public void actionControl(int actionId, int controlPosition) throws ModelException {
		IControl currControl = this.getControl(controlPosition);
		switch (actionId) {
		case 0:
			//TODO: action to on control with this currControl			
			break;
		case 1:
			//TODO: action to on control with this currControl
			break;
		case 2:
			//TODO: action to on control with this currControl
			break;
		default:			
			throw new ModelException("Not defined action for control");			
		}
	}

	@Override
	public void actionControl(ActionType action, int controlPosition) throws ModelException {
		this.actionControl(action.ordinal(), controlPosition);
	}
	//---
	
	@Override
	public IControl getControl(int position) throws ModelException {
		try {
			return this.controls.get(position);
		} catch (Exception e) {	throw new ModelException("Error at getControls for this model");}
	}

	@Override
	public List<IControl> getControls(int... positions) throws ModelException {
		try {
			List<IControl> currControls = new ArrayList<>();		
			for (int _position : positions) {
				if(_position > -1 ){
					currControls.add(this.getControl(_position));
				}
			}
			return currControls;
		} catch (Exception e) {	throw new ModelException("Error at getControls for this model");}
	}

	@Override
	public List<IControl> getControls(List<Integer> positions) throws ModelException {
		try {
			List<IControl> currControls = new ArrayList<>();		
			for (int _position : positions) {
				if(_position > -1 ){
					currControls.add(this.getControl(_position));
				}
			}
			return currControls;
		} catch (Exception e) {	throw new ModelException("Error at getControls for this model");}
	}

	
	@Override
	public boolean runModel() throws ModelException {
		//TODO: 
		throw new ModelException("RunModel Method not defined functionality on AModel");
	}
	
}
