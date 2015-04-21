package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.soul.entity.YBEntity;

public class LoginCase {

	// ��¼
	@Test
	public void testLogin(WebDriver driver, YBEntity yb) throws Exception {
		

		System.out.println("======����testLogin()����=======");

		// �����¼
		driver.findElement(By.linkText("��¼")).click();
		Thread.sleep(500);

		// �����û���
		driver.findElement(By.xpath("//*[@id='loginName']")).clear();
		driver.findElement(By.xpath("//*[@id='loginName']")).sendKeys(
				yb.getUsername());
		Thread.sleep(500);

		// ��������
		driver.findElement(By.id("logpass")).clear();
		driver.findElement(By.id("logpass")).sendKeys(yb.getPassword());
		Thread.sleep(500);

		// ������֤��
		driver.findElement(By.id("inputcode")).clear();
		driver.findElement(By.id("inputcode")).sendKeys(yb.getCode());
		Thread.sleep(1000);

		// �������
		driver.findElement(By.id("loginBtn")).click();
		Thread.sleep(500);
		// username = driver.findElement(By.id("loginNameShow")).getText();
		// System.out.println("ddddddddddd"+username);

	}

	// ȡ�õ�ǰ��¼�û�������
	@Test
	public String testLoginName(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		// System.out.println(driver.findElement(By.id("loginNameShow")).getText());
		return driver.findElement(By.id("loginNameShow")).getText();
	}

	// ע��
	@Test
	public void testLogout(WebDriver driver) throws Exception {
		// ���ע����ť
		driver.findElement(By.linkText("ע��")).click();
		Thread.sleep(500);
	}
}
