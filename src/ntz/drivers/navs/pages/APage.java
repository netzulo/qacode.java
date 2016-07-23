package ntz.drivers.navs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import ntz.drivers.ITrandasha;
import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.elements.IControl;
import ntz.drivers.navs.pages.modules.IModel;
import ntz.exceptions.PageException;
import ntz.exceptions.WebNavException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
* @author netzulo.com
* @since 2016-07-22
* @version 0.5.2
* 
* <p></p>
* <p></p>
* <p></p>
*/
public abstract class APage implements IPage{
	
	/**Fields************************************************************************************/



	/***/
	protected SearchType searcher;
	
	/*PAGE********************************************************/	
	
	


	/***/
	protected String url;
	
	/***/
	protected TrandashaBase bot;
		
	/*MODELS********************************************************/
	
	/***/
	protected List<IModel> models;
	
	/**Constructors******************************************************************************/
	
	/**
	 * @throws PageException
	 */
	public APage() throws PageException{
		throw new PageException("[APage][ERROR-100]: Constructor without params denied");
	}
	
	
	/**
	 * @throws PageException
	 */
	public APage(ITrandasha bot) throws PageException{
		
		if(bot == null){ throw new PageException("Bad url provided");}
		else{
			this.bot = (TrandashaBase) bot;
			models = new ArrayList<>();
		}
	}
	
	/**
	 * @throws PageException
	 */
	public APage(ITrandasha bot, String pageUrl) throws PageException{
		this(bot);
		if(pageUrl.length() <= 0){ throw new PageException("Bad url provided");}
		else{
			this.url = pageUrl;
		}
	}

	/**
	 * @throws PageException
	 */
	public APage(ITrandasha bot, String pageUrl, boolean isNavigateNow) throws PageException{
		this(bot, pageUrl);
		if(isNavigateNow){
			this.navToPageUrl();
		}
	}

	
	/**
	 * Just use on inherits of PageBase class
	 * @throws PageException
	 */
	public APage(ITrandasha bot, String pageUrl, boolean isNavigateNow, boolean isInitElements) throws PageException{
		this(bot, pageUrl,isNavigateNow);
		if(isInitElements){
			PageFactory.initElements(this.bot.webNav.getDriver(), this);
		}
	}

	
	/**Overrides*********************************************************************************/

	
	@Override
	public void addModel(IModel model) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void addControlToModel(IControl control) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void addControlToModel(String selector) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void addControlToModel(int modelPosition, IControl control) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void addControlsToModel(IControl control) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void addControlsToModel(String... selectors) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void addControlsToModel(List<String> selectors) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void addControlsToModel(int modelPosition, IControl control) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void addControlsToModel(int modelPosition, String... selectors) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void addControlsToModel(int modelPosition, List<String> selectors) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void findControlsByJs(String... selectors) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void findControlsByJs(String scriptJs, String... selectors) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void findControlsByCss(String... selectors) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void findControlsByXpath(String... selectors) throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public boolean isUrlChanged() throws PageException {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}


	@Override
	public void navToPageUrl() throws PageException {		
		try {
			this.bot.webNav.navigate(this.url);
		} catch (Exception e) {
			throw new PageException("Error at navigate to: "+ this.url);
		}
	}


	@Override
	public void navTabOpen() throws PageException {
		try {
			this.bot.webNav.tabOpen();
		} catch (WebNavException e) {
			throw new PageException("[APage.navTabOpen][ERROR-xxx]: Can't open a new tab");
		}	
	}


	@Override
	public void navTabChange(int numTab) throws PageException {
		try {
			this.bot.webNav.tabChange(numTab);
		} catch (WebNavException e) {
			throw new PageException("[APage.navTabChange][ERROR-xxx]: Can't open a new tab");
		}	
	}


	@Override
	public void navTabClose() throws PageException {
		try {
			this.bot.webNav.tabOpen();
		} catch (WebNavException e) {
			throw new PageException("[APage.navTabClose][ERROR-xxx]: Can't open a new tab");
		}	
	}


	@Override
	public void navTabClose(int numTabToClose) throws PageException {
		try {
			this.navTabChange(numTabToClose);
			this.bot.webNav.tabClose();
		} catch (WebNavException e) {
			throw new PageException("[APage.navTabClose][ERROR-3xx]: Can't open a new tab");
		}
	}


	@Override
	public void navToIframe(int numIframeToChange) throws PageException {
		try {
			if(numIframeToChange == -1){
				this.bot.webNav.getDriver().switchTo().defaultContent();
			}else{
				this.bot.webNav.getDriver().switchTo().frame(numIframeToChange);
			}
		} catch (Exception e) {
			throw new PageException("[APage.navToIframe][ERROR-xxx]: ");
		}
	}


	@Override
	public String getUrl() throws PageException {		
		return this.url;
	}


	@Override
	public void setUrl(String url) throws PageException {
		this.url = url;
	}


	@Override
	public ITrandasha getCurrentBot() throws PageException {
		return this.bot;
	}


	@Override
	public void setCurrentBot(ITrandasha bot) throws PageException {
		this.bot = (TrandashaBase) bot;
	}


	@Override
	public SearchType getSearcher() throws PageException {
		return searcher;
	}


	@Override
	public void setSearcher(SearchType searcher) throws PageException {
		this.searcher = searcher;
	}
	
	
	@Override
	public List<IModel> getModels() {
		return this.models;
	}
	
	@Override
	public IModel getModel(int modelPosition) {
		return this.models.get(modelPosition);
	}
}
