package ntz.testlink;

import java.util.List;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import br.eti.kinoshita.testlinkjavaapi.model.TestProject;
import br.eti.kinoshita.testlinkjavaapi.model.TestSuite;
import ntz.exceptions.TestlinkException;

/**
* @author netzulo.com
* @since 2016-08-05
* @version 0.5.7
*/
public interface ITestlink {	
	
	/***/
	boolean load(String url, String devKey) throws TestlinkException;
	/********************************************************************************/
	/***/
	boolean apiAddResult(TestCase testcase) throws TestlinkException;
	/***/
	boolean apiExecResults(String... proyectExtenalIds ) throws TestlinkException;
	/********************************************************************************/	
	/***/
	void loadTestCasesByIds(String[] externalids);
	/***/
	void loadTestCases();
	/***/
	void loadTestSuitesBySuite();
	/***/
	void loadTestSuitesByPlan();
	/***/
	void loadbuildsByProject();	
	/***/
	void loadTestPlansByProject();
	/***/
	void loadProjects();
	/***/
	TestCase getTestCaseByExtId(String externadId);
	/***/ 
	void loadCurrPlatform();
	/********************************************************************************/
	/***/
	List<TestCase> getTestcases();
	/***/
	List<TestSuite> getTestSuites();
	/***/
	List<Build> getBuilds();
	/***/
	List<TestPlan> getTestPlans();
	/***/
	List<TestProject> getTestProjects();
	/***/
	TestLinkAPI getApi();
	
	
	
}