package com.cases;

import org.testng.annotations.Test;

import com.common.BasicElements;
import com.common.BrowserElements;

public class AddActivitiesCase {
	BasicElements element = new BasicElements();
	BrowserElements browser = new BrowserElements();
	@Test
	public void testAddActivities() throws Exception {
		
		System.out.println("======进入testAddActivities()方法=======");
		
		Thread.sleep(3000);
		//点击书册管理
//		driver.findElement(By.xpath(".//*[@id='infori']/h1/input[1]")).click();
		element.findByXpathClick(".//*[@id='infori']/h1/input[1]");
		//点击页面管理
//		driver.findElement(By.linkText("页面管理")).click();
		element.findByLinkTextClick("页面管理");
		browser.refresh();
		Thread.sleep(3000);
//		driver.findElement(By.linkText("页面管理")).click();
		element.findByLinkTextClick("页面管理");
		//点击集体活动
//		driver.findElement(
//				By.xpath(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[7]"))
//				.click();
		element.findByXpathClick(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[7]");
		// 添加默认模板
		Thread.sleep(3000);
		for (int i = 0; i < 4; i++) {
			//点击添加页面按钮
//			driver.findElement(By.linkText("添加页面")).click();
			element.findByLinkTextClick("添加页面");
			//点击默认模板按钮
//			driver.findElement(
//					By.xpath("html/body/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[2]"))
//					.click();
			element.findByXpathClick("html/body/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[2]");
		}
		Thread.sleep(1000);
		//点击制作书页
//		driver.findElement(By.xpath(".//*[@id='topBar']/div/ul/li[1]/a"))
//				.click();
//		element.findByXpathClick(".//*[@id='topBar']/div/ul/li[1]/a]");
	}
}
