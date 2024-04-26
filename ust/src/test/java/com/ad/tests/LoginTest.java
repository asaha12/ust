package com.ad.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ad.basedriver.BaseDriver;
import com.ad.basedriver.PageDriver;
import com.ad.pages.LoginPage;

public class LoginTest extends BaseDriver {

	@BeforeClass
	public void start() throws InterruptedException
	{
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(3000);
		
	}
	
	@Test
	public void loginTest() throws InterruptedException
	{
		LoginPage loginPage = new LoginPage();
		loginPage.Login();
		
	}
	
	
}
