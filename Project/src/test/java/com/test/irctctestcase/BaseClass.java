package com.test.irctctestcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
	
	}
	
	@AfterTest
	public void close() {
		driver.close();
		driver.quit();
		System.out.println("Test Complete");
	
	}

}
