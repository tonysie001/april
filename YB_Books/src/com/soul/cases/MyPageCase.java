package com.soul.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.soul.entity.YBEntity;

public class MyPageCase {

	// 制作个人书页
	@Test
	public void testCreateMyPage(WebDriver driver, YBEntity yb, String classname)
			throws InterruptedException {

		System.out.println("======进入testCreateMyPage()方法=======");

		Thread.sleep(3000);
		// 单击个人书页
		driver.findElement(By.className("watermark2")).click();
		Thread.sleep(3000);

		// 从相册上传照片（顶部大图）
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
			// 调用增加留言方法
			// addMessage(driver);
			Thread.sleep(3000);
		} catch (Exception e) {

		}

		try {
			// 调用增加想说方法
			 addSay(driver);
			Thread.sleep(3000);
		} catch (Exception e) {

		}

		// 从相册上传照片（底部三张小图）
		addThreePhoto(driver);

		// 点击保存按钮
		driver.findElement(By.cssSelector("input.btnCss03.pageSave")).click();

		if (yb.getName().endsWith(classname)) {
			Thread.sleep(3000);
			// 刷新页面
			driver.navigate().refresh();
			Thread.sleep(3000);
			// 获取投票父类元素
			WebElement elementMessage = driver.findElement(By
					.id("itemContainer"));
			// 获取投票子类元素
			List<WebElement> submitButton = elementMessage.findElements(By
					.tagName("input"));

			System.out.println("submitButton = " + submitButton.size());

			submitButton.get(4).click();

		} else {
			// 刷新页面
			driver.navigate().refresh();
			Thread.sleep(3000);

			// 点击提交按钮
			driver.findElement(By.cssSelector("input.btnCss02.submitPage.fr"))
					.click();
		}

		// 点击确定按钮
		driver.findElement(By.cssSelector("button.aui_state_highlight"))
				.click();

		// 返回首页
		driver.findElement(By.linkText("返回首页")).click();

	}

	// 执行exe文件上传照片
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

	// 增加三张小图
	@Test
	public void addThreePhoto(WebDriver driver) {

		System.out.println("============addThreePhoto()方法===============");

		// 点击上传第一张小图
		try {
			driver.findElement(By.cssSelector("#imgMask1 > p > img.upaction"))
					.click();
			Thread.sleep(3000);
			tailoringPhoto(driver);
			// 点击图片上的确定按钮
			driver.findElement(By.cssSelector("div.progress > div > div"))
					.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 点击上传第二张小图
		try {
			driver.findElement(By.cssSelector("#imgMask2 > p > img.upaction"))
					.click();
			Thread.sleep(3000);
			tailoringPhoto(driver);
			// 点击图片上的确定按钮
			driver.findElement(By.cssSelector("div.progress > div > div"))
					.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 点击上传第三张小图
		try {
			driver.findElement(By.cssSelector("#imgMask3 > p > img.upaction"))
					.click();
			Thread.sleep(3000);
			tailoringPhoto(driver);
			// 点击图片上的确定按钮
			driver.findElement(By.cssSelector("div.progress > div > div"))
					.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 使用图片
	@Test
	public void tailoringPhoto(WebDriver driver) throws Exception {

		System.out.println("======进入tailoringPhoto()方法=======");

		// 点击本地上传
		driver.findElement(By.id("loaclFile")).click();
		Thread.sleep(3000);
		// 好传照片
		openExe();
		Thread.sleep(3000);
		// 点击取消按钮取消裁剪图片
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(3000);
		// 点击确定按钮确定使用图片
		driver.findElement(By.cssSelector("button.aui_state_highlight"))
				.click();
		Thread.sleep(3000);

	}

	/**
	 * 选择多条留言
	 */
	@Test
	public void addMessage(WebDriver driver) throws Exception {

		System.out.println("======进入addMessage()方法=======");

		// 单击增加留言图片
		driver.findElement(By.cssSelector("img[title=\"增加留言\"]")).click();
		Thread.sleep(3000);
		// 获取投票父类元素
		WebElement elementMessage = driver.findElement(By.id("sayToMeSl"));
		// 获取投票子类元素
		List<WebElement> checkboxMessage = elementMessage.findElements(By
				.tagName("input"));
		Thread.sleep(3000);
		System.out.println("  size =" + checkboxMessage.size());
		for (int i = 0; i < 1; i++) {
			checkboxMessage.get(i).click();
			Thread.sleep(500);
		}
		// 点击确定按钮，提交留言
		driver.findElement(By.linkText("确定")).click();
	}

	/**
	 * 选择多条想说
	 */
	@Test
	public void addSay(WebDriver driver) throws Exception {

		System.out.println("======进入addSay()方法=======");

		// 单击增加想说图片
		driver.findElement(By.cssSelector("img[title=\"增加想说\"]")).click();
		Thread.sleep(1000);
		// 获取投票父类元素
		WebElement elementSay = driver.findElement(By.id("iSaySl"));
		// 获取投票子类元素
		List<WebElement> checkboxSay = elementSay.findElements(By
				.tagName("input"));
		Thread.sleep(3000);
		System.out.println("  size =" + checkboxSay.size());
		for (int i = 0; i < 3; i++) {
			checkboxSay.get(i).click();
			Thread.sleep(500);
		}
		Thread.sleep(500);
		// 点击确定按钮，提交想说
		driver.findElement(By.linkText("确定")).click();
		Thread.sleep(500);
	}

}
