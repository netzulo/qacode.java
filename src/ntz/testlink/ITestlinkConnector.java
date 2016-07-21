package ntz.testlink;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import ntz.testlink.errors.ITestlinkErrorMessage;

public interface ITestlinkConnector extends ITestlinkErrorMessage {
	
	public static String DEVKEY = "token";
	public static String URL = "http://ip:port/lib/api/xmlrpc/v1/xmlrpc.php";
	
	
		 
	 void setCurrProject(int projectId) throws TestLinkAPIException;
	 void setCurrPlan(int planId) throws TestLinkAPIException;
	 void setCurrBuild(int buildId) throws TestLinkAPIException;
	 void getPlansByProyectId(int projectId) throws TestLinkAPIException;
	 void getBuildsByPlanId(int planId) throws TestLinkAPIException;
	 void getProjectsByALL() throws TestLinkAPIException;
	 void getTestCases(int planId, int buildId) throws TestLinkAPIException;
	 
	 void setTestCaseReport(ExecutionStatus status) throws TestLinkAPIException;
	 
	 
}