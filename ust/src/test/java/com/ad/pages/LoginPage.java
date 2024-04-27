package com.ad.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ad.basedriver.PageDriver;
import com.ad.utilities.GetScreenShot;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class LoginPage {
	ExtentTest test;
	
	public LoginPage(ExtentTest test)
	{
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
			
	}
	
	@FindBy(xpath = "//input[@id='userEmail']")	
	 WebElement userEmail;
	
	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement userPass;
	
	@FindBy(id= "loginButton")
	WebElement LoginButton;
	
	
	// Pass Case
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
	}

	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "" + scName + "");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}

	// Fail
	public void failCase(String message, String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "" + scName + "");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}

	
	public void Login() throws IOException
	{
				try {
					test.info("Please enter your email.");
					if (userEmail.isDisplayed()) {
						userEmail.sendKeys("codemen.turny@gmail.com");
						passCase("You have entered your username");
						Thread.sleep(2000);
						try {
							test.info("Please enter your password.");
							if (userPass.isDisplayed()) {
								userPass.sendKeys("TTT@wd123!!");
								passCase("You have entered your password");
								Thread.sleep(2000);
								try {
									test.info("Please click on the Login Button.");
									if (LoginButton.isDisplayed()) {
										LoginButton.click();
										Thread.sleep(20000);
										passCaseWithSC("Login Successful", "login_pass");
									}
								} catch (Exception e) {
									failCase("Submit button was not locateable.", "submit_fail");
								}
							}
						} catch (Exception e) {
							failCase("Password was not locateable. Please check the error message.", "pass_fail");

						}
					}
				} catch (Exception e) {
					failCase("User name was not locateable. Please check the error message.", "username_fail");
				}
			}
		
		
		
		
		
		
		

		
	}
	

