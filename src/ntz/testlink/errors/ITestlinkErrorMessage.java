package ntz.testlink.errors;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public interface ITestlinkErrorMessage {

	final String ERROR_notLoadProyects = "[TESTLINK][Error]: at find proyects on testlink";
	
	final String ERROR_notSetProyectByID = "[TESTLINK][Error]: at select proyect by ID";
	
	final String ERRROR_notSetPlanByID = "[TESTLINK][Error]: at select plan by ID";
	
	final String ERROR_notSetBuildByID = "[TESTLINK][Error]: at select build by ID";
	
	final String ERROR_plansByProyectID = "[TESTLINK][Error]: at get plans by proyect ID";
	
	final String ERROR_buildsByPlanID = "[TESTLINK][Error]: at get builds by plan ID";

	final String ERROR_proyects = "[TESTLINK][Error]: at get ALL proyects";
}
