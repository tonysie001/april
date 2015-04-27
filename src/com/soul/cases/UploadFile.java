package com.soul.cases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.soul.data.Common;

public class UploadFile {
  @Test
  public static void openExe() {//执行exe文件
		Runtime rn = Runtime.getRuntime();
		Process p = null;
		try {
			p = rn.exec(Common.YB_MESSAGE_PATH);
		} catch (Exception e) {
			System.out.println("Error exec!");
		}
	}
  public void uploadfile(WebDriver driver) throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='summaryNav']/a")).click();//在首页点击我的书页
	  
	  Thread.sleep(500);
	  driver.findElement(By.xpath(".//*[@id='pageType_chzn']/a/span")).click();//通过下拉框选择类型为集体活动
	  
	  driver.findElement(By.xpath(".//*[@id='pageType_chzn_o_9']")).click();
	  Thread.sleep(2000);
	  
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='itemContainer']/li/div/div/a[2]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.cssSelector("img.upaction")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("loaclFile")).click();
		Thread.sleep(3000);
		openExe();//调用upfile.exe
		Thread.sleep(3000);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".aui_close")).click();
		driver.findElement(By.cssSelector(".aui_state_highlight")).click();
		driver.findElement(By.cssSelector(".progress>div>canvas")).click();
		Thread.sleep(1000);
		//上传照片成功并且点击完成中间的上传按钮。
  }

}
