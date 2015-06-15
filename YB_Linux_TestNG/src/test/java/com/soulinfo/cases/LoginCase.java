package com.soulinfo.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.CommonElements;

public class LoginCase {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	BasicElements element = new BasicElements();
	CommonElements common = new CommonElements();

	/**
	 * 学生登录
	 * 
	 * @param username
	 * @param password
	 * @param code
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "testLoginStuDate", dataProviderClass = ExcelDataProvider.class)
	public void testStuLogin(String username, String password, String code)
			throws InterruptedException {
		logger.info("======进入testStuLogin()方法=======");
		login(username, password, code);
	}

	/**
	 * 班长登录
	 * 
	 * @param username
	 * @param password
	 * @param code
	 * @throws Exception
	 */
	@Test(dataProvider = "testLoginClaDate", dataProviderClass = ExcelDataProvider.class)
	public void testClaLogin(String username, String password, String code)
			throws Exception {
		logger.info("======进入testClaLogin()方法=======");
		login(username, password, code);
	}

	@Test
	public void login(String username, String password, String code)
			throws InterruptedException {

		// 点击登录
		element.findByLinkTextClick("登陆");

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
		
//		common.getScreen("Login");

		// 点击进入
		element.findByIDClick("loginBtn");
		
//		common.getScreen("index");
		logger.info("登录成功：" + username);
	}

	/**
	 * 注销
	 */
	@Test
	public void testLogout() {
		logger.info("======进入testLogout()方法=======");

		// 点击注销按钮
		element.findByLinkTextClick("注销");
		logger.info("注销成功");
	}
}
