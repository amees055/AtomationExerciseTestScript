package com.automationexerciseTestCases;



import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_12_AddProductInCart extends BaseClass{ 	
	@Test
	public void addproductincart() throws InterruptedException, IOException{
		driver.get(baseURl);
		if(driver.getTitle().equals("Automation Exercise"))
		{
			Assert.assertTrue(true);
			log.info("verified!! home page");
		}
		else
		{
			captureScreen(driver, "addproductincart");
		
			Assert.assertTrue(false);
			
		}
		driver.findElement(By.xpath("//a[@data-product-id=\"1\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
		driver.findElement(By.xpath("//a[@data-product-id=\"2\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a//u[text()='View Cart']")).click();
		
		List<WebElement>  firstproduct = driver.findElements(By.id("product-1"));
		List<WebElement>  secondproduct = driver.findElements(By.id("product-2"));
		HashMap<Integer,String> map= new HashMap<Integer, String>();
		map.put(1, "Blue Top");
		map.put(1, "Women > Tops");
		map.put(1, "Rs. 500");
		map.put(1, "1");
		map.put(1, "Rs. 500");
		
		
		map.put(2, "Men Tshirt");
		map.put(2, "Men > Tshirts");
		map.put(2, "Rs. 400");
		map.put(2, "1");
		map.put(2, "Rs. 400");
		
		for(int i=0;i<firstproduct.size();i++) 
		{
			assertTrue(firstproduct.get(i).getText().contains(map.get(1)));
			log.info(map.get(1));
			assertTrue(secondproduct.get(i).getText().contains(map.get(2)));
			log.info(map.get(2));
			
			
		}


	
		
		
		/*WebElement ele = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/img"));
	

		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;  
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a")).click();
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")).click();
	
		 Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[1]/img"));

        

		//Creating object of an Actions class
		Actions action1 = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action1.moveToElement(ele1).perform();
		
		driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a")).click();
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")).click();
		Thread.sleep(3000);
		
*/
		
		 
		
		
		
	 }
	

}
