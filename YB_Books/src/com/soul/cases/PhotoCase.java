package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PhotoCase {

	// 通过调用AutoIt生成的exe程序上传照片
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

	// 上传照片
	@Test
	public void testCreatePhoto(WebDriver driver) throws Exception {

		System.out.println("======进入testCreatePhoto()方法=======");
		Thread.sleep(3000);

		// 单击上传按钮
		WebElement element = driver.findElement(By.className("block2"));
		element.findElement(By.tagName("span")).click();
		Thread.sleep(3000);

		// 点击选择文件按钮
		driver.findElement(By.xpath("//*[@id='loaclFile']")).click();
		Thread.sleep(3000);

		// 上传照片方法
		openExe();
		Thread.sleep(3000);

		//点击开始上传按钮
		driver.findElement(By.className("start")).click();

		//单击关闭按钮，关闭上传框
		driver.findElement(By.cssSelector("h1.overtit2 > a > img")).click();

	}
}
