package ntz.testlink;

import br.eti.kinoshita.testlinkjavaapi.model.TestProject;
import ntz.exceptions.TestlinkException;
import ntz.testlink.errors.ITestlinkErrorMessage;

/***
 * 
 **/
public interface ITestlink extends ITestlinkErrorMessage {
	
	static String testlink_URL = "http://IP:PORT/lib/api/xmlrpc/v1/xmlrpc.php";
	static String testlink_DEVKEY = "token";	
	
	/***/
	boolean load(String url, String devKey) throws TestlinkException;	
	/***/
	TestProject[] getAllTestCases() throws TestlinkException;
	
}