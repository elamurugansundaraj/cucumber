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

public class AddTrafficPlan{
	 static WebDriver driver;
	@Given("User launche demo telecom site")
	public void user_launche_demo_telecom_site() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\revathi ss\\eclipse-workspace\\cucumber\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://demo.guru99.com/telecom/index.html");
		  
	}

	@Given("User click on add tariff plan button")
	public void user_click_on_add_tariff_plan_button() throws Throwable {
		try {
			handleFrame();
		}catch(Exception e) {
		}
	   driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	   
	}

	@When("Users enters all the fields")
	public void users_enters_all_the_fields() throws Throwable {
		try {
			handleFrame();
		}catch(Exception e) {
		}
	   driver.findElement(By.id("rental1")).sendKeys("299");
	   driver.findElement(By.id("local_minutes")).sendKeys("600");
	   driver.findElement(By.id("inter_minutes")).sendKeys("300");
	   driver.findElement(By.id("sms_pack")).sendKeys("100");
	   driver.findElement(By.id("minutes_charges")).sendKeys("2");
	   driver.findElement(By.id("inter_charges")).sendKeys("4");
	   driver.findElement(By.id("sms_charges")).sendKeys("1");
	}
	
	@When("User enters all the fields with one dimensional list")
	public void user_enters_all_the_fields_with_one_dimensional_list(DataTable tariffData) throws Throwable {
	    List<List<String>> data = tariffData.asLists(String.class);
	    try {
			handleFrame();
		}catch(Exception e) {
		}
	       driver.findElement(By.id("rental1")).sendKeys(data.get(0).get(0));
		   driver.findElement(By.id("local_minutes")).sendKeys(data.get(1).get(0));
		   driver.findElement(By.id("inter_minutes")).sendKeys(data.get(2).get(0));
		   driver.findElement(By.id("sms_pack")).sendKeys(data.get(2).get(3));
		   driver.findElement(By.id("minutes_charges")).sendKeys(data.get(2).get(5));
		   driver.findElement(By.id("inter_charges")).sendKeys(data.get(1).get(6));
		   driver.findElement(By.id("sms_charges")).sendKeys(data.get(2).get(5));
	}
	
	@When("User enters all the fields with one dimension map")
	public void user_enters_all_the_fields_with_one_dimension_map(DataTable tariffData) throws Throwable {
	   List<Map<String,String>> data = tariffData.asMaps(String.class, String.class);
	   try {
			handleFrame();
		}catch(Exception e) {
		}
	       driver.findElement(By.id("rental1")).sendKeys(data.get(0).get("Ren"));
		   driver.findElement(By.id("local_minutes")).sendKeys(data.get(2).get("Loc"));
		   driver.findElement(By.id("inter_minutes")).sendKeys(data.get(1).get("Int"));
		   driver.findElement(By.id("sms_pack")).sendKeys(data.get(0).get("Msg"));
		   driver.findElement(By.id("minutes_charges")).sendKeys(data.get(2).get("LocRs"));
		   driver.findElement(By.id("inter_charges")).sendKeys(data.get(1).get("IntRs"));
		   driver.findElement(By.id("sms_charges")).sendKeys(data.get(0).get("MsgRs"));
	}
	
	@When("Users click on submit button")
	public void users_click_on_submit_button() {
		driver.findElement(By.xpath("//input[@value='submit']")).click();
	}

	@Then("Users should be displayed tariff plan  is added or not")
	public void users_should_be_displayed_tariff_plan_is_added_or_not() throws Throwable {
		try {
			handleFrame();
		}catch(Exception e) {
		}
	Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).isDisplayed());
	String text = driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).getText();
	   System.out.println(text);
	}
public void handleFrame() throws Throwable  {
	Thread.sleep(5000);
	   driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
		 driver.findElement(By.id("closeBtn")).click();
		 driver.switchTo().parentFrame();
}

}