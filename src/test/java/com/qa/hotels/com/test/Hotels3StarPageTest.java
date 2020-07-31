package com.qa.hotels.com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.com.base.BasePage;
import com.qa.hotels.com.page.HomePage;
import com.qa.hotels.com.page.Hotels3Star;
import com.qa.hotels.com.page.HotelsPage;

public class Hotels3StarPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	HotelsPage hotelsPage;
	Hotels3Star hotel3star;
	
	
	@BeforeTest
	public void SetUp() {
		basePage = new BasePage();
		prop=basePage.init_properties();
		String browserName= prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		homePage= new HomePage(driver);
		hotel3star=new Hotels3Star(driver);
		hotelsPage= new HotelsPage(driver);
		hotelsPage=homePage.whereTo();
		}
	
	@Test(priority=1)
	
	public void choosingStar() {
		hotel3star.choosingStar();
		
		
	}
	@Test(priority=2)
	public void landmar() throws InterruptedException {
		hotel3star.landmarks();
	}
	
	@Test(priority=3)
	
	public void PageDown() throws InterruptedException {
		Thread.sleep(7000);
		hotel3star.goDown();
		
	}
	@Test(priority=4)
	
	public void threeStarHotels() {
		
		hotel3star.findinghotels();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}

}
