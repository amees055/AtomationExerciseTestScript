package com.automationexerciseTestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.automationexerciseUtilities.ReadConfig;


public class BaseClass {
	//ReadConfig object created to call methods from ReadConfig calss
	ReadConfig readconfig= new ReadConfig();
	
	//without readconfig
//public String baseURl= "https://automationexercise.com/login";
	
public String baseURl= readconfig.getApplicationURL();
//public String username="seema.c@boppotechnologies.com";

public String username=readconfig.getUsername();
//public String password= "seema@1234";

public String password= readconfig.getPassword();

public String signuplogin= readconfig.getsignuplogin();
public String name= readconfig.getname();
public String email= readconfig.getemail();
public String submit= readconfig.getsubmit();
public String setpassword= readconfig.getsetpassword();
public String firstname=readconfig.getFirstName();
public String lastname= readconfig.getLastName();
public String company=readconfig.getCompany();
public String address= readconfig.getAddress();
public String address2= readconfig.getAddress2();
public String state= readconfig.getState();
public String city= readconfig.getCity();
public String zipcode= readconfig.getZipcode();
public String mobilenumber= readconfig.getMobilenumber();



public static WebDriver driver;
//here we have put logger as public to access it in other class
public static Logger log;

@Parameters("browser")
@BeforeClass
public void setup(String br)
{

	//logger configuration
	log =Logger.getLogger("Automationtesting");
	PropertyConfigurator.configure("Log4j.properties");
	
	
	//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	//driver = new ChromeDriver();
	
	if(br.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver",readconfig.getChromeDriver());
	driver = new ChromeDriver();
	}
	else if(br.equals("IE"))
	{
		System.setProperty("webdriver.IE.driver",readconfig.getIEDriver());
		driver = new InternetExplorerDriver();
	}
	else if(br.equals("edge"))
	{
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//Drivers//msedgedriver.exe");
		driver = new EdgeDriver();
		log.info("Edge Browser Launched successfully");
	}
	else if(br.equals("firefox"))
	{
		System.setProperty("webdriver.firefox.driver",readconfig.getFireFoxDriver());
		driver = new FirefoxDriver();
	}
}

@AfterClass
public void tearDown()
{
	driver.quit();
	}
public void captureScreen(WebDriver driver, String tname) throws IOException{
	TakesScreenshot ts =(TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir")+"/Screenshots/" +tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot Taken");
}
}
