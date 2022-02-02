package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.BaseClass;

public class HotelPom extends BaseClass {
	public HotelPom() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private static WebElement username;
	@FindBy(id="password")
	private static WebElement pass;
	@FindBy(id="login")
	private static WebElement login;
	
	public static WebElement getUsername() {
		return username;
	}
	public static WebElement getPass() {
		return pass;
	}
	public static WebElement getLogin() {
		return login;
	}
	
	public static void login(String name, String pass) {
	sendKeys(getUsername(), name);
	sendKeys(getPass(), pass);
	click(getLogin());
	}
	
	
	
}
