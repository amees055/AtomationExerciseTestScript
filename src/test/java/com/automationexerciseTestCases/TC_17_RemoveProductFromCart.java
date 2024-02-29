package com.automationexerciseTestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_17_RemoveProductFromCart extends BaseClass{
	@Test
	public void removeproducfromcart() throws IOException, InterruptedException {
		driver.get(baseURl);
		
		if(driver.getTitle().equals("Automation Exercise"))
		{
			Assert.assertTrue(true);
			log.info("homePage is verified successfully!");
		}
		else
		{
			Assert.assertTrue(false);
			captureScreen(driver, "removeproducfromcart");
		}
		
		//add product to the cart
		 driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a//u[text()='View Cart']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[@class='cart_quantity_delete']")).click();
			

	        String expectedText5 = "Cart is empty! Click here to buy products.";
	        By elementLocator5 = By.xpath("//*[@id=\"empty_cart\"]/p"); 

	        WebElement element5 = driver.findElement(elementLocator5);

	        String actualText5 = element5.getText();
	        
	        if (actualText5.equals(expectedText5)) {
	        	log.info("Cart is empty");
	         
	        } else {
	        	captureScreen(driver, "removeproducfromcart");
	            System.out.println("Text on the  screen does not match the expected text.");
	        }
			
			
	}

}
