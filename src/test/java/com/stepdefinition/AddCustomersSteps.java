
	package com.stepdefinition;

	import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomersSteps {
	static WebDriver driver;
	@Given("User launches demo telecom site")
	public void user_launches_demo_telecom_site() {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\revathi ss\\eclipse-workspace\\cucumber\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://demo.guru99.com/telecom/index.html");
		 
	}

	@Given("User click on add customer button")
	public void user_click_on_add_customer_button() throws Throwable {
		try {
			handleFrame();
		}catch(Exception e) {
		}
	   driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	   
	}

	@When("User enters all the fields")
	public void user_enters_all_the_fields() throws Throwable {
		try {
			handleFrame();
		}catch(Exception e) {
		}
	   driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
	   driver.findElement(By.id("fname")).sendKeys("ela");
	   driver.findElement(By.id("lname")).sendKeys("murugan");
	   driver.findElement(By.id("email")).sendKeys("elamurugan1003@@gmail.com");
	   driver.findElement(By.name("addr")).sendKeys("pudukkottai");
	   driver.findElement(By.id("telephoneno")).sendKeys("8098708095");
	}
	@When("User enters all the fields with one dimensional")
	public void user_enters_all_the_fields_with_one_dimensional(DataTable customerData) throws Throwable {
	    List<String> data = customerData.asList(String.class);
	    try {
			handleFrame();
		}catch(Exception e) {
		}
	   driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
	   driver.findElement(By.id("fname")).sendKeys(data.get(0));
	   driver.findElement(By.id("lname")).sendKeys(data.get(1));
	   driver.findElement(By.id("email")).sendKeys(data.get(2));
	   driver.findElement(By.name("addr")).sendKeys(data.get(3));
	   driver.findElement(By.id("telephoneno")).sendKeys(data.get(4));
	}
	@When("User enters all the fields with one dimensional map")
	public void user_enters_all_the_fields_with_one_dimensional_map(DataTable customerData) throws Throwable {
	    Map<String, String> data = customerData.asMap(String.class, String.class);
	    try {
			handleFrame();
		}catch(Exception e) {
		}
	   driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
	   driver.findElement(By.id("fname")).sendKeys(data.get("Fname"));
	   driver.findElement(By.id("lname")).sendKeys(data.get("Lname"));
	   driver.findElement(By.id("email")).sendKeys(data.get("Email"));
	   driver.findElement(By.name("addr")).sendKeys(data.get("Add"));
	   driver.findElement(By.id("telephoneno")).sendKeys(data.get("Phone"));
	}


	@When("User click on submit button")
	public void user_click_on_submit_button() {
		driver.findElement(By.xpath("(//input[@value='Submit'])[1]")).click();
	}

	@Then("User should be displayed cutomer ID is generated or not")
	public void user_should_be_displayed_cutomer_ID_is_generated_or_not() throws Throwable {
		try {
			handleFrame();
		}catch(Exception e) {
		}
	Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
	String text = driver.findElement(By.xpath("(//td[@align='center'])[2]")).getText();
	   System.out.println(text);
	}
	public void handleFrame() throws Throwable {
		 Thread.sleep(5000);
		   driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
			 driver.findElement(By.id("closeBtn")).click();
			 driver.switchTo().parentFrame();
	}
}
