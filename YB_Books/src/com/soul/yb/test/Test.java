package com.soul.yb.test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.soul.cases.OperationBrowser;
import com.soul.data.Common;
import com.soul.data.ReadExcel;
import com.soul.logic.CreateBookLogic;

public class Test {

	public static void main(String args[]) throws Exception {
				
		// ʵ����driver����
		WebDriver driver = new FirefoxDriver();
		//������ʽ�ȴ�
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// ʵ������ȡEXCEL����
		File file = new File(Common.YB_MESSAGE_PATH);
		// ʵ������¼���󼯺�
		List<String[][]> list = new ReadExcel().readExcel(file);
		// ʵ�����������������
		OperationBrowser browser = new OperationBrowser();
		// ʵ�������������߼���
		CreateBookLogic logic = new CreateBookLogic();

		// �������
		browser.beforeMethod(driver);

		// �೤��������
//		logic.createBook(driver, list, Common.CLASS_NAME);
		// 50ѧ����������
//		logic.addBook(driver, list, Common.CLASS_NAME);
		// 50ѧ��������˵��ͶƱ
		logic.addMyBookText(driver, list, Common.CLASS_NAME);
		// 50ѧ������������ҳ
//		logic.createMyBook(driver, list, Common.CLASS_NAME);
		// �೤�ύ���
//		logic.submitBook(driver, list, Common.CLASS_NAME);

		// �ر������
		browser.afterMethod(driver);

	}
}
