package com.cases;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import com.common.BasicElements;

public class LoginCase {

	BasicElements element = new BasicElements();
	@Parameters({"username","password","code"})
	@Test
	public void testL(String username,String password,String code) throws InterruptedException{
		System.out.println("��û��ִ��������Է���");
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
		Thread.sleep(500);
		
		// �������
		element.findByIDClick("loginBtn");
		Thread.sleep(500);
	}
}
