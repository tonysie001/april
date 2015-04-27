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
		testCreateMySay(driver);
		// 向文本框输入信息
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSayone());
		testCreateSayButton(driver);

		driver.findElement(By.linkText("结束语")).click();
		System.out.println(driver.findElement(By.linkText("结束语")));
		testCreateMySay(driver);
		// 向文本框输入信息
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSaytwo());
		testCreateSayButton(driver);

		driver.findElement(By.linkText("在这个集体中最值得回忆的？")).click();
		System.out.println(driver.findElement(By.linkText("在这个集体中最值得回忆的？")));
		testCreateMySay(driver);
		// 向文本框输入信息
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSaythree());
		testCreateSayButton(driver);

		driver.findElement(By.linkText("我碰到的最尴尬可笑的？")).click();
		System.out.println(driver.findElement(By.linkText("我碰到的最尴尬可笑的？")));
		testCreateMySay(driver);
		// 向文本框输入信息
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSayfour());
		testCreateSayButton(driver);

		driver.findElement(By.linkText("曾经影响我的至理名言")).click();
		System.out.println(driver.findElement(By.linkText("曾经影响我的至理名言")));
		testCreateMySay(driver);
		// 向文本框输入信息
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSayfive());
		testCreateSayButton(driver);
	}

	@Test
	public void testCreateMySay(WebDriver driver) throws Exception {
		Thread.sleep(500);
		// 点击我也说
		driver.findElement(By.linkText("我也说")).click();
		Thread.sleep(500);
		// 清空文本框信息
		driver.findElement(By.cssSelector("textarea.speak.isayinput")).clear();
	}

	@Test
	public void testCreateSayButton(WebDriver driver) throws Exception {
		Thread.sleep(500);
		// 点击确定
		driver.findElement(By.linkText("确认")).click();
		Thread.sleep(500);
		// 刷新页面
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
