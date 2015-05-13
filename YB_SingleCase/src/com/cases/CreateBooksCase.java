package com.cases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.common.BasicElements;
import com.common.CommonElements;
import com.common.Driver;

public class CreateBooksCase {
	BasicElements element = new BasicElements();
	CommonElements comment = new CommonElements();

	// 创建新书册
	@Test
	public void test1CreateBooks() throws Exception {
	
		System.out.println("======进入testCreateBooks()方法=======");
		//点击我的新书
		element.findByLinkTextClick("我的书库");
		// driver.findElement(By.linkText("我的书库")).click();
		// Thread.sleep(1000);
		element.findByXpathClick(".//*[@id='frameContent']/div/div/input[1]");
		// driver.findElement(
		// By.xpath(".//*[@id='frameContent']/div/div/input[1]")).click();
		// Thread.sleep(1000);
		element.findByLinkTextClick("校园纪念册");
		// driver.findElement(By.linkText("校园纪念册")).click();
		// Thread.sleep(1000);
		element.findByIDSendKeys("gradeName", "mySchool");
		// driver.findElement(By.id("gradeName")).sendKeys("mySchool");
		Thread.sleep(1000);
		element.findByIDSendKeys("groupName", "myClass");
		// driver.findElement(By.id("groupName")).sendKeys("myClass");
		// Thread.sleep(1000);
		// driver.findElement(By.id("bookName")).sendKeys("myBook");
		element.findByIDSendKeys("bookName", comment.time());
		// driver.findElement(By.id("bookName")).sendKeys(time());

		// Thread.sleep(1000);
		String js = "document.getElementById('time').removeAttribute('readOnly');"
				+ "document.getElementById('time').setAttribute('value','2015-12-30');";
		// WebElement text1 = driver.findElement(By.id("time"));
		comment.executeScript(By.id("time"), js);

		// if (driver instanceof JavascriptExecutor) {
		// ((JavascriptExecutor) driver)
		// .executeScript(
		// ,
		// text1);
		// }
		element.findByIDClick("createBookButton");
		// driver.findElement(By.id("createBookButton")).click();
		// Thread.sleep(1000);
		element.findByIDClick("intoBookBtn");
		// driver.findElement(By.id("intoBookBtn")).click();
		element.findByCssClick("input.btnCss01.bookManagement");
	}

	@Test
	public String  test2Code() throws Exception {

		System.out.println("======进入testCode()方法=======" );
		Thread.sleep(500);
//		driver.findElement(By.cssSelector("input.btnCss01.bookManagement"))
//				.click();
//		element.findByCssClick("input.btnCss01.bookManagement");
//		String code = driver.findElement(By.className("color2")).getText();
		String code = element.getText(By.className("color2"));
		System.out.println("code = " + code);

		return code;
	}	
	
}
