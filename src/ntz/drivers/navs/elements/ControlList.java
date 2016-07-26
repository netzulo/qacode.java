package ntz.drivers.navs.elements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.exceptions.ControlException;
import ntz.tests.errors.ITestErrorMessage;

/**
* @author netzulo.com
* @since 2016-07-22
* @version 0.5.1
* 
* <p></p>
* <p></p>
* <p></p>
*/
public class ControlList extends ControlBase implements IControl {

	/**Fields************************************************************************************/
	protected List<ControlLink> listItemsLinks;	
	
	
	/**Constructors******************************************************************************/
	public ControlList(WebDriver driver, String selector) throws ControlException {
		super(driver, selector);
		loadListLink();
	}


	public ControlList(WebDriver driver, WebElement element) throws ControlException {
		super(driver, element);
		loadListLink();
	}


	public ControlList(WebDriver driver) throws ControlException {
		super(driver);
		loadListLink();
	}

	/**Protected methods****************************************************************************/
	protected void loadListLink() throws ControlException{
		List<WebElement> _listItems = this.element.findElements(By.cssSelector("li"));
				
		try {
			for (WebElement _li : _listItems) {
				WebElement _link = _li.findElement(By.cssSelector("a"));
				
				listItemsLinks.add(new ControlLink(this.driver, _link));		
			}		
		} catch (Exception e) {
			throw new ControlException(ITestErrorMessage.ERROR_listLinksNotFound);
		}
	}
	
	


	/**GETs & SETs methods****************************************************************************/
	public List<ControlLink> getListItemsLinks() {
		return listItemsLinks;
	}

}
