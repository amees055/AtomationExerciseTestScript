package com.automationexerciseTestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.automationexercisePageObjects.LoginPage;

public class TC_23_VerifyAddressDetailsInCheckoutPage extends BaseClass {
	@Test
	public void verifyaddressdetailsincheckoutpage() throws IOException, InterruptedException {
		driver.get(baseURl);
		if(driver.getTitle().equals("Automation Exercise"))
		{
			Assert.assertTrue(true);
			log.info("Homepage is visible successfully");
		}
		else
		{
			captureScreen(driver, "verifyaddress");
			Assert.assertTrue(false);
		} 
		
		driver.findElement(By.xpath("//li//a[@href='/login']")).click();
		
		//from page object class we have to import page object package
        //ACCOUNT CREAte
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
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(uname);
	
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
		
        
        driver.findElement(By.xpath("//a[@data-product-id='8']")).click();
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        
        
        String shoppingcart= driver.findElement(By.xpath("//li[@class='active']")).getText();
		assertEquals(shoppingcart, "Shopping Cart");
		log.info(shoppingcart+" text is visible");
		
		driver.findElement(By.xpath("//a[@class=\"btn btn-default check_out\"]")).click();
		
		Thread.sleep(3000);
//12. Verify that the delivery address is same address filled at the time registration of account

        String dfirstandlastname= driver.findElement(By.xpath("//*[@id='address_delivery']/li[2]")).getText();
        assertEquals(dfirstandlastname, "Mrs. "+firstname +" "+ lastname);
		log.info(dfirstandlastname+" is same first and last name as filled at the time of registration");
        
        String dcompany= driver.findElement(By.xpath("//*[@id='address_delivery']/li[3]")).getText();
        assertEquals(dcompany, company);
		log.info(dcompany+" is same company as filled at the time of registration");
		
        String daddress= driver.findElement(By.xpath("//*[@id='address_delivery']/li[4]")).getText();
        assertEquals(daddress, address);
		log.info(daddress+" is same address as filled at the time of registration");

        String daddress2= driver.findElement(By.xpath("//*[@id='address_delivery']/li[5]")).getText();
        assertEquals(daddress2, address2);
		log.info(daddress2+" is same address 2 as filled at the time of registration");

        String dstatecitypin= driver.findElement(By.xpath("//*[@id='address_delivery']/li[6]")).getText();
        assertEquals(dstatecitypin, city + " " + state + " " +zipcode);
		log.info(dstatecitypin+" is same city as filled at the time of registration");

        String dcountry= driver.findElement(By.xpath("//*[@id='address_delivery']/li[7]")).getText();
        assertEquals(dcountry, "Canada");
		log.info(dcountry+" is same country as filled at the time of registration");

        String dmobilenumber= driver.findElement(By.xpath("//*[@id='address_delivery']/li[8]")).getText();
        assertEquals(dmobilenumber, mobilenumber);
		log.info(dmobilenumber+" is same mobile number as filled at the time of registration");

//13. Verify that the billing address is same address filled at the time registration of account

        String bfirstandlastname= driver.findElement(By.xpath("//*[@id='address_invoice']/li[2]")).getText();
        assertEquals(bfirstandlastname, "Mrs. "+firstname +" "+ lastname);
		log.info(bfirstandlastname+" is same first and last name as filled at the time of registration");
        
        String bcompany= driver.findElement(By.xpath("//*[@id='address_invoice']/li[3]")).getText();
        assertEquals(bcompany, company);
		log.info(bcompany+" is same company as filled at the time of registration");
		
        String baddress= driver.findElement(By.xpath("//*[@id='address_invoice']/li[4]")).getText();
        assertEquals(baddress, address);
		log.info(baddress+" is same address as filled at the time of registration");

        String baddress2= driver.findElement(By.xpath("//*[@id='address_invoice']/li[5]")).getText();
        assertEquals(baddress2, address2);
		log.info(baddress2+" is same address 2 as filled at the time of registration");

        String bstatecitypin= driver.findElement(By.xpath("//*[@id='address_invoice']/li[6]")).getText();
        assertEquals(bstatecitypin, city + " " + state + " " +zipcode);
		log.info(bstatecitypin+" is same city as filled at the time of registration");

        String bcountry= driver.findElement(By.xpath("//*[@id='address_invoice']/li[7]")).getText();
        assertEquals(bcountry, "Canada");
		log.info(bcountry+" is same country as filled at the time of registration");

        String bmobilenumber= driver.findElement(By.xpath("//*[@id='address_invoice']/li[8]")).getText();
        assertEquals(bmobilenumber, mobilenumber);
		log.info(bmobilenumber+" is same mobile number as filled at the time of registration");
		
//Delete Account		

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
