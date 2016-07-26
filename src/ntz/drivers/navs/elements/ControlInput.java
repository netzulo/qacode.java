package ntz.drivers.navs.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	public ControlInput(WebDriver driver,WebElement currentEle) throws ControlException {
		super(driver,currentEle);
		this.Init();
	}

	public ControlInput(WebDriver driver, String cssSelector) throws ControlException {
		super(driver, cssSelector);
		this.Init();
	}

	
	@Override
	public IControl Init() throws ControlException {
		super.Init();
		this.InitHTML();
		return this; 
	}
	
	@Override
	public IControl InitHTML() {		
		//Load specific attributes
		switch (this.tagName) {
		case "input":
			//Commons
			this.stylesHTML.put("name", this.element.getAttribute("name"));
			this.stylesHTML.put("value", this.element.getAttribute("value"));
			this.stylesHTML.put("type", this.element.getAttribute("type"));
			this.stylesHTML.put("placeholder", this.element.getAttribute("placeholder"));
			this.stylesHTML.put("autofocus", this.element.getAttribute("autofocus"));			
			
			//Modifiers HTML5
			this.stylesHTML.put("readonly", this.element.getAttribute("readonly"));
			this.stylesHTML.put("disabled", this.element.getAttribute("disabled"));			
			
			//Validations
			this.stylesHTML.put("required", this.element.getAttribute("required"));
			this.stylesHTML.put("pattern", this.element.getAttribute("pattern"));
			this.stylesHTML.put("min", this.element.getAttribute("min"));
			this.stylesHTML.put("max", this.element.getAttribute("max"));
			this.stylesHTML.put("maxlength", this.element.getAttribute("maxlength"));
			this.stylesHTML.put("size", this.element.getAttribute("size"));
			this.stylesHTML.put("step", this.element.getAttribute("step"));			
			
			//especificos
			this.stylesHTML.put("checked", this.element.getAttribute("checked"));
			this.stylesHTML.put("list", this.element.getAttribute("list"));
			this.stylesHTML.put("multiple", this.element.getAttribute("multiple"));			
			break;
		default:
			break;
		}
		return this;
	}
	/**GETs & SETs methods****************************************************************************/

	public String eleInputName() {
		return this.stylesHTML.get("name");
	}

	public String eleInputValue() {
		return this.stylesHTML.get("value");
	}

	public String eleInputType() {
		return this.stylesHTML.get("type");
	}

	public String eleInputPlaceholder() {
		return this.stylesHTML.get("placeholder");
	}

	public String eleInputAutofocus() {
		return this.stylesHTML.get("autofocus");
	}

	public String eleInputReadonly() {
		return this.stylesHTML.get("readonly");
	}

	public String eleInputDisabled() {
		return this.stylesHTML.get("disabled");
	}

	public String eleInputRequired() {
		return this.stylesHTML.get("required");
	}

	public String getPattern() {
		return this.stylesHTML.get("pattern");
	}

	public String getMin() {
		return this.stylesHTML.get("min");
	}

	public String getMax() {
		return this.stylesHTML.get("max");
	}

	public String getMaxlength() {
		return this.stylesHTML.get("maxlength");
	}

	public String getSize() {
		return this.stylesHTML.get("size");
	}

	public String getStep() {
		return this.stylesHTML.get("step");
	}

	public String getChecked() {
		return this.stylesHTML.get("checked");
	}

	public String getDatalist() {
		return this.stylesHTML.get("datalist");
	}

	public String getMultiple() {
		return this.stylesHTML.get("multiple");
	}
}
