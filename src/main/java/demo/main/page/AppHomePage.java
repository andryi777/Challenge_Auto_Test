package demo.main.page;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import demo.main.util.PageObjectUtil;
import demo.main.util.Variables;
import demo.main.xpath.XPathHomePage;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.webdriver.RemoteDriver;

public class AppHomePage extends PageObject {

	
	private long wdwTimeOut = 300L;
	
	// xpath
	protected XPathHomePage xpathHomePage = XPathHomePage.getInstancia();

	// util
	protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();

	public long getWdwTimeOut() {
		return wdwTimeOut;
	}

	public void init() {
		RemoteDriver.of(getDriver()).navigate().to("http://localhost:3000/");
		RemoteDriver.of(getDriver()).manage().deleteAllCookies();
		RemoteDriver.of(getDriver()).manage().window().maximize();
		RemoteDriver.of(getDriver()).manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		
		Serenity.takeScreenshot();
	}

	public void register_pet_appoinment(String petName, String ownerName, String date, String time, String symptoms) {
		pageObjectUtil.seleniumWrite(getDriver(), xpathHomePage.txtPetName, 0, petName);
		pageObjectUtil.seleniumWrite(getDriver(), xpathHomePage.txtOwnerName, 0, ownerName);
		pageObjectUtil.seleniumWrite(getDriver(), xpathHomePage.txtDate, 0, date);
		pageObjectUtil.seleniumWrite(getDriver(), xpathHomePage.txtTime, 0, time);
		pageObjectUtil.seleniumWrite(getDriver(), xpathHomePage.txtSymptoms, 0, symptoms);
		
		Serenity.takeScreenshot();
		pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.btnAddAppoinment, 0);
		
		Serenity.takeScreenshot();
	}


	public boolean validate_register(String petName, String ownerName, String date, String time, String symptoms) {
		boolean flag = false;
		List<WebElement> appElements = getDriver().findElements(By.xpath("//*[@data-testid='appointment']"));
		
		System.out.println("appElements.size(): "+appElements.size());
		String startDateString = date;
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    date=LocalDate.parse(startDateString, formatter).format(formatter2);
	    
		for(int iter=1; iter<=appElements.size(); iter++) {
		    
		    if(xpathHomePage.lblPetName(iter).getText().compareTo(petName)==0 
		    		&& xpathHomePage.lblOwnerName(iter).getText().compareTo(ownerName)==0
		    		&& xpathHomePage.lblDate(iter).getText().compareTo(date)==0
		    		&& xpathHomePage.lblTime(iter).getText().compareTo(time)==0
		    		&& xpathHomePage.lblSyptoms(iter).getText().compareTo(symptoms)==0
		    	) {
		    	Variables.nodeList.add(petName);
		    	Variables.nodeList.add(ownerName);
		    	Variables.nodeList.add(date);
		    	Variables.nodeList.add(time);
		    	Variables.nodeList.add(symptoms);
				
		    	Variables.rootList.add(Variables.nodeList);
		    
				flag=true;
		    }	
			else{
				flag=false;
				continue;
			}
		    
		}
		
		return flag;
	}
	
	
	public boolean validate_register_duplicated(String petName, String ownerName, String date, String time, String symptoms) {
		
		validate_register(petName, ownerName, date, time, symptoms);
		
		boolean flag_register_duplicated = false;

		ArrayList<String> time_inicio = new ArrayList<String>();
		ArrayList<String> time_duplicated = new ArrayList<String>();
		ArrayList<String> date_duplicated = new ArrayList<String>();

		for (int i = 0; i < Variables.rootList.size(); i++) {
//			for(int j=0; j<Variables.rootList.get(i).size(); j++) {
//				System.out.println("i = "+i+", j= "+j + "-" + Variables.rootList.get(i).get(j));
//			}
			time_inicio.add(Variables.rootList.get(i).get(2).toString());
		}

		Set<String> miSet = new HashSet<String>(time_inicio);
		for (String v_time : miSet) {
			if (Collections.frequency(time_inicio, v_time) > 1) {
				time_duplicated.add(v_time);
			}
		}

		for (int indexRows = 0; indexRows < time_duplicated.size(); indexRows++) {
			for (int indexRootList = 0; indexRootList < Variables.rootList.size(); indexRootList++) {
				if (time_duplicated.get(indexRows).compareTo(Variables.rootList.get(indexRootList).get(2)) == 0) {
					date_duplicated.add(Variables.rootList.get(indexRootList).get(0));
				}
			}
			Set<String> set_dateDuplicated = new HashSet<String>(date_duplicated);
			for (String job : set_dateDuplicated) {
				if (Collections.frequency(date_duplicated, job) > 1) {
					System.out.println("Result: YES, There are appointments duplicated");
					flag_register_duplicated = true;
				}
			}
			set_dateDuplicated.clear();
		}
				
		if (!flag_register_duplicated) System.out.println("Result: There are no appointments duplicated");
		
		return flag_register_duplicated;
		
	}

	public void delete_pet_appoinment(String petName, String ownerName, String date, String time, String symptoms) {
		List<WebElement> appElements = getDriver().findElements(By.xpath("//*[@data-testid='appointment']"));
		
		System.out.println("appElements.size(): "+appElements.size());
		String startDateString = date;
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    date=LocalDate.parse(startDateString, formatter).format(formatter2);
	    
		for(int iter=1; iter<=appElements.size(); iter++) {
		    
		    if(xpathHomePage.lblPetName(iter).getText().compareTo(petName)==0 
		    		&& xpathHomePage.lblOwnerName(iter).getText().compareTo(ownerName)==0
		    		&& xpathHomePage.lblDate(iter).getText().compareTo(date)==0
		    		&& xpathHomePage.lblTime(iter).getText().compareTo(time)==0
		    		&& xpathHomePage.lblSyptoms(iter).getText().compareTo(symptoms)==0
		    	) {
		    	pageObjectUtil.seleniumClick(getDriver(), xpathHomePage.btnDeleteAppoinment(iter), 0);
		    }	
		    
		}
		Serenity.takeScreenshot();
	}

}