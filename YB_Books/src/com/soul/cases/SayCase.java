package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.soul.entity.YBEntity;

public class SayCase {

	// �˿���˵
	@Test
	public void testCreateSay(WebDriver driver, YBEntity yb) throws Exception {

		System.out.println("======����testCreateSay()����=======");
		Thread.sleep(2000);
		// �������ȥ�Ĵ��㣿
		driver.findElement(By.linkText("����ȥ�Ĵ��㣿")).click();
		System.out.println(driver.findElement(By.linkText("����ȥ�Ĵ��㣿")));

		try {
			testCreateMySay(driver);
		} catch (Exception e) {

			// ˢ��ҳ��
			driver.navigate().refresh();
			Thread.sleep(1000);
			// �������ȥ�Ĵ��㣿
			driver.findElement(By.linkText("����ȥ�Ĵ��㣿")).click();
			testCreateMySay(driver);
		}

		// ���ı���������Ϣ
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSayone());
		testCreateSayButton(driver);

		driver.findElement(By.linkText("������")).click();
		System.out.println(driver.findElement(By.linkText("������")));

		try {
			testCreateMySay(driver);
		} catch (Exception e) {

			// ˢ��ҳ��
			driver.navigate().refresh();
			Thread.sleep(1000);
			// ������
			driver.findElement(By.linkText("������")).click();
			testCreateMySay(driver);
		}
		// ���ı���������Ϣ
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSaytwo());
		testCreateSayButton(driver);

		driver.findElement(By.linkText("�������������ֵ�û���ģ�")).click();
		System.out.println(driver.findElement(By.linkText("�������������ֵ�û���ģ�")));

		try {
			testCreateMySay(driver);
		} catch (Exception e) {

			// ˢ��ҳ��
			driver.navigate().refresh();
			Thread.sleep(1000);
			// �������������ֵ�û���ģ�
			driver.findElement(By.linkText("�������������ֵ�û���ģ�")).click();
			testCreateMySay(driver);
		}
		
		// ���ı���������Ϣ
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSaythree());
		testCreateSayButton(driver);

//		driver.findElement(By.linkText("�������������ο�Ц�ģ�")).click();
//		System.out.println(driver.findElement(By.linkText("�������������ο�Ц�ģ�")));
//
//		try {
//			testCreateMySay(driver);
//		} catch (Exception e) {
//
//			// ˢ��ҳ��
//			driver.navigate().refresh();
//			Thread.sleep(1000);
//			//�������������ο�Ц�ģ�
//			driver.findElement(By.linkText("�������������ο�Ц�ģ�")).click();
//			testCreateMySay(driver);
//		}
//		
//		// ���ı���������Ϣ
//		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
//				.sendKeys(yb.getSayfour());
//		testCreateSayButton(driver);
//
//		driver.findElement(By.linkText("����Ӱ���ҵ���������")).click();
//		System.out.println(driver.findElement(By.linkText("����Ӱ���ҵ���������")));
//		Thread.sleep(1000);
//
//		try {
//			testCreateMySay(driver);
//		} catch (Exception e) {
//
//			// ˢ��ҳ��
//			driver.navigate().refresh();
//			Thread.sleep(1000);
//			//����Ӱ���ҵ���������
//			driver.findElement(By.linkText("����Ӱ���ҵ���������")).click();
//			testCreateMySay(driver);
//		}
//		
//		// ���ı���������Ϣ
//		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
//				.sendKeys(yb.getSayfive());
//		testCreateSayButton(driver);
	}

	@Test
	public void testCreateMySay(WebDriver driver) {
		try {
			Thread.sleep(1000);
			// �����Ҳ˵
			driver.findElement(By.linkText("��Ҳ˵")).click();
			Thread.sleep(1000);
			// ����ı�����Ϣ
			driver.findElement(By.cssSelector("textarea.speak.isayinput")).clear();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testCreateSayButton(WebDriver driver) {
		try {
			Thread.sleep(1000);
			// ���ȷ��
			driver.findElement(By.linkText("ȷ��")).click();
			Thread.sleep(1000);
			// ˢ��ҳ��
			driver.navigate().refresh();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
