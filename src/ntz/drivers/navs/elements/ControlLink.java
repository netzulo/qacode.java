package ntz.drivers.navs.elements;

import java.util.List;

import org.openqa.selenium.TakesScreenshot;
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
	
	
	/**Constructors******************************************************************************/
	
	
	public ControlLink(WebDriver driver, String selector) throws ControlException {
		super(driver, selector);
		this.Init();
	}

	public ControlLink(WebDriver driver, WebElement element) throws ControlException {
		super(driver, element);
		this.Init();
	}

	public ControlLink(WebDriver driver) throws ControlException {
		super(driver);
		this.Init();
	}
	
	/**Overrides ********************************************************************************/
	@Override
	public IControl InitHTML() throws ControlException {
		super.InitHTML();
		switch (this.tagName) {
		case "a":
			this.stylesHTML.put("download", this.element.getAttribute("download"));
			this.stylesHTML.put("href", this.element.getAttribute("href"));
			this.stylesHTML.put("hreflang", this.element.getAttribute("hreflang"));
			this.stylesHTML.put("rel", this.element.getAttribute("rel"));
			this.stylesHTML.put("target", this.element.getAttribute("target"));				
			break;
		default:
			break;
		}
		return this;
	}	

	@Override
	public IControl Init() throws ControlException {
		super.Init();
		this.Init(SearchMode.HTML);
		
		return this;
	}

	/**Public methods****************************************************************************/

	@Override
	public IControl Init(int searcherTypeInt) throws ControlException {
 
		return super.Init(searcherTypeInt);
	}

	@Override
	public IControl Init(SearchMode searcher) throws ControlException {
 
		return super.Init(searcher);
	}

	@Override
	public IControl InitElement() throws ControlException {
 
		return super.InitElement();
	}

	@Override
	public IControl InitCSS() throws ControlException {
 
		return super.InitCSS();
	}

	@Override
	public IControl InitJS() throws ControlException {
 
		return super.InitJS();
	}

	@Override
	public boolean runControl() throws ControlException {
 
		return super.runControl();
	}

	@Override
	public boolean eleScreenShot() throws ControlException {
 
		return super.eleScreenShot();
	}

	@Override
	public boolean eleWrite(String text) throws ControlException {
 
		return super.eleWrite(text);
	}

	@Override
	public boolean eleWrite(String text, boolean isClear) throws ControlException {
 
		return super.eleWrite(text, isClear);
	}

	@Override
	public boolean eleClear() throws ControlException {
 
		return super.eleClear();
	}

	@Override
	public void eleClick() throws ControlException {
 
		super.eleClick();
	}

	@Override
	public void eleClickByJS() throws ControlException {
 
		super.eleClickByJS();
	}

	@Override
	public IControl eleChild() throws ControlException {
 
		return super.eleChild();
	}

	@Override
	public IControl eleChildByPos(int... childsPosition) throws ControlException {
 
		return super.eleChildByPos(childsPosition);
	}

	@Override
	public IControl eleChildFirst() throws ControlException {
 
		return super.eleChildFirst();
	}

	@Override
	public IControl eleChildLast() throws ControlException {
 
		return super.eleChildLast();
	}

	@Override
	public List<IControl> eleChildren() throws ControlException {
 
		return super.eleChildren();
	}

	@Override
	public List<IControl> eleChildrenByPos(int... childsPosition) throws ControlException {
 
		return super.eleChildrenByPos(childsPosition);
	}

	@Override
	public IControl eleNext() throws ControlException {
 
		return super.eleNext();
	}

	@Override
	public IControl elePrevious() throws ControlException {
 
		return super.elePrevious();
	}

	@Override
	public IControl eleParent() throws ControlException {
 
		return super.eleParent();
	}

	@Override
	public WebDriver getDriver() throws ControlException {
 
		return super.getDriver();
	}

	@Override
	public String getSelector() throws ControlException {
 
		return super.getSelector();
	}

	@Override
	public String getTagName() throws ControlException {
 
		return super.getTagName();
	}

	@Override
	public TakesScreenshot getScreenshot() throws ControlException {
 
		return super.getScreenshot();
	}

	@Override
	public byte[] getScreenshotAsBytes() throws ControlException {
 
		return super.getScreenshotAsBytes();
	}

	@Override
	public String getScreenshotAsBase64() throws ControlException {
 
		return super.getScreenshotAsBase64();
	}

	@Override
	public WebElement getElement() throws ControlException {
 
		return super.getElement();
	}

	@Override
	public String toString() {
 
		return super.toString();
	}

}
