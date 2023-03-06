package demo.test.definition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import demo.main.step.StepAppoinment;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DefAppointment {
	
	@Steps
	StepAppoinment stepAppoinment;

	@Given("I enter to the main page")
	public void i_enter_to_the_main_page() {
		stepAppoinment.gotoHomePage();
	}

	@When("register a new appoinment")
	public void register_a_new_appoinment(DataTable dataAppoinment) {
		stepAppoinment.register_pet_appointment(dataAppoinment);
	}
	
	@When("register again the same appoinment")
	public void register_again_the_same_appoinment(DataTable dataAppoinment) {
		stepAppoinment.register_pet_appointment(dataAppoinment);
	}

	@Then("it should appear the new register on the right")
	public void it_should_appear_the_new_register_on_the_right(DataTable dataAppoinment) {
		assertTrue(stepAppoinment.exists_register(dataAppoinment));
	}

	@Then("it should not allow registering a duplicated record")
	public void it_should_not_allow_registering_a_duplicated_record(DataTable dataAppoinment) {
		assertFalse(stepAppoinment.exists_register_duplicated(dataAppoinment));
	}
	
	@Then("it should not appear the new register on the right")
	public void it_should_not_appear_the_new_register_on_the_right(DataTable dataAppoinment) {
		assertFalse(stepAppoinment.exists_register(dataAppoinment));
	}

	@When("delete an appoinment")
	public void delete_an_appoinment(DataTable dataAppoinment) {
		stepAppoinment.delete_pet_appoinment(dataAppoinment);
	}

	@Then("it should dissapear the register on the right")
	public void it_should_dissapear_the_register_on_the_right(DataTable dataAppoinment) {
		assertFalse(stepAppoinment.exists_register(dataAppoinment));
	}
	
}
