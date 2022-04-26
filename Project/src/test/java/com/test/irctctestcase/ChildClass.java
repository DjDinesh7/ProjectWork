package com.test.irctctestcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ChildClass extends BaseClass{
	
	@Test(priority =1)
	public void openPage() throws InterruptedException{
		driver.get(" https://www.irctc.co.in/nget/train-search ");
		Thread.sleep(100);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(100);
	}
	@Test(priority =2)
	public void windowHandling() throws InterruptedException {
		driver.findElement(By.xpath("//a[@aria-label='Menu BUSES. Website will be opened in new tab']")).click();
		driver.findElement(By.xpath("//a[@aria-label='Menu Flight. Website will be opened in new tab']")).click();
		Thread.sleep(100);
		Set<String> wHandles= driver.getWindowHandles();
		List<String> newWindow = new ArrayList<String>(wHandles);
		WebDriver window2 = driver.switchTo().window(newWindow.get(2));
		System.out.println("Title:-" +window2.getTitle());
		bus();
		String Title = driver.getTitle();
		Assert.assertEquals(Title,"IRCTC Bus - Online Bus Ticket Booking | Bus Reservation");
		WebDriver window1 = driver.switchTo().window(newWindow.get(1));
		System.out.println("Title:-" +window1.getTitle());
		flight();
		String Title1 = driver.getTitle();
		Assert.assertEquals(Title1,"Air Ticket Booking | Book Flight Tickets | Cheap Air Fare - IRCTC Air");
		driver.switchTo().window(newWindow.get(0));
		}
	@Test(priority =3)
	public void findTrain() {
		try {
			driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("PUNE JN - PUNE");
			driver.findElement(By.xpath("//input[@class='ng-tns-c58-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")).sendKeys("SURAT - ST");
			driver.findElement(By.xpath("//p-calendar[@id = 'jDate']")).click();
			//driver.findElement(By.xpath("//a[@class='ui-state-default ng-tns-c59-10 ng-star-inserted']")).click();
			driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/div/div/div[2]/table/tbody/tr[5]/td[7]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@label='Find Trains']")).click();
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//span[@class='ui-button-text ui-clickable']")).click();
		}catch(Exception e) {
			System.out.println("In Catch " +e.getMessage());
			System.out.println("cause is "+e.getCause());
			e.printStackTrace();
		}
}
	public void bus() throws InterruptedException {
		try{
			driver.findElement(By.id("departFrom")).sendKeys("Pune");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]")).click();
			
			driver.findElement(By.id("goingTo")).sendKeys("Mumbai");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//ul[@id='ui-id-2']/li[1]")).click();
			
			driver.findElement(By.id("departDate")).sendKeys("25");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//td[@data-handler = 'selectDay']/a")).click();
			
			driver.findElement(By.xpath("//i[@class = 'fas fa-search ml-1']")).click();
			Thread.sleep(5000);
			
		}catch(Exception e) {
			System.out.println("In Catch " +e.getMessage());
			System.out.println("cause is "+e.getCause());
			e.printStackTrace();
		}
	}
	
	public void flight() throws InterruptedException {
		try {
			driver.findElement(By.id("stationFrom")).sendKeys("Pune");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]")).click();
			
			driver.findElement(By.id("stationTo")).sendKeys("Mumbai");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//ul[@id='ui-id-2']/li[1]")).click();
			
			driver.findElement(By.xpath("//input[@id='originDate']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[@class='act']")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//i[@class = 'fas fa-search ml-1']")).click();
			Thread.sleep(10000);
			
		}catch(Exception e) {
			System.out.println("In Catch " +e.getMessage());
			System.out.println("cause is "+e.getCause());
			e.printStackTrace();
		}
	}
	
}
