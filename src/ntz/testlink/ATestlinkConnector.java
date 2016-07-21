package ntz.testlink;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionType;
import br.eti.kinoshita.testlinkjavaapi.constants.TestCaseDetails;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import br.eti.kinoshita.testlinkjavaapi.model.TestProject;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

public class ATestlinkConnector implements ITestlinkConnector {

	public TestLinkAPI api;	
	/**TESTLINK API fields**/
	public TestProject[] testProjects;
	public TestPlan[] testPlans;	
	public Build[] builds;
	public TestCase[] testCases;
	
	public TestProject currProject;
	public TestPlan currPlan;	
	public Build currBuild;
	public TestCase currTestCase;
	
	public ATestlinkConnector() throws MalformedURLException, TestLinkAPIException{		
		this.api=new TestLinkAPI(new java.net.URL(URL), DEVKEY);
		
		try {
			this.testProjects = api.getProjects();			
		} catch (Exception e) {
			throw new TestLinkAPIException(ERROR_notLoadProyects);
		}
	}
	
	@Override
	public void setCurrProject(int projectId) throws TestLinkAPIException {
		
		try {
			for (TestProject project : this.testProjects) {
				if(project.getId() == projectId){
					this.currProject = project;
				}
			}
		} catch (Exception e) {	throw new TestLinkAPIException(ERROR_notSetProyectByID); }
		
	}
	@Override
	public void setCurrPlan(int planId) throws TestLinkAPIException {
		
		try {
			for (TestPlan plan : this.testPlans) {
				if(plan.getId() == planId){
					this.currPlan = plan;
				}
			}	
		} catch (Exception e) {	throw new TestLinkAPIException(ERRROR_notSetPlanByID); }	
		
	}
	@Override
	public void setCurrBuild(int buildId) throws TestLinkAPIException {
		
		try {
			for (Build build : this.builds) {
				if(build.getId() == buildId){
					this.currBuild = build;
				}
			}	
		} catch (Exception e) {	throw new TestLinkAPIException(ERROR_notSetBuildByID); }		
	}
	
	@Override
	public void getPlansByProyectId(int projectId) throws TestLinkAPIException{
		try {
			this.testPlans = api.getProjectTestPlans(projectId);
		} catch (Exception e) {	throw new TestLinkAPIException(ERROR_plansByProyectID); }
	}
	@Override
	public void getBuildsByPlanId(int planId) throws TestLinkAPIException{
		try {
			this.builds = api.getBuildsForTestPlan(planId);
		} catch (Exception e) {	throw new TestLinkAPIException(ERROR_buildsByPlanID); }
	}
	@Override
	public void getProjectsByALL() throws TestLinkAPIException{
		try {
			this.testProjects = api.getProjects();
		} catch (Exception e) {	throw new TestLinkAPIException(ERROR_proyects); }
	}
	@Override
	public void getTestCases(int planId, int buildId) throws TestLinkAPIException{
		
		TestCaseDetails details = TestCaseDetails.FULL;
		//ExecutionStatus status = ExecutionStatus.NOT_RUN;
		ExecutionType exec = ExecutionType.AUTOMATED; 
		
		this.testCases = this.api.getTestCasesForTestPlan(
				planId,
				new ArrayList<Integer>(),
				buildId,
				new ArrayList<Integer>(),
				"",
				false,//EXECUTED
				new ArrayList<Integer>(),//assigned to
				null,
				exec,
				true,
				details
			);
				
				
//				(
//				planId,
//				new ArrayList<Integer>(),
//				buildId,
//				new ArrayList<Integer>(),
//				"",
//				false,
//				new ArrayList<Integer>(),
//				ExecutionStatus.PASSED.name(),
//				ExecutionType.AUTOMATED, 
//				false // Get step info
//			);
	}
	
	@Override
	public void setTestCaseReport(ExecutionStatus status) throws TestLinkAPIException{
		
		try {
			//TODO: I+D
			//this.api.reportTCResult();
		} catch (TestLinkAPIException e) {
			throw new TestLinkAPIException();
		}
	}
		
	@Override
	public String toString(){		
		return "TestlinkConnector [api=" + api + ", testProjects=" + Arrays.toString(testProjects) + ", testPlans="
				+ Arrays.toString(testPlans) + ", builds=" + Arrays.toString(builds) + ", testCases="
				+ Arrays.toString(testCases) + ", currProject=" + currProject + ", currPlan=" + currPlan
				+ ", currBuild=" + currBuild + ", currTestCase=" + currTestCase + "]";
	}
}
