package com.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resources.FunctionalLibrary;

public class AddTarfficPlan extends FunctionalLibrary {
	
	public AddTarfficPlan() {
		PageFactory.initElements(driver, this);
	}
     
	@FindBy(id="rental1")
	private WebElement monRen;
	
	@FindBy(id="local_minutes")
	private WebElement locMin;
	
	@FindBy(id="inter_minutes")
	private WebElement intMin;
	
	@FindBy(id="sms_pack")
	private WebElement msg;
	
	@FindBy(id="minutes_charges")
	private WebElement locRs;
	
	@FindBy(id="inter_charges")
	private WebElement intRs;
	
	@FindBy(id="sms_charges")
	private WebElement msgRs;
	
	@FindBy(xpath="//input[@value='submit']")
	private WebElement tarsubBtn;

	public WebElement getMonRen() {
		return monRen;
	}

	public WebElement getLocMin() {
		return locMin;
	}

	public WebElement getIntMin() {
		return intMin;
	}

	public WebElement getMsg() {
		return msg;
	}

	public WebElement getLocRs() {
		return locRs;
	}

	public WebElement getIntRs() {
		return intRs;
	}

	public WebElement getMsgRs() {
		return msgRs;
	}

	public WebElement getTarsubBtn() {
		return tarsubBtn;
	}
	
	
}