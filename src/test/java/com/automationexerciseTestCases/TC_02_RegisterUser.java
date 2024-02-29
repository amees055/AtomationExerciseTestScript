package com.automationexerciseTestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.automationexercisePageObjects.LoginPage;

public class TC_02_RegisterUser extends BaseClass{

	@Test
	public void registertest() throws IOException, InterruptedException
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
		
		String user = ""+ (int) (Math.random ()*Integer.MAX_VALUE); 
		 String uname = "User"+user;
		lp.setName(uname);
		log.info("name is Entered");

		 String userName = ""+ (int) (Math.random ()*Integer.MAX_VALUE); 
		 String emailID = "User"+userName+"@example.com";
		lp.SetEmail(emailID);
		log.info("email is Entered");

		lp.clicksignupbtn();
		
	/*	Thread.sleep(3000);
		lp.SetTitle();
		log.info("title set successful");*/
		
		//Enter Account Information
		
		
		String expectedText1 = "ENTER ACCOUNT INFORMATION";
        By elementLocator1 = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b"); 

        WebElement element1 = driver.findElement(elementLocator1);

        String actualText1 = element1.getText();

       // Assert.assertEquals(actualText, expectedText, "New User Signup!");
        if (actualText1.equals(expectedText1)) {
           // System.out.println("Verified! Enter account information text");
            log.info("Verified! Enter account information text");
        } else {
        	captureScreen(driver, "logintest");
            System.out.println("Text on the home screen does not match the expected text.");
        }
		
		WebElement radioButton = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
		if (!radioButton.isSelected()) {
            // Click the radio button to select it
            radioButton.click();
        }
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("test@123");
	
		 // Locate the dropdown element
        WebElement days = driver.findElement(By.xpath("//*[@id=\"days\"]"));
        days.click();
        
        // Use the Select class to interact with the dropdown
        Select dropdown = new Select(days);

        // Method 1: Select by visible text
        dropdown.selectByValue("1");
     
        WebElement months = driver.findElement(By.xpath("//*[@id=\"months\"]"));
        months.click();
       
        Select dropdown1 = new Select(months);

        dropdown1.selectByValue("12");
   	 
        WebElement years = driver.findElement(By.xpath("//*[@id=\"years\"]"));
        years.click();
        
        Select dropdown2 = new Select(years);

        dropdown2.selectByValue("1998");
        log.info("Date selected successfully");
        
        // Address Information
        lp.setFirstName(firstname);
        log.info("Entered FirstName");
        lp.setLastName(lastname);
        log.info("Entered LastName");
        lp.setCompany(company);
        log.info("Entered Company");
        lp.setAddress(address);
        log.info("Entered Address");
        lp.setAddress2(address2);
        log.info("Entered Address2");
        
        WebElement country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
        country.click();
        
        Select dropdown3 = new Select(country);
        dropdown3.selectByValue("Canada");
        log.info("Country Selected");
        
        lp.setState(state);
        log.info("Entered State");
        lp.setCity(city);
        log.info("Entered city");
        lp.setZipcode(zipcode);
        log.info("Entered zipcode");
        lp.setMobilenumber(mobilenumber);
        log.info("Entered mobilenumebr");
        
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
        
        String expectedText2 = "ACCOUNT CREATED!";
        By elementLocator2 = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"); 

        WebElement element2 = driver.findElement(elementLocator2);

        String actualText2 = element2.getText();

       // Assert.assertEquals(actualText, expectedText, "New User Signup!");
        if (actualText2.equals(expectedText2)) {
        	log.info("Verified! Account created");
          //  System.out.println("Verified! Account created");
        } else {
        	captureScreen(driver, "logintest");
            System.out.println("Text on the home screen does not match the expected text.");
        }
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
		Thread.sleep(5000);
		String expectedText3 = uname;
        By elementLocator3 = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b"); 

        WebElement element3 = driver.findElement(elementLocator3);

        String actualText3 = element3.getText();

       // Assert.assertEquals(actualText, expectedText, "New User Signup!");
        if (actualText3.equals(expectedText3)) {
        	log.info("Verified! user logged in as "+ uname);
          //  System.out.println("Verified! user logged in as test1");
        } else {
        	captureScreen(driver, "logintest");
            System.out.println("Text on the home screen does not match the expected text.");
        }
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        
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
  	
  		
  	
        
	}

}
