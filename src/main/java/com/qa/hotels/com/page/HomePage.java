package com.qa.hotels.com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.com.base.BasePage;
import com.qa.hotels.com.util.ElementUtil;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	// Locators: 
	By destinations= By.id("qf-0q-destination");
	By checkin= By.id("qf-0q-localised-check-in");
	By checkout= By.id("qf-0q-localised-check-out");
	By children= By.id("qf-0q-room-0-children");
	By child1= By.id("qf-0q-room-0-child-0-age");
	By child2= By.id("qf-0q-room-0-child-1-age");
	By close=By.xpath("//*[@class='cta widget-overlay-close']");
	By search= By.xpath("//*[@class='cta cta-strong']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public String getHomePageTitle() {
		return elementUtil.doGetPageTitle();
	}
	
	public HotelsPage whereTo() {
	//elementUtil.doClick(close);
	elementUtil.doSendKeys(destinations, "Boston, Massachusetts, United States of America");
	elementUtil.doSendKeys(checkin, "09/08/20");
	elementUtil.doSendKeys(checkout, "09/10/20");

	WebElement element1= elementUtil.getElement(children);
	elementUtil.Select(element1, "2");
	
	WebElement childone= elementUtil.getElement(child1);
	elementUtil.Select(childone, "4");
	
	WebElement childtwo=elementUtil.getElement(child2);
	elementUtil.Select(childtwo, "9");
	elementUtil.doClick(search);
		
		return new HotelsPage(driver);
	}
	
	
	
}
