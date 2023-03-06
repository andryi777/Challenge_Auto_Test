package demo.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;

@RunWith(RunPersonalizar.class)

//@CucumberOptions(features = { "src/test/resources/features/" }, tags = "@addAppointmentOutWrkHours", glue = { "demo" }, plugin = {
//		"pretty", "html:target/serenity-reports/serenity-html-report",
//		"json:target/serenity-reports/cucumber_report.json", "rerun:target/serenity-reports/rerun.txt" })

public class RunDemo {

	@RunBefore
	public static void previo() {
//		ExcelUtilPropio.getInstancia().escribirFeatures();
		System.out.println("ss");
				
//		EnvironmentVariables variables= SystemEnvironmentVariables.createEnvironmentVariables(); 
//
//		String v_user= EnvironmentSpecificConfiguration.from(variables).getProperty("saucelabs.username"); 
//		String v_pass= EnvironmentSpecificConfiguration.from(variables).getProperty("saucelabs.accessKey"); 
//
//		System.out.println(v_user+ " - "+v_pass); 
	}
}
