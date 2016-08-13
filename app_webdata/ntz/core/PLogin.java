package ntz.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ntz.drivers.ITrandasha;
import ntz.drivers.navs.pages.PageBase;
import ntz.exceptions.NavException;
import ntz.exceptions.PageException;

public class PLogin extends PageBase {

	@FindBy(css = "[id*='txtUsername']")
	private WebElement txtUsername;
	
	@FindBy(css = "[id*='txtPassword']")
	private WebElement txtPassword;
	
	@FindBy(css = "[id*='btnLogin']")
	private WebElement btnLogin;
	
	public PLogin() throws PageException {
		super();
	}

	public PLogin(ITrandasha bot, String pageUrl, boolean isNavigateNow, boolean isInitElements) throws PageException, NavException {
		super(bot, pageUrl, isNavigateNow, isInitElements);		
	}

	public PLogin(ITrandasha bot, String pageUrl, boolean isNavigateNow) throws PageException {
		super(bot, pageUrl, isNavigateNow);
	}

	public PLogin(ITrandasha bot, String pageUrl) throws PageException {
		super(bot, pageUrl);
	}

	public PLogin(ITrandasha bot) throws PageException {
		super(bot);
	}

	/*********************************************************************/
	public void login(String username, String password){
		this.txtUsername.clear();
		this.txtUsername.sendKeys(username);
		
		this.txtPassword.clear();
		this.txtPassword.sendKeys(password);
		
		this.btnLogin.click();
	}
	/*********************************************************************/
}
