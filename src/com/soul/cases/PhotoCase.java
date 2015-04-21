package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PhotoCase {

	// ͨ������AutoIt���ɵ�exe�����ϴ���Ƭ
	@Test
	public static void openExe() {
		Runtime rn = Runtime.getRuntime();
		Process p = null;
		try {
			p = rn.exec("\"D:/AutoIt/upfile.exe\"");
		} catch (Exception e) {
			System.out.println("Error exec!");
		}
	}

	// �ϴ���Ƭ
	@Test
	public void testCreatePhoto(WebDriver driver) throws Exception {

		System.out.println("======����testCreatePhoto()����=======");
		Thread.sleep(3000);

		// �����ϴ���ť
		WebElement element = driver.findElement(By.className("block2"));
		element.findElement(By.tagName("span")).click();
		Thread.sleep(3000);

		// ���ѡ���ļ���ť
		driver.findElement(By.xpath("//*[@id='loaclFile']")).click();
		Thread.sleep(3000);

		// �ϴ���Ƭ����
		openExe();
		Thread.sleep(3000);

		//�����ʼ�ϴ���ť
		driver.findElement(By.className("start")).click();

		//�����رհ�ť���ر��ϴ���
		driver.findElement(By.cssSelector("h1.overtit2 > a > img")).click();

	}
}
