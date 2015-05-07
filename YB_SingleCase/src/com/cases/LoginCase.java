package com.cases;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import com.common.BasicElements;

public class LoginCase {

	BasicElements element = new BasicElements();
	@Parameters({"username","password","code"})
	@Test
	public void testL(String username,String password,String code) throws InterruptedException{
		System.out.println("有没有执行这个测试方法");
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
		Thread.sleep(500);
		
		// 点击进入
		element.findByIDClick("loginBtn");
		Thread.sleep(500);
	}
}
