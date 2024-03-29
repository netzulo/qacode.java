package ntz.drivers.navs.elements;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.Credentials;

import ntz.drivers.ITrandasha;
import ntz.exceptions.ControlException;

/**
* @author netzulo.com
* @since 2016-08-20
* @version 0.5.9
* 
* <p></p>
* <p></p>
* <p></p>
*/
public class ControlAlert extends ControlBase implements IControl{
	

	/**Fields************************************************************************************/
	protected Alert elementAlert;
	protected Credentials creeds;	
	
	/**Constructors******************************************************************************/

	public ControlAlert(ITrandasha bot, String selector) throws ControlException {
		super(bot, selector);
		this.elementAlert = this.getDriver().switchTo().alert();
	}

	public ControlAlert(ITrandasha bot, WebElement element) throws ControlException {
		super(bot, element);
		this.elementAlert = this.getDriver().switchTo().alert();
	}

	public ControlAlert(ITrandasha bot) throws ControlException {
		super(bot);
		this.elementAlert = this.getDriver().switchTo().alert();
	}
	
	/**Custom controls 
	 * @throws ControlException ***************************************************************************/
	
	public void eleAlertAccept() throws ControlException{
		this.elementAlert.accept();
		this.eleAlertBackToPage();
	}
	
	public void eleAlertCancel() throws ControlException{
		this.elementAlert.dismiss();
		this.getDriver().switchTo().defaultContent();
	}
	
	public String eleAlertReadText() throws ControlException{
		return this.elementAlert.getText();
	}
	
	public void eleAlertBackToPage() throws ControlException{
		this.getDriver().switchTo().defaultContent();
	}
	
	/**Overrides *********************************************************************************/
	
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
