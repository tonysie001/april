package com.cases;

import java.util.Date;

import org.testng.annotations.Test;

import com.common.BrowserElements;

public class BrowserCase {

	BrowserElements browser = new BrowserElements();

	// 打开浏览器
	@Test
	public void openBrowser() {
		browser.openBrowser();
		System.out.println("打开浏览器时间：" + new Date(System.currentTimeMillis()));
	}
//	(dependsOnMethods = {"openBrowser"})
	// 退出浏览器
	@Test
	public void closeBrowser() {
		System.out.println("关闭浏览器时间：" + new Date(System.currentTimeMillis()));
		browser.closeBrowser();
	}
}
