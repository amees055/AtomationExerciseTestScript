package com.automationexerciseTestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_11_VerifySubscriptionInCartPage extends BaseClass{
	@Test
	public void subscriptionincartpage() throws InterruptedException, IOException{
		driver.get(baseURl);
		if(driver.getTitle().equals("Automation Exercise"))
		{
			Assert.assertTrue(true);
			log.info("verified!! home page");
		}
		else
		{
			captureScreen(driver, "subscriptionincartpage");
		
			Assert.assertTrue(false);
			
		}
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;  
        js.executeScript("window.scrollBy(0,5000)");
        Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"susbscribe_email\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"susbscribe_email\"]")).sendKeys("test@mail.com");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"subscribe\"]")).click();
	
/*	String expectedText1 = "Success! Your details have been submitted successfully.";
    By elementLocator1 = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"); 

    WebElement element1 = driver.findElement(elementLocator1);

    String actualText1 = element1.getText();

   
    if (actualText1.equals(expectedText1)) {
       // System.out.println("Verified! Enter account information text");
        log.info("Success! Your details have been submitted successfully");
    } else {
    	captureScreen(driver, "logintest");
        System.out.println("Text on the home screen does not match the expected text.");
    } */
}




}


		
	
