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
	// 制作个人书页
	@Test
	public void testCreateMyPage(String username,String classname)
			throws InterruptedException {

		System.out.println("======进入testCreateMyPage()方法=======");
//		System.out.println("当前个人书页为：" + yb.getUsername());

		Thread.sleep(3000);
		// 单击个人书页
//		driver.findElement(By.className("watermark2")).click();
		element.findByClassClick("watermark2");
		Thread.sleep(3000);

		// 上传照片（顶部大图）
		try {
			addBigPhoto(classname);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 调用增加留言方法
		try {
			addMessage();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 调用增加想说方法
		try {
			addSay();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 上传照片（底部三张小图）
		try {
			for(int i=1; i<4 ;i++){
				addThreePhoto(i);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 点击保存按钮
//		driver.findElement(By.cssSelector("input.btnCss03.pageSave")).click();
		element.findByCssClick("input.btnCss03.pageSave");
		Thread.sleep(3000);
		if (username.equals(classname)) {
			// 刷新页面
			browser.refresh();
			Thread.sleep(3000);

//			// 获取投票父类元素
//			WebElement elementMessage = driver.findElement(By
//					.id("itemContainer"));
//			// 获取投票子类元素
//			List<WebElement> submitButton = elementMessage.findElements(By
//					.tagName("input"));
			List<WebElement> submitButton = element.findSelect(By.id("itemContainer"), "input");

			System.out.println("submitButton = " + submitButton.size());

			submitButton.get(4).click();

		} else {
			Thread.sleep(3000);
			// 刷新页面
			browser.refresh();
			Thread.sleep(3000);

			// 点击提交按钮
//			driver.findElement(By.cssSelector("input.btnCss02.submitPage.fr"))
//					.click();
			element.findByCssClick("input.btnCss02.submitPage.fr");

		}

		Thread.sleep(500);
		// 点击确定按钮
//		driver.findElement(By.cssSelector("button.aui_state_highlight"))
//				.click();
		element.findByCssClick("button.aui_state_highlight");

		// 返回首页
//		driver.findElement(By.linkText("返回首页")).click();
		element.findByLinkTextClick("返回首页");

	}

	public void addBigPhoto(String classname)
			throws InterruptedException {
		System.out.println("======进入addBigPhoto()方法=======");
		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("img.upaction")).click();
		element.findByCssClick("img.upaction");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@value='网络地址']")).click();
		element.findByXpathClick("//input[@value='网络地址']");
		Thread.sleep(1000);
//		driver.findElement(By.id("imgSrc")).clear();
		element.findByIDClear("imgSrc");
		Thread.sleep(1000);
//		driver.findElement(By.id("imgSrc"))
//				.sendKeys(
//						"http://192.168.2.185/img/static/memento/online/book_banner.png");
		element.findByIDSendKeys("imgSrc", "http://192.168.2.185/img/static/memento/online/book_banner.png");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@value='网络地址']")).click();
		element.findByXpathClick("//input[@value='网络地址']");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@value='确定']")).click();
		element.findByXpathClick("//input[@value='确定']");
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

	// 增加三张小图
	@Test
	public void addThreePhoto(int i) throws InterruptedException {

		System.out
				.println("============addThreePhoto()方法======================");
		//单击上传图片小按钮
//		driver.findElement(By.cssSelector("#imgMask"+i+" > p > img.upaction"))
//		.click();
		element.findByCssClick("#imgMask"+i+" > p > img.upaction");
		Thread.sleep(1000);
		//单击网络上传
//		driver.findElement(By.xpath("//input[@value='网络地址']")).click();
		element.findByXpathClick("//input[@value='网络地址']");
		Thread.sleep(1000);
		//输入网络地址
//		driver.findElement(By.id("imgSrc"))
//				.sendKeys(
//						"http://192.168.2.185/img/static/memento/online/book_banner.png");
		element.findByIDSendKeys("imgSrc", "http://192.168.2.185/img/static/memento/online/book_banner.png");
		Thread.sleep(1000);
		//单击网络地址
//		driver.findElement(By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]"))
//				.click();
		element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");
		Thread.sleep(1000);
		//单击确定上传按钮
//		driver.findElement(By.xpath(".//*[@id='imgSure']/input[1]")).click();
		element.findByXpathClick(".//*[@id='imgSure']/input[1]");
//		 driver.findElement(By.cssSelector("#imgSure > input.btnCss05")).click();
		Thread.sleep(1000);
		//单击取消剪裁按钮
//		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		element.findByXpathClick("(//button[@type='button'])[2]");
		Thread.sleep(1000);
		//单击图片上确定按钮
//		driver.findElement(By.cssSelector("div.progress > div > div")).click();
		element.findByCssClick("div.progress > div > div");
		Thread.sleep(1000);
	}

	/**
	 * 选择多条留言
	 */
	@Test
	public void addMessage() throws Exception {

		System.out.println("======进入addMessage()方法=======");

		// 单击增加留言图片
//		driver.findElement(By.cssSelector("img[title=\"增加留言\"]")).click();
		element.findByCssClick("img[title=\"增加留言\"]");
		Thread.sleep(3000);
		// 获取投票父类元素
//		WebElement elementMessage = driver.findElement(By.id("sayToMeSl"));
//		// 获取投票子类元素
//		List<WebElement> checkboxMessage = elementMessage.findElements(By
//				.tagName("input"));
		List<WebElement> checkboxMessage = element.findSelect(By.id("sayToMeSl"), "input");
		Thread.sleep(3000);
		System.out.println("  size =" + checkboxMessage.size());
		for (int i = 0; i < 1; i++) {
			checkboxMessage.get(i).click();
			Thread.sleep(500);
		}
		// 点击确定按钮，提交留言
//		driver.findElement(By.linkText("确定")).click();
		element.findByLinkTextClick("确定");
	}

	/**
	 * 选择多条想说
	 */
	@Test
	public void addSay() throws Exception {

		System.out.println("======进入addSay()方法=======");

		// 单击增加想说图片
//		driver.findElement(By.cssSelector("img[title=\"增加想说\"]")).click();
		element.findByCssClick("img[title=\"增加想说\"]");
		Thread.sleep(1000);
//		// 获取投票父类元素
//		WebElement elementSay = driver.findElement(By.id("iSaySl"));
//		// 获取投票子类元素
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
		// 点击确定按钮，提交想说
//		driver.findElement(By.linkText("确定")).click();
		element.findByLinkTextClick("确定");
		Thread.sleep(500);
	}

}
