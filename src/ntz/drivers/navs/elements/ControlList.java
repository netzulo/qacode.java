package ntz.drivers.navs.elements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.exceptions.ControlException;
import ntz.tests.errors.ITestErrorMessage;

/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class ControlList extends ControlBase implements IControl {

	/**Fields************************************************************************************/
	protected List<ControlLink> listItemsLinks;	
	
	
	/**Constructors******************************************************************************/
	public ControlList(WebElement currentEle) throws ControlException {
		super(currentEle);		
		loadListLink();
	}

	public ControlList(WebDriver driver, String cssSelector) throws ControlException {
		super(driver, cssSelector);
		loadListLink();
	}

	/**Protected methods****************************************************************************/
	protected void loadListLink() throws ControlException{
		List<WebElement> _listItems = this.element.findElements(By.cssSelector("li"));
				
		try {
			for (WebElement _li : _listItems) {
				WebElement _link = _li.findElement(By.cssSelector("a"));
				
				listItemsLinks.add(new ControlLink(_link));		
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
