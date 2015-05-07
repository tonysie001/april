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

	// �������
	@BeforeMethod
	public void beforeMethod() {
		browser.openBrowser();
		System.out.println("�������ʱ�䣺" + new Date(System.currentTimeMillis()));
	}

	// ��¼
	@Test(dataProvider = "GetDataFromXml", dataProviderClass = LoginDataProvider.class)
	public void testLogin(String username, String password, String code)
			throws Exception {
		System.out.println("======����testLogin()����=======");

		// �����¼ 
		Thread.sleep(500);
		 element.findByLinkTextClick("��¼");
		
		 // �����û���
		 element.findByXpathClear("//*[@id='loginName']");
		 element.findByXpathSendKeys("//*[@id='loginName']", username);
		
		 // ��������
		 element.findByIDClear("logpass");
		 element.findByIDSendKeys("logpass", password);
		
		 // ������֤��
		 element.findByIDClear("inputcode");
		 element.findByIDSendKeys("inputcode", code);
		
		 // �������
		 element.findByIDClick("loginBtn");
		 Thread.sleep(500);
	}

	// �˳������
	@AfterMethod
	public void afterMethod( ) {
		System.out.println("�ر������ʱ�䣺" + new Date(System.currentTimeMillis()));
		browser.closeBrowser();
	}

}
