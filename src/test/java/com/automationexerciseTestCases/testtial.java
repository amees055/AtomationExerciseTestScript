 
package com.automationexerciseTestCases;
import org.testng.annotations.Test;
import java.util.List;
    import java.util.concurrent.TimeUnit;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
    import org.testng.annotations.Test;

    public class testtial {
    static WebDriver driver = new FirefoxDriver();
    @Test
    public void method() {
    driver.get("http://www.myntra.com");
    driver.manage().window().maximize();
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.xpath(".//*[@id='login']/div[2]")).click();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  //  WebDriverWait wait = new WebDriverWait(driver, 20);
   // WebElement ele =wait.until(ExpectedConditions.elementToBeClickable(By.id("q")));
    driver.findElement(By.id("q")).click();
    driver.findElement(By.id("q")).sendKeys("puma");
    driver.findElement(By.className("icon-search")).click();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    WebElement table = driver.findElement(By.className("results-cnt"));// 
    List<WebElement> rows=table.findElements(By.className("product"));
    int count = rows.size();
    for (WebElement items : rows){
    System.out.println(items.getText());
    }

Actions action = new Actions(driver);
WebElement we = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[4]/ul/li[1]"));     
action.moveToElement(we).build().perform();
driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[4]/ul/li[1]/div[1]/span[1]/div[1]")).click();
driver.findElement(By.xpath("*//div[@class='buy-opts']/div[2]/button[1]")).click();

WebElement viewCart = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/a[3]"));
action.moveToElement(viewCart).build().perform();
driver.findElement(By.xpath("html/body/div[1]/div[8]/div[2]/div[3]/a")).click();

  WebElement view = driver.findElement(By.className("prod-name"));
  List<WebElement>selected_Items =view.findElements(By.tagName("a"));       
  for (WebElement sel_items : selected_Items){
  System.out.println(sel_items.getText());
  }
  if(rows.get(0).equals(selected_Items.get(0))){
  System.out.println("EQUALS");
  }else{
  System.err.println("NOT EQUALS");
  }
  }
  }

