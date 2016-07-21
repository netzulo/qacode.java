package ntz.drivers.navs.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.exceptions.ControlException;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class ControlInput extends ControlBase implements IControl {

	protected String name;
	protected String value;
	protected String type;						
	protected String placeholder;
	protected String autofocus;
	//modificadores
	protected String readonly;
	protected String disabled;
	//validaciones
	protected String required;
	protected String pattern;
	protected String min;
	protected String max;
	protected String maxlength;
	protected String size;
	protected String step;
	
	//especificos
	protected String checked;
	protected String datalist;
	protected String multiple;
	
	
	
	public ControlInput(WebElement currentEle) throws ControlException {
		super(currentEle);
		readAttributes();
	}

	public ControlInput(WebDriver driver, String cssSelector) throws ControlException {
		super(driver, cssSelector);
		readAttributes();
	}

	@Override
	public void readAttributes() {
		//Load superAttributes		
		super.readAttributes();
		
		//Load specific attributes
		switch (this.tagName) {
		case "input":
			//comunes
			name = this.element.getAttribute("name");
			value = this.element.getAttribute("value");
			type = this.element.getAttribute("type");						
			placeholder = this.element.getAttribute("placeholder");
			autofocus = this.element.getAttribute("autofocus");
			
			//modificadores HTML5
			readonly = this.element.getAttribute("readonly");
			disabled = this.element.getAttribute("disabled");
			
			//validaciones
			required = this.element.getAttribute("required");
			pattern = this.element.getAttribute("pattern");
			min = this.element.getAttribute("min");
			max = this.element.getAttribute("max");
			maxlength = this.element.getAttribute("maxlength");
			size = this.element.getAttribute("size");
			step = this.element.getAttribute("step");
			
			//especificos
			checked = this.element.getAttribute("checked"); // input type=checkbox
			datalist = this.element.getAttribute("list"); // con datalist
			multiple = this.element.getAttribute("multiple"); // 
			break;
		default:
			break;
		}
		
	}
	/**GETs & SETs methods****************************************************************************/

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public String getAutofocus() {
		return autofocus;
	}

	public String getReadonly() {
		return readonly;
	}

	public String getDisabled() {
		return disabled;
	}

	public String getRequired() {
		return required;
	}

	public String getPattern() {
		return pattern;
	}

	public String getMin() {
		return min;
	}

	public String getMax() {
		return max;
	}

	public String getMaxlength() {
		return maxlength;
	}

	public String getSize() {
		return size;
	}

	public String getStep() {
		return step;
	}

	public String getChecked() {
		return checked;
	}

	public String getDatalist() {
		return datalist;
	}

	public String getMultiple() {
		return multiple;
	}
	
	
	
	
	
	
}
