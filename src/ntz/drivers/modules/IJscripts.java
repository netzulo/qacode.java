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
				"listeners = getEventListeners(arguments[0]);"+
				"for(event in listeners) {"+
					"allListeners[event] = allListeners[event] || [];"+
					"allListeners[event].push({listener: listeners[event], element: arguments[0]});"+  
				"}"+
			"arguments[0] = arguments[0].parentNode;"+
 			"}"+
  			"return allListeners;";

	final String getFirstArg = "return arguments[0]";  			  			
	
	
	final String eleGetAttribute = "return arguments[0].getAttribute(arguments[1]);";
	final String elesetAttribute = "return arguments[0].setAttribute(arguments[1],arguments[2]);";
}
