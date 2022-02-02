package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.BaseClass;

public class HotelPom1 extends BaseClass{
	public HotelPom1() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="location")
	private static WebElement location;
	@FindBy(id="hotels")
	private static WebElement hotel;
	@FindBy(id="room_type")
	private static WebElement room;
	@FindBy(id="room_nos")
	private static WebElement roomcount;
	@FindBy(id="datepick_in")
	private static WebElement checkin;
	@FindBy(id="datepick_out")
	private static WebElement checkout;
	@FindBy(id="adult_room")
	private static WebElement adultsperroom;
	@FindBy(id="child_room")
	private static WebElement childperroom;
	@FindBy(id="Submit")
	private static WebElement search;
	public static WebElement getLocation() {
		return location;
	}
	public static WebElement getHotel() {
		return hotel;
	}
	public static WebElement getRoom() {
		return room;
	}
	public static WebElement getRoomcount() {
		return roomcount;
	}
	public static WebElement getCheckin() {
		return checkin;
	}
	public static WebElement getCheckout() {
		return checkout;
	}
	public static WebElement getAdultsperroom() {
		return adultsperroom;
	}
	public static WebElement getChildperroom() {
		return childperroom;
	}
	public static WebElement getSearch() {
		return search;
	}

	public static void selection(int l,int h, int r,int rc,String datein,String dateout,int adults,int child ) {
		selectByIndex(getLocation(), l);
		selectByIndex(getHotel(), h);
		selectByIndex(getRoom(), r);
		selectByIndex(getRoomcount(), rc);
		sendKeys(getCheckin(), datein);
		sendKeys(getCheckout(), dateout);
		selectByIndex(getAdultsperroom(), adults);
		selectByIndex(getChildperroom(), child);
		click(getSearch());
	}
}
