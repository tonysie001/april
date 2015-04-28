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
				
		// 实例化driver对象
		WebDriver driver = new FirefoxDriver();
		//设置隐式等待
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 实例化读取EXCEL对象
		File file = new File(Common.YB_MESSAGE_PATH);
		// 实例化登录对象集合
		List<String[][]> list = new ReadExcel().readExcel(file);
		// 实例化操作浏览器对象
		OperationBrowser browser = new OperationBrowser();
		// 实例化创建新书逻辑类
		CreateBookLogic logic = new CreateBookLogic();

		// 打开浏览器
		browser.beforeMethod(driver);

		// 班长创建新书
//		logic.createBook(driver, list, Common.CLASS_NAME);
		// 50学生加入新书
//		logic.addBook(driver, list, Common.CLASS_NAME);
		// 50学生发表想说、投票
		logic.addMyBookText(driver, list, Common.CLASS_NAME);
		// 50学生制作个人书页
//		logic.createMyBook(driver, list, Common.CLASS_NAME);
		// 班长提交书册
//		logic.submitBook(driver, list, Common.CLASS_NAME);

		// 关闭浏览器
		browser.afterMethod(driver);

	}
}
