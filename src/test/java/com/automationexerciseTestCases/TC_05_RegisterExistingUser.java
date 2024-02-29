package com.automationexerciseTestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automationexercisePageObjects.LoginPage;

public class TC_05_RegisterExistingUser extends BaseClass {
	@Test
	public void registerexistinguser() throws IOException
	{
		driver.get(baseURl);
		//log4j.properties and log4j.jar is user for logging data.. result will get in log folder
		log.info("URL is Opened");
		
		if(driver.getTitle().equals("Automation Exercise"))
		{
			Assert.assertTrue(true);
			log.info("Homepage is visible successfully");
		}
		else
		{
			captureScreen(driver, "registertest");
			Assert.assertTrue(false);
		} 
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		String expectedText = "New User Signup!";
        By elementLocator = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"); // Use the correct locator (id, xpath, etc.)

        // Locate the element on the home screen
        WebElement element = driver.findElement(elementLocator);

        // Get the actual text from the element
        String actualText = element.getText();

        // Verify the text using TestNG assertion
       // Assert.assertEquals(actualText, expectedText, "New User Signup!");
        if (actualText.equals(expectedText)) {
           // System.out.println("Verified! User New user signup");
        	log.info("Verified! User New user signup");
        } else {
            System.out.println("Text on the home screen does not match the expected text.");
        }
		
		//from page object class we have to import page object package
		LoginPage lp= new LoginPage(driver);
		
		lp.setName(name);
		log.info("name is Entered");

		lp.SetEmail(email);
		log.info("email is Entered");

		lp.clicksignupbtn();
		 String expectedText4 = "Email Address already exist!";
	        By elementLocator4 = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p"); 

	        WebElement element4 = driver.findElement(elementLocator4);

	        String actualText4 = element4.getText();

	       // Assert.assertEquals(actualText, expectedText, "New User Signup!");
	        if (actualText4.equals(expectedText4)) {
	        	log.info("ERROr! Email Address already exist!");
	           // System.out.println("Verified! ACCOUNT DELETED!");
	        } else {
	        	captureScreen(driver, "logintest");
	            System.out.println("Text on the home screen does not match the expected text.");
	        }
	
	}
}
