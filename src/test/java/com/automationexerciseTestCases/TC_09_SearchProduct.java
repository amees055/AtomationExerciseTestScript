package com.automationexerciseTestCases;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_09_SearchProduct extends BaseClass{
	@Test
	public void searchproduct() throws IOException, InterruptedException
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
			captureScreen(driver, "productdetailpage");
			Assert.assertTrue(false);
		} 
	driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click(); //click on product button
	
	if(driver.getTitle().equals("Automation Exercise - All Products"))
	{
		Assert.assertTrue(true);
		log.info("Homepage is visible successfully");
	}
	else
	{
		captureScreen(driver, "searchproduct");
		Assert.assertTrue(false);
	}
	
	driver.findElement(By.xpath("//*[@id=\"search_product\"]")).sendKeys("top");
	driver.findElement(By.xpath("//*[@id=\"submit_search\"]")).click();
	Thread.sleep(2000);
	
	 By productLocator = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]");
	 List<WebElement> productElements = driver.findElements(productLocator);
	 for (WebElement productElement : productElements) {
         Assert.assertTrue(productElement.isDisplayed(), "Product is not visible.");
     }
	
	}
}