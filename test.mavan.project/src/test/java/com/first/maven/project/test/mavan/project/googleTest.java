package com.first.maven.project.test.mavan.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class googleTest {

	WebDriver driver;

	public googleTest(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "lu_map")
	WebElement map_link;

	By map = By.xpath(".//*[@id='hdtb-msb-vis']/div[2]/a");
	By getlist = By.xpath(".//*[@id='pane']/div/div[2]/div/div/div[2]/div");

	public void click_map() {
		// driver.findElement(map).click();
		map_link.click();
	}

}
