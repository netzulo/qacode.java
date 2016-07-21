package ntz.drivers.navs.pages;
import ntz.exceptions.PageException;


/**
 * Best Web Scrapper ever
 * @author netzulo.com
 * @since 2016-04-04
 * @version 0.5.1
 */
public interface IPageForm {
	
	/**
	 * Rellena un formulario con la informacion especificada 
	 * */
	boolean formFill(String... texts ) throws PageException;
	
	/**
	 * Rellena un formulario con la informacion especificada y hace submit del formulario
	 * */
	boolean formFill(boolean isSubmit,String... texts ) throws PageException;
	

	/**
	 * Valida la integridad de los datos para los distitntos campos y hace click sobre el boton de confirmacion o SUBMIT del formulario
	 * */
	boolean formSubmit(boolean validateFields) throws PageException;

	
}
