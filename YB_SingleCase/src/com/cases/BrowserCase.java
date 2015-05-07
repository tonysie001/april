package com.cases;

import java.util.Date;

import org.testng.annotations.Test;

import com.common.BrowserElements;

public class BrowserCase {

	BrowserElements browser = new BrowserElements();

	// �������
	@Test
	public void openBrowser() {
		browser.openBrowser();
		System.out.println("�������ʱ�䣺" + new Date(System.currentTimeMillis()));
	}
//	(dependsOnMethods = {"openBrowser"})
	// �˳������
	@Test
	public void closeBrowser() {
		System.out.println("�ر������ʱ�䣺" + new Date(System.currentTimeMillis()));
		browser.closeBrowser();
	}
}
