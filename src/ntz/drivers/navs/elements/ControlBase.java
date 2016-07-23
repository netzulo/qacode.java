package ntz.drivers.navs.elements;

import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public ControlBase(WebDriver driver, String selector) throws ControlException {
		super(driver, selector);
	}
	public ControlBase(WebDriver driver, WebElement element) throws ControlException {
		super(driver, element);
	}
	public ControlBase(WebDriver driver) throws ControlException {
		super(driver);
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
	public boolean runControl() {
		return super.runControl();
	}
	@Override
	public boolean eleScreenShot() {
		return super.eleScreenShot();
	}
	@Override
	public boolean eleWrite(String text) {
		return super.eleWrite(text);
	}
	@Override
	public boolean eleWrite(String text, boolean isClear) {
		return super.eleWrite(text, isClear);
	}
	@Override
	public boolean eleClear() {
		return super.eleClear();
	}
	@Override
	public void eleClick() {
		super.eleClick();
	}
	@Override
	public void eleClickByJS() {
		super.eleClickByJS();
	}
	@Override
	public IControl eleChild() {
		return super.eleChild();
	}
	@Override
	public IControl eleChildByPos(int... childsPosition) {
		return super.eleChildByPos(childsPosition);
	}
	@Override
	public IControl eleChildFirst() {
		return super.eleChildFirst();
	}
	@Override
	public IControl eleChildLast() {
		return super.eleChildLast();
	}
	@Override
	public List<IControl> eleChildren() {
		return super.eleChildren();
	}
	@Override
	public List<IControl> eleChildrenByPos(int... childsPosition) {
		return super.eleChildrenByPos(childsPosition);
	}
	@Override
	public IControl eleNext() {
		return super.eleNext();
	}
	@Override
	public IControl elePrevious() {
		return super.elePrevious();
	}
	@Override
	public IControl eleParent() {
		return super.eleParent();
	}
	@Override
	public WebDriver getDriver() {
		return super.getDriver();
	}
	@Override
	public String getSelector() {
		return super.getSelector();
	}
	@Override
	public String getTagName() {
		return super.getTagName();
	}
	@Override
	public TakesScreenshot getScreenshot() {
		return super.getScreenshot();
	}
	@Override
	public byte[] getScreenshotAsBytes() {
		return super.getScreenshotAsBytes();
	}
	@Override
	public String getScreenshotAsBase64() {
		return super.getScreenshotAsBase64();
	}
	@Override
	public WebElement getElement() {
		return super.getElement();
	}
	

	/** "Private" methods***************************************************************************/

	/**Protected methods*************************************************************************/
	/**GETs & SETs*******************************************************************************/
	
	
}
