package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.soul.entity.YBEntity;


public class CreateVoteCase {

	// ������ͶƱ
	@Test
	public void testCreateVote(WebDriver driver, YBEntity yb) throws Exception {
		
		System.out.println("======����testCreateVote()����=======");
		
		
		driver.findElement(By.linkText("������ҳ")).click();

		Thread.sleep(1000);
		driver.findElement(By.linkText("����ͶƱ")).click();
		Thread.sleep(500);
		for (int i = 0; i < 5; i++) {
			System.out.println("====testCreateVote()for() =======" + i );
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".onbtnCss03")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath(".//*[@id='popupDiv']/div/div[1]/table/tbody/tr[1]/td[2]/input"))
					.sendKeys(yb.getTitle());
			driver.findElement(
					By.xpath(".//*[@id='popupDiv']/div/div[1]/table/tbody/tr[2]/td[2]/input"))
					.sendKeys(yb.getOption1());
			driver.findElement(
					By.xpath(".//*[@id='popupDiv']/div/div[1]/table/tbody/tr[3]/td[2]/input"))
					.sendKeys(yb.getOption2());
			driver.findElement(
					By.xpath(".//*[@id='popupDiv']/div/div[1]/table/tbody/tr[4]/td[2]/input"))
					.sendKeys(yb.getOption3());
			driver.findElement(By.id("createVote")).click();
			Thread.sleep(500);
		}
		driver.findElement(By.linkText("������ҳ")).click();
	}
}
