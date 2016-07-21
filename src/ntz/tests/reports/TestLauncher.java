package ntz.tests.reports;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class TestLauncher {

	private TestNG testng;
	
	public TestNG getTestng() {
		return testng;
	}


	public TestLauncher(boolean defaultListeners) {
			
		testng = new TestNG(defaultListeners);				
		if(!defaultListeners){
			testng.addListener(reporter());
			testng.addListener(listener());
		}
	}
	
	
	public IReporter reporter(){
		return new IReporter(){

			@Override
			public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String arg2) {
				// TODO Auto-generated method stub
				
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
}
