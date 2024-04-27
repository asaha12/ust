package com.ad.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ad.basedriver.BaseDriver;
import com.ad.basedriver.PageDriver;
import com.ad.pages.LoginPage;
import com.ad.utilities.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class LoginTest extends BaseDriver {
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;

	@BeforeClass
	public void start() throws InterruptedException
	{
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(3000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>GroundFloor v2 Login</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
		
	}
	
	@Test
	public void loginTest() throws IOException
	{
		childTest =parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Login</b></p>");
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.Login();
		
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
	
	
}
