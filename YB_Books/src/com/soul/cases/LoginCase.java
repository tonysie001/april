package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.soul.entity.YBEntity;

public class LoginCase {

	// 登录
	@Test
	public void testLogin(WebDriver driver, YBEntity yb) throws Exception {
		

		System.out.println("======进入testLogin()方法=======");

		// 点击登录
		driver.findElement(By.linkText("登录")).click();
		Thread.sleep(500);

		// 输入用户名
		driver.findElement(By.xpath("//*[@id='loginName']")).clear();
		driver.findElement(By.xpath("//*[@id='loginName']")).sendKeys(
				yb.getUsername());
		Thread.sleep(500);

		// 输入密码
		driver.findElement(By.id("logpass")).clear();
		driver.findElement(By.id("logpass")).sendKeys(yb.getPassword());
		Thread.sleep(500);

		// 输入验证码
		driver.findElement(By.id("inputcode")).clear();
		driver.findElement(By.id("inputcode")).sendKeys(yb.getCode());
		Thread.sleep(1000);

		// 点击进入
		driver.findElement(By.id("loginBtn")).click();
		Thread.sleep(500);
		// username = driver.findElement(By.id("loginNameShow")).getText();
		// System.out.println("ddddddddddd"+username);

	}

	// 取得当前登录用户的名字
	@Test
	public String testLoginName(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		// System.out.println(driver.findElement(By.id("loginNameShow")).getText());
		return driver.findElement(By.id("loginNameShow")).getText();
	}

	// 注销
	@Test
	public void testLogout(WebDriver driver) throws Exception {
		// 点击注销按钮
		driver.findElement(By.linkText("注销")).click();
		Thread.sleep(500);
	}
}
