package com.ad.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ad.basedriver.PageDriver;

public class LoginPage {
	
	public LoginPage()
	{
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
			
	}
	
	@FindBy(xpath = "//input[@id='userEmail']")	
	 WebElement userEmail;
	
	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement userPass;
	
	@FindBy(id= "loginButton")
	WebElement LoginButton;
	
	
	public void Login() throws InterruptedException
	{
		userEmail.sendKeys("codemen.turny@gmail.com");
		userPass.sendKeys("TTT@wd123!!");
		LoginButton.click();
		Thread.sleep(50000);
		
		
	}
	

}
