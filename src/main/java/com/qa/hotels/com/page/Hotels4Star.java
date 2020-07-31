package com.qa.hotels.com.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.hotels.com.util.ElementUtil;
import com.qa.hotels.com.util.JavaScriptUtil;

public class Hotels4Star {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	
	
	By fourStar= By.id("f-star-rating-4");
	By landmark= By.xpath("//h3[contains(text(),'Landmarks')]");
	By citycenter= By.id("f-lid-1401516");
	By miles= By.id("f-distance");
	
	
	
	public Hotels4Star(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		javaScriptUtil= new JavaScriptUtil();
		}
	public void choosingStar() {
		elementUtil.doClick(fourStar);
		
	}
	public void landmarks() throws InterruptedException {
		WebElement landmarke=driver.findElement(landmark);
		JavaScriptUtil.clickElementByJS(landmarke, driver);
		Thread.sleep(5000);
		WebElement city= driver.findElement(citycenter);
		JavaScriptUtil.clickElementByJS(city, driver);
		Thread.sleep(5000);
		WebElement element=driver.findElement(miles);
		Select select= new Select(element);
		select.selectByValue("10.0");
		
	}
	public void goDown() throws InterruptedException {
	for(int j=0 ;j<=20; j++) {


		javaScriptUtil.scrollDownPage(driver, 1000);
		Thread.sleep(2000);
		}
	}
	
	public void findinghotels() {
	List<WebElement> linklist =driver.findElements(By.className("property-name-link")); 
	
	System.out.println("Total links are : "+ linklist.size());
	
	
	for(int i= 0 ; i<linklist.size(); i ++){
		
		String text= linklist.get(i).getText();
		System.out.println(text);
	}

	}
	}
	
	


