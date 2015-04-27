package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddBookCase {

	// 进入我的书库
	@Test
	public void testMyBook(WebDriver driver, String code)
			throws InterruptedException {
		System.out.println("======进入testMyBook()方法=======");
		Thread.sleep(2000);
		try {

			// 点击我的书库
			driver.findElement(By.linkText("我的书库")).click();
			testAddBook(driver, code);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 刷新页面
			driver.navigate().refresh();
			Thread.sleep(2000);
			testMyBook(driver, code);
		}
	}

	// 加入新书
	@Test
	public void testAddBook(WebDriver driver, String code) throws Exception {
		Thread.sleep(3000);

		System.out.println("======进入testAddBook()方法=======");
		// 点击加入新书册
		driver.findElement(By.xpath("//*[@id='addBook']")).click();
		Thread.sleep(1000);

		// 清空邀请码输入框的值
		driver.findElement(By.id("keyword")).clear();
		Thread.sleep(500);

		// 输入邀请码
		driver.findElement(By.id("keyword")).sendKeys(code);
		Thread.sleep(500);

		// 点击进入按钮
		driver.findElement(By.id("checkBut")).click();
		Thread.sleep(3000);

	}

	// 打开参与新书
	@Test
	public void testOpenBook(WebDriver driver) throws Exception {

		System.out.println("======进入testOpenBook()方法=======");

		// 点击我的书库
		driver.findElement(By.linkText("我的书库")).click();
		Thread.sleep(3000);

		// 点击刚加入的新书册
		driver.findElement(
				By.cssSelector("html body div#frameContent.content div.perrig_home ul.booklist li.mypage div a img"))
				.click();
		Thread.sleep(3000);
	}

	// 打开创建新书
	@Test
	public void testOpenCreateBook(WebDriver driver) throws Exception {
		
		System.out.println("======进入testOpenCreateBook()方法=======");
		
		// 点击我的书库
		driver.findElement(By.linkText("我的书库")).click();
		Thread.sleep(3000);
		// 点击刚创建的新书册（上方无参与书册）
//		driver.findElement(By.xpath(".//*[@id='frameContent']/div/ul/li[1]/div[2]/a/img")).click();
		//点击刚创建的新书册（上方有参与书册）
		driver.findElement(By.xpath(".//*[@id='frameContent']/div/ul[2]/li[1]/div[2]/a/img")).click();
	}
}
