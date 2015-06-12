package com.soulinfo.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BrowserElements {

	Driver d = new Driver();
	WebDriver driver = d.getDriver();
	String URL = Driver.getPropertyString("BASE_URL");

	/**
	 * 浏览器打开指定URL
	 * 
	 * @param url
	 */
	public void openBrowser() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * 浏览器退出
	 */
	public void closeBrowser() {
		driver.quit();
	}

	/**
	 * 浏览器刷新
	 */
	public void refresh() {
		driver.navigate().refresh();
	}

	/**
	 * 浏览器后退
	 */
	public void back() {
		driver.navigate().back();
	}

	/**
	 * 浏览器前进
	 */
	public void forward() {
		driver.navigate().forward();
	}
}
