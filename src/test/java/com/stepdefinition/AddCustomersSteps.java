
	package com.stepdefinition;

	import org.junit.Assert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.When;


	public class AddCustomersSteps {
		static WebDriver driver;
		@Given("User launches demo telecom site")
		public void user_launches_demo_telecom_site() throws Exception {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\revathi ss\\eclipse-workspace\\cucumber\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://demo.guru99.com/telecom/index.html");
		 Thread.sleep(3000);
		 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
		 driver.findElement(By.id("closeBtn")).click();
		 driver.switchTo().parentFrame();
		}

		@Given("User click on add customer button")
		public void user_click_on_add_customer_button() throws Exception {
		   driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
		   Thread.sleep(5000);
		   driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
			 driver.findElement(By.id("closeBtn")).click();
			 driver.switchTo().parentFrame();
		}

		@When("User enters all the fields")
		public void user_enters_all_the_fields() {
		   driver.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		   driver.findElement(By.id("fname")).sendKeys("ela");
		   driver.findElement(By.id("lname")).sendKeys("murugan");
		   driver.findElement(By.id("email")).sendKeys("elamurugan1003@gmail.com");
		   driver.findElement(By.name("addr")).sendKeys("pudukkottai");
		   driver.findElement(By.id("telephoneno")).sendKeys("8098708095");
		 }

		@When("User click on submit button")
		public void user_click_on_submit_button() throws Exception {
			  driver.findElement(By.xpath("(//input[@value='submit'])[1]")).click();
			  Thread.sleep(3000);
			  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"flow_close_btn_iframe\"]")));
				 driver.findElement(By.id("closeBtn")).click();
				 driver.switchTo().parentFrame();
		}

		@Then("User should be displayed cutomer ID is generated or not")
		public void user_should_be_displayed_cutomer_ID_is_generated_or_not() {
		Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
		String text = driver.findElement(By.xpath("(//td[@align='center'])[2]")).getText();
		   System.out.println(text);
		}

	}


