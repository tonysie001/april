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
		try {
			driver.findElement(By.cssSelector("img.upaction")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@value='网络地址']")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("imgSrc")).clear();
			Thread.sleep(3000);
			driver.findElement(By.id("imgSrc"))
					.sendKeys(
							"http://192.168.2.185/img/static/memento/online/book_banner.png");
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@value='网络地址']")).click();

			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@value='确定']")).click();

			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[@type='button'])[2]"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("button.aui_state_highlight"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("canvas")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// 调用增加留言方法
			addMessage(driver);
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

	// 增加三张小图
	@Test
	public void addThreePhoto(WebDriver driver) {

		System.out
				.println("============addThreePhoto()方法======================");

		// 点击上传第一张小图
		try {
			driver.findElement(By.cssSelector("#imgMask1 > p > img.upaction"))
					.click();
			Thread.sleep(3000);
			selectPhoto(driver);
			// 文本框输入路径
			driver.findElement(By.id("imgSrc"))
					.sendKeys(
							"http://192.168.2.185/img/static/memento/cover/book3_img1.png");
			Thread.sleep(3000);
			tailoringPhoto(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 点击上传第二张小图
		try {
			driver.findElement(By.cssSelector("#imgMask2 > p > img.upaction"))
					.click();
			Thread.sleep(3000);
			selectPhoto(driver);
			// 文本框输入路径
			driver.findElement(By.id("imgSrc"))
					.sendKeys(
							"http://192.168.2.185/img/static/memento/cover/book3_img2.png");
			Thread.sleep(3000);
			tailoringPhoto(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 点击上传第三张小图
		try {
			driver.findElement(By.cssSelector("#imgMask3 > p > img.upaction"))
					.click();
			Thread.sleep(3000);
			selectPhoto(driver);
			// 文本框输入路径
			driver.findElement(By.id("imgSrc"))
					.sendKeys(
							"http://192.168.2.185/img/static/memento/accessory/book4_img2.png");
			Thread.sleep(3000);
			tailoringPhoto(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 选择网络地址上传
	@Test
	public void selectPhoto(WebDriver driver) {

		System.out.println("======进入selectPhoto()方法=======");

		try {
			// 点击网络地址
			driver.findElement(By.xpath("//input[@value='网络地址']")).click();
			Thread.sleep(3000);
			// 清空文本框
			driver.findElement(By.id("imgSrc")).clear();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			selectPhoto(driver);
		}
	}

	// 使用图片
	@Test
	public void tailoringPhoto(WebDriver driver) throws Exception {

		System.out.println("======进入tailoringPhoto()方法=======");
		// 失去文本框焦点
		driver.findElement(By.xpath("//input[@value='网络地址']")).click();
		// loseFocus(driver);
		//
		Thread.sleep(6000);

		// 点击确定按钮上传图片
		// driver.findElement(By.cssSelector("#imgSure > input.btnCss05")).click();
		driver.findElement(By.xpath("//input[@value='确定']")).click();
		// driver.findElement(By.xpath("id('imgSure')/x:input[1]")).click();
		Thread.sleep(3000);
		// 点击取消按钮取消裁剪图片
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(3000);
		// 点击确定按钮确定使用图片
		driver.findElement(By.cssSelector("button.aui_state_highlight"))
				.click();
		Thread.sleep(3000);
		// 点击图片上的确定按钮
		driver.findElement(By.cssSelector("div.progress > div > div")).click();
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
		for (int i = 0; i < 4; i++) {
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
