package com.cases;

import org.testng.annotations.Test;

import com.common.BasicElements;

public class CreateBigPhotoCase {
	BasicElements element = new BasicElements();
	//制作全景照片
	@Test
	public void testCreateBigPhoto() throws Exception {
		
		System.out.println("======进入testCreateBigPhoto()方法=======");
		
		// driver.findElement(By.xpath(".//*[@id='summaryNav']/a")).click();//在首页点击我的书页
		element.findByXpathClick(".//*[@id='summaryNav']/a");
//		driver.findElement(By.xpath(".//*[@id='pageType_chzn']/a/span"))
//				.click();
		// 通过下拉框选择类型为全景照片
		element.findByXpathClick(".//*[@id='pageType_chzn']/a/span");			
//		driver.findElement(By.xpath(".//*[@id='pageType_chzn_o_16']")).click();
		element.findByXpathClick(".//*[@id='pageType_chzn_o_16']");			
		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("//*[@id='itemContainer']/li[1]/div/div/a[2]"))
//				.click();
		element.findByXpathClick("//*[@id='itemContainer']/li[1]/div/div/a[2]");			
		Thread.sleep(500);
//		driver.findElement(By.id("imgMask0")).click();
		element.findByIDClick("imgMask0");
//		driver.findElement(By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]"))
//				.click();
		element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");			
//		driver.findElement(By.id("imgSrc"))
//				.sendKeys(
//						"http://192.168.2.185/img/static/memento/online/book_banner.png");
		element.findByIDSendKeys("imgSrc", "http://192.168.2.185/img/static/memento/online/book_banner.png");
//		driver.findElement(By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]"))
//				.click();
		element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");			
//		driver.findElement(By.xpath(" .//*[@id='imgSure']/input[1]")).click();
		element.findByXpathClick(".//*[@id='imgSure']/input[1]");			
		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(".aui_close")).click();
		element.findByCssClick(".aui_close");
//		driver.findElement(By.cssSelector(".aui_state_highlight")).click();
		element.findByCssClick(".aui_state_highlight");
//		driver.findElement(By.cssSelector(".progress>div>canvas")).click();
		element.findByCssClick(".progress>div>canvas");
		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath(".//*[@id='frameContent']/div[2]/div[2]/input[3]"))
//				.click();
		element.findByXpathClick(".//*[@id='frameContent']/div[2]/div[2]/input[3]");			
		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(".aui_state_highlight")).click();
		element.findByCssClick(".aui_state_highlight");
		Thread.sleep(2000);
	}
}
