package ntz.tests.errors;

/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public interface ITestErrorMessage {
	
	///ITrandasha Exceptions
	
	final String DEV_notImplemented = "[BOT][ERROR]: webdriver not implemented";
	
	final String ERROR_botNull = "[BOT][ERROR]: can't build bot browser if bot it's null";
	
	final String ERROR_serverUrlNULL = "[BOT][ERROR]: can't build bot if url it's invalid format"; 
	
	final String ERROR_remoteBrowserNULL = "[BOT][ERROR]: can't build remote browser on node";
	
	final String ERROR_localBrowserNULL = "[BOT][ERROR]: can't build local browser";
	
	///WebDriver Exceptions
	final String ErrorTest_noSuchElement = "[BOT][ERROR]: don't found and element";
		
	
	
	///IControl Exceptions
	
	final String ERROR_clickEle = "[BOT][ERROR]: at try to click on element";
	
	final String ERROR_clearEle = "[BOT][ERROR]: at try to clear element";
	
	final String ERROR_writeEle = "[BOT][ERROR]: at try to write on element";

	final String ERROR_alertAccept = "[BOT][ERROR]: at try to acept alert ok button";
	
	final String ERROR_alertCancel = "[BOT][ERROR]: at try to acept alert cancel button";

	final String ERROR_alertAuth = "[BOT][ERROR]: at try to authenticate username and password on alert";

	final String ERROR_listLinksNotFound = "[BOT][ERROR]: at find sub links for each LI element of UL";

	final String ERROR_tableWrongTagname = "[BOT][ERROR]: Constructor, not TABLE tagName found for this element";

	final String ERROR_tableLoad = "[BOT][ERROR]: readCells(), can't load Table Structure";

	
	///Commons Exceptions
	
	final String ERROR_unknown = "[BOT][ERROR]: unkown error";

	final String ERROR_notImplemented = "[BOT][ERROR]: not implemented";
}
