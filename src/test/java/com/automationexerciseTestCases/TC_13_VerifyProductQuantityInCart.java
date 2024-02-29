package com.automationexerciseTestCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_13_VerifyProductQuantityInCart extends BaseClass{
	@Test
	public void productquantityincart() throws InterruptedException{
		// Navigate to url 'http://automationexercise.com'
		driver.get(baseURl);
		Thread.sleep(2000);
		String title= driver.getTitle();
		assertEquals(title, "Automation Exercise", "Incorrect Title");
		
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
		driver.findElement(By.xpath("//input[@type='number']")).clear();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("4");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a//u[text()='View Cart']")).click();
		String qty= driver.findElement(By.xpath("//td[@class='cart_quantity']")).getText();
		assertEquals(qty, "4");
		
		
	}

}
