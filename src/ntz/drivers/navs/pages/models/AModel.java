package ntz.drivers.navs.pages.models;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ntz.drivers.ITrandasha;
import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.elements.ControlBase;
import ntz.drivers.navs.elements.ControlList;
import ntz.drivers.navs.elements.IControl;
import ntz.exceptions.ModelException;
import ntz.exceptions.NavException;
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
public abstract class AModel implements IModel {
	
	/**Fields************************************************************************************/
	/***/
	private ITrandasha bot;	
	/***/	
	/***/
	private List<IControl> controls;
	/**Constructors******************************************************************************/
	
	/***/
	public AModel(ITrandasha _bot){
		this.bot = _bot;
		this.controls = new ArrayList<>();				
	}
	
	/**
	 * @throws NavException */
	public AModel(ITrandasha _bot, String... _selectors) throws ModelException, NavException{
		this(_bot);
		for (String selector : _selectors) {
			if(selector == null){throw new ModelException();}
			else{
				WebElement ele = ((TrandashaBase)this.bot).navs.getDriver().findElement(By.cssSelector(selector));
				try {
					
					IControl ctl = getControlType(new ControlBase(((TrandashaBase)this.bot).navs.getDriver(), ele));
					
					this.controls.add(ctl);
					
				} catch (Exception e) {throw new ModelException("Error at try to load element");}
			}
		}//foreach
			
	}
			
	private IControl getControlType(ControlBase controlBase) throws ModelException {
		IControl ctlCasted = null;
		try {
			
			switch (controlBase.getTagName()) {
			case "ul":
			case "ol":
				ctlCasted = ((ControlList)controlBase);
				break;

			default:
				return controlBase;
			}
			
		} catch (Exception e) {
			throw new ModelException("[AModel.getControlType][ERROR]: error at cast control Object");
		}
		
		return ctlCasted;
	}

	/***/
	public AModel(ITrandasha _bot, IControl... _controls) throws ModelException{
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
	public void addControl(IControl control) {
		if(control == null){}
		else{
			this.controls.add(control);
		}
	}
	 
	@Override
	public boolean runModel() throws ModelException {
		//TODO: must be defined on BaseClass or inherits 
		throw new ModelException("RunModel Method not defined functionality on AModel");
	}
	
	
	
	
}



