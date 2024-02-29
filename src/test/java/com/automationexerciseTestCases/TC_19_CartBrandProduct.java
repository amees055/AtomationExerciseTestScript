package com.automationexerciseTestCases;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_19_CartBrandProduct extends BaseClass{
	@Test
	public void cartbrandproduct() throws IOException, InterruptedException {
		driver.get(baseURl);
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		Thread.sleep(3000);
		
		String expectedtext="BRANDS";
		By locator= By.xpath("//h2[text()='Brands']");
		
		WebElement element= driver.findElement(locator);
		
		String actualtext = element.getText();
		
		if(actualtext.equals(expectedtext))
		{
			log.info("Brand is visible on left side of bar");
			
		}
		else
		{
			captureScreen(driver, "cartbrandproduct");
			log.info("brand is not visible on screen");
		}
		
	}

}
