package ntz.drivers.navs.elements;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.drivers.ITrandasha;
import ntz.exceptions.ControlException;
/**
* @author netzulo.com
* @since 2016-07-22
* @version 0.5.3
* 
* <p></p>
* <p></p>
* <p></p>
*/
public class ControlBase extends AControl implements IControl{
	
	
	/**Fields************************************************************************************/		
	/**Constructors******************************************************************************/

	public ControlBase(ITrandasha bot, String selector) throws ControlException {
		super(bot, selector);
	}
	public ControlBase(ITrandasha bot, WebElement element) throws ControlException {
		super(bot, element);
	}
	public ControlBase(ITrandasha bot) throws ControlException {
		super(bot);
	}
	
	/**Public methods****************************************************************************/
	
	@Override
	public IControl Init() throws ControlException {
		
		return super.Init();
	}
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
	public IControl InitHTML() throws ControlException {
		
		return super.InitHTML();
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
	public String eleRead() throws ControlException {
		
		return super.eleRead();
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
	public Hashtable<String, String> eleAttrs() throws ControlException {
		
		return super.eleAttrs();
	}
	@Override
	public IControl eleAttr(String attrName) throws ControlException {
		
		return super.eleAttr(attrName);
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
	public String getText() throws ControlException {
 
		return super.getText();
	}
	/** "Private" methods***************************************************************************/
	
	/**Protected methods*************************************************************************/
	/**GETs & SETs*******************************************************************************/
	//**DEBUG*/
	@Override
	public String toString() {
		return super.toString();
	}
}
