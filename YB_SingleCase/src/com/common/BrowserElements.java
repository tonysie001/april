package com.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BrowserElements {

	Driver d = new Driver();
	WebDriver driver = d.getDriver();
	// 项目URL
	String url = Driver.getPropertyString("BASE_URL");

	/**
	 * 浏览器打开指定url
	 * 
	 * @param url
	 */
	public void openBrowser() {
		System.out.println("进入打开浏览器操作");
		System.out.println(url);
		driver.get(url);
		System.out.println("判断浏览器成功");
		driver.manage().window().maximize();
		// 设置隐式等待
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
