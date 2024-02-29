package com.automationexerciseTestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_07_VerifyTestcasePage extends BaseClass{
	@Test
	public void testcasepage() throws IOException, InterruptedException
	{
		driver.get(baseURl);
		//log4j.properties and log4j.jar is user for logging data.. result will get in log folder
		log.info("URL is Opened");
		//driver.manage().window().maximize();
		if(driver.getTitle().equals("Automation Exercise"))
		{
			log.info("verified! home screen is visible successfully");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "contactus");
			Assert.assertTrue(false);
		} 
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();
		 String expectedText = "TEST CASES";
	        By elementLocator = By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b"); 

	        WebElement element = driver.findElement(elementLocator);

	        String actualText = element.getText();

	       // Assert.assertEquals(actualText, expectedText, "New User Signup!");
	        if (actualText.equals(expectedText)) {
	        	log.info("Test Case txt is visible");
	           // System.out.println("Verified! ACCOUNT DELETED!");
	        } else {
	        	captureScreen(driver, "testcasepage");
	            System.out.println("Text on the home screen does not match the expected text.");
	        }
			
	}

}
