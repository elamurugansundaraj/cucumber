
	package com.stepdefinition;

	import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.objectrepository.AddCustomerPage;

import com.objectrepository.HomePage;
import com.resources.FunctionalLibrary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomersSteps extends FunctionalLibrary{
	FunctionalLibrary f = new FunctionalLibrary();
	HomePage hp = new HomePage();
	AddCustomerPage cp = new AddCustomerPage();
	
	

	@Given("User click on add customer button")
	public void user_click_on_add_customer_button() throws Throwable {
		try {
			handleFrame();
		} catch (Exception e) {
		}
		f.click(hp.getAddCustomerBtn());
	}

	@When("User enters all the fields")
	public void user_enters_all_the_fields() throws Throwable {
		try {
			handleFrame();
		} catch (Exception e) {
		}
		f.click(cp.getDoneBtn());
		f.insertText(cp.getFname(), "ela");
		f.insertText(cp.getLname(), "murugan");
		f.insertText(cp.getEmail(), "elamurugan1003@gmaill.com");
		f.insertText(cp.getAddress(), "pudukkottai");
		f.insertText(cp.getPhone(), "8098708095");
	}

	@When("User enters all the fields with List")
	public void user_enters_all_the_fields_with_List(DataTable customerData) throws Throwable {
		List<String> data = customerData.asList(String.class);
		try {
			handleFrame();
		} catch (Exception e) {
		}
		f.click(cp.getDoneBtn());
		f.insertText(cp.getFname(), data.get(0));
		f.insertText(cp.getLname(), data.get(1));
		f.insertText(cp.getEmail(), data.get(2));
		f.insertText(cp.getAddress(), data.get(3));
		f.insertText(cp.getPhone(), data.get(4));
	}

	@When("User enters all the fields with Map")
	public void user_enters_all_the_fields_with_Map(DataTable customerData) throws Throwable {
		Map<String, String> data = customerData.asMap(String.class, String.class);
		try {
			handleFrame();
		} catch (Exception e) {
		}
		f.click(cp.getDoneBtn());
		f.insertText(cp.getFname(), data.get("Fname"));
		f.insertText(cp.getLname(), data.get("Lname"));
		f.insertText(cp.getEmail(), data.get("Email"));
		f.insertText(cp.getAddress(), data.get("Add"));
		f.insertText(cp.getPhone(), data.get("Phone"));
	}

	@When("User enters all the fields with Outline {string},{string},{string},{string},{string}")
	public void user_enters_all_the_fields_with_Outline(String string, String string2, String string3, String string4,
			String string5) throws Throwable {

		try {
			handleFrame();
		} catch (Exception e) {
		}
		f.click(cp.getDoneBtn());
		f.insertText(cp.getFname(), string);
		f.insertText(cp.getLname(), string2);
		f.insertText(cp.getEmail(), string3);
		f.insertText(cp.getAddress(), string4);
		f.insertText(cp.getPhone(), string5);
	}

	@When("User click on submit button")
	public void user_click_on_submit_button() {
		f.click(cp.getSubmit());
	}

	@Then("User should be displayed cutomer ID is generated or not")
	public void user_should_be_displayed_cutomer_ID_is_generated_or_not() throws Throwable {
		try {
			handleFrame();
		} catch (Exception e) {
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