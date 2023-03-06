package demo.test.runner;

import net.thucydides.core.util.EnvironmentVariables;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import io.cucumber.java.After;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.webdriver.RemoteDriver;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.steps.StepEventBus;

public class hooks extends PageObject{

	static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	
	@After
	public void tearDown() throws InvalidKeyException, NoSuchAlgorithmException {

		String v_environment = variables.getProperty("environment");
		System.out.println(v_environment);

		if (!v_environment.contains("local")) {
			TestOutcome outcome = StepEventBus.getEventBus().getBaseStepListener().getCurrentTestOutcome();
			System.out.println("SauceOnDemandSessionID="+RemoteDriver.of(getDriver()).getSessionId().toString()+ " job-name="+outcome.getCompleteName());
			
//			if(outcome.isSuccess()) {
//				appiumDriver().executeScript("sauce:job-result=passed");
//			}else {
//				sendEmail(outcome);
//				appiumDriver().executeScript("sauce:job-result=failed");
//			}
		}

	}
}
