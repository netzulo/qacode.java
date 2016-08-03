package ntz.app;

import org.testng.annotations.Test;

import ntz.exceptions.TrandashaException;
import ntz.testlink.TestlinkBase;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class TestlinkTest {
	@Test
	public void ConnectorTest() throws TrandashaException {
		TestlinkBase testlink;
		
		try {		
			testlink = new TestlinkBase();
			
			//TODO: create structure from code
			
			//TODO: update testcases
			
						
			System.out.println(testlink.toString());
		  
		} catch (Exception e) {
			throw new TrandashaException("Error al usar TestlinkConnector",e);
		}
	  
	}
}
