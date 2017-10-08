package com.first.maven.project.test.mavan.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class flipcartloginTest {
	WebDriver driver;

	public flipcartloginTest(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[9]/a")
	WebElement loginlink;

	@FindBy(xpath = "//input[@class='_2zrpKA']")
	WebElement emailfield;

	@FindBy(xpath = "//input[@class='_2zrpKA _3v41xv']")
	WebElement Passwordfield;

	@FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement loginButton;

	public void login(String email, String Password) throws InterruptedException {
		loginlink.click();
		Thread.sleep(2000);
		emailfield.sendKeys(email);
		Passwordfield.sendKeys(Password);
		loginButton.click();
	}

}
