package demo.main.step;

import java.util.List;
import java.util.Map;

import demo.main.page.AppHomePage;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;

public class StepAppoinment {

	@Steps
	private AppHomePage appHomePage;
	

	public void gotoHomePage() {
		appHomePage.init();
	}


	public void register_pet_appointment(DataTable dataAppoinment) {
		List<Map<String, String>> user = dataAppoinment.asMaps(String.class, String.class);
		String petName = user.get(0).get("petName");
		String ownerName = user.get(0).get("ownerName");
		String date = user.get(0).get("date");
		String time = user.get(0).get("time");
		String symptoms = user.get(0).get("symptoms");
		
		appHomePage.register_pet_appoinment(petName, ownerName, date, time, symptoms);
	}


	public boolean exists_register(DataTable dataAppoinment) {
		List<Map<String, String>> user = dataAppoinment.asMaps(String.class, String.class);
		String petName = user.get(0).get("petName");
		String ownerName = user.get(0).get("ownerName");
		String date = user.get(0).get("date");
		String time = user.get(0).get("time");
		String symptoms = user.get(0).get("symptoms");
		
		return appHomePage.validate_register(petName, ownerName, date, time, symptoms);

	}
	
	public boolean exists_register_duplicated(DataTable dataAppoinment) {
		List<Map<String, String>> user = dataAppoinment.asMaps(String.class, String.class);
		String petName = user.get(0).get("petName");
		String ownerName = user.get(0).get("ownerName");
		String date = user.get(0).get("date");
		String time = user.get(0).get("time");
		String symptoms = user.get(0).get("symptoms");
		
		return appHomePage.validate_register_duplicated(petName, ownerName, date, time, symptoms);

	}


	public void delete_pet_appoinment(DataTable dataAppoinment) {
		List<Map<String, String>> user = dataAppoinment.asMaps(String.class, String.class);
		String petName = user.get(0).get("petName");
		String ownerName = user.get(0).get("ownerName");
		String date = user.get(0).get("date");
		String time = user.get(0).get("time");
		String symptoms = user.get(0).get("symptoms");
		
		appHomePage.delete_pet_appoinment(petName, ownerName, date, time, symptoms);
	}
	
}
