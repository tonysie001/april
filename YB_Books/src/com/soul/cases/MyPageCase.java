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
		System.out.println("当前个人书页为：" + yb.getUsername());

		Thread.sleep(3000);
		// 单击个人书页
		driver.findElement(By.className("watermark2")).click();
		Thread.sleep(3000);

		// 上传照片（顶部大图）
		try {
			addBigPhoto(driver, classname, yb);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 调用增加留言方法
		try {
			addMessage(driver);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 调用增加想说方法
		try {
			addSay(driver);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 上传照片（底部三张小图）
		try {
			for(int i=1; i<4 ;i++){
				addThreePhoto(driver,i);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 点击保存按钮
		driver.findElement(By.cssSelector("input.btnCss03.pageSave")).click();
		Thread.sleep(3000);
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
			Thread.sleep(3000);
			// 刷新页面
			driver.navigate().refresh();
			Thread.sleep(3000);

			// 点击提交按钮
			driver.findElement(By.cssSelector("input.btnCss02.submitPage.fr"))
					.click();

		}

		Thread.sleep(500);
		// 点击确定按钮
		driver.findElement(By.cssSelector("button.aui_state_highlight"))
				.click();

		// 返回首页
		driver.findElement(By.linkText("返回首页")).click();

	}

	public void addBigPhoto(WebDriver driver, String classname, YBEntity yb)
			throws InterruptedException {
		System.out.println("======进入addBigPhoto()方法=======");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("img.upaction")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='网络地址']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("imgSrc")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("imgSrc"))
				.sendKeys(
						"http://192.168.2.185/img/static/memento/online/book_banner.png");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='网络地址']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='确定']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.aui_state_highlight"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("canvas")).click();
		Thread.sleep(1000);
	}

	// 增加三张小图
	@Test
	public void addThreePhoto(WebDriver driver,int i) throws InterruptedException {

		System.out
				.println("============addThreePhoto()方法======================");
		//单击上传图片小按钮
		driver.findElement(By.cssSelector("#imgMask"+i+" > p > img.upaction"))
		.click();
		Thread.sleep(1000);
		//单击网络上传
		driver.findElement(By.xpath("//input[@value='网络地址']")).click();
		Thread.sleep(1000);
		//输入网络地址
		driver.findElement(By.id("imgSrc"))
				.sendKeys(
						"http://192.168.2.185/img/static/memento/online/book_banner.png");
		Thread.sleep(1000);
		//单击网络地址
		driver.findElement(By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]"))
				.click();
		Thread.sleep(1000);
		//单击确定上传按钮
		driver.findElement(By.xpath(".//*[@id='imgSure']/input[1]")).click();
//		 driver.findElement(By.cssSelector("#imgSure > input.btnCss05")).click();
		Thread.sleep(1000);
		//单击取消剪裁按钮
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(1000);
		//单击图片上确定按钮
		driver.findElement(By.cssSelector("div.progress > div > div")).click();
		Thread.sleep(1000);
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
