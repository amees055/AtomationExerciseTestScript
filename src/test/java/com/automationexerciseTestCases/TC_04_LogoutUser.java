package com.automationexerciseTestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automationexercisePageObjects.LoginPage;

public class TC_04_LogoutUser extends BaseClass {
	@Test
	public void logoutuser() throws IOException
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
			captureScreen(driver, "logoutuser");
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
		
		log.info("SignIn Successful");
	
		String expectedText1 = "seema";
        By elementLocator1 = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b"); 

        WebElement element1 = driver.findElement(elementLocator1);

        String actualText1 = element1.getText();

        if (actualText1.equals(expectedText1)) {
        	log.info("Verified! user logged in as seema");
          //  System.out.println("Verified! user logged in as test1");
        } else {
        	captureScreen(driver, "logintest");
            System.out.println("Text on the home screen does not match the expected text.");
        }
        
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
        
        String expectedText2 = "Login to your account";
		By elementLocator2 = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"); 
        WebElement element2 = driver.findElement(elementLocator2);
        String actualText2 = element2.getText();
        if (actualText2.equals(expectedText2)) {
        	log.info("Verified! Login to your account visible successfully");
        } else {
        	captureScreen(driver, "logintest");
            System.out.println("Text on the home screen does not match the expected text.");
        }
        

	}

}
