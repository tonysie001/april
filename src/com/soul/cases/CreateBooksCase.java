package com.soul.cases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateBooksCase {

	// ���������
	@Test
	public void testCreateBooks(WebDriver driver) throws Exception {

		System.out.println("======����testCreateBooks()����=======");
		Thread.sleep(1000);
		driver.findElement(By.linkText("�ҵ����")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath(".//*[@id='frameContent']/div/div/input[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("У԰�����")).click();
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

		System.out.println("======����testCode()����=======");

		Thread.sleep(1000);
		// ����ռ���������
//		driver.findElement(
//				By.cssSelector("html body div#frameContent.content div.perrig_home ul.booklist li.mypage div a img"))
//				.click();
//		Thread.sleep(3000);

		// ��ȡͶƱ����Ԫ��
//		WebElement element = driver.findElement(By.className("booklist"));
//		// ��ȡͶƱ����Ԫ��
//		List<WebElement> edit = element.findElements(By.tagName("<a>"));

//		edit.get(0).click();
		  driver.findElement(By.cssSelector("input.btnCss01.bookManagement")).click();
		String code = driver.findElement(By.className("color2")).getText();
		System.out.println("code = " + code);
		// ���������
		// String code = driver.findElement(By.id("codeValue")).getText();
		// System.out.println("code = " + code);
		return code;
	}
}
