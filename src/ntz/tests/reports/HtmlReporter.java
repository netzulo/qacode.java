package ntz.tests.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class HtmlReporter implements IReporter, IReportTemplateHtml5 {
	private PrintWriter reportWriter;

	/********************************************************************************************/	
	/*SUITEs args*/
	@SuppressWarnings("unused")
	private List<ISuite> suites;
	private Map<String, ISuiteResult> suiteResults;
	private ISuiteResult suiteResult;	
	
	/********************************************************************************************/	
	/*TESTs VARs*/	
	private ITestContext testContext; 	
	//FAILED
	private IResultMap failedResult;
	private Set<ITestResult> testsFailed;	
	//PASSED
	private IResultMap passResult;
	private Set<ITestResult> testsPassed;
	//SKIPPED
	private IResultMap skippedResult;
	private Set<ITestResult> testsSkipped;
	
	/********************************************************************************************/	
	
	/**
	 * @author ntz
	 * ejecutar el siguiente metodo antes de empezar --> confHtmlPrinter 
	 * 
	 * */
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,String outputDirectory) {
		try {
			new File(outputDirectory).mkdirs();
			this.confHtmlPrinter(outputDirectory);
			//INIT---
			this.suites = suites;
							
			for (ISuite suite : suites) {
//				String suiteName = "Suite nombre: "+suite.getName();
				suiteResults = suite.getResults();
				

				for (String testName : suiteResults.keySet()) {										
					//SUITES
					suiteResult = suiteResults.get(testName);				
					testContext = suiteResult.getTestContext();	
					
					//FAILED
					failedResult = testContext.getFailedTests();				
					testsFailed = failedResult.getAllResults();
					
					//PASSED
					passResult = testContext.getPassedTests();				
					testsPassed = passResult.getAllResults();
					
					//SKIPPED
					skippedResult = testContext.getSkippedTests();				
					testsSkipped = skippedResult.getAllResults();

				}//for testname
			}//for suite
			
			confPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			reportWriter.flush();
			reportWriter.close();
		}
	}

	/**
	 * Se ejecuta antes de startHtml para asegurar la ejecucion del PrinterHTML
	 * */
	private void confHtmlPrinter(String outputDirectory) {
		Date fecha = new Date();
		SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");				
		String fileName = "testing-report-web_"+fechaFormato.format(fecha)+".html";
		
		try {
			reportWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(outputDirectory, fileName))));
		} catch (IOException e) {
			System.out.println("Error in creating writer: " + e);
		}		
	}
	
	
	private void confPage(){
		
		
		this.reportWriter.write(start_Html);
		
//			this.reportWriter.write(HtmlText.start_SideMenu);
//			this.reportWriter.write(HtmlText.item_SideMenu);
//			this.reportWriter.write(HtmlText.end_SideMenu);
		
			this.reportWriter.write(start_MainContent);											
				this.reportWriter.write(start_DivTestAllFailed +"Test fallidos: "+this.testsFailed.size()+ end_Div );
				this.reportWriter.write(start_DivTestAllPassed +"Test Pasados: "+this.testsPassed.size()+ end_Div );
				this.reportWriter.write(start_DivTestAllSkipped +"Test bloqueados: "+this.testsSkipped.size()+ end_Div );
				/*TESTs*/
				confPageTests(0, testsFailed);
				confPageTests(1, testsPassed);
				confPageTests(2, testsSkipped);
			this.reportWriter.write(end_MainContent);
					
		this.reportWriter.write(end_Html);
	}

	@SuppressWarnings("unused")
	private void confPageTests(int i, Set<ITestResult> _tests) {
		for ( ITestResult testResult : _tests) {
			String _attrs = "";
			String _name = "";
			String _testName = "";
			String _statusNum = "";
			String _descripcion = "";
			String _methodName = "";			
			String _instanceName = "";
			String _throwMessage = "";
			Throwable exp = null;
			//---
			try { _attrs = (testResult.getAttributeNames().size() > 0)? testResult.getAttributeNames().toString(): ""; }
			catch (Exception e) {}
			try { _name = testResult.getName().replace('_', ' '); }
			catch (Exception e) {}
//			try { _testName = testResult.getTestName(); }
//			catch (Exception e) {}
			try { _statusNum = testResult.getStatus()+""; }
			catch (Exception e) {}			
			try { _descripcion = (testResult.getMethod().getDescription().length() > 0 )? testResult.getMethod().getDescription() : ""; }
			catch (Exception e) {}
			try { _methodName = testResult.getMethod().getMethodName();}
			catch (Exception e) {}
			try { _instanceName = testResult.getInstanceName(); }
			catch (Exception e) {}			
			try { exp = testResult.getThrowable(); }
			catch (Exception e) {}
			
			try {
				//Se añaden clases css ya que son necesarias solo al descubrir que ese paso es el que ha provocado el error				
				String message = testResult.getThrowable().getMessage();	
				
				if(message.contains("\n")){
					message = new StringBuilder(message).delete(0, 1).toString();
				}
				
				if(i == 0){
					message = new StringBuilder(message).insert(18, " alert alert-warning").toString();				
					message = new StringBuilder(message).delete(83, 89).toString();
					message = new StringBuilder(message).insert(83, "exclamation-sign\"").toString();
				}
				if(i == 1){
					message = new StringBuilder(message).insert(18, " alert alert-info").toString();				
					message = new StringBuilder(message).delete(80, 85).toString();
					//message = new StringBuilder(message).insert(80, "exclamation-sign").toString();
				}
				_throwMessage = (testResult.getThrowable() != null)? message : ""; }
			catch (Exception e) {}		
			//---
			if(i == 0) {				
				this.reportWriter.write(start_DivTestFailed);
//				switch (exp.getMessage()) {				
//				case ITestText.error_assert:
//					this.reportWriter.write(HtmlText.start_DivTestSkipped);
//					break;
//				default:
//					this.reportWriter.write(HtmlText.start_DivTestFailed);
//					break;
//				}
			}
			
			if(i == 1) this.reportWriter.write(start_DivTestPassed);
			if(i == 2) this.reportWriter.write(start_DivTestSkipped);//modified 17-06-2013, 2.51
			
			//Marca como skip ciertos test fallidos
//			if(i == 0){
//				int testState = testResult.getStatus();
//				
//				testResult.setStatus(1);
//			}
			
			this.reportWriter.write(start_spanTestName+_name+end_span);			
			this.reportWriter.write(start_pTestArgs+_attrs+end_p);
			this.reportWriter.write(start_pTestDesc+_descripcion+end_p);
			//if(i == 0 ) this.reportWriter.write(HtmlText.start_pTestErrorDesc+HtmlText.start_spanIconWarning+HtmlText.end_span+_throwMessage+HtmlText.end_p);
			//if(i == 0 )
			this.reportWriter.write(_throwMessage);
			
			this.reportWriter.write(end_Div);
		}
		
	}
	
	
	
	
	
	
}