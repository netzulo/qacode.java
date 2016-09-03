package ntz.drivers.navs.elements;

import org.openqa.selenium.WebElement;

import ntz.drivers.ITrandasha;
import ntz.exceptions.ControlException;
/**
* @author netzulo.com
* @since 2016-07-22
* @version 0.5.1
* 
* <p></p>
* <p></p>
* <p></p>
*/
public class ControlInput extends ControlBase implements IControl {
	
	public ControlInput(ITrandasha bot,WebElement currentEle) throws ControlException {
		super(bot,currentEle);
		this.Init();
	}

	public ControlInput(ITrandasha bot, String cssSelector) throws ControlException {
		super(bot, cssSelector);
		this.Init();
	}

	
	@Override
	public IControl Init() throws ControlException {
		super.Init();
		this.InitHTML();
		return this; 
	}
	
	@Override
	public IControl InitHTML() throws ControlException {		
		super.InitHTML();
		//Load specific attributes
		switch (this.tagName) {
		case "input":
			//Commons
			this.eleAttr("name");
			this.eleAttr("value");
			this.eleAttr("type");
			this.eleAttr("placeholder");
			this.eleAttr("autofocus");			
			
			//Modifiers HTML5
			this.eleAttr("readonly");
			this.eleAttr("disabled");					
			
			//Validations
			this.eleAttr("required");
			this.eleAttr("pattern");
			this.eleAttr("min");
			this.eleAttr("max");
			this.eleAttr("maxlength");
			this.eleAttr("size");
			this.eleAttr("step");					
			
			//TODO:for each control
			String inputType = this.attrType();
						
			switch (inputType ) {
			case "text"://TODO: build functionality				
				this.eleAttr("list");
				break;
			case "file"://TODO: build functionality				
				this.eleAttr("list");
				break;
			case "checkbox":
				this.eleAttr("checked");
				break;
			case "button"://TODO: build functionality
				throw new ControlException("[ControlInput][ERROR]: Not implemented");	
			case "number"://TODO: build functionality
				throw new ControlException("[ControlInput][ERROR]: Not implemented");	
			case "date"://TODO: build functionality
				throw new ControlException("[ControlInput][ERROR]: Not implemented");	
			case "email"://TODO: build functionality
				throw new ControlException("[ControlInput][ERROR]: Not implemented");	
			case "submit"://TODO: build functionality
				throw new ControlException("[ControlInput][ERROR]: Not implemented");	
				
			case "undefined":
			default:
				throw new ControlException("[ControlInput][ERROR]: Not implemented");	
			}
			//								
			break;
		default:
			break;
		}
		return this;
	}
	/**GETs & SETs methods****************************************************************************/

	public String attrName() {
		return this.stylesHTML.get("name");
	}

	public String attrValue() {
		return this.stylesHTML.get("value");
	}

	public String attrType() {
		return this.stylesHTML.get("type");
	}

	public String attrPlaceholder() {
		return this.stylesHTML.get("placeholder");
	}

	public String attrAutofocus() {
		return this.stylesHTML.get("autofocus");
	}

	public String attrReadonly() {
		return this.stylesHTML.get("readonly");
	}

	public String attrDisabled() {
		return this.stylesHTML.get("disabled");
	}

	public String attrRequired() {
		return this.stylesHTML.get("required");
	}

	public String getAttrPattern() {
		return this.stylesHTML.get("pattern");
	}

	public String getAttrMin() {
		return this.stylesHTML.get("min");
	}

	public String getAttrMax() {
		return this.stylesHTML.get("max");
	}

	public String getAttrMaxlength() {
		return this.stylesHTML.get("maxlength");
	}

	public String getAttrSize() {
		return this.stylesHTML.get("size");
	}

	public String getAttrStep() {
		return this.stylesHTML.get("step");
	}

	public String getAttrChecked() {
		return this.stylesHTML.get("checked");
	}

	public String getAttrDatalist() {
		return this.stylesHTML.get("datalist");
	}

	public String getAttrMultiple() {
		return this.stylesHTML.get("multiple");
	}
}
