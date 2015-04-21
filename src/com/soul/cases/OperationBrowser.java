package com.soul.cases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * 
 * @author SionInSoul ���������
 * 
 */
public class OperationBrowser {
	String baseUrl = "http://192.168.2.185";

	//��������������վ
	@BeforeMethod
	public void beforeMethod(WebDriver driver) {
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	//�˳������
	@AfterMethod
	public void afterMethod(WebDriver driver) {
		driver.quit();
	}
}
