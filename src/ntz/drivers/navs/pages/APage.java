package ntz.drivers.navs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import ntz.drivers.ITrandasha;
import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.elements.ControlBase;
import ntz.drivers.navs.elements.IControl;
import ntz.drivers.navs.pages.models.IModel;
import ntz.exceptions.ControlException;
import ntz.exceptions.NavException;
import ntz.exceptions.PageException;
import ntz.tests.errors.ITestErrorMessage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
* @author netzulo.com
* @since 2016-08-20
* @version 0.5.9
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
	 * @throws NavException 
	 */
	public APage(ITrandasha bot, String pageUrl, boolean isNavigateNow, boolean isInitElements) throws PageException, NavException{
		this(bot, pageUrl,isNavigateNow);
		if(isInitElements){
			PageFactory.initElements(this.bot.navs.getDriver(), this);
		}
	}

	
	/**Overrides *********************************************************************************/


	@Override
	public void removeModels() throws PageException {
		try {
			if(this.models.size() <= 0){throw new PageException("[APage.addModel][ERROR]: No models to remove was found");}
			else{
				for (int i = 0; i < this.models.size(); i++) {
					this.models.remove(i);
				}
				//reinitialize instance
				this.models = new ArrayList<>();
			} 
		} catch (Exception e) {
			throw new PageException("[APage.addModel][ERROR]: error at iterate to remove each model");
		}
		
	}
	
	
	@Override
	public void addModel(IModel model) throws PageException {
		if(model == null){throw new PageException("[APage.addModel][ERROR]: Null model");}
		else{
			this.models.add(model);
		}
	}


	@Override
	public void addControlToModel(IControl control) throws PageException {
		if(control ==null ){throw new PageException("[APage.addControlToModel][ERROR]: Null control");}
		else{
			IModel firstModel = this.models.get(0);
			if(firstModel == null){throw new PageException("[APage.addControlToModel][ERROR]: Null model");}
			else{
				firstModel.addControl(control);
			}
		}
	}


	@Override
	public void addControlToModel(String selector) throws PageException {
		try {
			this.addControlsToModel(new ControlBase(this.bot, selector));
		} catch (ControlException e) {
			throw new PageException(e.getMessage(),e);
		}
	}


	@Override
	public void addControlToModel(int modelPosition,IControl control) throws PageException {
		this.models.get(modelPosition).addControl(control);
	}


	@Override
	public void addControlsToModel(IControl... control) throws PageException {
		for (IControl iControl : control) {
			this.addControlToModel(iControl);
		}
	}


	@Override
	public void addControlsToModel(String... selectors) throws PageException {
		for (String selector : selectors) {
			this.addControlToModel(selector);
		}
	}


	@Override
	public void addControlsToModel(List<String> selectors) throws PageException {
		for (String selector : selectors) {
			this.addControlToModel(selector);
		}
	}


	@Override
	public void addControlsToModel(int modelPosition, IControl... controls) throws PageException {
		for (IControl iControl : controls) {
			this.models.get(modelPosition).addControl(iControl);
		}
	}


	@Override
	public void addControlsToModel(int modelPosition, String... selectors) throws PageException {
		for (String selector : selectors) {
			this.addControlToModel(selector);
		}
	}


	@Override
	public void addControlsToModel(int modelPosition, List<String> selectors) throws PageException {
		for (String selector : selectors) {
			this.addControlToModel(selector);
		}
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
			this.bot.navs.goToUrl(this.url);
		} catch (Exception e) {
			throw new PageException("Error at navigate to: "+ this.url);
		}
	}


	@Override
	public void navTabOpen() throws PageException {
		try {
			this.bot.navs.tabOpen();
		} catch (NavException e) {
			throw new PageException("[APage.navTabOpen][ERROR-xxx]: Can't open a new tab");
		}	
	}


	@Override
	public void navTabChange(int numTab) throws PageException {
		try {
			this.bot.navs.tabChange(numTab);
		} catch (NavException e) {
			throw new PageException("[APage.navTabChange][ERROR-xxx]: Can't open a new tab");
		}	
	}


	@Override
	public void navTabClose() throws PageException {
		try {
			this.bot.navs.tabOpen();
		} catch (NavException e) {
			throw new PageException("[APage.navTabClose][ERROR-xxx]: Can't open a new tab");
		}	
	}


	@Override
	public void navTabClose(int numTabToClose) throws PageException {
		try {
			this.navTabChange(numTabToClose);
			this.bot.navs.tabClose();
		} catch (NavException e) {
			throw new PageException("[APage.navTabClose][ERROR-3xx]: Can't open a new tab");
		}
	}


	@Override
	public void navToIframe(int numIframeToChange) throws PageException {
		try {
			if(numIframeToChange == -1){
				this.bot.navs.getDriver().switchTo().defaultContent();
			}else{
				this.bot.navs.getDriver().switchTo().frame(numIframeToChange);
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
	
	@Override
	public String toString() {
		String botToLog = "";
		String modelsToLog = "";
		String searcherName = "NULL";
		String text = "";
		try {
			botToLog = bot.toString();
			modelsToLog = models.toString();
			
			searcherName = searcher.name();
			
			text = "APage [searcher=" + searcherName + ", url=" + url + ", bot=" + botToLog + ", models=" + modelsToLog + "]";
		} catch (Exception e) {
			e.getMessage();
		}
		
		return text;
	}
	/**Page public methods*************************************************************************/
		
	@Override
	public String getCurrentUrl() throws PageException{
		String currUrl = "";
		try {
			
			currUrl = this.bot.navs.getCurrentUrl();
			
			
		} catch (Exception e) {
			throw new PageException(ITestErrorMessage.ERROR_url);
		}
		return currUrl;
	}


	
	
}
