package com.automationexerciseTestCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_21_AddReviewOnProduct extends BaseClass{
	@Test
	public void addreviewonproduct() {
		driver.get(baseURl);
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		
		String allproduct= driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
		assertEquals(allproduct, "ALL PRODUCTS");
		log.info(allproduct+" text is visible");
		driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
		driver.findElement(By.id("name")).sendKeys("xyz");
		driver.findElement(By.id("email")).sendKeys("amees@mail.com");
		driver.findElement(By.id("review")).sendKeys("ajgfhsgfjsfgjdgfdjhfgsjfdgsjdfgs jfdakjasdgfskjfdggf");
		driver.findElement(By.id("button-review")).click();
		
		
		/*String successmessage= driver.findElement(By.xpath("")).getText();
		assertEquals(successmessage, "Thank you for your review");
		log.info(successmessage+" text is visible");*/
		
	}

}
