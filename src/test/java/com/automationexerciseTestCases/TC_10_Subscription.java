package com.automationexerciseTestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.annotations.Test;

public class TC_10_Subscription extends BaseClass{
	@Test
	public void subscription() throws IOException, InterruptedException {
		driver.get(baseURl);
		if(driver.getTitle().equals("Automation Exercise"))
		{
			Assert.assertTrue(true);
			log.info("verified!! home page");
		}
		else
		{
			captureScreen(driver, "subscription");
		
			Assert.assertTrue(false);
			
		}
		

		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		js.executeScript("window.scrollBy(0,11200)", "");
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		driver.findElement(By.xpath("//*[@id=\"susbscribe_email\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"susbscribe_email\"]")).sendKeys("abc@mail.com");
		
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"subscribe\"]")).click();
	}
}
