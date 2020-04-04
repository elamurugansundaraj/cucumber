package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.objectrepository.AddTarfficPlan;
import com.objectrepository.HomePage;
import com.resources.FunctionalLibrary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddTrafficPlan extends FunctionalLibrary{
	FunctionalLibrary f = new FunctionalLibrary();
	 HomePage hp = new HomePage();
	 AddTarfficPlan tp = new AddTarfficPlan();
	

	 @Given("User click on add tariff button")
		public void user_click_on_add_tariff_button() throws Throwable {
			try {
				handleFrame();
			}catch(Exception e) {
			}
		   f.click(hp.getAddTariffBtn());
		}

		@When("Users enters all the fields")
		public void users_enters_all_the_fields() throws Throwable {
			try {
				handleFrame();
			}catch(Exception e) {
			} 
			   f.insertText(tp.getMonRen(), "100");
			   f.insertText(tp.getLocMin(), "101");
			   f.insertText(tp.getIntMin(), "102");
			   f.insertText(tp.getMsg(), "103");
			   f.insertText(tp.getLocRs(), "1");
			   f.insertText(tp.getIntRs(), "2");
			   f.insertText(tp.getMsgRs(), "1");
		}
		@When("Users enters all the fields with List")
		public void users_enters_all_the_fields_with_List(DataTable tariffData) throws Throwable {
			List<List<String>> data = tariffData.asLists(String.class);
			try {
				handleFrame();
			}catch(Exception e) {
			} 
			f.insertText(tp.getMonRen(), data.get(0).get(0));
			   f.insertText(tp.getLocMin(), data.get(0).get(1));
			   f.insertText(tp.getIntMin(), data.get(0).get(2));
			   f.insertText(tp.getMsg(), data.get(1).get(3));
			   f.insertText(tp.getLocRs(), data.get(1).get(4));
			   f.insertText(tp.getIntRs(), data.get(0).get(5));
			   f.insertText(tp.getMsgRs(), data.get(1).get(6));
			   
		}
		@When("Users enters all the fields with Map")
		public void users_enters_all_the_fields_with_Map(DataTable tariffdata) throws Throwable {
			List<Map<String, String>> data = tariffdata.asMaps(String.class, String.class);
			try {
				handleFrame();
			}catch(Exception e) {
			} 
			
			   f.insertText(tp.getMonRen(), data.get(0).get("MonRen"));
			   f.insertText(tp.getLocMin(), data.get(0).get("LocMin"));
			   f.insertText(tp.getIntMin(), data.get(1).get("IntMin"));
			   f.insertText(tp.getMsg(), data.get(0).get("Msg"));
			   f.insertText(tp.getLocRs(), data.get(1).get("LocRs"));
			   f.insertText(tp.getIntRs(), data.get(0).get("IntRs"));
			   f.insertText(tp.getMsgRs(), data.get(1).get("MsgRs"));
			   
		}
		@When("Users enters all the fields with Outline {string},{string},{string},{string},{string},{string},{string}")
		public void users_enters_all_the_fields_with_Outline(String string, String string2, String string3, String string4, String string5, String string6, String string7) throws Throwable {
			try {
				handleFrame();
			}catch(Exception e) {
			} 
			f.insertText(tp.getMonRen(), string);
			   f.insertText(tp.getLocMin(), string2);
			   f.insertText(tp.getIntMin(), string3);
			   f.insertText(tp.getMsg(), string4);
			   f.insertText(tp.getLocRs(), string5);
			   f.insertText(tp.getIntRs(), string6);
			   f.insertText(tp.getMsgRs(), string7);	  
		}
		@When("User click on tariff submit button")
		public void user_click_on_tariff_submit_button() {
			f.click(tp.getTarsubBtn());
		}

		@Then("User should be displayed tariff is added or not")
		public void user_should_be_displayed_tariff_is_added_or_not() throws Throwable {
			try {
				handleFrame();
			}catch(Exception e) {
			}
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).isDisplayed());
		String text = driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).getText();
		   System.out.println(text);
		}
		public void handleFrame() throws Throwable {
			 Thread.sleep(5000);
			   driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
				 driver.findElement(By.id("closeBtn")).click();
				 driver.switchTo().parentFrame();
		}
	}