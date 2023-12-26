package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	public WebDriver driver;
	
	public BasePage(WebDriver driver) //constructor-- name should be same as class name.
	{
		this.driver= driver;
		PageFactory.initElements(driver,this); // this keyword refer basepage class
	}

}
