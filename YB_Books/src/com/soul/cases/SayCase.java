package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.soul.entity.YBEntity;

public class SayCase {

	// 此刻想说
	@Test
	public void testCreateSay(WebDriver driver, YBEntity yb) throws Exception {

		System.out.println("======进入testCreateSay()方法=======");
		Thread.sleep(2000);
		// 点击接下去的打算？
		driver.findElement(By.linkText("接下去的打算？")).click();
		System.out.println(driver.findElement(By.linkText("接下去的打算？")));

		try {
			testCreateMySay(driver);
		} catch (Exception e) {

			// 刷新页面
			driver.navigate().refresh();
			Thread.sleep(1000);
			// 点击接下去的打算？
			driver.findElement(By.linkText("接下去的打算？")).click();
			testCreateMySay(driver);
		}

		// 向文本框输入信息
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSayone());
		testCreateSayButton(driver);

		driver.findElement(By.linkText("结束语")).click();
		System.out.println(driver.findElement(By.linkText("结束语")));

		try {
			testCreateMySay(driver);
		} catch (Exception e) {

			// 刷新页面
			driver.navigate().refresh();
			Thread.sleep(1000);
			// 结束语
			driver.findElement(By.linkText("结束语")).click();
			testCreateMySay(driver);
		}
		// 向文本框输入信息
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSaytwo());
		testCreateSayButton(driver);

		driver.findElement(By.linkText("在这个集体中最值得回忆的？")).click();
		System.out.println(driver.findElement(By.linkText("在这个集体中最值得回忆的？")));

		try {
			testCreateMySay(driver);
		} catch (Exception e) {

			// 刷新页面
			driver.navigate().refresh();
			Thread.sleep(1000);
			// 在这个集体中最值得回忆的？
			driver.findElement(By.linkText("在这个集体中最值得回忆的？")).click();
			testCreateMySay(driver);
		}
		
		// 向文本框输入信息
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSaythree());
		testCreateSayButton(driver);

//		driver.findElement(By.linkText("我碰到的最尴尬可笑的？")).click();
//		System.out.println(driver.findElement(By.linkText("我碰到的最尴尬可笑的？")));
//
//		try {
//			testCreateMySay(driver);
//		} catch (Exception e) {
//
//			// 刷新页面
//			driver.navigate().refresh();
//			Thread.sleep(1000);
//			//我碰到的最尴尬可笑的？
//			driver.findElement(By.linkText("我碰到的最尴尬可笑的？")).click();
//			testCreateMySay(driver);
//		}
//		
//		// 向文本框输入信息
//		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
//				.sendKeys(yb.getSayfour());
//		testCreateSayButton(driver);
//
//		driver.findElement(By.linkText("曾经影响我的至理名言")).click();
//		System.out.println(driver.findElement(By.linkText("曾经影响我的至理名言")));
//		Thread.sleep(1000);
//
//		try {
//			testCreateMySay(driver);
//		} catch (Exception e) {
//
//			// 刷新页面
//			driver.navigate().refresh();
//			Thread.sleep(1000);
//			//曾经影响我的至理名言
//			driver.findElement(By.linkText("曾经影响我的至理名言")).click();
//			testCreateMySay(driver);
//		}
//		
//		// 向文本框输入信息
//		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
//				.sendKeys(yb.getSayfive());
//		testCreateSayButton(driver);
	}

	@Test
	public void testCreateMySay(WebDriver driver) {
		try {
			Thread.sleep(1000);
			// 点击我也说
			driver.findElement(By.linkText("我也说")).click();
			Thread.sleep(1000);
			// 清空文本框信息
			driver.findElement(By.cssSelector("textarea.speak.isayinput")).clear();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testCreateSayButton(WebDriver driver) {
		try {
			Thread.sleep(1000);
			// 点击确定
			driver.findElement(By.linkText("确认")).click();
			Thread.sleep(1000);
			// 刷新页面
			driver.navigate().refresh();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
