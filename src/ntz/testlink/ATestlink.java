package ntz.testlink;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.constants.TestCaseDetails;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.Platform;
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
public abstract class ATestlink implements ITestlink {

	/***/
	public TestLinkAPI api = null;
	
	/***/
	private List<TestProject> testProjects = null;
	/***/
	private List<TestPlan> testPlans = null;
	/***/
	private List<Build> builds = null;
	/***/
	private List<TestSuite> testSuites = null;
	/***/
	private List<TestCase> testcases = null;
		
	/********************************************************************************/
	/***/
	private List<TestCase> executedTestcases = new ArrayList<>();
	/***/
	private TestProject currProject = null;	
	/***/
	private TestPlan currPlan = null;	
	/***/
	private Build currBuild = null;	
	/***/
	private Platform currPlatform = null;	
	/********************************************************************************/
	/***/
	public ATestlink() throws TestlinkException{		
		throw new TestlinkException("[ATestlink][ERROR]: Constructor not allowed");
	}
	
	/***/
	public ATestlink(String url, String devKey) throws TestlinkException{
		if(url.length() < 0 && devKey.length() < 0){throw new TestlinkException("[ATestlink][ERROR]: Bad url or developer key");}
		else{
			if(!load(url,devKey)){
				throw new TestlinkException();
			}
		}
			
	}
	
	/**
	 * 
	 * @example: URL --> http://IP:PORT/lib/api/xmlrpc/v1/xmlrpc.php
	 * */
	@Override
	public boolean load(String url, String devKey) throws TestlinkException{
		boolean isLoaded = false;
		try {		
			///Init list
			testProjects = new ArrayList<>();
			testPlans = new ArrayList<>();
			builds = new ArrayList<>();
			testSuites = new ArrayList<>();
			testcases = new ArrayList<>();
			
			
			this.api = new TestLinkAPI(new URL(url),devKey);			
			/// Load properties
			if(this.api == null){}
			else{
				/////Retrieve all testlink information
				//GET proyects				
				loadProjects();
				//GET testplans
				loadTestPlansByProject();
				//GET builds
				loadbuildsByProject();					
				//GET testSuites
				loadTestSuitesByPlan();
				loadTestSuitesBySuite();
				//GET testCases
				loadTestCases();								
				
				/////SETs currents
				this.currProject = this.testProjects.get(0);
				this.currPlan = this.testPlans.get(0);
				this.currBuild = this.builds.get(0);
				loadCurrPlatform();
				isLoaded = true;
			}
		} catch (Exception e) {
			isLoaded = false;
			throw new TestlinkException("[ATestlink][ERROR]: at try to instance testlinkAPI");			
		}
		return isLoaded;
	}	
	

	@Override
	public void loadCurrPlatform() {
		this.currPlatform = this.api.getTestPlanPlatforms(this.currPlan.getId())[0];		
	}

	/********************************************************************************/
	
	@Override
	public void loadProjects(){
		//GET testProjects
		this.testProjects = Arrays.asList(this.api.getProjects());
	}

	
	
	@Override
	public void loadTestPlansByProject(){
		//GET testPlans
		for (TestProject testProject : testProjects) {
			TestPlan[] _testplans = this.api.getProjectTestPlans(testProject.getId());
			for (int i = 0; i < _testplans.length; i++) {
				this.testPlans.add(_testplans[i]);
			}
		}
	}
	
	@Override
	public void loadbuildsByProject(){
		//GET testcases
		for (int i = 0; i < this.testPlans.size(); i++) {
			Build[] _builds = this.api.getBuildsForTestPlan(testPlans.get(i).getId());
			for (int j = 0; j < _builds.length; j++) {
				this.builds.add(_builds[j]);
			}
		}
	}
	
	@Override
	public void loadTestSuitesByPlan(){
		//GET testcases
		for (int i = 0; i < this.testPlans.size(); i++) {
			TestSuite[] _testSuites = this.api.getTestSuitesForTestPlan(testPlans.get(i).getId());
			for (int j = 0; j < _testSuites.length; j++) {
				this.testSuites.add(_testSuites[j]);
			}
		}
	}
	
	@Override
	public void loadTestSuitesBySuite(){
		//GET testcases
		for (int i = 0; i < this.testSuites.size(); i++) {
			TestSuite[] _moreTestSuites = this.api.getTestSuitesForTestSuite(this.testSuites.get(i).getId());
			for (int j = 0; j < _moreTestSuites.length; j++) {
				this.testSuites.add(_moreTestSuites[j]);
			}
		}
	}
	
	@Override
	public void loadTestCases(){
		//GET testcases
		for (int i = 0; i < this.testSuites.size(); i++) {
			TestCase[] _testCases = this.api.getTestCasesForTestSuite(this.testSuites.get(i).getId(), true, TestCaseDetails.FULL);
			for (int j = 0; j < _testCases.length; j++) {			
				this.testcases.add(_testCases[j]);
			}
		}
	}
	@Override
	public void loadTestCasesByIds(String[] externalids) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public TestCase getTestCaseByExtId(String externadId) {
		TestCase foundTestCase = null;
		for (TestCase testcase : testcases) {
			if(testcase.getFullExternalId().contains(externadId)){
				foundTestCase  = testcase;
			}
		}
		return foundTestCase;		
	}
	

	@Override
	public boolean apiAddResult(TestCase testcase) throws TestlinkException {
		boolean isAdded = false;		
		try {			
			executedTestcases.add(testcase);			
			isAdded = true;
		} catch (Exception e) {
			throw new TestlinkException(e);
		}
		return isAdded;
	}

	@Override
	public boolean apiExecResults(String... proyectExtenalIds) throws TestlinkException {
		boolean isUpdated = false;
		try {
	 		for (TestCase testcase : executedTestcases) {
				
				 int testCaseId = testcase.getId();
				 int testCaseExternalId = testcase.getId();//testcase.getInternalId();
				 int testPlanId = this.currPlan.getId();
				 ExecutionStatus status = testcase.getExecutionStatus();
				 int buildId = this.currBuild.getId();
				 String buildName = this.currBuild.getName();
				 String notes = this.currBuild.getNotes();
				 Boolean guess = new Boolean(false);
				 String bugId = "bug-"+testcase.getId();
				 int platformId = this.currPlatform.getId();
				 String platformName = this.currPlatform.getName(); 
				 Hashtable<String,String> customFields = new Hashtable<String,String>(); 
				 boolean overwrite = true;			
				/**
				 * @method_info: this.api.reportTCResult
				 * testCaseId,
				 * testCaseExternalId,
				 * testPlanId,
				 * status,
				 * buildId,
				 * buildName,
				 * notes,
				 * guess,
				 * bugId, 
				 * platformId, 
				 * platformName, 
				 * customFields, 
				 * overwrite
				 **/			
				this.api.reportTCResult(
						testCaseId,
						testCaseExternalId,
						testPlanId,
						status,
						buildId,
						buildName,
						notes,
						guess,
						bugId,
						platformId,
						platformName,
						customFields,
						overwrite);
				
			}
		} catch (Exception e) {
			throw new TestlinkException();
		}
 		isUpdated = true;
		return isUpdated;
	}
	/********************************************************************************/
	
	@Override
	public TestLinkAPI getApi() {
		return api;
	}
	@Override
	public List<TestProject> getTestProjects() {
		return testProjects;
	}
	@Override
	public List<TestPlan> getTestPlans() {
		return testPlans;
	}
	@Override
	public List<Build> getBuilds() {
		return builds;
	}
	@Override
	public List<TestSuite> getTestSuites() {
		return testSuites;
	}
	@Override
	public List<TestCase> getTestcases() {
		return testcases;
	}

	public TestProject getCurrProject() {
		return currProject;
	}
	
}
