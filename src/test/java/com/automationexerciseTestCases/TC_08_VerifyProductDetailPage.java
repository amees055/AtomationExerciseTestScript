package com.automationexerciseTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_08_VerifyProductDetailPage extends BaseClass {
	@Test
	public void productdetailpage() throws IOException, InterruptedException
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
		captureScreen(driver, "productdetailpage");
		Assert.assertTrue(false);
	}
	
	
	
	driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/ul/li/a")).click(); // click view detail
	
	 By productNameLocator = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2"); //product name
	 WebElement element = driver.findElement(productNameLocator);
	 String elementText = element.getText();
	 System.out.println("Product Name: " + elementText);
	 
     By categoryLocator = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]"); //category
     WebElement element1 = driver.findElement(categoryLocator);
	 String elementText1 = element1.getText();
	 System.out.println(elementText1);
	 
     By priceLocator = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span"); //price
     WebElement element2 = driver.findElement(priceLocator);
	 String elementText2 = element2.getText();
	 System.out.println("Price: " + elementText2);
	 
     By availabilityLocator = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]"); //availability
     WebElement element3 = driver.findElement(availabilityLocator);
	 String elementText3 = element3.getText();
	 System.out.println(elementText3);
	 
     By conditionLocator = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]"); //condition
     WebElement element4 = driver.findElement(conditionLocator);
	 String elementText4 = element4.getText();
	 System.out.println(elementText4);
	 
     By brandLocator = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]"); //brand
     WebElement element5 = driver.findElement(brandLocator);
	 String elementText5 = element5.getText();
	 System.out.println(elementText5);
	


	}
}
