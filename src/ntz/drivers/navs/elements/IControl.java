package ntz.drivers.navs.elements;

import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.exceptions.ControlException;

/**
* @author netzulo.com
* @since 2016-07-23
* @version 0.5.3
* 
* <p></p>
* <p></p>
* <p></p>
*/
public interface IControl {
	
	/***/
	enum SearchMode{ELEMENT,HTML, CSS, JS};	
	
	/**Protected*********************************************************************************/
	
	/***/
	IControl Init() throws ControlException;
	/***/
	IControl Init(int searcherTypeInt) throws ControlException;
	/***/
	IControl Init(SearchMode searcher) throws ControlException;
	
	/***/
	IControl InitElement() throws ControlException;
	/***/
	IControl InitHTML() throws ControlException;
	/***/
	IControl InitCSS() throws ControlException;
	/***/
	IControl InitJS() throws ControlException;
	//---
	/***/
	boolean runControl() throws ControlException;
	/**Commons **********************************************************************************/
	boolean eleScreenShot() throws ControlException;
	
	boolean eleWrite(String text) throws ControlException;
	boolean eleWrite(String text, boolean isClear) throws ControlException;
	boolean eleClear() throws ControlException;
	void eleClick() throws ControlException;
	void eleClickByJS() throws ControlException;
		
	IControl eleChild() throws ControlException;
	IControl eleChildByPos(int... childsPosition) throws ControlException;
	IControl eleChildFirst() throws ControlException;
	IControl eleChildLast() throws ControlException;
	
	List<IControl> eleChildren() throws ControlException;
	List<IControl> eleChildrenByPos(int... childsPosition) throws ControlException;
		
	IControl eleNext() throws ControlException;
	IControl elePrevious() throws ControlException;
	IControl eleParent() throws ControlException;
	/**GETs & SETs*******************************************************************************/
	
	/***/
	WebDriver getDriver() throws ControlException;
	/***/
	WebElement getElement() throws ControlException;
	/***/
	String getSelector() throws ControlException;
	/***/
	String getTagName() throws ControlException;
	
	/***/
	TakesScreenshot getScreenshot() throws ControlException;
	/***/
	byte[] getScreenshotAsBytes() throws ControlException;
	/***/
	String getScreenshotAsBase64() throws ControlException;
	
	
	//**DEBUG*/
	String toString();
}
