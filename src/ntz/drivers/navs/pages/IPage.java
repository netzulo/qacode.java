package ntz.drivers.navs.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.drivers.navs.elements.ControlTable;
import ntz.exceptions.PageException;
/**
* @author netzulo.com
* @since 2016-03-31
* @version 0.5.1
*/
public interface IPage {
	
	/**
	 * Lanza busquedas sobre selectores css sobre un script javascript iterando la lista de selectores
	 * Example: llama internamente a...
	 * <p>1--> this.busquedasLimpiar</p>
	 * <p>2--> this.busquedasLanzarJS</p>
	 * <p>3--> this.busquedasResultLog</p>
	 * */
	void searchControlsByJS(String textJS, String... selectores) throws PageException;
	
	/**
	 * Devuelve una instancia para el driver que esta utilizando en este momento
	 * 
	 * */
	WebDriver getCurrentDriver() throws PageException;
	
	/**
	 * Comprueba que la url no sea la seteada en la pagina
	 * */
	boolean isUrlChanged()throws PageException;
	
	/**
	 * Permite abrir una nueva pestaña
	 * <p>Cambia de pestaña usando un atajo de teclado: CONTROL+t</p>
	 * */
	void tabOpen() throws PageException;
	
	/**
	 * Permite cambiar entre pestañas
	 * <p>Cambia de pestaña usando un atajo de teclado: CONTROL+numTab</p>
	 * */
	void tabChange(int numTab) throws PageException;
	
	/**
	 * Permite cerrar una pestaña abierta
	 * <p>Cierra la pestaña actual usando un atajo de teclado: CONTROL+w</p>
	 * */
	void tabClose() throws PageException;
	
	/**
	 * Permite cambiar entre Frames dentro de un FrameSet web
	 * 
	 * <p>{@numberFrame}: -1 --> sale del frame volviendo al contenido</p>
	 * <p>{@numberFrame}: != -1 --> navega al subframe en la posicion indicada</p>
	 * */
	 void changeFrame(int numberFrame) throws PageException;
	
	/**
	 * Navega a la direccion de la pagina seteada
	 * */
	void goPageUrl() throws PageException;
	
	/**
	 * Iniciar la navegacion
	 * */
	void init() throws PageException;
	
	
	/**
	 * Funcion para lanzar las busquedas aplicando el array
	 * con los selectores para cada pagina especificamente
	 * */
	void searchCustom() throws PageException;
	
	/**
	 * Permite la ejecucion personalizada de busquedas de selectores
	 * */
	void searchCustom(String[] selectors) throws PageException;
	
	/**
	 * Inicia las busquedas de controles preconfigurados
	 * @return 
	 * */
	List<Boolean> searchControls(String...selectors) throws PageException;
	
	/**
	 * Inicia las busquedas de controles preconfigurados permitiendo encontrar valores nulos para los distintos selectores
	 * @return 
	 * */
	List<Boolean> searchControls(boolean isValidNULL, String... selectors) throws PageException;
	
	/**
	 * Parar la navegacion
	 * */
	void finish() throws PageException;
	
	/**
	 * Comprueba si la url como parametro es igual a la url del objeto actual
	 * */
	boolean isUrl(String url)throws PageException;
	
	
	/**
	 * Dada una lista de elementos web relacionados con las columnas para una tabla
	 * Busca por cada columna la fila y para cada fila, sus celdas
	 * 
	 * @return : List<String> list= [["fila_01_celda_01", "fila_01_celda_02"],["fila_02_celda_01", "fila_02_celda_02"]]
	 * <p>list[0] = ["fila_01_celda_01", "fila_01_celda_02"]</p>
	 * <p>list[1] = ["fila_02_celda_01", "fila_02_celda_02"]</p>
	 * */
	List<String> tableGetRow(List<WebElement> tableRowColsList) throws PageException;


	/**
	 * Implementacion para la clase WebTable con el selector dado por la pagina
	 * */
	ControlTable tableData() throws PageException;
	
	ControlTable tableData(WebElement tableElement) throws PageException;
	/**
	 * Ejecuta el metodo isContains para una clase WebTable, comprobando si existe un registro igual.
	 * @param textToSearch
	 * @throws PageException 
	 * */
	boolean tableDataContains(String textToSearch) throws PageException;
	/**
	 * Dado un elemento TABLE y el texto a chequear cuando no encuentre informacion
	 * dentro de las filas y columnas
	 * 
	 * @return TRUE si la tabla webElement esta vacia, FALSE en cualquier otro caso
	 * */
	boolean isTableEmpty(WebElement checkerElement, String checkerText) throws PageException;

	
	/***
	 * Dado un elemento INPUT type=checkbox, cambia el estado lanzando un evento click
	 * 
	 * */
	void chkBtnActive(WebElement checkElement, boolean isClick) throws PageException;

	List<String> tableRowExist();

	/**
	 * Busca todos los elementos web con el siguiente selector
	 * @SELECTOR_ByCss:[id*='rfvtxtText'] 
	 * */
	int txtErrorRequired();	
	
	
	/**
	 * Realiza busquedas utiliando metodos JavaScript para localizar los elementos
	 * @throws PageException 
	 * */
	void searchCustomByJS(String textJS, String...selectores) throws PageException;

	/**
	 * Se limpia el formulario de busqueda, se establece un fltro y un texto para la nueva búsqueda, y se hace la busqueda
	 * */
	IPage frmSearch(String txtFilter, String txtSearch);
	
	/**
	 * Se limpia el formulario de busqueda, se establece un fltro y un texto para la nueva búsqueda, y se hace la busqueda
	 * */
	IPage frmSearch(String txtFilter, String txtSearch, boolean searchNow);
	
	
	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	

	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	
}
