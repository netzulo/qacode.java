package ntz.drivers.modules.navs;

import org.openqa.selenium.WebDriver;

import ntz.drivers.navs.elements.IControl;
import ntz.exceptions.NavException;

/**
 * Store List<WebControl> controls of a website scrapped by searchers
 * @author netzulo.com
* @since 2016-07-25
* @version 0.5.4
* 
* <p></p>
* <p></p>
* <p></p>
*/
public class NavBase extends ANav implements INav{

	
	/**Fields************************************************************************************/	
	
	/**Constructors******************************************************************************/
	public NavBase() throws NavException {
		super();
	}

	public NavBase(WebDriver driver) throws NavException {
		super(driver);
	}

	
	/**Public methods****************************************************************************/
	
	@Override
	public boolean goToUrl(String url) throws NavException {
		return super.goToUrl(url);
	}

	
	@Override
	public boolean goBack() throws NavException {
		return super.goBack();
	}

	@Override
	public boolean goRefresh() throws NavException {
		return super.goRefresh();
	}

	@Override
	public boolean tabOpen() throws NavException {
		return super.tabOpen();
	}

	@Override
	public boolean tabReOpenClosed() throws NavException {
		return super.tabReOpenClosed();
	}

	@Override
	public boolean tabClose() throws NavException {
		return super.tabClose();
	}

	@Override
	public boolean tabChange(int numTab) throws NavException {
		return super.tabChange(numTab);
	}

	@Override
	public boolean click(IControl control) throws NavException {
		return super.click(control);
	}

	@Override
	public boolean clickJS(IControl control) throws NavException {
		return super.clickJS(control);
	}

	@Override
	public boolean text(IControl control) throws NavException {
		return super.text(control);
	}

	@Override
	public boolean text(IControl control, String setText) throws NavException {
		return super.text(control, setText);
	}

	@Override
	public boolean textJS(IControl control) throws NavException {
		return super.textJS(control);
	}

	@Override
	public boolean textJS(IControl control, String setText) throws NavException {
		return super.textJS(control, setText);
	}

	@Override
	public boolean attribute(IControl control, String getAttrName) throws NavException {
		return super.attribute(control, getAttrName);
	}

	@Override
	public boolean attributeJS(IControl control, String getAttrName) throws NavException {
		return super.attributeJS(control, getAttrName);
	}

	@Override
	public boolean attributeJS(IControl control, String getAttrName, String setAttrValue) throws NavException {
		return super.attributeJS(control, getAttrName, setAttrValue);
	}

	@Override
	public boolean checkbox(IControl control, boolean newState) throws NavException {
		return super.checkbox(control, newState);
	}

	@Override
	public boolean checkboxJS(IControl control, boolean newState) throws NavException {
		return super.checkboxJS(control, newState);
	}

	@Override
	public WebDriver getDriver() throws NavException {
		return super.getDriver();
	}
	

	@Override
	public boolean setDriver(WebDriver driver) throws NavException {
		return super.setDriver(driver);
	}	
	/**Private methods***************************************************************************/
	/**Protected methods*************************************************************************/
	/**GETs & SETs*******************************************************************************/
	
}
