package com.soul.cases;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.soul.data.Common;

/**
 * ���������
 * 
 * @author SionInSoul
 * 
 */
public class OperationBrowser {

	// �������
	@BeforeMethod
	public void beforeMethod(WebDriver driver) {
		driver.get(Common.BASE_URL);
		driver.manage().window().maximize();
		System.out.println("�������ʱ�䣺" + new Date(System.currentTimeMillis()));
	}

	// �˳������
	@AfterMethod
	public void afterMethod(WebDriver driver) {
		System.out.println("�ر������ʱ�䣺" + new Date(System.currentTimeMillis()));
		driver.quit();
	}
}
