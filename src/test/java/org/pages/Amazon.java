package org.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.BaseClass;

public class Amazon extends BaseClass{
	public Amazon() {
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//input[@id=\"twotabsearchtextbox\"]")
	private WebElement searchBox ;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement searchBtn ;
	
	@FindBy(xpath="//*[@class=\"a-size-mini a-spacing-none a-color-base s-line-clamp-2\"]")
	private List<WebElement> iphone ;
	
	@FindBy(xpath="//span[@class=\"a-price-whole\"]")
	private List<WebElement> prices ;

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public List<WebElement> getIphone() {
		return iphone;
	}

	public List<WebElement> getPrices() {
		return prices;
	}
	
	
	
	
	
	
	
	
	

}
