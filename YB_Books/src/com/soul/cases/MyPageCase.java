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

		Thread.sleep(3000);
		// ����������ҳ
		driver.findElement(By.className("watermark2")).click();
		Thread.sleep(3000);

		// ������ϴ���Ƭ��������ͼ��
		driver.findElement(By.cssSelector("img.upaction")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("loaclFile")).click();
		Thread.sleep(3000);
		openExe();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button.aui_state_highlight"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("canvas")).click();

		try {
			// �����������Է���
			// addMessage(driver);
			Thread.sleep(3000);
		} catch (Exception e) {

		}

		try {
			// ����������˵����
			 addSay(driver);
			Thread.sleep(3000);
		} catch (Exception e) {

		}

		// ������ϴ���Ƭ���ײ�����Сͼ��
		addThreePhoto(driver);

		// ������水ť
		driver.findElement(By.cssSelector("input.btnCss03.pageSave")).click();

		if (yb.getName().endsWith(classname)) {
			Thread.sleep(3000);
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
			// ˢ��ҳ��
			driver.navigate().refresh();
			Thread.sleep(3000);

			// ����ύ��ť
			driver.findElement(By.cssSelector("input.btnCss02.submitPage.fr"))
					.click();
		}

		// ���ȷ����ť
		driver.findElement(By.cssSelector("button.aui_state_highlight"))
				.click();

		// ������ҳ
		driver.findElement(By.linkText("������ҳ")).click();

	}

	// ִ��exe�ļ��ϴ���Ƭ
	@Test
	public static void openExe() {
		Runtime rn = Runtime.getRuntime();
		Process p = null;
		try {
			p = rn.exec("\"D:/Workspaces/YB_Books/files/upfile.exe\"");
		} catch (Exception e) {
			System.out.println("Error exec!");
		}
	}

	// ��������Сͼ
	@Test
	public void addThreePhoto(WebDriver driver) {

		System.out.println("============addThreePhoto()����===============");

		// ����ϴ���һ��Сͼ
		try {
			driver.findElement(By.cssSelector("#imgMask1 > p > img.upaction"))
					.click();
			Thread.sleep(3000);
			tailoringPhoto(driver);
			// ���ͼƬ�ϵ�ȷ����ť
			driver.findElement(By.cssSelector("div.progress > div > div"))
					.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ����ϴ��ڶ���Сͼ
		try {
			driver.findElement(By.cssSelector("#imgMask2 > p > img.upaction"))
					.click();
			Thread.sleep(3000);
			tailoringPhoto(driver);
			// ���ͼƬ�ϵ�ȷ����ť
			driver.findElement(By.cssSelector("div.progress > div > div"))
					.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ����ϴ�������Сͼ
		try {
			driver.findElement(By.cssSelector("#imgMask3 > p > img.upaction"))
					.click();
			Thread.sleep(3000);
			tailoringPhoto(driver);
			// ���ͼƬ�ϵ�ȷ����ť
			driver.findElement(By.cssSelector("div.progress > div > div"))
					.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ʹ��ͼƬ
	@Test
	public void tailoringPhoto(WebDriver driver) throws Exception {

		System.out.println("======����tailoringPhoto()����=======");

		// ��������ϴ�
		driver.findElement(By.id("loaclFile")).click();
		Thread.sleep(3000);
		// �ô���Ƭ
		openExe();
		Thread.sleep(3000);
		// ���ȡ����ťȡ���ü�ͼƬ
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(3000);
		// ���ȷ����ťȷ��ʹ��ͼƬ
		driver.findElement(By.cssSelector("button.aui_state_highlight"))
				.click();
		Thread.sleep(3000);

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
