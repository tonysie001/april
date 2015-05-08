package com.cases;

import org.testng.annotations.Test;

import com.common.BasicElements;
import com.common.BrowserElements;

public class SayCase {
	
	BasicElements element = new BasicElements();
	BrowserElements browser = new BrowserElements();
	// �˿���˵
	@Test(dataProvider = "createSayDate", dataProviderClass = ExcelDataProvider.class)
	public void testCreateSay(String say1,String say2,String say3) throws Exception {

		System.out.println("======����testCreateSay()����=======");
		Thread.sleep(2000);
		// �������ȥ�Ĵ��㣿
//		driver.findElement(By.linkText("����ȥ�Ĵ��㣿")).click();
		element.findByLinkTextClick("����ȥ�Ĵ��㣿");
//		System.out.println(driver.findElement(By.linkText("����ȥ�Ĵ��㣿")));

		try {
			testCreateMySay();
		} catch (Exception e) {

			// ˢ��ҳ��
			browser.refresh();
			Thread.sleep(1000);
			// �������ȥ�Ĵ��㣿
//			driver.findElement(By.linkText("����ȥ�Ĵ��㣿")).click();
			element.findByLinkTextClick("����ȥ�Ĵ��㣿");
			testCreateMySay();
		}

		// ���ı���������Ϣ
//		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
//				.sendKeys(yb.getSayone());
		element.findByCssSendKeys("textarea.speak.isayinput", say1);
		testCreateSayButton();

//		driver.findElement(By.linkText("������")).click();
		element.findByLinkTextClick("������");
//		System.out.println(driver.findElement(By.linkText("������")));

		try {
			testCreateMySay();
		} catch (Exception e) {

			// ˢ��ҳ��
			browser.refresh();
			Thread.sleep(1000);
			// ������
//			driver.findElement(By.linkText("������")).click();
			element.findByLinkTextClick("������");
			testCreateMySay();
		}
		// ���ı���������Ϣ
//		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
//				.sendKeys(yb.getSaytwo());
		element.findByCssSendKeys("textarea.speak.isayinput", say2);
		
		testCreateSayButton();

//		driver.findElement(By.linkText("�������������ֵ�û���ģ�")).click();
		element.findByLinkTextClick("�������������ֵ�û���ģ�");
//		System.out.println(driver.findElement(By.linkText("�������������ֵ�û���ģ�")));

		try {
			testCreateMySay();
		} catch (Exception e) {

			// ˢ��ҳ��
			browser.refresh();
			Thread.sleep(1000);
			// �������������ֵ�û���ģ�
//			driver.findElement(By.linkText("�������������ֵ�û���ģ�")).click();
			element.findByLinkTextClick("�������������ֵ�û���ģ�");
			testCreateMySay();
		}
		
		// ���ı���������Ϣ
//		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
//				.sendKeys(yb.getSaythree());
		element.findByCssSendKeys("textarea.speak.isayinput", say3);
		testCreateSayButton();

	}

	@Test
	public void testCreateMySay() {
		try {
			Thread.sleep(1000);
			// �����Ҳ˵
//			driver.findElement(By.linkText("��Ҳ˵")).click();
			element.findByLinkTextClick("��Ҳ˵");
			Thread.sleep(1000);
			// ����ı�����Ϣ
//			driver.findElement(By.cssSelector("textarea.speak.isayinput")).clear();
			element.findByCssClear("textarea.speak.isayinput");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testCreateSayButton() {
		try {
			Thread.sleep(1000);
			// ���ȷ��
//			driver.findElement(By.linkText("ȷ��")).click();
			element.findByLinkTextClick("ȷ��");
			Thread.sleep(1000);
			// ˢ��ҳ��
			browser.refresh();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
