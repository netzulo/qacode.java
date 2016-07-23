import ntz.app.TrandashaTest;
import ntz.tests.reports.TestLauncher;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public class Main {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		String outputDir = "/results";
		TestLauncher launcher = new TestLauncher(true);
		Class[] testClasses = new Class[]{
				TrandashaTest.class
		};
		
		//Execs testPlan
		launcher.getTestng().setTestClasses(testClasses);
		launcher.getTestng().setOutputDirectory(outputDir);
		launcher.getTestng().run();
		
	}
}
