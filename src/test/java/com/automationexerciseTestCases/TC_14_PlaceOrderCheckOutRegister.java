package com.automationexerciseTestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.automationexercisePageObjects.LoginPage;

public class TC_14_PlaceOrderCheckOutRegister extends BaseClass {
	@Test
	public void placeorder() throws InterruptedException, IOException {
		driver.get(baseURl);
		//Verify that home page is visible successfully
		
		String title= driver.getTitle();
		log.info(title);
		assertEquals(title, "Automation Exercise","Incorrect Title");
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a//u[text()='View Cart']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a//u[text()='Register / Login']")).click();
		
		//Fill all details in Signup and create account
		driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(name);
		 String userName = ""+ (int) (Math.random ()*Integer.MAX_VALUE); 
		 String emailID = "User"+userName+"@example.com";
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(emailID);
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
		Thread.sleep(2000);
		
		LoginPage lp= new LoginPage(driver);
		
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
		Thread.sleep(2000);
		String expectedText3 = name;
        By elementLocator3 = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b"); 

        WebElement element3 = driver.findElement(elementLocator3);

        String actualText3 = element3.getText();

       // Assert.assertEquals(actualText, expectedText, "New User Signup!");
        if (actualText3.equals(expectedText3)) {
        	log.info("Verified! user logged in as " + name);
          //  System.out.println("Verified! user logged in as test1");
        } else {
        	captureScreen(driver, "logintest");
            System.out.println("Text on the home screen does not match the expected text.");
        }
        
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
       // driver.findElement(By.xpath("//textarea[@name='message']")).click();
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("this is my first order automation and im very happy");
        driver.findElement(By.xpath("//a[text()='Place Order']")).click();
        
        
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
		Thread.sleep(5000);

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
