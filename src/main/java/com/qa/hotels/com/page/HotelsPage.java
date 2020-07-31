package com.qa.hotels.com.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.com.base.BasePage;
import com.qa.hotels.com.util.ElementUtil;
import com.qa.hotels.com.util.JavaScriptUtil;



public class HotelsPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	
	
	By threeStar= By.id("f-star-rating-3");
	//By otel= By.xpath("//a[contains(text(), 'Hilton Garden Inn Boston/Waltham' )]");
	
	public HotelsPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		javaScriptUtil= new JavaScriptUtil();
		
		}
	public void choosingStar() {
		elementUtil.doClick(threeStar);
		
	}
	public String getTitle() {
		return elementUtil.doGetPageTitle();
	}
	public void goDown() throws InterruptedException {
	for(int j=0 ;j<=60; j++) {

//		if(j >= 60) {
//			break;
//		}
		javaScriptUtil.scrollDownPage(driver, 1000);
		Thread.sleep(2000);
		}
	}
	
	public void findingHilton() {
	List<WebElement> linklist =driver.findElements(By.className("property-name-link")); // tag name provides links 
	
	System.out.println("Total links are : "+ linklist.size());
	
	
	for(int i= 0 ; i<linklist.size(); i++){
		
		String text= linklist.get(i).getText();
		System.out.println(text);
	if (text.contains("Hilton")) {
		System.out.println("Yes, there are Hilton in 3 star hotels");
		break;
	}	
//	else {System.out.println("No, there is no any Hilton in 3 star hotels");
//		
//	}

//	if (text.equals("Hilton")) {
//		System.out.println("Yes, there are Hilton in 3 star hotels");
//		break;
//		
//	}
//	else {
//		System.out.println("No, there is no any Hilton in 3 star hotels");
//		break;
//	}
	}
	
	
	}
	
	

	}
	
	
	


