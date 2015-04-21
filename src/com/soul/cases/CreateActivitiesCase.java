package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CreateActivitiesCase {
  @Test
  public void testCreateaAtivities(WebDriver driver) throws InterruptedException  {
	  
	
		  System.out.println("======进入testCreateaAtivities()方法=======");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(".//*[@id='summaryNav']/a")).click();
		  //循环5次增加创建活动页面
		  for(int i =1; i<6;i++)
		  {
			  System.out.println("===testCreateaAtivities== i = " + i);
			  Thread.sleep(500);
			  driver.findElement(By.xpath(".//*[@id='pageType_chzn']/a/span")).click();//通过下拉框选择类型为集体活动
			  Thread.sleep(2000);
			  driver.findElement(By.xpath(".//*[@id='pageType_chzn_o_15']")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//*[@id='itemContainer']/li["+i+"]/div/div/a[2]")).click();
			  Thread.sleep(1000);
			  driver.findElement(By.id("imgMask0")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.id("imgSrc")).sendKeys("http://www.yearbook.com.cn/img/static/memento/online/book_banner.png");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath(" .//*[@id='imgSure']/input[1]")).click(); 
			  Thread.sleep(2000);
			  driver.findElement(By.cssSelector(".aui_close")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.cssSelector(".aui_state_highlight")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.cssSelector(".progress>div>canvas")).click();
			  Thread.sleep(1000);
			  for(int j = 1;j<4;j++)//循环添加小图片
			  {
				  try{
					  System.out.println("===testCreateaAtivities== j = " + j);
					  driver.findElement(By.id("imgMask"+j )).click(); 
					  Thread.sleep(2000);
					  driver.findElement(By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]")).click();
					  Thread.sleep(2000);
					  driver.findElement(By.id("imgSrc")).sendKeys("http://www.yearbook.com.cn/img/static/memento/online/book_banner.png");
					  Thread.sleep(2000);
					  driver.findElement(By.xpath(".//*[@id='popupDiv']/div/div[2]/input[3]")).click();
					  Thread.sleep(2000);
					  driver.findElement(By.xpath(" .//*[@id='imgSure']/input[1]")).click(); 
					  Thread.sleep(2000);
					  driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
					  Thread.sleep(2000);
					  driver.findElement(By.cssSelector(".progress>div>canvas")).click();
					  Thread.sleep(1000);
				  }catch(Exception e){
					// TODO Auto-generated catch block
					  e.printStackTrace();
//					  j++;
				  }
				 
			  }
			  driver.findElement(By.xpath(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[1]/div/p")).sendKeys("电影节");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[3]/span/p")).sendKeys("电影节");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[4]/div/p")).sendKeys(
			  		"经过近一年的筹备策划，班级进行了两部电影《时空博弈》、" +
			  		"《预定航线》的拍摄与制作。两部与穿越有关的电影，《预定航线》充满历史不可逆转的沉痛，" +
			  		"《时 空博弈》则有着对全新未来的憧憬，不一样的剧情，不一样的呈现方式，不一样的精彩。" +
	                "拍摄过程中，大家不仅体会到电影拍摄制作的不易，大家的团结和默契也与日俱增。拍摄电影给大" +
	                "家留下拍摄制作电影的经验，还有无数难忘的美好回忆。" +"电影节当天，主创人员的室内红毯别开生面，" +
	                		"大家的努力付出了得到了肯定。高中最重要的活动之一虽然落幕，但我们的青春仍未散场");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath(".//*[@id='frameContent']/div[2]/div[2]/input[3]")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.cssSelector(".aui_state_highlight")).click();
			  Thread.sleep(2000);
		  }
		  
  }
  
}
