package com.cases;

import org.testng.annotations.Test;

import com.common.BasicElements;
import com.common.BrowserElements;

public class AddActivitiesCase {
	BasicElements element = new BasicElements();
	BrowserElements browser = new BrowserElements();
	@Test
	public void testAddActivities() throws Exception {
		
		System.out.println("======����testAddActivities()����=======");
		
		Thread.sleep(3000);
		//���������
//		driver.findElement(By.xpath(".//*[@id='infori']/h1/input[1]")).click();
		element.findByXpathClick(".//*[@id='infori']/h1/input[1]");
		//���ҳ�����
//		driver.findElement(By.linkText("ҳ�����")).click();
		element.findByLinkTextClick("ҳ�����");
		browser.refresh();
		Thread.sleep(3000);
//		driver.findElement(By.linkText("ҳ�����")).click();
		element.findByLinkTextClick("ҳ�����");
		//�������
//		driver.findElement(
//				By.xpath(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[7]"))
//				.click();
		element.findByXpathClick(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[7]");
		// ���Ĭ��ģ��
		Thread.sleep(3000);
		for (int i = 0; i < 4; i++) {
			//������ҳ�水ť
//			driver.findElement(By.linkText("���ҳ��")).click();
			element.findByLinkTextClick("���ҳ��");
			//���Ĭ��ģ�尴ť
//			driver.findElement(
//					By.xpath("html/body/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[2]"))
//					.click();
			element.findByXpathClick("html/body/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[2]");
		}
		Thread.sleep(1000);
		//���������ҳ
//		driver.findElement(By.xpath(".//*[@id='topBar']/div/ul/li[1]/a"))
//				.click();
//		element.findByXpathClick(".//*[@id='topBar']/div/ul/li[1]/a]");
	}
}
