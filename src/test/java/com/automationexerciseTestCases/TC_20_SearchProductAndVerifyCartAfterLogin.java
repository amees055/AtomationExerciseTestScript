package com.automationexerciseTestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automationexercisePageObjects.LoginPage;

public class TC_20_SearchProductAndVerifyCartAfterLogin extends BaseClass{
	@Test
	public void searchproductandverifycart() throws IOException, InterruptedException {
		driver.get(baseURl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		Thread.sleep(2000);
		
		//verify text logic1 
		String allproduct= driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
		assertEquals(allproduct, "ALL PRODUCTS");
		log.info(allproduct+" text is visible");
		
		//verify text logic2
		/*String expectedtext="ALL PRODUCTS";
		By locator = By.xpath("//h2[@class='title text-center']");
		
		WebElement element= driver.findElement(locator);
		
		String actualtext= element.getText();
		
		if(expectedtext.equals(actualtext))
		{
			log.info("All Product is visible on screen");
		}
		else
		{
			log.info("all prodcut tect is not visible on screen");
			captureScreen(driver, "searchproductandverifycart");
		}
		*/
		
		/*driver.findElement(By.id("search_product")).sendKeys("tshirt");
		driver.findElement(By.id("submit_search")).click(); 
		
		String searchproduct= driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
		assertEquals(searchproduct, "SEARCHED PRODUCTS");
		log.info(searchproduct+ " text is visible");
		
		

       
		By productlocator= By.xpath("//div[@class='single-products']");
		List<WebElement> products= driver.findElements(productlocator);
		for(WebElement product: products) {
			if(product.isDisplayed());
				           
                log.info("product is  displayed: " +product.getText());
    	        Thread.sleep(2000);
		 }
	       */
		
		//By addToCartLocator = By.xpath("//a[@data-product-id]");

        // Loop to add 5 products to the cart
        for (int i = 1; i <= 5; i++) {
            // Construct the locator for the current product
            String productLocator = " //a[@data-product-id='"+ i +"']"; // Example locator for product, adjust as per your HTML
         
            // Find the "Add to Cart" button for the current product and click on it
            WebElement addToCartButton = driver.findElement(By.xpath(productLocator));
            addToCartButton.click();
	        Thread.sleep(3000);
	        
            driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
	        Thread.sleep(3000);
	        

		}
	       driver.findElement(By.xpath("//a[@href=\"/view_cart\"]")).click();
	       
	       
	       //login
	       
	       driver.findElement(By.xpath("//a[@href='/login']")).click();
			LoginPage lp= new LoginPage(driver);

			lp.setUserName(username);
			log.info("Username is Entered");

			lp.SetPassword(password);
			log.info("password is Entered");

			lp.Clicksubmit();
			
			log.info("SignIn Successful");
			
			
		       driver.findElement(By.xpath("//a[@href=\"/view_cart\"]")).click();
		       


	}

	       

}

