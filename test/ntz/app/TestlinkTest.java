package ntz.app;

import org.testng.annotations.Test;

import ntz.exceptions.TrandashaException;
import ntz.testlink.TestlinkConnector;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class TestlinkTest {
	@Test
	public void ConnectorTest() throws TrandashaException {
		TestlinkConnector testlink;
		
		try {		
			testlink = new TestlinkConnector();
			
			//TODO: create structure from code
			
			//TODO: update testcases
			
						
			System.out.println(testlink.toString());
		  
		} catch (Exception e) {
			throw new TrandashaException("Error al usar TestlinkConnector",e);
		}
	  
	}
}
