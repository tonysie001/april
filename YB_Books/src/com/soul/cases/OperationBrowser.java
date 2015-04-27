package com.soul.cases;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.soul.data.Common;

/**
 * 操作浏览器
 * 
 * @author SionInSoul
 * 
 */
public class OperationBrowser {

	// 打开浏览器
	@BeforeMethod
	public void beforeMethod(WebDriver driver) {
		driver.get(Common.BASE_URL);
		driver.manage().window().maximize();
		System.out.println("打开浏览器时间：" + new Date(System.currentTimeMillis()));
	}

	// 退出浏览器
	@AfterMethod
	public void afterMethod(WebDriver driver) {
		System.out.println("关闭浏览器时间：" + new Date(System.currentTimeMillis()));
		driver.quit();
	}
}
