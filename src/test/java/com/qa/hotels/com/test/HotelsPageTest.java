package com.qa.hotels.com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.com.base.BasePage;
import com.qa.hotels.com.page.HomePage;
import com.qa.hotels.com.page.HotelsPage;

public class HotelsPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	HotelsPage hotelpage;
	
	
	@BeforeTest
	public void SetUp() {
		basePage = new BasePage();
		prop=basePage.init_properties();
		String browserName= prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		homePage= new HomePage(driver);
		hotelpage= new HotelsPage(driver);
		hotelpage=homePage.whereTo();
		}
	
	@Test(priority=1)
	
	public void choosingStar() {
		hotelpage.choosingStar();
		
		
	}
	
	@Test(priority=2)
	
	public void PageDown() throws InterruptedException {
		Thread.sleep(5000);
		hotelpage.goDown();
		
	}
	@Test(priority=3)
	
	public void checkingHilton() {
		
		hotelpage.findingHilton();
		
		
	}
	
	
	
	@AfterTest(enabled=true)
	public void tearDown() {
		driver.close();
		
	}

}
