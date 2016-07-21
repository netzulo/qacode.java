package ntz.test.app;

import org.testng.annotations.Test;

import ntz.exceptions.BotException;
import ntz.testlink.TestlinkConnector;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class TestlinkTest {
	@Test
	public void ConnectorTest() throws BotException {
		TestlinkConnector testlink;
		
		try {		
			testlink = new TestlinkConnector();
			
			//TODO: create structure from code
			
			//TODO: update testcases
			
						
			System.out.println(testlink.toString());
		  
		} catch (Exception e) {
			throw new BotException("Error al usar TestlinkConnector",e);
		}
	  
	}
}
