package com.qa.hotels.com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.com.base.BasePage;
import com.qa.hotels.com.page.HomePage;
import com.qa.hotels.com.util.AppConstants;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	@BeforeTest
	public void SetUp() {
		basePage = new BasePage();
		prop=basePage.init_properties();
		String browserName= prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		homePage=new HomePage(driver);
	
	}
	
	@Test	(priority=1)
	public void verifyHomePageTitle(){
		String title= 	homePage.getHomePageTitle();
			System.out.println(title);
	Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);		
	}
	@Test(priority=2)
	public void destinationChoosing() {
		
		homePage.whereTo();
		
		
	}
	
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
