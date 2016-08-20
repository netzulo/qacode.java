package ntz.drivers.navs.elements;

import org.openqa.selenium.WebElement;

import ntz.drivers.ITrandasha;
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
	public ControlDropdown(ITrandasha bot, String cssSelector) throws ControlException {
		super(bot, cssSelector);
		throw new ControlException();
	}

	public ControlDropdown(ITrandasha bot,WebElement currentEle) throws ControlException {
		super(bot,currentEle);
		throw new ControlException();
	}

	/**Public methods****************************************************************************/

	
	/**Private methods***************************************************************************/
	/**Protected methods*************************************************************************/
	/**GETs & SETs*******************************************************************************/
}
