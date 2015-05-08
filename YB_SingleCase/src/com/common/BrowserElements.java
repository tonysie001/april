package com.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BrowserElements {

	Driver d = new Driver();
	WebDriver driver = d.getDriver();
	// ��ĿURL
	String url = Driver.getPropertyString("BASE_URL");

	/**
	 * �������ָ��url
	 * 
	 * @param url
	 */
	public void openBrowser() {
		System.out.println("��������������");
		System.out.println(url);
		driver.get(url);
		System.out.println("�ж�������ɹ�");
		driver.manage().window().maximize();
		// ������ʽ�ȴ�
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * ������˳�
	 */
	public void closeBrowser() {
		driver.quit();
	}

	/**
	 * �����ˢ��
	 */
	public void refresh() {
		driver.navigate().refresh();
	}

	/**
	 * ���������
	 */
	public void back() {
		driver.navigate().back();
	}

	/**
	 * �����ǰ��
	 */
	public void forward() {
		driver.navigate().forward();
	}
}
