package com.automationexerciseUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	//for every variable in property file we have to make specific methods
//1st we have to write properties object we have to create one object for the property  class
	Properties pro;
	
	// then we will create one constructor
	//ReadConfig() is the name of constructor
	public ReadConfig()
	{
		//where my config.properties file is present ./ representing the home directory
		//file is a class
		//src is a file variable
		File src= new File("./Configuration/config.properties");
		try {
			//when you want to read the data we have to open the file in read mode so in that case we user FileInputStream
			FileInputStream fis= new FileInputStream(src);
			//pro.load is a method which will load the complete config.properties file
			pro= new Properties();
			pro.load(fis);
			
		}
		catch (Exception e) {
			//try catch is used for like in case if file is not found then it will show message
			System.out.println("Exception is" + e.getMessage());
		}	
	
		
	}
	//once the properties file is loaded we need to read each and every value by adding a method
			//adding methods for each value different method for each variable
	public String getApplicationURL()
	{
		String url= pro.getProperty("baseURl");
		return url;
	}	
	//It will read and return the value
	public String getUsername()
	{
		String username= pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password= pro.getProperty("password");
		return password;
	}
	//In future if adding config.properties ten we have to create methods for the same
	
	public String getChromeDriver()
	{
		String chromepath= pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getEdgeDriver()
	{
		String edge= pro.getProperty("edge");
		return edge;
	}	
	public String getIEDriver()
	{
		String IE= pro.getProperty("IE");
		return IE;
	}
	public String getFireFoxDriver()
	{
		String firefox= pro.getProperty("firefox");
		return firefox;
	}
	
	public String getsignuplogin()
	{
		String signuplogin= pro.getProperty("signuplogin");
		return signuplogin;
	}
	public String getname()
	{
		String name= pro.getProperty("name");
		return name;
	}
	public String getemail()
	{
		String email= pro.getProperty("email");
		return email;
	}
	public String getsubmit()
	{
		String submit= pro.getProperty("submit");
		return submit;
	}
	public String gettitle()
	{
		String title= pro.getProperty("title");
		return title;
	}
	public String getsetpassword()
	{
		String rpassword= pro.getProperty("setpassword");
		return rpassword;
	}
	public String getFirstName()
	{
		String firstname= pro.getProperty("firstname");
		return firstname;
	}
	
	public String getLastName()
	{
		String lastname= pro.getProperty("lastname");
		return lastname;
	}
	
	public String getCompany()
	{
		String company= pro.getProperty("company");
		return company;
	}
	
	public String getAddress()
	{
		String address= pro.getProperty("address");
		return address;
	}
	
	public String getAddress2()
	{
		String address2= pro.getProperty("address2");
		return address2;
	}
	
	public String getState()
	{
		String state= pro.getProperty("state");
		return state;
	}
	
	public String getCity()
	{
		String city= pro.getProperty("city");
		return city;
	}
	
	public String getZipcode()
	{
		String zipcode= pro.getProperty("zipcode");
		return zipcode;
	}
	
	public String getMobilenumber()
	{
		String mobilenumber= pro.getProperty("mobilenumber");
		return mobilenumber;
	}
	
	
}
