package com.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.common.BasicElements;

public class LoginCase {

	BasicElements element = new BasicElements();

	// ��¼
	@Test(dataProvider = "testLoginDate", dataProviderClass = ExcelDataProvider.class)
	public void testLogin(String username, String password, String code)
			throws Exception {
		System.out.println("======����testLogin()����=======");

		// �����¼aaa
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
//			driver.findElement(By.linkText("ע��")).click();
			element.findByLinkTextClick("ע��");
			Thread.sleep(500);
		}
}
