package com.cases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.common.BasicElements;

public class SubmitBookCase {
	BasicElements element = new BasicElements();
	//班长提交其他未提交页
	@Test
	public void testSubimitOthers() throws Exception {
		
		System.out.println("======进入testSubimitOthers()方法=======");
		//在首页点击我的书页
		// driver.findElement(By.xpath(".//*[@id='summaryNav']/a")).click();
//		driver.findElement(By.xpath(".//*[@id='pageStatus_chzn']/a/span"))
//				.click();
		element.findByXpathClick(".//*[@id='summaryNav']/a");
		element.findByXpathClick(".//*[@id='pageStatus_chzn']/a/span");
		
//		driver.findElement(By.xpath(".//*[@id='pageStatus_chzn_o_2']")).click();
		element.findByXpathClick(".//*[@id='pageStatus_chzn_o_2']");
		Thread.sleep(500);
		try {
			while (true) {
//				driver.findElement(
//						By.xpath(".//*[@id='itemContainer']/li[1]/input"))
//						.click();
				element.findByXpathClick(".//*[@id='itemContainer']/li[1]/input");
//				driver.findElement(By.cssSelector(".aui_state_highlight"))
//						.click();
				element.findByCssClick(".aui_state_highlight");
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException e) {
			return;
		}
	}

	//班长提交Note及书册
	@Test
	public void testSubmitBook() throws Exception {
		
		System.out.println("======进入testSubmitBook()方法=======");

//		driver.findElement(By.xpath(".//*[@id='infori']/h1/input[1]")).click();
		element.findByXpathClick(".//*[@id='infori']/h1/input[1]");
		Thread.sleep(1000);
//		driver.findElement(By.className("tab02")).click();
		element.findByClassClick("tab02");
		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[8]"))
//				.click();// 提交note页
		element.findByXpathClick(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[8]");
		Thread.sleep(2000);
		// driver.findElement(By.xpath(".//*[@id='bookManagefream']/div[2]/div[2]/div[1]/section/div/div/div/div[2]/a[3]")).click();
		element.findByXpathClick(".//*[@id='bookManagefream']/div[2]/div[2]/div[1]/section/div/div/div/div[2]/a[3]");
//		driver.findElement(By.cssSelector(".icon8.submitPage")).click();
		element.findByCssClick(".icon8.submitPage");
//		driver.findElement(By.cssSelector(".aui_state_highlight")).click();
		element.findByCssClick(".aui_state_highlight");
		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(".btnCss03.bookSubmitBtn")).click();
		element.findByCssClick(".btnCss03.bookSubmitBtn");
//		driver.findElement(By.cssSelector(".aui_state_highlight")).click();
		element.findByCssClick(".aui_state_highlight");
		Thread.sleep(2000);
	}
}
