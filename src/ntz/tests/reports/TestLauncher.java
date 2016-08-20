package ntz.tests.reports;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;




/**
* @author netzulo.com
* @since 2016-07-25
* @version 0.5.4
* @update FIX 0.5.4_a
* @TODO: change addListener to load ITestNGListener classes instead of ITestListener
*/
public class TestLauncher {

	private TestNG testng;
	private HtmlReporter htmlReporter = new HtmlReporter();
	
	public TestNG getTestng() {
		return testng;
	}


	public TestLauncher(boolean defaultListeners) {
			
		testng = new TestNG(defaultListeners);
		
		if(!defaultListeners){
			testng.addListener(reporter());
			testng.addListener(listener());
		}
		else{
//			testng.addListener(new Reporter());
			testng.addListener(new TestListenerAdapter());
		}
	}
	
	public TestLauncher(boolean isCustomReporter,boolean isCustomListener) {

		if(!isCustomReporter && !isCustomListener){
			//ALL its FALSE
			testng = new TestNG(false);
		}
		else{
			testng = new TestNG(true);
			if(isCustomReporter){
				testng.addListener(reporter());
			}
			else{
				//DEFAULT REPORTERs
				testng.addListener(new Reporter());
			}
			if(isCustomListener){
				testng.addListener(listener());
			}
			else{
				//DEFAULT LISTENERs
				testng.addListener(new TestListenerAdapter());
			}
		}
	}
	
	
	public IReporter reporter(){
		return new IReporter(){

			@Override
			public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {				
				htmlReporter.generateReport(xmlSuites, suites, outputDirectory);				
			}			
		};
	}
	
	public ITestListener listener(){
		return new ITestListener(){
			@Override
			public void onStart(ITestContext arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFinish(ITestContext arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTestFailure(ITestResult arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTestSkipped(ITestResult arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTestStart(ITestResult arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTestSuccess(ITestResult arg0) {
				// TODO Auto-generated method stub
				
			}
		};
	}


	public void execTestPlan(Class[] testClasses, String outputDir) {
		testng.setTestClasses(testClasses);
		testng.setOutputDirectory(outputDir);
		testng.run();
		
	}
}
