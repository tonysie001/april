package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CreateActivitiesCase {
  @Test
  public void testCreateaAtivities(WebDriver driver) throws InterruptedException  {
	  
	
		  System.out.println("======����testCreateaAtivities()����=======");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(".//*[@id='summaryNav']/a")).click();
		  //ѭ��5�����Ӵ����ҳ��
		  for(int i =1; i<6;i++)
		  {
			  System.out.println("===testCreateaAtivities== i = " + i);
			  Thread.sleep(500);
			  driver.findElement(By.xpath(".//*[@id='pageType_chzn']/a/span")).click();//ͨ��������ѡ������Ϊ����
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
			  for(int j = 1;j<4;j++)//ѭ�����СͼƬ
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
			  driver.findElement(By.xpath(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[1]/div/p")).sendKeys("��Ӱ��");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[3]/span/p")).sendKeys("��Ӱ��");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[4]/div/p")).sendKeys(
			  		"������һ��ĳﱸ�߻����༶������������Ӱ��ʱ�ղ��ġ���" +
			  		"��Ԥ�����ߡ��������������������봩Խ�йصĵ�Ӱ����Ԥ�����ߡ�������ʷ������ת�ĳ�ʹ��" +
			  		"��ʱ �ղ��ġ������Ŷ�ȫ��δ�����㽣���һ���ľ��飬��һ���ĳ��ַ�ʽ����һ���ľ��ʡ�" +
	                "��������У���Ҳ�����ᵽ��Ӱ���������Ĳ��ף���ҵ��Ž��Ĭ��Ҳ���վ����������Ӱ����" +
	                "����������������Ӱ�ľ��飬�����������������û��䡣" +"��Ӱ�ڵ��죬������Ա�����ں�̺�����棬" +
	                		"��ҵ�Ŭ�������˵õ��˿϶�����������Ҫ�Ļ֮һ��Ȼ��Ļ�������ǵ��ഺ��δɢ��");
			  Thread.sleep(2000);
			  driver.findElement(By.xpath(".//*[@id='frameContent']/div[2]/div[2]/input[3]")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.cssSelector(".aui_state_highlight")).click();
			  Thread.sleep(2000);
		  }
		  
  }
  
}
