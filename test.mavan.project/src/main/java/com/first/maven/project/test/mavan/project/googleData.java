package com.first.maven.project.test.mavan.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class googleData { 

	WebDriver driver;
	googleTest gt;
	XSSFWorkbook wb;
	File src;
	FileInputStream fis;
	FileOutputStream fout;

	googleData() throws IOException {
		src = new File("./GoogleData.xlsx");
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
	}


	public Boolean IsTestElementPresent(WebElement driver, String Value) {
		try {
			driver.findElement(By.xpath(Value));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	@Test
	public void test1() {

		System.setProperty("webdriver.chrome.driver",
				"F:\\Software\\Library Package\\Chrome package\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			driver.navigate().to(
					"https://www.google.co.in/search?hl=en&dcr=0&source=hp&q=medical+near+me&oq=medical+near+me&gs_l=psy-ab.3..0l3j0i22i30k1l7.2847.5768.0.6211.15.15.0.0.0.0.237.2075.0j12j1.13.0.dummy_maps_web_fallback...0...1.1.64.psy-ab..2.13.2067...0i131k1j0i10k1.0.oi9nA4SZRMo");

			driver.findElement(By.xpath(".//*[@id='lu_map']")).click();
			for (int i = 1; i <= 10; i++) {
				try {
					System.out.println("Number of page : " + i);
					List<WebElement> list = driver.findElements(By.xpath(".//*[@class='_iPk']"));

					System.out.println(list.size());

					for (WebElement each_list : list) {

						String title = "", Address1 = " ", Address2 = "", ContactNo = "";

						if (IsTestElementPresent(each_list, ".//div")) {
							title = each_list.findElement(By.xpath(".//div")).getAttribute("innerText").toUpperCase();
							System.out.println("Title is: " + title);
						} else {
							System.out.println("Title is: not exits.");

						}

						if (IsTestElementPresent(each_list, ".//span/div[1]/span")) {
							Address1 = each_list.findElement(By.xpath(".//span/div[1]/span")).getAttribute("innerText")
									.toString();
							System.out.println("Address1 is: " + Address1);
						} else {
							System.out.println("Address1 is: not exits.");

						}

						if (IsTestElementPresent(each_list, ".//span/div[2]/span")) {
							Address2 = each_list.findElement(By.xpath(".//span/div[2]/span")).getAttribute("innerText")
									.toString();
							System.out.println("Address2 is: " + Address2);
						} else {
							System.out.println("Address2 is: not exits.");

						}

						if (IsTestElementPresent(each_list, ".//span/div[3]/span")) {
							ContactNo = each_list.findElement(By.xpath(".//span/div[3]/span")).getAttribute("innerText")
									.toString();
							System.out.println("Contact is: " + ContactNo);
						} else {
							System.out.println("Contact is: not exits.");

						}
						insert_datatoExcel(String.valueOf(i), title, Address1, Address2, ContactNo);
					}

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

				finally {
					driver.findElement(By.xpath(".//*[@id='pnnext']/span[2]")).click();
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		finally {
			try {
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver.quit();
		}
	}

	public void insert_datatoExcel(String PageNo, String title, String address1, String address2, String contact)
			throws IOException, InterruptedException {

		XSSFSheet sh1 = wb.getSheetAt(0);
		int lastrow = sh1.getLastRowNum();
		int i = lastrow + 1;
		if (String.valueOf(sh1.getRow(i)) == "null") {
			sh1.createRow(i);
			sh1.getRow(i).createCell(0).setCellValue(PageNo);
			sh1.getRow(i).createCell(1).setCellValue(title);
			sh1.getRow(i).createCell(2).setCellValue(address1);
			sh1.getRow(i).createCell(3).setCellValue(address2);
			sh1.getRow(i).createCell(4).setCellValue(contact);
			fout = new FileOutputStream(new File("./GoogleData.xlsx"));
			wb.write(fout);
			// fout.close();
			Thread.sleep(5);
		}
	}
}
