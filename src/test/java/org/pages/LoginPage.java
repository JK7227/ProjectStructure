package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement txtUserName;
	
	@FindBy(id="pass")
	private WebElement txtPass;
	
	@FindBy(name="login")
	private WebElement click;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getClick() {
		return click;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}







