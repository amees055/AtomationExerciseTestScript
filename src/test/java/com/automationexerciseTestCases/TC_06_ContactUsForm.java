package com.automationexerciseTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class TC_06_ContactUsForm extends BaseClass {
	@Test
	public void contactus() throws IOException, InterruptedException, AWTException
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
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")).click();
		 String expectedText = "GET IN TOUCH";
	        By elementLocator = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2"); 

	        WebElement element = driver.findElement(elementLocator);

	        String actualText = element.getText();

	       // Assert.assertEquals(actualText, expectedText, "New User Signup!");
	        if (actualText.equals(expectedText)) {
	        	log.info("Verified! GET IN TOUCH is visible");
	           // System.out.println("Verified! ACCOUNT DELETED!");
	        } else {
	        	captureScreen(driver, "contactus");
	            System.out.println("Text on the home screen does not match the expected text.");
	        }
			
			
			driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input")).sendKeys(name); //name

			driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input")).sendKeys(email); //email
		
			driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input")).sendKeys("software tester"); //subject

			driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("sdfrgtyuikdsfmladhfkjsdncsknc"); //message
			
			//driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[5]")).click(); //upload file
			//driver.findElement(By.name("upload_file")).sendKeys("C:\\Users\\Seema\\Downloads\\rd.png");
	       
			  /*  By fileInputLocator = By.xpath("//*[@type=\"file\"]"); // Use the correct locator (id, xpath, etc.)
	        //driver.findElement(fileInputLocator).click();

			String filePath = "C:\\Users\\Seema\\Downloads\\rd.png";			 
	        WebElement fileInput = driver.findElement(fileInputLocator);
	       // JavascriptExecutor js = (JavascriptExecutor) driver;
	       // js.executeScript("arguments[0].style.display='block';", fileInput);
	        //js.executeScript("arguments[0].value=arguments[1];", fileInput, filePath);
	        
	       
	      fileInput.click();
	        Robot robot = new Robot();
	        StringSelection stringSelection = new StringSelection(filePath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL); */
	       

	       Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input")).click();	//submit
			 Alert alert = driver.switchTo().alert();

		        // Get the text from the alert
		        String alertText = alert.getText();
		        System.out.println("Alert Text: " + alertText);
		        alert.accept();
		        
		        String expectedText1 = "Success! Your details have been submitted successfully.";
		        By elementLocator1 = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"); 

		        WebElement element1 = driver.findElement(elementLocator1);

		        String actualText1 = element1.getText();

		       
		        if (actualText1.equals(expectedText1)) {
		           // System.out.println("Verified! Enter account information text");
		            log.info("Success! Your details have been submitted successfully");
		        } else {
		        	captureScreen(driver, "logintest");
		            System.out.println("Text on the home screen does not match the expected text.");
		        }
		        
		        driver.findElement(By.xpath("//*[@id=\"form-section\"]/a/span")).click();
		        if(driver.getTitle().equals("Automation Exercise"))
				{
					Assert.assertTrue(true);
					log.info("Homepage is visible successfully");
				}
				else
				{
					captureScreen(driver, "contactus");
					Assert.assertTrue(false);
				} 
				


	}
		

}
