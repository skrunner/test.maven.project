package com.first.maven.project.test.mavan.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {
	
	WebDriver driver;
	flipcartloginTest ft;
	
	@BeforeTest
	public void beforetest() {
		driver=chooseBrowser.SelectBrowser("chrome", "https://www.flipkart.com/");
		ft = PageFactory.initElements(driver, flipcartloginTest.class);
	}
		
	@Test(testName="Sucessful login")
	public void login_to_flipCart() {
	try {
		ft.login("abc@gmail.com", "abcdef");
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
	
	
	@AfterTest
	public void quit_driver() {
		driver.quit();
	}

}
