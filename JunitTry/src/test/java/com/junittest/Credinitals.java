package com.junittest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Credinitals {

	public static String properties(String data) throws IOException {
		File file = new File("C:\\Users\\Yuvaraj\\eclipse-workspace\\JunitTry\\src\\test\\resources\\ExcelData.properties");
		FileInputStream fileconn = new FileInputStream(file);
		Properties pro = new Properties();
		pro.load(fileconn);
		String proData = pro.getProperty(data);
		return proData;
	}
	public static void drop_Down_Select(WebElement element,int index) {
		Select sc= new Select(element);
		sc.selectByIndex(index);
	}
}
