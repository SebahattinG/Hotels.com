package com.qa.hotels.com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.com.base.BasePage;
import com.qa.hotels.com.page.HomePage;
import com.qa.hotels.com.page.Hotels4Star;
import com.qa.hotels.com.page.HotelsPage;

public class Hotels4StarPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	HotelsPage hotelsPage;
	Hotels4Star hotels4star;
	
	
	@BeforeTest
	public void SetUp() {
		basePage = new BasePage();
		prop=basePage.init_properties();
		String browserName= prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		homePage= new HomePage(driver);
		hotels4star=new Hotels4Star(driver);
		hotelsPage= new HotelsPage(driver);
		hotelsPage=homePage.whereTo();
		}
	
	@Test(priority=1)
	
	public void choosingStar() {
		hotels4star.choosingStar();
		
		
	}
	@Test(priority=2)
	public void landmark() throws InterruptedException {
		
		hotels4star.landmarks();
	}
	@Test(priority=3)
	public void down() throws InterruptedException {
		
		hotels4star.goDown();
	}
	
	@Test(priority=4)
	
	public void fourStarHotels() {
		
		hotels4star.findinghotels();
		
		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}

}
