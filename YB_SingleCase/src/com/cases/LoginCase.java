package com.cases;

import org.testng.annotations.Test;
import com.common.BasicElements;

public class LoginCase {

	BasicElements element = new BasicElements();

	// ��¼
	@Test(dataProvider = "testLoginStuDate", dataProviderClass = ExcelDataProvider.class)
	public void testStuLogin(String username, String password, String code)
			throws Exception {
		System.out.println("======����testStuLogin()����=======");

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
		Thread.sleep(500);

		// �������
		element.findByIDClick("loginBtn");
		Thread.sleep(500);
	}
	
	// ��¼
	@Test(dataProvider = "testLoginClaDate", dataProviderClass = ExcelDataProvider.class)
	public void testClaLogin(String username, String password, String code)
			throws Exception {
		System.out.println("======����testClaLogin()����=======");

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
		Thread.sleep(500);

		// �������
		element.findByIDClick("loginBtn");
		Thread.sleep(500);
	}
	
	// ע��
		@Test
		public void testLogout() throws Exception {
			// ���ע����ť
			element.findByLinkTextClick("ע��");
			Thread.sleep(500);
		}
}
