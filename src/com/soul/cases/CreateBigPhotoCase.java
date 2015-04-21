package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CreateBigPhotoCase {
	
	//制作全景照片
	@Test
	public void testCreateBigPhoto(WebDriver driver) throws Exception {
		
		System.out.println("======进入testCreateBigPhoto()方法=======");
		
		// driver.findElement(By.xpath(".//*[@id='summaryNav']/a")).click();//在首页点击我的书页
		driver.findElement(By.xpath(".//*[@id='pageType_chzn']/a/span"))
				.click();// 通过下拉框选择类型为全景照片
		driver.findElement(By.xpath(".//*[@id='pageType_chzn_o_16']")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id='itemContainer']/li[1]/div/div/a[2]"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.id("imgMask0")).click();
		driver.findElement(By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]"))
				.click();
		driver.findElement(By.id("imgSrc"))
				.sendKeys(
						"http://192.168.2.185/img/static/memento/online/book_banner.png");
		driver.findElement(By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]"))
				.click();
		driver.findElement(By.xpath(" .//*[@id='imgSure']/input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".aui_close")).click();
		driver.findElement(By.cssSelector(".aui_state_highlight")).click();
		driver.findElement(By.cssSelector(".progress>div>canvas")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath(".//*[@id='frameContent']/div[2]/div[2]/input[3]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".aui_state_highlight")).click();
		Thread.sleep(2000);
	}
}
