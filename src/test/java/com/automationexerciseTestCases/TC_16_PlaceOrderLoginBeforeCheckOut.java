package com.automationexerciseTestCases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercisePageObjects.LoginPage;

public class TC_16_PlaceOrderLoginBeforeCheckOut extends BaseClass {
	@Test
	public void loginbeforecheckout() throws IOException, InterruptedException {
		driver.get(baseURl);
		if(driver.getTitle().equals("Automation Exercise"))
		{
			Assert.assertTrue(true);
			log.info("homepage is visible successfully!");
		}
		else
		{
			captureScreen(driver, "loginbeforecheckout");
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
		
		//driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
		Thread.sleep(5000);
		String expectedText3 = name;
        By elementLocator3 = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b"); 

        WebElement element3 = driver.findElement(elementLocator3);

        String actualText3 = element3.getText();

       // Assert.assertEquals(actualText, expectedText, "New User Signup!");
        if (actualText3.equals(expectedText3)) {
        	log.info("Verified! user logged in as "+ name);
          //  System.out.println("Verified! user logged in as test1");
        } else {
        	captureScreen(driver, "loginbeforecheckout");
            System.out.println("Text on the home screen does not match the expected text.");
        }
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a//u[text()='View Cart']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("this is my first order automation and im very happy");
	    driver.findElement(By.xpath("//a[text()='Place Order']")).click();
	    Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("hdcd");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("123456789023");
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("434");
        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("04");
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2024");
        driver.findElement(By.xpath("//button[text()='Pay and Confirm Order']")).click();


        String expectedText5 = "Congratulations! Your order has been confirmed!";
        By elementLocator5 = By.xpath("//p[text()='Congratulations! Your order has been confirmed!']"); 

        WebElement element5 = driver.findElement(elementLocator5);

        String actualText5 = element5.getText();
        
        if (actualText5.equals(expectedText5)) {
        	log.info("Verify success message 'Your order has been placed successfully!'");
         
        } else {
        	captureScreen(driver, "logintest");
            System.out.println("Text on the home screen does not match the expected text.");
        }
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        
       /* driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        
        String expectedText6 = "ACCOUNT DELETED!";
        By elementLocator6 = By.xpath("//h2[@class=\"title text-center\"]"); 

        WebElement element6 = driver.findElement(elementLocator6);

        String actualText6 = element6.getText();
        
        if (actualText6.equals(expectedText6)) {
        	log.info("Verify success message 'ACCOUNT DELETED!'");
         
        } else {
        	captureScreen(driver, "logintest");
            System.out.println("Text on the home screen does not match the expected text.");
        }
        
       driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
  	*/
	}

}
