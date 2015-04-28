package com.soul.cases;

import java.text.SimpleDateFormat;
import java.util.Date;

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
//		driver.findElement(By.id("bookName")).sendKeys("myBook");
		driver.findElement(By.id("bookName")).sendKeys(time());

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
		Thread.sleep(500);
		driver.findElement(By.cssSelector("input.btnCss01.bookManagement"))
				.click();
		String code = driver.findElement(By.className("color2")).getText();
		return code;
	}
	
	public static String time(){ 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
		}

}
