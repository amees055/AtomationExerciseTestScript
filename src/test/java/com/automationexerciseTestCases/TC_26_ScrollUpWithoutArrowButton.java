package com.automationexerciseTestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_26_ScrollUpWithoutArrowButton extends BaseClass{
@Test
public void scrollupanddown() throws IOException, InterruptedException {
	driver.get(baseURl);

	if(driver.getTitle().equals("Automation Exercise"))
	{
		Assert.assertTrue(true);
		log.info("home page is visible successfully");
	}
	else 
	{
		
		Assert.assertTrue(false);
		captureScreen(driver, "scrollupanddownfunctionality");
		}
	
    JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript("window.scrollBy(0, 11500)");
	Thread.sleep(3000);
	String subscription= driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")).getText();
	assertEquals(subscription, "SUBSCRIPTION");
	log.info(subscription + "text is visible");
	driver.findElement(By.xpath("//*[@id=\"scrollUp\"]")).click();
	Thread.sleep(3000);
	
	js.executeScript("window.scrollTo(0, 0);");
	Thread.sleep(3000);
	String text= driver.findElement(By.xpath("//*[@id='slider-carousel']/div/div[1]/div[1]/h2")).getText();
	org.junit.Assert.assertTrue("Text not found!", text.contains(text));

	//assertEquals(text, "Full-Fledged practice website for Automation Engineers");
	log.info(text + "text is visible");

}
}
