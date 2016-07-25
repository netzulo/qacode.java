package ntz.drivers.modules;
/**
* @author netzulo.com
* @since 2016-07-25
* @version 0.5.4
* 
* <p></p>
* <p></p>
* <p></p>
*/
public interface IJscripts {

	final String js_click = "arguments[0].click();";
	
	final String js_getAllEventListeners = 
			"var allListeners = {}, listeners;"+
			"while(arguments[0]) {"+
				"listeners = getEventListeners(el);"+
				"for(event in listeners) {"+
					"allListeners[event] = allListeners[event] || [];"+
					"allListeners[event].push({listener: listeners[event], element: arguments[0]});"+  
				"}"+
			"arguments[0] = arguments[0].parentNode;"+
 			"}"+
  			"return allListeners;";

	final String getFirstArg = "return arguments[0]";  			  			
}
