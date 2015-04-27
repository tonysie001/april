package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddBookCase {

	// �����ҵ����
	@Test
	public void testMyBook(WebDriver driver, String code)
			throws InterruptedException {
		System.out.println("======����testMyBook()����=======");
		Thread.sleep(2000);
		try {

			// ����ҵ����
			driver.findElement(By.linkText("�ҵ����")).click();
			testAddBook(driver, code);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// ˢ��ҳ��
			driver.navigate().refresh();
			Thread.sleep(2000);
			testMyBook(driver, code);
		}
	}

	// ��������
	@Test
	public void testAddBook(WebDriver driver, String code) throws Exception {
		Thread.sleep(3000);

		System.out.println("======����testAddBook()����=======");
		// ������������
		driver.findElement(By.xpath("//*[@id='addBook']")).click();
		Thread.sleep(1000);

		// ���������������ֵ
		driver.findElement(By.id("keyword")).clear();
		Thread.sleep(500);

		// ����������
		driver.findElement(By.id("keyword")).sendKeys(code);
		Thread.sleep(500);

		// ������밴ť
		driver.findElement(By.id("checkBut")).click();
		Thread.sleep(3000);

	}

	// �򿪲�������
	@Test
	public void testOpenBook(WebDriver driver) throws Exception {

		System.out.println("======����testOpenBook()����=======");

		// ����ҵ����
		driver.findElement(By.linkText("�ҵ����")).click();
		Thread.sleep(3000);

		// ����ռ���������
		driver.findElement(
				By.cssSelector("html body div#frameContent.content div.perrig_home ul.booklist li.mypage div a img"))
				.click();
		Thread.sleep(3000);
	}

	// �򿪴�������
	@Test
	public void testOpenCreateBook(WebDriver driver) throws Exception {
		
		System.out.println("======����testOpenCreateBook()����=======");
		
		// ����ҵ����
		driver.findElement(By.linkText("�ҵ����")).click();
		Thread.sleep(3000);
		// ����մ���������ᣨ�Ϸ��޲�����ᣩ
//		driver.findElement(By.xpath(".//*[@id='frameContent']/div/ul/li[1]/div[2]/a/img")).click();
		//����մ���������ᣨ�Ϸ��в�����ᣩ
		driver.findElement(By.xpath(".//*[@id='frameContent']/div/ul[2]/li[1]/div[2]/a/img")).click();
	}
}
