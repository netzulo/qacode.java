package ntz.tests.reports;
/**
* @author netzulo.com
* @since 2013-01-1
* @version 0.5.1
*/
public interface IReportTemplateHtml5 {
		
		/***********************HTML TEMPLATE********************************************************/
		public final static String start_Html = "<!DOCTYPE><html lang=\"es\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>ntzTrandasha Test driven</title><!--JQUERY--><script src=\"https://code.jquery.com/jquery-1.11.3.min.js\"></script><!--BOOSTRAP--><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\"><!--Propios--><link rel=\"stylesheet\" href=\"../../../css/tmpl.css\"><script src=\"../../../js/tmpl.js\"></script><script src=\"../../../js/Ntzeffects.js\"></script></head><body class=\"bg\"><header id=\"mainHeader\"><figure id=\"logo\"><img src=\"../../../img/logo.jpg\" alt=\"\"></figure></header><nav id=\"mainMenu\"><ul class=\"nav nav-tabs nav-justified\"><li><a href=\"../../../index.html\">Inicio</a></li><li><a href=\"../../../reports.php\">Reports</a></li><li><a href=\"../../../upload-report.html\">Upload report</a></li></ul></nav><section id=\"mainSection\">";
		
		public final static String start_SideMenu = "<nav id=\"sideMenu\" class=\"col-lg-2 col-md-2 col-sm-2 col-xs-2\"><ul>";
		public final static String item_SideMenu = "<li><div class=\"suites total\"> Suites ejecutadas: VAR INSIDE LI</div></li>";
		public final static String end_SideMenu = "</ul></nav>";
		
		public final static String start_MainContent = "<div id=\"mainContent\" class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">";
			public final static String write_suiteNames = "";
				//Tests
				public final static String write_TestNames = "";
				
				public final static String write_MainContentTests_Start_1 = "";
				
				//Al mismo tiempo for() testFaileds, testPasseds y testsSkipped
				public final static String write_MainContent_TestFail_2 = "";
				public final static String write_MainContent_TestPass_2 = "";
				public final static String write_MainContent_TestSkip_2 = "";
							
				public final static String write_MainContentTests_Finish_3 = "";
			
				//end for() tests y suites
				
			public final static String end_MainContent = "";
			
		public final static String end_Html = "</section><footer id=\"mainFooter\"></footer></body></html>";
		
		/********************************************************************************************/

		/**/
		public final static String start_spanIconFailed = "<span class=\"glyphicon glyphicon-remove-sign\" >";
		public final static String start_spanIconPassed = "<span class=\"glyphicon glyphicon-ok-sign\" >";
		public final static String start_spanIconSkipped = "<span class=\"glyphicon glyphicon-info-sign\" >";
		public final static String start_spanIconWarning = "<span class=\"glyphicon glyphicon-warning-sign\" >";	
		public final static String start_spanTestName = "<span class=\"testName\" >";
		public final static String end_span = "</span>";
		public final static String start_pTestArgs = "<p class=\"testArgs\" >";
		public final static String start_pTestDesc = "<p class=\"testDesc\" >";
		public final static String start_pTestErrorDesc = "<p class=\"testErrorDesc stepDesc alert alert-warning\" >";
		public final static String start_pTestTotalTime = "<p class=\"testTotalTime\" >";
		public final static String end_p = "</p>";
		public final static String end_Div = "</div>";
		public static final String start_pStepTitle = "<p class=\"stepDesc\"><span class=\"stepTitle glyphicon glyphicon-check\">";
		public static final String middle_pStepDesc  = "</span>: ";			
		//</p>
		/***/
		/***********************TESTs TEMPLATE*******************************************************/
		public final static String start_DivAllSuites ="<div class=\"suites alert-info\">";
		
		public final static String start_DivSuite = "<div class=\"suite alert-info\">";
		
		public final static String start_DivTest = "<div class=\"test alert-info\">";

		public final static String start_DivTestAllFailed = "<div class=\"allFailed col-lg-4 alert-danger\"><span class=\"glyphicon glyphicon-align-left\" ></span>";
		
		public final static String start_DivTestAllPassed = "<div class=\"allPassed col-lg-4 alert-success\"><span class=\"glyphicon glyphicon-ok\" ></span>";

		public final static String start_DivTestAllSkipped = "<div class=\"allSkipped col-lg-4 alert-warning\"><span class=\"glyphicon glyphicon-align-left\" ></span>";

		public final static String start_DivTestResult = "<div class=\"test testResult alert-info\">";

		public final static String start_DivTestFailed = "<div class=\"test testFailed alert-danger\">"+start_spanIconFailed + end_span;
		
		public final static String start_DivTestPassed = "<div class=\"test testPassed alert-success\">"+start_spanIconPassed + end_span;
		
		public final static String start_DivTestSkipped = "<div class=\"test testSkipped alert-warning\">"+start_spanIconSkipped + end_span;

}
