import ntz.core.tests.PDashboardTest;
import ntz.core.tests.PLoginTest;
import ntz.tests.reports.TestLauncher;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class Main {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
//		args = new String[1];
//		args[0] = "sidemenu";	
		/////		
		TestLauncher launcher;
		Class[] testClasses;
		final String outputDir = System.getProperty("user.dir")+"/results";
		if(args.length > 0){
			//Load testPlan options
				
			launcher = new TestLauncher(true);	
			testClasses = getTestClasses(args);
			
			//Execs testPlan
			launcher.execTestPlan(testClasses, outputDir);
		}
		else{
			throw new Exception("Not testclases selected");
		}
		
	}

	
	/**
	 * Add new Options to your classes from here
	 * 
	 * TODO:Rewrite this method switch before to use ^^
	 * */
	@SuppressWarnings("rawtypes")
	private static Class[] getTestClasses(String[] args) throws Exception {
		Class[] testClasses = new Class[args.length];		
		for (int i = 0; i < args.length; i++) {
			  switch (args[i]) {
			case "login":
				testClasses[i] = PLoginTest.class;
				break;
			case "sidemenu":
				testClasses[i] = PDashboardTest.class;
				break;
			default:
				throw new Exception("Unkown TestClass name");
			}
		}		
		return testClasses;
	}
}
