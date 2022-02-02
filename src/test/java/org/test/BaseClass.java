package org.test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public static WebDriver driver;
	public static WebDriver browserLaunch(String BrowserName) {
		if (BrowserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if (BrowserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if (BrowserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}else if (BrowserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		return driver;
	}
	public static void launchUrl(String Url) {
		driver.get(Url);
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public static void implicityWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	public static void close() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	public static String getCurrentUrl() {
	  return driver.getCurrentUrl();
	}
	public static String getTitle() {
		return driver.getTitle();
	}
	public static String getWindowsHandle() {
		return driver.getWindowHandle(); 	
	}
	public static Set<String> getWindowsHandles() {
		Set<String> allIds = driver.getWindowHandles();
		int count= 0;
		for (String eachid : allIds) {
			if (count==1) {
				driver.switchTo().window(eachid);
			}	
		}
		return allIds;
	}
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public static void navigateBack() {
		driver.navigate().back();
	}
	public static void navigateForward() {
		driver.navigate().forward();
	}
	public static void navigateRefresh() {
		driver.navigate().refresh();
	}
	
    //WebElement
	
	public static void sendKeys(WebElement e, String value ) {
		e.sendKeys(value);
	}
	public static void click(WebElement e) {
		e.click();
	}
//	public static void click(List<WebElement> e) {
//		((WebElement) e).click();
//	}
	public static void clear(WebElement e) {
		e.clear();
	}
	public static String getAttribute(WebElement e) {
		String text = e.getAttribute("value");
		return text ;
	}
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	public static Boolean isDisplayed(WebElement e) {
		boolean displayed = e.isDisplayed();
		return displayed;	
	}
	public static Boolean isEnabled(WebElement e) {
		return e.isEnabled();	
	}
	public static Boolean isSelected(WebElement e) {
		return e.isSelected();	
	}
	
	
	//Alert
    public static String switchToAlert(String Warning) {
			String s=null;
			if (Warning.equalsIgnoreCase("Accept")) {
				Alert a = driver.switchTo().alert();
				 s = a.getText();
				a.accept();
			}else if (Warning.equalsIgnoreCase("Dismiss")) {
				Alert a = driver.switchTo().alert();
				 s = a.getText();
				a.dismiss();
			}
			return s;
			
		}

		//need to do using Sendkeys in alert

	//Actions
	public static void moveToElement(WebElement e) {
	  Actions  a=new Actions(driver);
		a.moveToElement(e).perform();	
    }
	public static void dragAndDrop(WebElement e1,WebElement e2) {
		Actions  a=new Actions(driver);
		a.dragAndDrop(e1, e2).perform();
	}
	public static void doubleClick(WebElement e) {
		Actions  a=new Actions(driver);
		a.doubleClick().perform();
	}
	public static void contextClick(WebElement e) {
		Actions  a=new Actions(driver);
		a.contextClick().perform();
	}
	public static void clickAction(WebElement e) {
		Actions  a=new Actions(driver);
		a.click().perform();
	}
	public static void clickAndHold(WebElement e) {
		Actions  a=new Actions(driver);
		a.clickAndHold().perform();
	}

	//Drop Down
	public static Select s;
	public static boolean isMultiple(WebElement e) {
	    s=new Select(e);
		return s.isMultiple();	
	}
	public static void selectByIndex(WebElement e, int index) {
		s=new Select(e);
		s.selectByIndex(index);
	}
	public static void selectByVisibleText(WebElement e, String name) {
	    s=new Select(e);
		s.selectByVisibleText(name);
	}	
	public static void selectByValue(WebElement e, String value ) {
		s=new Select(e);
		s.selectByValue(value);
	}
	public static void deselectByIndex(WebElement e, int index) {
		s=new Select(e);
		s.deselectByIndex(index);
	}
	public static void deselectByVisibleText(WebElement e, String name) {
	    s=new Select(e);
		s.deselectByVisibleText(name);
	}	
	public static void deselectByValue(WebElement e, String value ) {
		s=new Select(e);
		s.deselectByValue(value);
	}
	public static void deselectAll(WebElement e) {
		s=new Select(e);
		s.deselectAll();
	}
	public static void getFirstSelectedOptions(WebElement e) {
		s=new Select(e);
		s.getFirstSelectedOption();
	}
//	public static Set<String> getOptions(WebElement e) {
//		s=new Select(e);
//		String text=null;
//		List<WebElement> options = s.getOptions();
//		for (int i = 0; i < options.size(); i++) {
//			WebElement op = options.get(i);
//			text = op.getText();
//		}
//		return text ;	
//	}
	

	//Screenshot
	public static  File screenshot(String name) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des=new File("D:\\\\java project\\\\MavenProject\\\\Screenshot\\\\Screenshot"+name+".png");
		FileUtils.copyFile(src, des);
		return des;
	}
	
	//JavaScriptExecutor
	public static void jsSet(String name, WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+name+"')",e);
	}
	public static String jsGet(WebElement e) {
		String txt=null;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Object obj = js.executeScript("return arguments[0].getAttribute('value')",e);
		txt = obj.toString();
		return txt;
	}
	public static void jsClick(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click",e);
	}
	public static void jsScrollDown(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",e);
	}
	public static void jsScrollUp(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)",e);
	}
	
	//Robot
//	public static void keyPressAndRelease() throws AWTException {
//		Robot r=new Robot();
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyRelease(KeyEvent.VK_DOWN);
//	}
	
	
}
