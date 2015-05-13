package com.cases;

import org.testng.annotations.Test;
import com.common.BasicElements;

public class LoginCase {

	BasicElements element = new BasicElements();

	// 登录
	@Test(dataProvider = "testLoginStuDate", dataProviderClass = ExcelDataProvider.class)
	public void testStuLogin(String username, String password, String code)
			throws Exception {
		System.out.println("======进入testStuLogin()方法=======");

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
		Thread.sleep(500);

		// 点击进入
		element.findByIDClick("loginBtn");
		Thread.sleep(500);
	}
	
	// 登录
	@Test(dataProvider = "testLoginClaDate", dataProviderClass = ExcelDataProvider.class)
	public void testClaLogin(String username, String password, String code)
			throws Exception {
		System.out.println("======进入testClaLogin()方法=======");

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
		Thread.sleep(500);

		// 点击进入
		element.findByIDClick("loginBtn");
		Thread.sleep(500);
	}
	
	// 注销
		@Test
		public void testLogout() throws Exception {
			// 点击注销按钮
			element.findByLinkTextClick("注销");
			Thread.sleep(500);
		}
}
