/**
 * 
 */
package ntz.drivers.navs.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.elements.ControlBase;
import ntz.exceptions.PageException;

/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public abstract class APageLogin extends APage implements IPageLogin {

	
	public APageLogin() throws PageException {}

	
	public APageLogin(TrandashaBase bot, String url) throws PageException {
		super(bot, url);
	}


	public APageLogin(TrandashaBase bot, String url, boolean navigateCurrentUrl) throws PageException {
		super(bot, url, navigateCurrentUrl);
	}
	
	@Override
	public void searchCustom(String[] selectors) throws PageException {
		this.searchControls(selectors);
	}

	@Override
	public boolean setLogin(String[] selectors) throws PageException {
		boolean isSettedSelectors = false;
		try {
			if(selectors == null){
				throw new PageException("[APageLogin.setLogin][ERROR-xxx]: selectors list NULL");
			}
			else{
				this.searchControls(selectors);
				isSettedSelectors = true;
			}
		} catch (Exception e) {
			throw new PageException("[APageLogin.setLogin][ERROR-xxx]: not implemented");
		}	
		return isSettedSelectors;
	}

	@Override
	public boolean login(String username, String password) throws PageException {
		boolean isLogged = false;
		List<ControlBase> controls = this.bot.webNav.getControls();		
		WebElement txtUsername = null;
		WebElement txtPassword = null;
		WebElement btnLogin = null;
		
		try {
			txtUsername = controls.get(0).getElement();
			txtPassword = controls.get(1).getElement();
			btnLogin = controls.get(2).getElement();
			
			txtUsername.sendKeys(username);
			txtPassword.sendKeys(password);
			btnLogin.click();
			
			isLogged = true;
		} catch (Exception e) {
			throw new PageException("[APageLogin.login][ERROR-xxx]: error at login");
		}
		
		return isLogged;
	}

	
}
