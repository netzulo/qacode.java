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
public class ControlLink extends ControlBase {
	
	/*** Specifies that the target will be downloaded when a user clicks on the hyperlink*/
	protected String download;
	
	/**Specifies the URL of the page the link goes to*/
	protected String href;
	
	/**Specifies the language of the linked document*/
	protected String hreflang;
	
	/**Specifies the relationship between the current document and the linked document
	 * @OPTIONS<p> alternate, author, bookmark, help, license, next, nofollow, noreferrer, prefetch, prev, search, tag</p>
	 * */
	protected String rel;
	
	/**
	 * Specifies where to open the linked document
	 * @OPTIONS<p> _blank , _parent, _self, _top, framename </p>
	 * 
	 * */
	protected String target;
	
	
	
	public ControlLink(WebDriver driver, String cssSelector) throws ControlException {
		super(driver, cssSelector);
	}
	public ControlLink(WebElement currentEle) throws ControlException {
		super(currentEle);
	}
		
	
	@Override
	public void readAttributes() {
		super.readAttributes();		
		
		switch (this.tagName) {
		case "a":
			download = this.element.getAttribute("download");
			href = this.element.getAttribute("href");
			hreflang = this.element.getAttribute("hreflang");
			rel = this.element.getAttribute("rel");
			target = this.element.getAttribute("target");					
			break;
		default:
			break;
		}
	}	
	
}
