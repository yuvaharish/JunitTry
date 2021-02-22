package com.junittest;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class BaseClass extends Credinitals {
	static WebDriver driver;
	static Properties pro;

	@BeforeClass
	public static void loadUrl() throws IOException {
		System.setProperty("webdriver.chrome.driver", properties("driverLocation"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(properties("Url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void login_Page() throws IOException {
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(properties("userName"));
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(properties("passWord"));
		WebElement login = driver.findElement(By.id("login"));
		login.click();
	}
	@Test
	public void search_Hotel_Page() throws IOException {
		WebElement location = driver.findElement(By.id("location"));
		drop_Down_Select(location, 1);
		WebElement Hotels = driver.findElement(By.id("hotels"));
		drop_Down_Select(Hotels, 1);
		WebElement room = driver.findElement(By.id("room_type"));
		drop_Down_Select(room, 1);
		WebElement check_In_Date = driver.findElement(By.id("datepick_in"));
		check_In_Date.clear();
		check_In_Date.sendKeys(properties("In_Date"));
		WebElement Check_Out_Date = driver.findElement(By.id("datepick_out"));
		Check_Out_Date.clear();
		Check_Out_Date.sendKeys(properties("Out_Date"));
		WebElement adults_Per_Room = driver.findElement(By.id("adult_room"));
		drop_Down_Select(adults_Per_Room, 2);
		WebElement children_Per_Room = driver.findElement(By.id("child_room"));
		drop_Down_Select(children_Per_Room, 1);
		WebElement search_Hotel = driver.findElement(By.id("Submit"));
		search_Hotel.click();
		WebElement Select = driver.findElement(By.id("radiobutton_0"));
		Select.click();
		WebElement book_Hotel = driver.findElement(By.id("continue"));
		book_Hotel.click();
	}
	@Test
	public void book_A_Hotel_Page() throws IOException {
		WebElement firstName = driver.findElement(By.id("first_name"));
		WebElement lastName = driver.findElement(By.id("last_name"));
		WebElement address = driver.findElement(By.id("address"));
		WebElement cardNumber = driver.findElement(By.id("cc_num"));
		WebElement cardType = driver.findElement(By.id("cc_type"));
		WebElement expirDate = driver.findElement(By.id("cc_exp_month"));
		WebElement expirYear = driver.findElement(By.id("cc_exp_year"));
		WebElement cVV = driver.findElement(By.id("cc_cvv"));
		WebElement bookNow = driver.findElement(By.id("book_now"));
		firstName.sendKeys(properties("FirstName"));
		lastName.sendKeys(properties("LastName"));
		address.sendKeys(properties("BillingAddress"));
		cardNumber.sendKeys(properties("Credit_Card_No"));
		drop_Down_Select(cardType, 1);
		drop_Down_Select(expirDate, 2);
		drop_Down_Select(expirYear, 2);
		cVV.sendKeys(properties("CVV_Number"));
		bookNow.click();
		WebElement orderNumber = driver.findElement(By.id("order_no"));
		String confirmationNumber = orderNumber.getAttribute("value");
		System.out.println(confirmationNumber);
	}
	
	
	
}
