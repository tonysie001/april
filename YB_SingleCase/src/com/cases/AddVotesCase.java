package com.cases;

import org.testng.annotations.Test;

import com.common.BasicElements;

public class AddVotesCase {
	BasicElements element = new BasicElements();
	// 班长增加投票页
	@Test
	public void testAddVotes() throws Exception {
		
		System.out.println("======进入testAddVotes()方法=======");
		
//		driver.findElement(By.xpath(".//*[@id='infori']/h1/input[1]")).click();
		element.findByXpathClick(".//*[@id='infori']/h1/input[1]");				
//		driver.findElement(By.linkText("页面管理")).click();
		Thread.sleep(3000);
		element.findByLinkTextClick("页面管理");
		Thread.sleep(2000);
//		driver.findElement(
//				By.xpath(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[6]"))
//				.click();
		element.findByXpathClick(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[6]");
		// 循环添加N个默认模板
		 Thread.sleep(3000);
		for (int i = 0; i < 3; i++) {
//			driver.findElement(By.linkText("添加页面")).click();
			element.findByLinkTextClick("添加页面");
//			driver.findElement(
//					By.xpath("html/body/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[2]"))
//					.click();
		element.findByXpathClick("html/body/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[2]");
		}
		Thread.sleep(500);
		//制作书页按钮
//		driver.findElement(By.xpath(".//*[@id='topBar']/div/ul/li[1]/a"))
//				.click();
		element.findByXpathClick(".//*[@id='topBar']/div/ul/li[1]/a");
		Thread.sleep(500);
	}

	// 制作提交投票页
	@Test
	public void testCreateVote() throws Exception {
				
		System.out.println("======进入testCreateVote()方法=======");
		Thread.sleep(500);
//		driver.findElement(By.xpath(".//*[@id='summaryNav']/a")).click();
//		driver.findElement(By.linkText("我的书页")).click();
		element.findByLinkTextClick("我的书页");
		// 循环2次增加投票页面
		for (int i = 1; i < 4; i++) {
			Thread.sleep(500);
//			driver.findElement(By.xpath(".//*[@id='pageType_chzn']/a/span"))
//					.click();
			// 通过下拉框选择类型为投票
			element.findByXpathClick(".//*[@id='pageType_chzn']/a/span");
//			driver.findElement(By.xpath(".//*[@id='pageType_chzn_o_11']"))
//					.click();
			element.findByXpathClick(".//*[@id='pageType_chzn_o_11']");
			Thread.sleep(1000);
//			driver.findElement(
//					By.xpath("//*[@id='itemContainer']/li[" + i
//							+ "]/div/div/a[2]")).click();
			element.findByXpathClick("//*[@id='itemContainer']/li[" + i
							+ "]/div/div/a[2]");
			Thread.sleep(1000);
//			driver.findElement(
//					By.xpath("//div[@id='pageinfo']/div/ul/li/div/div/a/img"))
//					.click();// 第一个选择按钮
			element.findByXpathClick("//div[@id='pageinfo']/div/ul/li/div/div/a/img");
//			driver.findElement(By.xpath("//div[@id='voteSl']/div/div/input"))
//					.click();// radio button1
			element.findByXpathClick("//div[@id='voteSl']/div/div/input");
//			driver.findElement(By.className("sure")).click();
			element.findByClassClick("sure");
			Thread.sleep(1000);
//			driver.findElement(
//					By.xpath("//div[@id='pageinfo']/div/ul/li[3]/div/div/a/img"))
//					.click();// 第二个选择按钮
			element.findByXpathClick("//div[@id='pageinfo']/div/ul/li[3]/div/div/a/img");
//			driver.findElement(By.xpath("//div[@id='voteSl']/div/div/input"))
//					.click();
			element.findByXpathClick("//div[@id='voteSl']/div/div/input");
//			driver.findElement(By.className("sure")).click();
			element.findByClassClick("sure");
			Thread.sleep(1000);
//			driver.findElement(
//					By.xpath("//div[@id='pageinfo']/div/ul/li[5]/div/div/a/img"))
//					.click();// 第三个选择按钮
			element.findByXpathClick("//div[@id='pageinfo']/div/ul/li[5]/div/div/a/img");
//			driver.findElement(By.xpath("//div[@id='voteSl']/div/div/input"))
//					.click();
			element.findByXpathClick("//div[@id='voteSl']/div/div/input");
//			driver.findElement(By.className("sure")).click();
			element.findByClassClick("sure");
			Thread.sleep(1000);
//			driver.findElement(By.cssSelector(".btnCss03.pageSubmit")).click();
//			driver.findElement(By.cssSelector(".aui_state_highlight")).click();// 提交完成
			Thread.sleep(1000);
			
			
			
			
//			  driver.findElement(By.cssSelector("input.btnCss03.pageSave")).click();
			  element.findByCssClick("input.btnCss03.pageSave");
				Thread.sleep(1000);
//			  driver.findElement(By.cssSelector("#pageType_chzn > a.chzn-single > div > b")).click();
			  element.findByCssClick("#pageType_chzn > a.chzn-single > div > b");
				Thread.sleep(1000);
//			  driver.findElement(By.id("pageType_chzn_o_11")).click();
			  element.findByIDClick("pageType_chzn_o_11");
				Thread.sleep(1000);
//			  driver.findElement(By.xpath(".//*[@id='itemContainer']/li["+i+"]/input")).click();
			  element.findByXpathClick(".//*[@id='itemContainer']/li["+i+"]/input");
				Thread.sleep(1000);
//			  driver.findElement(By.xpath("//input[@value='提交']")).click();
//			  driver.findElement(By.cssSelector("button.aui_state_highlight")).click();
			  element.findByCssClick("button.aui_state_highlight");
				Thread.sleep(1000);
			// div[@id='voteSl']div[2]/div/input
		}

	}
}
