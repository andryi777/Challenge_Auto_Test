package demo.main.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;

public class XPathHomePage extends PageObject{

	private static XPathHomePage obj = null;

	public static XPathHomePage getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new XPathHomePage();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public final String txtPetName="//input[@name='pet']";
	public final String txtOwnerName="//input[@name='owner']";
	public final String txtDate="//input[@name='date']";
	public final String txtTime="//input[@name='time']";
	public final String txtSymptoms="//textarea[@name='symptoms']";
	public final String btnAddAppoinment="//button[@data-testid='btn-submit']";
	
	public WebElement lblPetName(int iterator) {
		WebElement we = getDriver().findElement(By.xpath("//*[@data-testid='appointment']["+iterator+"]/p[contains(text(),'Pet')]//following-sibling::span[1]"));
		return we;
	};
	public WebElement lblOwnerName(int iterator) {
		WebElement we = getDriver().findElement(By.xpath("//*[@data-testid='appointment']["+iterator+"]/p[contains(text(),'Owner')]//following-sibling::span[1]"));
		return we;
	};
	public WebElement lblDate(int iterator) {
		WebElement we = getDriver().findElement(By.xpath("//*[@data-testid='appointment']["+iterator+"]/p[contains(text(),'Date')]//following-sibling::span[1]"));
		return we;
	};
	public WebElement lblTime(int iterator) {
		WebElement we = getDriver().findElement(By.xpath("//*[@data-testid='appointment']["+iterator+"]/p[contains(text(),'Time')]//following-sibling::span[1]"));
		return we;
	};
	public WebElement lblSyptoms(int iterator) {
		WebElement we = getDriver().findElement(By.xpath("//*[@data-testid='appointment']["+iterator+"]/p[contains(text(),'Symptoms')]//following-sibling::span[1]"));
		return we;
	};
	public WebElement btnDeleteAppoinment(int iterator) {
		WebElement we = getDriver().findElement(By.xpath("//*[@data-testid='appointment']["+iterator+"]/button[@data-testid='btn-delete']"));
		return we;
	};
}
