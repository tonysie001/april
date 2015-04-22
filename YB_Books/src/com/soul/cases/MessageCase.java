package com.soul.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.soul.entity.YBEntity;

public class MessageCase {

	// 给小伙伴留言
	@Test
	public void testCreateMessage(WebDriver driver, String username,
			List<YBEntity> list) throws Exception {

		System.out.println("======进入testCreateMessage()方法=======");

		for (YBEntity yb : list) {
			if (username.equals(yb.getName())) {

			} else {
				System.out.println(username != yb.getName());
				System.out.println("if  ()  username = " + username);
				System.out.println(" yb.getname= " + yb.getName());
				Thread.sleep(3000);
				driver.findElement(By.id("groupBtn")).click();
				Thread.sleep(3000);
				driver.findElement(By.linkText(yb.getName())).click();

				Thread.sleep(2000);
				driver.findElement(By.cssSelector("input.onbtnCss03")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("comment")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("comment")).clear();
				driver.findElement(By.id("comment")).sendKeys(yb.getMessage());
				Thread.sleep(2000);
				driver.findElement(By.id("addCommentBut")).click();
			}

		}
		driver.findElement(By.id("groupBtn")).click();
		Thread.sleep(3000);
		System.out.println("username = " + username);
		driver.findElement(By.linkText(username)).click();

	}

}
