package com.soul.cases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateBooksCase {

	// 创建新书册
	@Test
	public void testCreateBooks(WebDriver driver) throws Exception {

		System.out.println("======进入testCreateBooks()方法=======");
		Thread.sleep(1000);
		driver.findElement(By.linkText("我的书库")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath(".//*[@id='frameContent']/div/div/input[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("校园纪念册")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("gradeName")).sendKeys("mySchool");
		Thread.sleep(1000);
		driver.findElement(By.id("groupName")).sendKeys("myClass");
		Thread.sleep(1000);
		driver.findElement(By.id("bookName")).sendKeys("myBook");
		Thread.sleep(1000);
		WebElement text1 = driver.findElement(By.id("time"));
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver)
					.executeScript(
							"document.getElementById('time').removeAttribute('readOnly');"
									+ "document.getElementById('time').setAttribute('value','2015-12-30');",
							text1);
		}
		driver.findElement(By.id("createBookButton")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("intoBookBtn")).click();
	}

	public String testCode(WebDriver driver) throws Exception {

		System.out.println("======进入testCode()方法=======");

		Thread.sleep(1000);
		// 点击刚加入的新书册
//		driver.findElement(
//				By.cssSelector("html body div#frameContent.content div.perrig_home ul.booklist li.mypage div a img"))
//				.click();
//		Thread.sleep(3000);

		// 获取投票父类元素
//		WebElement element = driver.findElement(By.className("booklist"));
//		// 获取投票子类元素
//		List<WebElement> edit = element.findElements(By.tagName("<a>"));

//		edit.get(0).click();
		  driver.findElement(By.cssSelector("input.btnCss01.bookManagement")).click();
		String code = driver.findElement(By.className("color2")).getText();
		System.out.println("code = " + code);
		// 获得邀请码
		// String code = driver.findElement(By.id("codeValue")).getText();
		// System.out.println("code = " + code);
		return code;
	}
}
