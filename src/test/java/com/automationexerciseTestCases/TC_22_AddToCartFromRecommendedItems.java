package com.automationexerciseTestCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Window;
import org.testng.annotations.Test;

      public class TC_22_AddToCartFromRecommendedItems extends BaseClass{
@Test
       public void addtocartfromrecommendeditems() throws InterruptedException {
	driver.get(baseURl);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	js.executeScript("window.scrollBy(0,10500)", "");
	Thread.sleep(3000);
	
	String recommendeditems= driver.findElement(By.xpath("//h2[text()='recommended items']")).getText();
	assertEquals(recommendeditems, "RECOMMENDED ITEMS");
	log.info(recommendeditems+" text is visible");
	Thread.sleep(3000);

	driver.findElement(By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[1]/div/div/div/a")).click();
	Thread.sleep(3000);

	driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
	driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
	
	
	
}
}
