package com.automationexerciseTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_18_ViewCategoryProduct extends BaseClass {
	@Test
	public void categoryproduct() throws IOException, InterruptedException {
		driver.get(baseURl);

        String expectedText5 = "CATEGORY";
        By elementLocator5 = By.xpath("//div//h2[text()='Category']"); 

        WebElement element5 = driver.findElement(elementLocator5);

        String actualText5 = element5.getText();
        
        if (actualText5.equals(expectedText5)) {
        	log.info("Categories text on left side bar is visible");
         
        } else {
        	captureScreen(driver, "categoryproduct");
            System.out.println("Category text not visible");
        }
        
        //women categories
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a/span")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@href='/category_products/2']")).click();
        
        String expectedText1 = "WOMEN - TOPS PRODUCTS";
        By elementLocator1 = By.xpath("//h2[@class='title text-center']"); 

        WebElement element1 = driver.findElement(elementLocator1);

        String actualText1 = element1.getText();
        
        if (actualText1.equals(expectedText1)) {
        	log.info("WOMEN - TOPS PRODUCTS is visible");
         
        } else {
        	captureScreen(driver, "categoryproduct");
            System.out.println("WOMEN - TOPS PRODUCTS text not visible");
			}
        
        //men categories
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a/span")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@href='/category_products/3']")).click();
        
        String expectedText2 = "MEN - TSHIRTS PRODUCTS";
        By elementLocator2 = By.xpath("//h2[@class='title text-center']"); 

        WebElement element2 = driver.findElement(elementLocator2);

        String actualText2 = element2.getText();
        
        if (actualText2.equals(expectedText2)) {
        	log.info("MEN - TSHIRTS PRODUCTS is visible");
         
        } else {
        	captureScreen(driver, "categoryproduct");
            System.out.println("MEN - TSHIRTS PRODUCTS text not visible");
			}
	
	}
}
