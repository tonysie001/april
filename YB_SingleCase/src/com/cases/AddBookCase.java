package com.cases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.common.BasicElements;

public class AddBookCase {
	BasicElements element = new BasicElements();
	CreateBooksCase book = new CreateBooksCase();
	

	// 进入我的书库
	@Test
	public void testMyBook()throws Exception {
		System.out.println("======进入testMyBook()方法=======");
			// 点击我的书库
		
//			driver.findElement(By.linkText("我的书库")).click();
			element.findByLinkTextClick("我的书库");
	}

	// 加入新书
	@Parameters({"code"})
	@Test
	public void testAddBook(String code) throws Exception {
		Thread.sleep(3000);

		System.out.println("======进入testAddBook()方法=======");
		System.out.println("code == " +  code);
		// 点击加入新书册
//		driver.findElement(By.xpath("//*[@id='addBook']")).click();
		element.findByXpathClick("//*[@id='addBook']");
		Thread.sleep(1000);

		// 清空邀请码输入框的值
//		driver.findElement(By.id("keyword")).clear();
		element.findByIDClear("keyword");
		Thread.sleep(500);

		// 输入邀请码
//		driver.findElement(By.id("keyword")).sendKeys(code);
	
		element.findByIDSendKeys("keyword", code);
		Thread.sleep(500);

		// 点击进入按钮
//		driver.findElement(By.id("checkBut")).click();
		element.findByIDClick("checkBut");
		Thread.sleep(3000);

	}

	// 打开参与新书
	@Test
	public void testOpenBook() throws Exception {

		System.out.println("======进入testOpenBook()方法=======");

		// 点击我的书库
//		driver.findElement(By.linkText("我的书库")).click();
		element.findByLinkTextClick("我的书库");
		Thread.sleep(3000);

		// 点击刚加入的新书册
//		driver.findElement(
//				By.cssSelector("html body div#frameContent.content div.perrig_home ul.booklist li.mypage div a img"))
//				.click();
		element.findByCssClick("html body div#frameContent.content div.perrig_home ul.booklist li.mypage div a img");
		Thread.sleep(3000);
	}

	// 打开创建新书
	@Test
	public void testOpenCreateBook() throws Exception {
		
		System.out.println("======进入testOpenCreateBook()方法=======");
		
		// 点击我的书库
//		driver.findElement(By.linkText("我的书库")).click();
		element.findByLinkTextClick("我的书库");
		Thread.sleep(3000);
		// 点击刚创建的新书册（上方无参与书册）
//		driver.findElement(By.xpath(".//*[@id='frameContent']/div/ul/li[1]/div[2]/a/img")).click();
		//点击刚创建的新书册（上方有参与书册）
//		driver.findElement(By.xpath(".//*[@id='frameContent']/div/ul[2]/li[1]/div[2]/a/img")).click();
		element.findByXpathClick(".//*[@id='frameContent']/div/ul[2]/li[1]/div[2]/a/img");
	}
}
