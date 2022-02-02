package org.flipkart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.test.BaseClass;

public class Flipkart extends BaseClass {
	public Flipkart() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement closebtn;
	@FindBy(name="q")
	private WebElement searchbtn;
	@FindBy(className="L0Z3Pu")
	private WebElement clicksearchbtn;
	@FindBy(xpath="(//a[@class='IRpwTa'])[2]")
	private WebElement nikeshoe;
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addtocart;
	public WebElement getClosebtn() {
		return closebtn;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public WebElement getClicksearchbtn() {
		return clicksearchbtn;
	}
	public WebElement getNikeshoe() {
		return nikeshoe;
	}
	public WebElement getAddtocart() {
		return addtocart;
	}
	
	

}
