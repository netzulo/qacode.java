package ntz.drivers.navs.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.exceptions.ControlException;

/**
* @author netzulo.com
* @since 2016-07-25
* @version 0.5.5
* @update 0.5.1_a
* <p></p>
* <p></p>
* <p></p>
*/
public class ControlDropdown extends ControlBase implements IControl {

	/**Fields************************************************************************************/
	/**Constructors******************************************************************************/
	public ControlDropdown(WebDriver driver, String cssSelector) throws ControlException {
		super(driver, cssSelector);
		throw new ControlException();
	}

	public ControlDropdown(WebDriver driver,WebElement currentEle) throws ControlException {
		super(driver,currentEle);
		throw new ControlException();
	}

	/**Public methods****************************************************************************/

	
	/**Private methods***************************************************************************/
	/**Protected methods*************************************************************************/
	/**GETs & SETs*******************************************************************************/
}
