package com.first.maven.project.test.mavan.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class chooseBrowser {
	
	static WebDriver driver;
	
	public static WebDriver SelectBrowser(String browser, String url) {

		if (browser.equalsIgnoreCase("Mozilla")) {

			System.setProperty("webdriver.gecko.driver",
					"F:\\Software\\Library Package\\Mozilla Driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"F:\\Software\\Library Package\\Chrome package\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver",
					"F:\\Software\\Library Package\\InterExplorer package\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.get(url);
		return driver;
	}


}
