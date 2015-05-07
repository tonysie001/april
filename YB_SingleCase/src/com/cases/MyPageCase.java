package com.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.common.BasicElements;
import com.common.BrowserElements;

public class MyPageCase {
	BasicElements element = new BasicElements();
	BrowserElements browser = new BrowserElements();
	// ����������ҳ
	@Test
	public void testCreateMyPage(String username,String classname)
			throws InterruptedException {

		System.out.println("======����testCreateMyPage()����=======");
//		System.out.println("��ǰ������ҳΪ��" + yb.getUsername());

		Thread.sleep(3000);
		// ����������ҳ
//		driver.findElement(By.className("watermark2")).click();
		element.findByClassClick("watermark2");
		Thread.sleep(3000);

		// �ϴ���Ƭ��������ͼ��
		try {
			addBigPhoto(classname);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// �����������Է���
		try {
			addMessage();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ����������˵����
		try {
			addSay();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// �ϴ���Ƭ���ײ�����Сͼ��
		try {
			for(int i=1; i<4 ;i++){
				addThreePhoto(i);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ������水ť
//		driver.findElement(By.cssSelector("input.btnCss03.pageSave")).click();
		element.findByCssClick("input.btnCss03.pageSave");
		Thread.sleep(3000);
		if (username.equals(classname)) {
			// ˢ��ҳ��
			browser.refresh();
			Thread.sleep(3000);

//			// ��ȡͶƱ����Ԫ��
//			WebElement elementMessage = driver.findElement(By
//					.id("itemContainer"));
//			// ��ȡͶƱ����Ԫ��
//			List<WebElement> submitButton = elementMessage.findElements(By
//					.tagName("input"));
			List<WebElement> submitButton = element.findSelect(By.id("itemContainer"), "input");

			System.out.println("submitButton = " + submitButton.size());

			submitButton.get(4).click();

		} else {
			Thread.sleep(3000);
			// ˢ��ҳ��
			browser.refresh();
			Thread.sleep(3000);

			// ����ύ��ť
//			driver.findElement(By.cssSelector("input.btnCss02.submitPage.fr"))
//					.click();
			element.findByCssClick("input.btnCss02.submitPage.fr");

		}

		Thread.sleep(500);
		// ���ȷ����ť
//		driver.findElement(By.cssSelector("button.aui_state_highlight"))
//				.click();
		element.findByCssClick("button.aui_state_highlight");

		// ������ҳ
//		driver.findElement(By.linkText("������ҳ")).click();
		element.findByLinkTextClick("������ҳ");

	}

	public void addBigPhoto(String classname)
			throws InterruptedException {
		System.out.println("======����addBigPhoto()����=======");
		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("img.upaction")).click();
		element.findByCssClick("img.upaction");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@value='�����ַ']")).click();
		element.findByXpathClick("//input[@value='�����ַ']");
		Thread.sleep(1000);
//		driver.findElement(By.id("imgSrc")).clear();
		element.findByIDClear("imgSrc");
		Thread.sleep(1000);
//		driver.findElement(By.id("imgSrc"))
//				.sendKeys(
//						"http://192.168.2.185/img/static/memento/online/book_banner.png");
		element.findByIDSendKeys("imgSrc", "http://192.168.2.185/img/static/memento/online/book_banner.png");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@value='�����ַ']")).click();
		element.findByXpathClick("//input[@value='�����ַ']");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@value='ȷ��']")).click();
		element.findByXpathClick("//input[@value='ȷ��']");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		element.findByXpathClick("(//button[@type='button'])[2]");
		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("button.aui_state_highlight"))
//				.click();
		element.findByCssClick("button.aui_state_highlight");
		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("canvas")).click();
		element.findByCssClick("canvas");
		Thread.sleep(1000);
	}

	// ��������Сͼ
	@Test
	public void addThreePhoto(int i) throws InterruptedException {

		System.out
				.println("============addThreePhoto()����======================");
		//�����ϴ�ͼƬС��ť
//		driver.findElement(By.cssSelector("#imgMask"+i+" > p > img.upaction"))
//		.click();
		element.findByCssClick("#imgMask"+i+" > p > img.upaction");
		Thread.sleep(1000);
		//���������ϴ�
//		driver.findElement(By.xpath("//input[@value='�����ַ']")).click();
		element.findByXpathClick("//input[@value='�����ַ']");
		Thread.sleep(1000);
		//���������ַ
//		driver.findElement(By.id("imgSrc"))
//				.sendKeys(
//						"http://192.168.2.185/img/static/memento/online/book_banner.png");
		element.findByIDSendKeys("imgSrc", "http://192.168.2.185/img/static/memento/online/book_banner.png");
		Thread.sleep(1000);
		//���������ַ
//		driver.findElement(By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]"))
//				.click();
		element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");
		Thread.sleep(1000);
		//����ȷ���ϴ���ť
//		driver.findElement(By.xpath(".//*[@id='imgSure']/input[1]")).click();
		element.findByXpathClick(".//*[@id='imgSure']/input[1]");
//		 driver.findElement(By.cssSelector("#imgSure > input.btnCss05")).click();
		Thread.sleep(1000);
		//����ȡ�����ð�ť
//		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		element.findByXpathClick("(//button[@type='button'])[2]");
		Thread.sleep(1000);
		//����ͼƬ��ȷ����ť
//		driver.findElement(By.cssSelector("div.progress > div > div")).click();
		element.findByCssClick("div.progress > div > div");
		Thread.sleep(1000);
	}

	/**
	 * ѡ���������
	 */
	@Test
	public void addMessage() throws Exception {

		System.out.println("======����addMessage()����=======");

		// ������������ͼƬ
//		driver.findElement(By.cssSelector("img[title=\"��������\"]")).click();
		element.findByCssClick("img[title=\"��������\"]");
		Thread.sleep(3000);
		// ��ȡͶƱ����Ԫ��
//		WebElement elementMessage = driver.findElement(By.id("sayToMeSl"));
//		// ��ȡͶƱ����Ԫ��
//		List<WebElement> checkboxMessage = elementMessage.findElements(By
//				.tagName("input"));
		List<WebElement> checkboxMessage = element.findSelect(By.id("sayToMeSl"), "input");
		Thread.sleep(3000);
		System.out.println("  size =" + checkboxMessage.size());
		for (int i = 0; i < 1; i++) {
			checkboxMessage.get(i).click();
			Thread.sleep(500);
		}
		// ���ȷ����ť���ύ����
//		driver.findElement(By.linkText("ȷ��")).click();
		element.findByLinkTextClick("ȷ��");
	}

	/**
	 * ѡ�������˵
	 */
	@Test
	public void addSay() throws Exception {

		System.out.println("======����addSay()����=======");

		// ����������˵ͼƬ
//		driver.findElement(By.cssSelector("img[title=\"������˵\"]")).click();
		element.findByCssClick("img[title=\"������˵\"]");
		Thread.sleep(1000);
//		// ��ȡͶƱ����Ԫ��
//		WebElement elementSay = driver.findElement(By.id("iSaySl"));
//		// ��ȡͶƱ����Ԫ��
//		List<WebElement> checkboxSay = elementSay.findElements(By
//				.tagName("input"));
		List<WebElement> checkboxSay = element.findSelect(By.id("iSaySl"), "input");
		Thread.sleep(3000);
		System.out.println("  size =" + checkboxSay.size());
		for (int i = 0; i < 3; i++) {
			checkboxSay.get(i).click();
			Thread.sleep(500);
		}
		Thread.sleep(500);
		// ���ȷ����ť���ύ��˵
//		driver.findElement(By.linkText("ȷ��")).click();
		element.findByLinkTextClick("ȷ��");
		Thread.sleep(500);
	}

}
