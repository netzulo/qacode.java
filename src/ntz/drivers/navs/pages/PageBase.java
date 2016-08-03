package ntz.drivers.navs.pages;

import java.util.List;

import ntz.drivers.ITrandasha;
import ntz.drivers.navs.elements.IControl;
import ntz.drivers.navs.pages.models.IModel;
import ntz.exceptions.NavException;
import ntz.exceptions.PageException;
/**
* @author netzulo.com
* @since 2016-07-22
* @version 0.5.2
* 
* <p></p>
* <p></p>
* <p></p>
*/
public class PageBase extends APage {
	
	/**Constructors*************************************************************************/

	public PageBase() throws PageException {super();}

	public PageBase(ITrandasha bot, String pageUrl, boolean isNavigateNow, boolean isInitElements)throws PageException, NavException {super(bot, pageUrl, isNavigateNow, isInitElements);}

	public PageBase(ITrandasha bot, String pageUrl, boolean isNavigateNow) throws PageException {super(bot, pageUrl, isNavigateNow);}

	public PageBase(ITrandasha bot, String pageUrl) throws PageException {super(bot, pageUrl);}

	public PageBase(ITrandasha bot) throws PageException {super(bot);}
	/**Overrides*************************************************************************/
	@Override
	public void addModel(IModel model) throws PageException {
		super.addModel(model);		
	}

	@Override
	public void addControlToModel(IControl control) throws PageException {
		super.addControlToModel(control);
	}

	@Override
	public void addControlToModel(String selector) throws PageException {
		super.addControlToModel(selector);
	}

	@Override
	public void addControlToModel(int modelPosition, IControl control) throws PageException {
		super.addControlToModel(modelPosition, control);
	}

	@Override
	public void addControlsToModel(IControl... control) throws PageException {
		super.addControlsToModel(control);
	}

	@Override
	public void addControlsToModel(String... selectors) throws PageException {
		super.addControlsToModel(selectors);
	}

	@Override
	public void addControlsToModel(List<String> selectors) throws PageException {
		super.addControlsToModel(selectors);
	}

	@Override
	public void addControlsToModel(int modelPosition, IControl... controls) throws PageException {
		super.addControlsToModel(modelPosition, controls);
	}

	@Override
	public void addControlsToModel(int modelPosition, String... selectors) throws PageException {
		super.addControlsToModel(modelPosition, selectors);
	}

	@Override
	public void addControlsToModel(int modelPosition, List<String> selectors) throws PageException {
		super.addControlsToModel(modelPosition, selectors);
	}

	@Override
	public void findControlsByJs(String... selectors) throws PageException {
		super.findControlsByJs(selectors);
	}

	@Override
	public void findControlsByJs(String scriptJs, String... selectors) throws PageException {
		super.findControlsByJs(scriptJs, selectors);
	}

	@Override
	public void findControlsByCss(String... selectors) throws PageException {
		super.findControlsByCss(selectors);
	}

	@Override
	public void findControlsByXpath(String... selectors) throws PageException {
		super.findControlsByXpath(selectors);
	}

	@Override
	public boolean isUrlChanged() throws PageException {
		return super.isUrlChanged();
	}

	@Override
	public void navToPageUrl() throws PageException {
		super.navToPageUrl();
	}

	@Override
	public void navTabOpen() throws PageException {
		super.navTabOpen();
	}

	@Override
	public void navTabChange(int numTab) throws PageException {
		super.navTabChange(numTab);
	}

	@Override
	public void navTabClose() throws PageException {
		super.navTabClose();
	}

	@Override
	public void navTabClose(int numTabToClose) throws PageException {
		super.navTabClose(numTabToClose);
	}

	@Override
	public void navToIframe(int numIframeToChange) throws PageException {
		super.navToIframe(numIframeToChange);
	}

	@Override
	public IModel getModel(int modelPosition) {
		return super.getModel(modelPosition);
	}

	@Override
	public String toString() {

		return super.toString();
	}

	/**GETs SETs methods*************************************************************************/
	@Override
	public String getUrl() throws PageException {		 
		return super.getUrl();
	}

	@Override
	public void setUrl(String url) throws PageException {		 
		super.setUrl(url);
	}

	@Override
	public ITrandasha getCurrentBot() throws PageException {		 
		return super.getCurrentBot();
	}

	@Override
	public void setCurrentBot(ITrandasha bot) throws PageException {		 
		super.setCurrentBot(bot);
	}

	@Override
	public SearchType getSearcher() throws PageException {		 
		return super.getSearcher();
	}

	@Override
	public void setSearcher(SearchType searcher) throws PageException {		 
		super.setSearcher(searcher);
	}

	@Override
	public List<IModel> getModels() {
		return super.getModels();
	}
	
}
