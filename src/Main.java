import ntz.app.TrandashaTest;
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
		
		if(args.length > 0){
			//Load testPlan options
			String outputDir = "/results";
			TestLauncher launcher = new TestLauncher(true);
			Class[] testClasses = getTestClasses(args);
			
			//Execs testPlan
			launcher.getTestng().setTestClasses(testClasses);
			launcher.getTestng().setOutputDirectory(outputDir);
			launcher.getTestng().run();
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
	private static Class[] getTestClasses(String[] args) throws Exception {
		Class[] testClasses = new Class[args.length];		
		for (int i = 0; i < args.length; i++) {
			  switch (args[i]) {
			case "login":
				testClasses[i] = PLoginTest.class;
				break;
			default:
				throw new Exception("Unkown TestClass name");
			}
		}		
		return testClasses;
	}
}
