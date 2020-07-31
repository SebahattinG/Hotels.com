
package com.qa.hotels.com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.com.base.BasePage;
import com.qa.hotels.com.page.HomePage;
import com.qa.hotels.com.page.Hotels5Star;
import com.qa.hotels.com.page.HotelsPage;

public class Hotels5StarPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	HotelsPage hotelsPage;
	Hotels5Star hotels5star;
	
	
	@BeforeTest
	public void SetUp() {
		basePage = new BasePage();
		prop=basePage.init_properties();
		String browserName= prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		homePage= new HomePage(driver);
		hotels5star=new Hotels5Star(driver);
		hotelsPage= new HotelsPage(driver);
		hotelsPage=homePage.whereTo();
		}
	
	@Test(priority=1)
	
	public void choosingStar() {
		hotels5star.choosingStar();
		
		
	}
	@Test(priority=2)
	public void landmark() throws InterruptedException {
		
		hotels5star.landmarks();
	}
	
	@Test(priority=3, enabled=true)
	
	public void PageDown() throws InterruptedException {
		hotels5star.goDown();
		
	}
	@Test(priority=4)
	
	public void fiveStarHotels() {
		
		hotels5star.findinghotels();

	}
	
	
	
	@AfterTest(enabled=false)
	public void tearDown() {
		driver.close();
		
	}

}
