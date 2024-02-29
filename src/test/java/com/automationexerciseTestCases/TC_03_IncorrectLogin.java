package com.automationexerciseTestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automationexercisePageObjects.LoginPage;

public class TC_03_IncorrectLogin extends BaseClass {
	@Test
	public void loginwithincorrectdata() throws IOException
	{
		driver.get(baseURl);
		//log4j.properties and log4j.jar is user for logging data.. result will get in log folder
		log.info("URL is Opened");
		if(driver.getTitle().equals("Automation Exercise"))
		{
			log.info("verified! home screen is visible successfully");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "loginwithincorrectdata");
			Assert.assertTrue(false);
		} 
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		//from page object class we have to import page object package
		LoginPage lp= new LoginPage(driver);
		
		
		String expectedText = "Login to your account";
		By elementLocator = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"); 
        WebElement element = driver.findElement(elementLocator);
        String actualText = element.getText();
       // Assert.assertEquals(actualText, expectedText, "New User Signup!");
        if (actualText.equals(expectedText)) {
        	log.info("Verified! Login to your account visible successfully");
        } else {
        	captureScreen(driver, "logintest");
            System.out.println("Text on the home screen does not match the expected text.");
        }
        
		
		lp.setUserName(username);
		log.info("Username is Entered");

		lp.SetPassword(password);
		log.info("password is Entered");

		lp.Clicksubmit();
		
	
		 String expectedText4 = "Your email or password is incorrect!";
	        By elementLocator4 = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"); 

	        WebElement element4 = driver.findElement(elementLocator4);

	        String actualText4 = element4.getText();

	       // Assert.assertEquals(actualText, expectedText, "New User Signup!");
	        if (actualText4.equals(expectedText4)) {
	        	log.info("ERROr! Your email or password is incorrect!");
	           // System.out.println("Verified! ACCOUNT DELETED!");
	        } else {
	        	captureScreen(driver, "logintest");
	            System.out.println("Text on the home screen does not match the expected text.");
	        }
	}

}
