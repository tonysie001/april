package com.cases;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.common.BasicElements;
import com.common.Driver;

public class LoginCase {
	Driver browser = new Driver();
	BasicElements element = new BasicElements();

	// 打开浏览器
	@BeforeMethod
	public void beforeMethod() {
		browser.openBrowser();
		System.out.println("打开浏览器时间：" + new Date(System.currentTimeMillis()));
	}

	// 登录
	@Test(dataProvider = "GetDataFromXml", dataProviderClass = LoginDataProvider.class)
	public void testLogin(String username, String password, String code)
			throws Exception {
		System.out.println("======进入testLogin()方法=======");

		// 点击登录 
		Thread.sleep(500);
		 element.findByLinkTextClick("登录");
		
		 // 输入用户名
		 element.findByXpathClear("//*[@id='loginName']");
		 element.findByXpathSendKeys("//*[@id='loginName']", username);
		
		 // 输入密码
		 element.findByIDClear("logpass");
		 element.findByIDSendKeys("logpass", password);
		
		 // 输入验证码
		 element.findByIDClear("inputcode");
		 element.findByIDSendKeys("inputcode", code);
		
		 // 点击进入
		 element.findByIDClick("loginBtn");
		 Thread.sleep(500);
	}

	// 退出浏览器
	@AfterMethod
	public void afterMethod( ) {
		System.out.println("关闭浏览器时间：" + new Date(System.currentTimeMillis()));
		browser.closeBrowser();
	}

}
