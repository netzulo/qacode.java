package ntz.drivers.navs.pages;

import java.util.List;

import ntz.drivers.ITrandasha;
import ntz.drivers.navs.elements.IControl;
import ntz.drivers.navs.pages.modules.IModel;
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
public interface IPage {

	/**enums************************************************************************************/
	enum SearchType{CSS,JS,XPATH}
	/*MODELS********************************************************/
	
	/***/	
	void addModel(IModel model);
	
	/**
	 * Add to first model
	 * */
	void addControlToModel(IControl control) throws PageException;
	/***/
	void addControlToModel(String selector) throws PageException;
	/***/ 
	void addControlToModel(int modelPosition,IControl control) throws PageException;
	
		
	/***/
	void addControlsToModel(IControl control) throws PageException;
	/***/
	void addControlsToModel(String... selectors) throws PageException;
	/***/
	void addControlsToModel(List<String> selectors) throws PageException;

	/***/
	void addControlsToModel(int modelPosition,IControl control) throws PageException;
	/***/
	void addControlsToModel(int modelPosition,String... selectors) throws PageException;
	/***/
	void addControlsToModel(int modelPosition,List<String> selectors) throws PageException;
	
	/*PAGE********************************************************/
		
	/***/
	void findControlsByJs(String...selectors) throws PageException;
	/***/
	void findControlsByJs(String scriptJs, String...selectors) throws PageException;
	/***/
	void findControlsByCss(String...selectors) throws PageException;
	/***/
	void findControlsByXpath(String...selectors) throws PageException;
	
	/***/
	boolean isUrlChanged() throws PageException;
	
	/***/
	void navToPageUrl() throws PageException;
	
	/***/
	void navTabOpen() throws PageException;
	
	/***/
	void navTabChange(int numTab) throws PageException;
	
	/***/
	void navTabClose()throws PageException;
	
	/***/
	void navTabClose(int numTabToClose) throws PageException;
	
	/***/
	void navToIframe(int numIframeToChange) throws PageException;
	
	/**GETs SETs me1thods*************************************************************************/
	
	/***/
	String getUrl()throws PageException;
	/***/
	void setUrl(String url) throws PageException;
		
	/***/
	ITrandasha getCurrentBot() throws PageException;
	/***/
	void setCurrentBot(ITrandasha bot) throws PageException;
	
	/***/
	SearchType getSearcher() throws PageException;
	/***/
	void setSearcher(SearchType searcher) throws PageException;
	
	/***/
	List<IModel> getModels();
	
	/***/
	IModel getModel(int modelPosition);
}
