package org.test;

import org.flipkart.pages.Flipkart;

public class FlipkartTest extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		browserLaunch("Edge");
		maximize();
		implicityWait(10);
		launchUrl("https://www.flipkart.com/");
		
		Flipkart f=new Flipkart();
		click(f.getClosebtn());
		sendKeys(f.getSearchbtn(), "Nike");
		click(f.getClicksearchbtn());
		click(f.getNikeshoe());
		System.out.println(f.getWindowsHandles());
		Thread.sleep(3000);
		click(f.getAddtocart());
		
	}
}
