package ntz.drivers.navs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ntz.drivers.TrandashaBase	;
import ntz.drivers.modules.Nav;
import ntz.drivers.navs.elements.ControlTable;
import ntz.exceptions.PageException;
import ntz.exceptions.ControlException;
import ntz.exceptions.WebNavException;
import ntz.logs.Log;
import ntz.tests.errors.ITestErrorMessage;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public abstract class APage implements IPage{
	
	protected String url;
	protected TrandashaBase bot;

	public APage() throws PageException{
		throw new PageException("[APage][ERROR-100]: Constructor without params denied");
	}
	public APage(TrandashaBase bot, String url) throws PageException{
		//Param: driver
		if(bot!=null){
			this.bot = bot;
		}else{
			throw new PageException("[APage][ERROR-101]: Constructor error on bot");
		} 
		//Param: url
		if(url!=null && url.equals("") != true){
			this.setUrl(url);
		}
		else{
			throw new PageException("[APage][ERROR-102]:  Constructor error on url");
		}
		
	}//APage
	
	public APage(TrandashaBase bot, String url, boolean navigateCurrentUrl) throws PageException{
		//Param: driver
		if(bot!=null){
			this.bot = bot;
		}else{
			throw new PageException("[APage][ERROR-101]: Constructor error on bot");
		} 
		//Param: url
		if(url!=null && url.equals("") != true){
			this.setUrl(url);
			
			if(navigateCurrentUrl){
				try {
					this.bot.webNav.navigate(url);
				} catch (WebNavException e) {
					throw new PageException("[APage.()][ERROR-108]: error at navigate to url |"+url, e);
				}
			}
			else{
				throw new PageException("[APage.()][ERROR-109]: User better APage(Bot bot, String url) |");
			}
		}
		else{
			throw new PageException("[APage][ERROR-102]:  Constructor error on url");
		}
		
	}//APage
	
	/** Overrides ************************************************************************************************************/
	@Override
	public List<String> tableGetRow(List<WebElement> tableRowColsList)  throws PageException{
		List<String> resultsRows = new ArrayList<>();
		List<String> resultsCols = new ArrayList<>();
		for (WebElement rowEle : tableRowColsList) {//			
			
			List<WebElement> cols = rowEle.findElements(By.cssSelector("td > span"));
			
			for (WebElement colEle : cols) {
				resultsCols.add(colEle.getText());
			}				
			resultsRows.add(resultsCols.toString());
			resultsCols = new ArrayList<>();
		}
		
		return resultsRows;
	}	
	
	@Override
	public List<String>	tableRowExist(){
		return null;
		
	}
	
	@Override
	public WebDriver getCurrentDriver(){
		WebDriver driver = null;
		WebDriver _driver = this.bot.webNav.getDriver();
		if(_driver  != null){
			driver = _driver ; 
		}//else
		return driver;
	}
	
	@Override
	public void searchControlsByJS(String textJS, String...selectores) throws PageException{
		WebDriver driver = null;
		List<Boolean> foundElements;
		//SELECCIONA EL DRIVER
		driver = getCurrentDriver();
		
		if(driver !=null){		
			//Limpia la lista de busquedas antes de empezar
			this.busquedasLimpiar();
			//Lanza las busquedas CSS sobre el navegador remoto
			foundElements = this.busquedasLanzarJS(textJS, selectores);
			//Por cada busqueda, comprueba si hay elemento			
			this.busquedasResultLog(foundElements);
		}//if
	}
	
	@Override
	public List<Boolean> searchControls(String...selectors) throws PageException {
		//WebNavigation nav = getServer().webNav;
		//RemoteWebDriver driver = this.bot.getRemoteDriver();
		WebDriver driver = null;
		List<Boolean> foundElements = null;
		
		//SELECCIONA EL DRIVER
		driver = getCurrentDriver();
				
		if(driver !=null){		
			//Limpia la lista de busquedas antes de empezar
			this.busquedasLimpiar();
			//Lanza las busquedas CSS sobre el navegador remoto
			foundElements = this.busquedasLanzar(selectors);
			//Por cada busqueda, comprueba si hay elemento			
			this.busquedasResultLog(foundElements);
		}//if
		return foundElements;
		
	}
		
	@Override
	public List<Boolean> searchControls(boolean isValidNULL,String...selectors) throws PageException {
		//WebNavigation nav = getServer().webNav;
		//RemoteWebDriver driver = this.bot.getRemoteDriver();
		WebDriver driver = null;
		List<Boolean> foundElements = null;
		
		//SELECCIONA EL DRIVER
		driver = getCurrentDriver();
				
		if(driver !=null){		
			//Limpia la lista de busquedas antes de empezar
			this.busquedasLimpiar();
			//Lanza las busquedas CSS sobre el navegador remoto
			foundElements = this.busquedasLanzar(true,selectors);
			//Por cada busqueda, comprueba si hay elemento			
			//this.busquedasResultLog(foundElements);
			//EVITA que falle con resultados FALSE
		}//if
		return foundElements;
		
	}
	
	@Override
	public boolean isUrlChanged() throws PageException {
		boolean isUrlChange = false;
		try {
			String urlPage = this.url;
			String currentUrl = this.bot.webNav.getCurrentUrl();
			
			boolean isSamePage = urlPage.endsWith(currentUrl);
			if(!isSamePage){
				isUrlChange = true;
			}
			
		} catch (WebNavException e) {
			throw new PageException("[APage.isUrlChanged][ERROR-3xx]: Can't find current url");
		}
		
		
		return isUrlChange;
	}
	
	@Override
	public void goPageUrl() throws PageException {
		try {
			this.bot.webNav.navigate(this.getUrl());
		} catch (WebNavException e) {
			throw new PageException();
		}
	}

	@Override
	public void tabOpen() throws PageException {
		try {
			this.bot.webNav.tabOpen();
		} catch (WebNavException e) {
			throw new PageException("[APage.tabOpen][ERROR-3xx]: Can't open a new tab");
		}		
	}
	
	@Override
	public void tabChange(int numTab) throws PageException {
		try {
			this.bot.webNav.tabChange(numTab);
		} catch (WebNavException e) {
			throw new PageException("[APage.tabOpen][ERROR-3xx]: Can't open a new tab");
		}
	}

	@Override
	public void tabClose() throws PageException {
		try {
			this.bot.webNav.tabClose();
		} catch (WebNavException e) {
			throw new PageException("[APage.tabOpen][ERROR-3xx]: Can't open a new tab");
		}
	}
	
	@Override
	public void changeFrame(int numberFrame) throws PageException{
		try {
			if(numberFrame == -1){
				this.bot.webNav.getDriver().switchTo().defaultContent();
			}else{
				this.bot.webNav.getDriver().switchTo().frame(numberFrame);
			}
		} catch (Exception e) {
			throw new PageException("[PLogin.changeFrame][ERROR-2xx]: ");
		}
	
	}
	@Override
	public boolean isTableEmpty(WebElement checkerElement, String checkerText) throws PageException{
		String txtFound;			
		try {
			PageFactory.initElements(this.bot.webNav.getDriver(), this);
			txtFound = checkerElement.getText();
			
			if(txtFound.equalsIgnoreCase(checkerText) == true){
				return true;
			}
			else if(txtFound.isEmpty() == true){
				return false;
			}
			else {
				throw new PageException("");
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public void chkBtnActive(WebElement checkElement, boolean isClick) throws PageException{		
		try {
			if(checkElement.isSelected()){
				throw new PageException("[Checkbox][ERROR]: El checkbox ya esta selecionado");
			}
			else{
				if(isClick){
					checkElement.click();
				}			
			}		
		} catch (Exception e) {
			throw new PageException("[Checkbox][ERROR]: error desconocido");
		}
	}	
	
	@Override
	public int txtErrorRequired(){
		 List<WebElement> element = this.bot.webNav.getDriver().findElements(By.cssSelector(("[id*='rfvtxtText']")));
		 int num = element.size();	
		 
		 
		 
		 return num;
	}
	
	/********************************************************************************************/
	
	
	/**GETs SETs methods*************************************************************************/
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	

	/**Protected methods*************************************************************************/
	
	
	
	/**
	 * Limpia la lista de controles
	 * <p>before execute: </p>
	 * <p>after execute: protected List<Boolean> busquedasLanzar(String...selectores)</p>
	 * @throws PageException
	 * */
	protected void busquedasLimpiar() throws PageException{
		try {
			//.isEmpty() --> genera un error
			//probando con .size()
			if(this.bot.webNav.getControls().size() > 0){
				this.bot.webNav.searchCleaner();
			}
		} catch (WebNavException e) {
			throw new PageException("[APage.busquedasLimpiar][Error-200]: Error at use search cleaner");
		}
	}
	
	/**
	 * Lanza busquedas sobre selectores css sobre un script javascript iterando la lista de selectores
	 * 
	 * example: "return document.querySelector('"+selectores[i]+"')"
	 */
	protected List<Boolean> busquedasLanzarJS(String scriptJS, String...selectores) throws PageException{
		Nav nav = bot.webNav;
		WebDriver driver = null;
		List<Boolean> foundElements = new ArrayList<>();
		
		//SELECCIONA EL DRIVER
		driver = getCurrentDriver();
		
		//Si el driver no es nulo
		if(driver !=null){			
			//Realiza busqueda CSS y añade el elemento --> notifica resultado busqueda en foundElements
			for (int i = 0; i < selectores.length; i++) {				
				try {
					if(scriptJS.equalsIgnoreCase("") == true){
						scriptJS = "return window.frames[1].frames[1].frames[2].document.querySelector('"+selectores[i]+"')[0]";
					}else{
						//scriptJS = "return document.querySelector('"+selectores[i]+"')";
					}
					
					WebElement ele = null;
					String eleText = "EMPTY";
					
					try{
						ele = (WebElement) ((JavascriptExecutor) driver).executeScript(scriptJS, new Object[0]);
					}catch(Exception err){
						throw new PageException("[APage.busquedasLanzarJS][Error-201]: Error at search by JS code");
					}					
					
					if(ele != null){
						foundElements.add(nav.searchAndAdd(ele));
					}
					else{
						try{
							eleText = (String) ((JavascriptExecutor) driver).executeScript(scriptJS, new Object[0]);
						}catch(Exception err){
							throw new PageException("[APage.busquedasLanzarJS][Error-201]: Error at search by JS code");
						}
						if(eleText.endsWith("EMPTY") == true || eleText != null){
							//foundElements.add(nav.searchAndAdd(eleText));
							foundElements.add(true);
						}
//						else{
//							foundElements.add(false);
//						}
						
					}
					//foundElements.add(nav.searchAndAdd(selectores[i]));
				}
				catch (WebNavException e) {
					throw new PageException("[APage.busquedasLanzarJS][Error-201]: Error at use search launcher");
				}//elemento Web
			}//for
		}
		return foundElements;
	}
	
	/**
	 * Lanza una busqueda de selectores CSS
	 * <p>before execute: protected void busquedasLimpiar()</p>
	 * <p>after execute: protected List<Boolean> busquedasLanzar(String...selectores)</p>
	 * @throws PageException
	 * */
	protected List<Boolean> busquedasLanzar(String...selectores) throws PageException{
		Nav nav = bot.webNav;
		//RemoteWebDriver driver = this.bot.getRemoteDriver();
		WebDriver driver = null;
		List<Boolean> foundElements = new ArrayList<>();
		boolean isLocated; //temp for locate elements via CSSselector
		//SELECCIONA EL DRIVER
		driver = getCurrentDriver();		
		
		//Si el driver no es nulo
		if(driver !=null){			
			//Realiza busqueda CSS y añade el elemento --> notifica resultado busqueda en foundElements
			for (int i = 0; i < selectores.length; i++) {
				try {
					isLocated = nav.searchAndAdd(selectores[i]);
					
					foundElements.add(isLocated);
				} catch (WebNavException e) {
					throw new PageException("[APage.busquedasLanzar][Error-201]: Error at use search launcher | Error at search");
				}//elemento Web
			}
		}
		
		return foundElements;
	}
	
	/**
	 * Lanza una busqueda de selectores CSS permitiendo selectores encontrados NULLs
	 * <p>before execute: protected void busquedasLimpiar()</p>
	 * <p>after execute: protected List<Boolean> busquedasLanzar(String...selectores)</p>
	 * @throws PageException
	 * */
	protected List<Boolean> busquedasLanzar(boolean isValidNull,String...selectores) throws PageException{
		Nav nav = bot.webNav;
		//RemoteWebDriver driver = this.bot.getRemoteDriver();
		WebDriver driver = null;
		List<Boolean> foundElements = new ArrayList<>();
		boolean isLocated; //temp for locate elements via CSSselector
		//SELECCIONA EL DRIVER
		driver = getCurrentDriver();		
		
		//Si el driver no es nulo
		if(driver !=null){			
			//Realiza busqueda CSS y añade el elemento --> notifica resultado busqueda en foundElements
			for (int i = 0; i < selectores.length; i++) {
				try {
					isLocated = nav.searchAndAdd(selectores[i],isValidNull);
					
					foundElements.add(isLocated);
				} catch (ControlException e) {
					throw new PageException("[APage.busquedasLanzar][Error-201]: Error at use search launcher | Error at search");
				}//elemento Web
			}
		}
		
		return foundElements;
	}
		
	/**
	 * Genera resultados en el LOG a partir de una lista de valores booleanos
	 * <p>before execute: protected List<Boolean> busquedasLanzar(String...selectores)</p>
	 * <p>after execute: </p>
	 * @throws PageException
	 * */
	protected void busquedasResultLog(List<Boolean> foundElements) throws PageException{
		//Por cada busqueda, comprueba si hay elemento
		String codError202 = "[APage.busquedasResultLog][Error-202]: Error at use search results";
		String codOK = "[APage.busquedasResultLog][OK]: found element by CSS selector";		
		for (Boolean isEle : foundElements) {		
			if(!isEle){	
				Log.error(codError202);
				throw new PageException(codError202);
			}
			else{
				Log.info(codOK);
			}
		}//for
	}
		
	/**FIELDS  **********************************************************************************/	
	/*································································*/
	
	/*································································*/
	/**OVERRIDES methods*************************************************************************/
	
	
	@Override
	public ControlTable tableData(WebElement tableElement) throws PageException {
		ControlTable tbl = null;
		try {
			tbl = new ControlTable(tableElement);
		} catch (Exception e) {
			String err = String.format("[CONTROL][ERROR]: %s", e.getMessage());
			throw new PageException(err, e);
		}
		return tbl;
	}	
	
	@Override
	public boolean tableDataContains(String textToSearch) throws PageException{
		try {
			return tableData().isContain(textToSearch);
		} catch (PageException e) {
			throw new PageException(ITestErrorMessage.ERROR_notImplemented);
		}
	}
	
	
	@Override
	public IPage frmSearch(String txtFilter, String txtSearch){		
		this.frmSearch(txtFilter, txtSearch, true);		
		return this;
	}
	
	
	@Override
	public IPage frmSearch(String txtFilter, String txtSearch, boolean searchNow){
		
		return this;
	}
	
	/**NOT IMPLEMENTED methods*************************************************************************/
	@Override
	public void searchCustom() throws PageException {
		throw new PageException(ITestErrorMessage.ERROR_notImplemented);
	}
	
	@Override
	public void init() throws PageException {
		PageFactory.initElements(this.bot.webNav.getDriver(), this);
	}

	@Override
	public void finish() throws PageException {
		throw new PageException(ITestErrorMessage.ERROR_notImplemented);		
	}

	@Override
	public boolean isUrl(String url) throws PageException {
		throw new PageException(ITestErrorMessage.ERROR_notImplemented);	
	}

	
}
