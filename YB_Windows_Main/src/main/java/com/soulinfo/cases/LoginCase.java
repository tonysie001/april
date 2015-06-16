package com.soulinfo.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soulinfo.entity.YBEntity;
import com.soulinfo.util.BasicElements;
import com.soulinfo.util.CommonElements;

public class LoginCase {
	private final static Logger logger = LoggerFactory.getLogger(LoginCase.class);
	BasicElements element = new BasicElements();
	CommonElements common = new CommonElements();

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @param code
	 * @throws InterruptedException
	 */
	public void testLogin(YBEntity yb) throws InterruptedException {
		logger.info("======进入testStuLogin()方法=======");
		// 点击登录
		element.findByLinkTextClick("登陆");

		// 输入用户名
		element.findByXpathClear("//*[@id='loginName']");
		element.findByXpathSendKeys("//*[@id='loginName']", yb.getUsername());

		// 输入密码
		element.findByIDClear("logpass");
		element.findByIDSendKeys("logpass", yb.getPassword());

		// 输入验证码
		element.findByIDClear("inputcode");
		element.findByIDSendKeys("inputcode", yb.getCode());
		Thread.sleep(500);

		common.getScreen("Login");

		// 点击进入
		element.findByIDClick("loginBtn");		
		logger.info("登录成功：" + yb.getUsername());
	}

	/**
	 * 注销
	 */

	public void testLogout() {
		logger.info("======进入testLogout()方法=======");

		// 点击注销按钮
		element.findByLinkTextClick("注销");
		logger.info("注销成功");
	}
}
