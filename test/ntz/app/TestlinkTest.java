package ntz.app;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import ntz.exceptions.PageException;
import ntz.exceptions.TestlinkException;
import ntz.files.FileManager;
import ntz.logs.Log;
import ntz.testlink.TestlinkBase;
import ntz.tests.TestInfoBase;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class TestlinkTest extends TestInfoBase {
	private Hashtable<String,String> props;
	private TestlinkBase testlink;
	
	
	@DataProvider(name = "pathsDP")
	public Object[][] pathsDP(){
		return new Object[][]{
			{"/libs/configs/testlink/testlink.properties"},
			{"libs/configs/testlink/testlink.properties"},
			{"/configs/testlink/testlink.properties"},
			{"configs/testlink/testlink.properties"},
			{"/testlink/testlink.properties"},
			{"testlink/testlink.properties"},
			{"testlink.properties"},
			{"\\libs\\configs\\testlink\\testlink.properties"},
			{"libs\\configs\\testlink\\testlink.properties"},
			{"\\configs\\testlink\\testlink.properties"},
			{"configs\\testlink\\testlink.properties"},
			{"\\testlink\\testlink.properties"},
			{"testlink\\testlink.properties"},
			{"testlink.properties"}			
		};
	}
	
	@AfterMethod
	public void beforeMethod() throws TestlinkException{
		try {								
			//TODO: connect to existing structure
			
			//TODO: create structure from code
			
			//TODO: update testcases
//			TestCase test001 = testlink.api.getTestCaseByExternalId("wd-1", 1);
//			TestCase test002 = testlink.api.getTestCaseByExternalId("wd-2", 1);
			  
		} catch (Exception e) {								
			throw new TestlinkException("Error al usar TestlinkConnector",e);
		}
	}
	
	
	@BeforeMethod
	public void afterMethod() throws TestlinkException{		
		try {								
			
			
		} catch (Exception e) {								
			throw new TestlinkException("Error al usar TestlinkConnector",e);
		}
	}
	

	
	@Test()
	public void ConnectorTest() throws PageException {
		try {					
			props = FileManager.readProperties("/libs/configs/testlink/testlink.properties", "url","devkey");
			testlink = new TestlinkBase(props.get("url"), props.get("devkey"));								
//			TestCase test001 = testlink.api.getTestCaseByExternalId("wd-1", 1);
//			TestCase test002 = testlink.api.getTestCaseByExternalId("wd-2", 1);
//							
//			System.out.println(test001.toString());
//			System.out.println(test002.toString());
			Log.info("TESLINK: --> "+testlink.toString());
		} catch (Exception e) {								
			this.onErrorAtFinish(e);
		}	  
	}
	
	
	@Test()
	public void TestViewer() throws PageException {
		try {					
			props = FileManager.readProperties(FileManager.PATH_TESTLINK, "url","devkey");
			testlink = new TestlinkBase(props.get("url"), props.get("devkey"));								
			TestCase loginOK = testlink.getTestCaseByExtId("wd-1");
			TestCase loginKO = testlink.getTestCaseByExtId("wd-2");

			Log.warn("[TESTCASE]: "+ loginOK.toString());
			Log.warn("[TESTCASE]: "+ loginKO.toString());
			Log.info("TESLINK: --> "+testlink.toString());
		} catch (Exception e) {								
			this.onErrorAtFinish(e);
		}	  
	}

	@Test()
	public void TestUpdater() throws PageException {
		try {					
			props = FileManager.readProperties("/libs/configs/testlink/testlink.properties", "url","devkey");
			testlink = new TestlinkBase(props.get("url"), props.get("devkey"));								
			TestCase loginOK = testlink.getTestCaseByExtId("wd-1");
			TestCase loginKO = testlink.getTestCaseByExtId("wd-2");

			loginOK.setExecutionStatus(ExecutionStatus.PASSED);
			loginKO.setExecutionStatus(ExecutionStatus.BLOCKED);
			
			testlink.apiAddResult(loginOK);
			testlink.apiAddResult(loginKO);
			
			testlink.apiExecResults();
			Log.info("TESLINK: --> "+testlink.toString());
		} catch (Exception e) {								
			this.onErrorAtFinish(e);
		}	  
	}
	
	
	@Test()
	public void TestSpecificUpdater() throws PageException {
		try {					
			props = FileManager.readProperties("/libs/configs/testlink/testlink.properties", "url","devkey");
			testlink = new TestlinkBase(props.get("url"), props.get("devkey"));								
			ExecutionStatus newState = ExecutionStatus.PASSED;
			
			
			for (TestCase testcase: testlink.getTestcases()) {
				testcase.setExecutionStatus(newState);
				testlink.apiAddResult(testcase);
			}
			
			testlink.apiExecResults();
			Log.info("TESLINK: --> "+testlink.toString());
		} catch (Exception e) {								
			this.onErrorAtFinish(e);
		}	  
	}

	
	
	
	@Test(dataProvider="pathsDP")
	public void FileManagerTestPath(String path) throws PageException{
		try {				
			props = FileManager.readProperties(path, "url","devkey");
			Log.info("[WORKS]: " + props.toString());
		} catch (Exception e) {		
			Log.error(props.toString());
			this.onErrorAtFinish(e);			
		}		
	}
//	@Test()
//	public void Test_ws_1() throws PageException{
//		TestCase test = null;
//		ExecutionStatus status = null;
//		try {					
//			testlink.apiTestCase("wd-1");
//			test  = testlink.apiTestCase();
//			//------
//						
//			status = ExecutionStatus.PASSED; 
//						
//			//------			
//			//TODO: update testcases		
//			testlink.apiAddResult("wd-1", ExecutionStatus.PASSED);
//			System.out.println(testlink.toString());
//		  
//		} catch (Exception e) {								
//			this.onErrorAtFinish(e);
//		}
//		
//	}
}
