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
		testCreateMySay(driver);
		// ���ı���������Ϣ
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSayone());
		testCreateSayButton(driver);

		driver.findElement(By.linkText("������")).click();
		System.out.println(driver.findElement(By.linkText("������")));
		testCreateMySay(driver);
		// ���ı���������Ϣ
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSaytwo());
		testCreateSayButton(driver);

		driver.findElement(By.linkText("�������������ֵ�û���ģ�")).click();
		System.out.println(driver.findElement(By.linkText("�������������ֵ�û���ģ�")));
		testCreateMySay(driver);
		// ���ı���������Ϣ
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSaythree());
		testCreateSayButton(driver);

		driver.findElement(By.linkText("�������������ο�Ц�ģ�")).click();
		System.out.println(driver.findElement(By.linkText("�������������ο�Ц�ģ�")));
		testCreateMySay(driver);
		// ���ı���������Ϣ
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSayfour());
		testCreateSayButton(driver);

		driver.findElement(By.linkText("����Ӱ���ҵ���������")).click();
		System.out.println(driver.findElement(By.linkText("����Ӱ���ҵ���������")));
		testCreateMySay(driver);
		// ���ı���������Ϣ
		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
				.sendKeys(yb.getSayfive());
		testCreateSayButton(driver);
	}

	@Test
	public void testCreateMySay(WebDriver driver) throws Exception {
		Thread.sleep(500);
		// �����Ҳ˵
		driver.findElement(By.linkText("��Ҳ˵")).click();
		Thread.sleep(500);
		// ����ı�����Ϣ
		driver.findElement(By.cssSelector("textarea.speak.isayinput")).clear();
	}

	@Test
	public void testCreateSayButton(WebDriver driver) throws Exception {
		Thread.sleep(500);
		// ���ȷ��
		driver.findElement(By.linkText("ȷ��")).click();
		Thread.sleep(500);
		// ˢ��ҳ��
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
