package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddActivitiesCase {
	@Test
	public void testAddActivities(WebDriver driver) throws Exception {
		
		System.out.println("======进入testAddActivities()方法=======");
		
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='infori']/h1/input[1]")).click();
		driver.findElement(By.linkText("页面管理")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[7]"))
				.click();
		// 循环添加4个默认模板
		Thread.sleep(3000);
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.linkText("添加页面")).click();
			driver.findElement(
					By.xpath("html/body/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[2]"))
					.click();
		}
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='topBar']/div/ul/li[1]/a"))
				.click();
	}

}
