package org.amazon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.test.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Amazon extends BaseClass{
	@BeforeClass
	private void beforeClass() {
		browserLaunch("Chrome");
		implicityWait(10);
		maximize();
	}
	@AfterClass
	private void afterClass() {
		quit();
	}
	@BeforeMethod
	public void before() {
		java.util.Date d=new java.util.Date();
		System.out.println("Before Date "+d);
	}
	@AfterMethod
	public void after() {
		java.util.Date d=new java.util.Date();
		System.out.println("Before Date "+d);
	}
	@Test
	private void test1() {
		org.pages.Amazon a=new org.pages.Amazon();
		launchUrl("https://www.amazon.in/");
		sendKeys(a.getSearchBox(), "iPhone");
		click(a.getSearchBtn());
		List<String> l1=new ArrayList<String>();
		for (int i = 0; i < a.getIphone().size();i++) {
			String txt1 = a.getIphone().get(i).getText();
			l1.add(txt1);	
		}			
		System.out.println(l1);	
	    List<Integer> l2=new ArrayList<Integer>();
		for (int i = 0; i < a.getPrices().size();i++) {
			String txt2 = a.getPrices().get(i).getText();
			String r = txt2.replace(",", "");
			int h = Integer.parseInt(r);
			l2.add(h);				
		}	
			System.out.println(l2);
			Map<String, Integer> m=new TreeMap<String, Integer>();
			for (int i = 0; i < l2.size(); i++) {
			m.put(l1.get(i), l2.get(i));
			}
	Set<Entry<String, Integer>> s = m.entrySet();
	for (Entry<String, Integer> x : s) {
		System.out.println(x);				
	}
	Collections.sort(l2);
	System.out.println(l2);	
	System.out.println(Collections.max(l2));
	System.out.println(Collections.min(l2));
	}
}			

//	public static void main(String[] args) {
//		browserLaunch("Chrome");
//		launchUrl("https://www.amazon.in/");
//		implicityWait(10);
//		maximize();
	
//		for (int i = 0; i < iPhones.size(); i++) {
//		for (int j = 0; j < prices.size(); j++) {	
//			if (i==j) {
//				String txt1 = iPhones.get(i).getText();
//				String txt2 = prices.get(j).getText();
//				String r = txt2.replace(",", "");
//			//	System.out.println(r);
//				Integer a=Integer.parseInt(r); 
//				Map<String, Integer> m=new TreeMap<String, Integer>();
//				
//					m.put(txt1, a);
//					Set<Entry<String, Integer>> s = m.entrySet();
//					System.out.println(s);		
//		}			
//		}
//		}
	