package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Testing extends BaseClass{
	public static void main(String[] args) throws InterruptedException, AWTException  {
		browserLaunch("Chrome");
		launchUrl("http://todomvc.com/examples/angularjs/#/");
		maximize();
		implicityWait(10);
	
		Robot r=new Robot();
		
		WebElement Listbox = driver.findElement(By.xpath("//input[@ng-model='newTodo']"));
		sendKeys(Listbox, "Hi");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		sendKeys(Listbox, "Hello");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		sendKeys(Listbox, "Whats up");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement check1 = driver.findElement(By.xpath("//label[@class='ng-binding']"));
		Thread.sleep(3000);

		WebElement check2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		click(check2);

		WebElement check3 = driver.findElement(By.xpath("//button[@class='destroy']"));
		click(check3);

		Thread.sleep(3000);
		WebElement check4 = driver.findElement(By.xpath("//a[text()='Completed']"));
//		clickAction(check4);
		click(check4);
		getText(check4);
		Thread.sleep(3000);
		quit();


	}		   
}
