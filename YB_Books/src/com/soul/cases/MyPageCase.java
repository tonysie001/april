package com.soul.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.soul.entity.YBEntity;

public class MyPageCase {

	// ����������ҳ
	@Test
	public void testCreateMyPage(WebDriver driver, YBEntity yb, String classname)
			throws InterruptedException {

		System.out.println("======����testCreateMyPage()����=======");
		System.out.println("��ǰ������ҳΪ��" + yb.getUsername());

		Thread.sleep(3000);
		// ����������ҳ
		driver.findElement(By.className("watermark2")).click();
		Thread.sleep(3000);

		// �ϴ���Ƭ��������ͼ��
		try {
			addBigPhoto(driver, classname, yb);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// �����������Է���
		try {
			addMessage(driver);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ����������˵����
		try {
			addSay(driver);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// �ϴ���Ƭ���ײ�����Сͼ��
		try {
			for(int i=1; i<4 ;i++){
				addThreePhoto(driver,i);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ������水ť
		driver.findElement(By.cssSelector("input.btnCss03.pageSave")).click();
		Thread.sleep(3000);
		if (yb.getName().endsWith(classname)) {
			// ˢ��ҳ��
			driver.navigate().refresh();
			Thread.sleep(3000);

			// ��ȡͶƱ����Ԫ��
			WebElement elementMessage = driver.findElement(By
					.id("itemContainer"));
			// ��ȡͶƱ����Ԫ��
			List<WebElement> submitButton = elementMessage.findElements(By
					.tagName("input"));

			System.out.println("submitButton = " + submitButton.size());

			submitButton.get(4).click();

		} else {
			Thread.sleep(3000);
			// ˢ��ҳ��
			driver.navigate().refresh();
			Thread.sleep(3000);

			// ����ύ��ť
			driver.findElement(By.cssSelector("input.btnCss02.submitPage.fr"))
					.click();

		}

		Thread.sleep(500);
		// ���ȷ����ť
		driver.findElement(By.cssSelector("button.aui_state_highlight"))
				.click();

		// ������ҳ
		driver.findElement(By.linkText("������ҳ")).click();

	}

	public void addBigPhoto(WebDriver driver, String classname, YBEntity yb)
			throws InterruptedException {
		System.out.println("======����addBigPhoto()����=======");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("img.upaction")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='�����ַ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("imgSrc")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("imgSrc"))
				.sendKeys(
						"http://192.168.2.185/img/static/memento/online/book_banner.png");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='�����ַ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='ȷ��']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.aui_state_highlight"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("canvas")).click();
		Thread.sleep(1000);
	}

	// ��������Сͼ
	@Test
	public void addThreePhoto(WebDriver driver,int i) throws InterruptedException {

		System.out
				.println("============addThreePhoto()����======================");
		//�����ϴ�ͼƬС��ť
		driver.findElement(By.cssSelector("#imgMask"+i+" > p > img.upaction"))
		.click();
		Thread.sleep(1000);
		//���������ϴ�
		driver.findElement(By.xpath("//input[@value='�����ַ']")).click();
		Thread.sleep(1000);
		//���������ַ
		driver.findElement(By.id("imgSrc"))
				.sendKeys(
						"http://192.168.2.185/img/static/memento/online/book_banner.png");
		Thread.sleep(1000);
		//���������ַ
		driver.findElement(By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]"))
				.click();
		Thread.sleep(1000);
		//����ȷ���ϴ���ť
		driver.findElement(By.xpath(".//*[@id='imgSure']/input[1]")).click();
//		 driver.findElement(By.cssSelector("#imgSure > input.btnCss05")).click();
		Thread.sleep(1000);
		//����ȡ�����ð�ť
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(1000);
		//����ͼƬ��ȷ����ť
		driver.findElement(By.cssSelector("div.progress > div > div")).click();
		Thread.sleep(1000);
	}

	/**
	 * ѡ���������
	 */
	@Test
	public void addMessage(WebDriver driver) throws Exception {

		System.out.println("======����addMessage()����=======");

		// ������������ͼƬ
		driver.findElement(By.cssSelector("img[title=\"��������\"]")).click();
		Thread.sleep(3000);
		// ��ȡͶƱ����Ԫ��
		WebElement elementMessage = driver.findElement(By.id("sayToMeSl"));
		// ��ȡͶƱ����Ԫ��
		List<WebElement> checkboxMessage = elementMessage.findElements(By
				.tagName("input"));
		Thread.sleep(3000);
		System.out.println("  size =" + checkboxMessage.size());
		for (int i = 0; i < 1; i++) {
			checkboxMessage.get(i).click();
			Thread.sleep(500);
		}
		// ���ȷ����ť���ύ����
		driver.findElement(By.linkText("ȷ��")).click();
	}

	/**
	 * ѡ�������˵
	 */
	@Test
	public void addSay(WebDriver driver) throws Exception {

		System.out.println("======����addSay()����=======");

		// ����������˵ͼƬ
		driver.findElement(By.cssSelector("img[title=\"������˵\"]")).click();
		Thread.sleep(1000);
		// ��ȡͶƱ����Ԫ��
		WebElement elementSay = driver.findElement(By.id("iSaySl"));
		// ��ȡͶƱ����Ԫ��
		List<WebElement> checkboxSay = elementSay.findElements(By
				.tagName("input"));
		Thread.sleep(3000);
		System.out.println("  size =" + checkboxSay.size());
		for (int i = 0; i < 3; i++) {
			checkboxSay.get(i).click();
			Thread.sleep(500);
		}
		Thread.sleep(500);
		// ���ȷ����ť���ύ��˵
		driver.findElement(By.linkText("ȷ��")).click();
		Thread.sleep(500);
	}

}
