package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddVotesCase {

	// 班长增加投票页
	@Test
	public void testAddVotes(WebDriver driver) throws Exception {
		
		System.out.println("======进入testAddVotes()方法=======");
		
		driver.findElement(By.xpath(".//*[@id='infori']/h1/input[1]")).click();
		driver.findElement(By.linkText("页面管理")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[6]"))
				.click();
		// 循环添加N个默认模板
		// Thread.sleep(3000);
		for (int i = 0; i < 3; i++) {
			driver.findElement(By.linkText("添加页面")).click();
			driver.findElement(
					By.xpath("html/body/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[2]"))
					.click();
		}
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='topBar']/div/ul/li[1]/a"))
				.click();
	}

	// 制作提交投票页
	@Test
	public void testCreateVote(WebDriver driver) throws Exception {
				
		System.out.println("======进入testCreateVote()方法=======");
		
		driver.findElement(By.xpath(".//*[@id='summaryNav']/a")).click();
		// 循环2次增加投票页面
		for (int i = 1; i < 4; i++) {
			Thread.sleep(500);
			driver.findElement(By.xpath(".//*[@id='pageType_chzn']/a/span"))
					.click();// 通过下拉框选择类型为投票
			driver.findElement(By.xpath(".//*[@id='pageType_chzn_o_11']"))
					.click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//*[@id='itemContainer']/li[" + i
							+ "]/div/div/a[2]")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//div[@id='pageinfo']/div/ul/li/div/div/a/img"))
					.click();// 第一个选择按钮
			driver.findElement(By.xpath("//div[@id='voteSl']/div/div/input"))
					.click();// radio button1
			driver.findElement(By.className("sure")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//div[@id='pageinfo']/div/ul/li[3]/div/div/a/img"))
					.click();// 第二个选择按钮
			driver.findElement(By.xpath("//div[@id='voteSl']/div/div/input"))
					.click();
			driver.findElement(By.className("sure")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//div[@id='pageinfo']/div/ul/li[5]/div/div/a/img"))
					.click();// 第三个选择按钮
			driver.findElement(By.xpath("//div[@id='voteSl']/div/div/input"))
					.click();
			driver.findElement(By.className("sure")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".btnCss03.pageSubmit")).click();
			driver.findElement(By.cssSelector(".aui_state_highlight")).click();// 提交完成
			Thread.sleep(1000);
			// div[@id='voteSl']div[2]/div/input
		}

	}
}
