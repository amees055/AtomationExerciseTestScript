package com.automationexercisePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	//constructor
	public LoginPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
@FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
@CacheLookup
WebElement txtusername;

@FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
@CacheLookup
WebElement txtpassword;

@FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/button")
@CacheLookup
WebElement loginbtn;

//signup
@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")
@CacheLookup
WebElement txtname;
@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
@CacheLookup
WebElement txtemail;
@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/button")
@CacheLookup
WebElement submitbtn;

//address information
@FindBy(xpath="//*[@id=\"first_name\"]")
@CacheLookup
WebElement txtfirstname;
@FindBy(xpath="//*[@id=\"last_name\"]")
@CacheLookup
WebElement txtlastname;
@FindBy(xpath="//*[@id=\"company\"]")
@CacheLookup
WebElement txtcompany;
@FindBy(xpath="//*[@id=\"address1\"]")
@CacheLookup
WebElement txtaddress;
@FindBy(xpath="//*[@id=\"address2\"]")
@CacheLookup
WebElement txtaddress2;
@FindBy(xpath="//*[@id=\"state\"]")
@CacheLookup
WebElement txtstate;
@FindBy(xpath="//*[@id=\"city\"]")
@CacheLookup
WebElement txtcity;
@FindBy(xpath="//*[@id=\"zipcode\"]")
@CacheLookup
WebElement txtzipcode;
@FindBy(xpath="//*[@id=\"mobile_number\"]")
@CacheLookup
WebElement txtmobilenumber;




//action method
public void setUserName(String uname)
{
	txtusername.sendKeys(uname);
	
}
public void SetPassword (String Pwd)
{
	txtpassword.sendKeys(Pwd);
}
public void Clicksubmit()
{
	loginbtn.click();
}
public void setName(String uname)
{
	txtname.sendKeys(uname);	
}

public void SetEmail (String Pwd)
{
	txtemail.sendKeys(Pwd);
}
public void clicksignupbtn()
{
	submitbtn.click();
	
}
public void setFirstName(String fname)
{
	txtfirstname.sendKeys(fname);
	
}
public void setLastName(String uname)
{
	txtlastname.sendKeys(uname);
	
}
public void setCompany(String uname)
{
	txtcompany.sendKeys(uname);
	
}
public void setAddress(String uname)
{
	txtaddress.sendKeys(uname);
	
}
public void setAddress2(String uname)
{
	txtaddress2.sendKeys(uname);
	
}
public void setState(String uname)
{
	txtstate.sendKeys(uname);
	
}
public void setCity(String uname)
{
	txtcity.sendKeys(uname);
	
}
public void setZipcode(String uname)
{
	txtzipcode.sendKeys(uname);
	
}
public void setMobilenumber(String uname)
{
	txtmobilenumber.sendKeys(uname);
	
}


}
