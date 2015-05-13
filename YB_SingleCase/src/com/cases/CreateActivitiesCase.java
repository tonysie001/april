package com.cases;

import org.testng.annotations.Test;

import com.common.BasicElements;
import com.common.BrowserElements;

public class CreateActivitiesCase {
	BasicElements element = new BasicElements();
	BrowserElements browser = new BrowserElements();
	
	@Test
	public void testCreateaAtivities()
			throws InterruptedException {

		System.out.println("======进入testCreateaAtivities()方法=======");
//		Thread.sleep(3000);
//		element.findByLinkTextClick("制作书页");
//		driver.findElement(By.xpath(".//*[@id='summaryNav']/a")).click();
//		  driver.findElement(By.linkText("我的书页")).click();
		Thread.sleep(3000);
		  element.findByLinkTextClick("我的书页");
//		driver.findElement(By.xpath(".//*[@id='pageStatus_chzn']/a/span"))
//		.click();
		// 循环5次增加创建活动页面
		for (int i = 1; i < 6; i++) {
			System.out.println("===testCreateaAtivities== i = " + i);
//			Thread.sleep(2000);
//			driver.findElement(By.xpath(".//*[@id='pageType_chzn']/a/span"))
//					.click();
			// 通过下拉框选择类型为集体活动
			element.findByXpathClick(".//*[@id='pageType_chzn']/a/span");				
			Thread.sleep(2000);
//			driver.findElement(By.xpath(".//*[@id='pageType_chzn_o_15']"))
//					.click();
			element.findByXpathClick(".//*[@id='pageType_chzn_o_15']");				
			Thread.sleep(2000);
//			driver.findElement(
//					By.xpath("//*[@id='itemContainer']/li[" + i
//							+ "]/div/div/a[2]")).click();
			element.findByXpathClick("//*[@id='itemContainer']/li[" + i	+ "]/div/div/a[2]");				
			Thread.sleep(1000);
//			driver.findElement(By.id("imgMask0")).click();
			element.findByIDClick("imgMask0");
			Thread.sleep(2000);
//			driver.findElement(
//					By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]"))
//					.click();
			element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");				
			Thread.sleep(2000);
//			driver.findElement(By.id("imgSrc"))
//					.sendKeys(
//							"http://192.168.2.185/img/static/memento/online/book_banner.png");
			element.findByIDSendKeys("imgSrc", "http://192.168.2.185/img/static/memento/online/book_banner.png");
			Thread.sleep(2000);
//			driver.findElement(
//					By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]"))
//					.click();
			element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");				
			Thread.sleep(2000);
//			driver.findElement(By.xpath(" .//*[@id='imgSure']/input[1]"))
//					.click();
			element.findByXpathClick(".//*[@id='imgSure']/input[1]");				
			Thread.sleep(2000);
//			driver.findElement(By.cssSelector(".aui_close")).click();
			element.findByCssClick(".aui_close");
			Thread.sleep(2000);
//			driver.findElement(By.cssSelector(".aui_state_highlight")).click();
			element.findByCssClick(".aui_state_highlight");
			Thread.sleep(2000);
//			driver.findElement(By.cssSelector(".progress>div>canvas")).click();
			element.findByCssClick(".progress>div>canvas");
			Thread.sleep(1000);
			for (int j = 1; j < 4; j++)// 循环添加小图片
			{
				try {
					System.out.println("===testCreateaAtivities== j = " + j);
//					driver.findElement(By.id("imgMask" + j)).click();
					element.findByIDClick("imgMask"+j);
					Thread.sleep(2000);
//					driver.findElement(
//							By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]"))
//							.click();
					element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");				
					Thread.sleep(2000);
//					driver.findElement(By.id("imgSrc"))
//							.sendKeys(
//									"http://192.168.2.185/img/static/memento/online/book_banner.png");
					element.findByIDSendKeys("imgSrc", "http://192.168.2.185/img/static/memento/online/book_banner.png");
					Thread.sleep(2000);
//					driver.findElement(
//							By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]"))
//							.click();
					element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");				
					Thread.sleep(2000);
//					driver.findElement(
//							By.xpath(" .//*[@id='imgSure']/input[1]")).click();
					element.findByXpathClick(".//*[@id='imgSure']/input[1]");	
					Thread.sleep(2000);
//					driver.findElement(
//							By.xpath("(//button[@type='button'])[2]")).click();
					element.findByXpathClick("(//button[@type='button'])[2]");		
					Thread.sleep(2000);
//					driver.findElement(By.cssSelector(".progress>div>canvas"))
//							.click();
					element.findByCssClick(".progress>div>canvas");
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// j++;
				}

			}
//			driver.findElement(
//					By.xpath(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[1]/div/p"))
//					.sendKeys("电影节");
			element.findByXpathSendKeys(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[1]/div/p", "电影节");
			Thread.sleep(2000);
//			driver.findElement(
//					By.xpath(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[3]/span/p"))
//					.sendKeys("电影节");
			element.findByXpathSendKeys(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[3]/span/p", "电影节");
			Thread.sleep(2000);
//			driver.findElement(
//					By.xpath(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[4]/div/p"))
//					.sendKeys(
//							"经过近一年的筹备策划，班级进行了两部电影《时空博弈》、"
//									+ "《预定航线》的拍摄与制作。两部与穿越有关的电影，《预定航线》充满历史不可逆转的沉痛，"
//									+ "《时 空博弈》则有着对全新未来的憧憬，不一样的剧情，不一样的呈现方式，不一样的精彩。"
//									+ "拍摄过程中，大家不仅体会到电影拍摄制作的不易，大家的团结和默契也与日俱增。拍摄电影给大"
//									+ "家留下拍摄制作电影的经验，还有无数难忘的美好回忆。"
//									+ "电影节当天，主创人员的室内红毯别开生面，"
//									+ "大家的努力付出了得到了肯定。高中最重要的活动之一虽然落幕，但我们的青春仍未散场");
			String text = "经过近一年的筹备策划，班级进行了两部电影《时空博弈》、"
					+ "《预定航线》的拍摄与制作。两部与穿越有关的电影，《预定航线》充满历史不可逆转的沉痛，"
					+ "《时 空博弈》则有着对全新未来的憧憬，不一样的剧情，不一样的呈现方式，不一样的精彩。"
					+ "拍摄过程中，大家不仅体会到电影拍摄制作的不易，大家的团结和默契也与日俱增。拍摄电影给大"
					+ "家留下拍摄制作电影的经验，还有无数难忘的美好回忆。"
					+ "电影节当天，主创人员的室内红毯别开生面，"
					+ "大家的努力付出了得到了肯定。高中最重要的活动之一虽然落幕，但我们的青春仍未散场";
			element.findByXpathSendKeys(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[4]/div/p", text);
			Thread.sleep(2000);

			// 点击保存按钮

//			driver.findElement(By.cssSelector("input.btnCss03.pageSave"))
//					.click();
			element.findByCssClick("input.btnCss03.pageSave");
			Thread.sleep(3000);
//			driver.findElement(
//					By.cssSelector("#pageType_chzn > a.chzn-single > div > b"))
//					.click();
			element.findByCssClick("#pageType_chzn > a.chzn-single > div > b");
			Thread.sleep(3000);
//			driver.findElement(By.id("pageType_chzn_o_15")).click();
			element.findByIDClick("pageType_chzn_o_15");
			Thread.sleep(3000);
//			driver.findElement(
//					By.xpath(".//*[@id='itemContainer']/li[" + i + "]/input"))
//					.click();
			element.findByXpathClick(".//*[@id='itemContainer']/li[" + i + "]/input");
			Thread.sleep(3000);
//			driver.findElement(By.cssSelector("button.aui_state_highlight"))
//					.click();
			element.findByCssClick("button.aui_state_highlight");
			Thread.sleep(2000);

		}
	}
}
