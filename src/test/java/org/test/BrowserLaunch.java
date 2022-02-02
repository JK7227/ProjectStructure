package org.test;


import java.io.IOException;


import org.pages.LoginPage;

public class BrowserLaunch extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		browserLaunch("Chrome");
		launchUrl("https://www.facebook.com");
		implicityWait(10);
		
		LoginPage l=new LoginPage();
		
		jsSet("Jothikrishna", l.getTxtUserName());
		System.out.println(jsGet(l.getTxtUserName()));
	//	click(l.getClick()); 
	
		
}
}
