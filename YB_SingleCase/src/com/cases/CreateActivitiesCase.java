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

		System.out.println("======����testCreateaAtivities()����=======");
//		Thread.sleep(3000);
//		element.findByLinkTextClick("������ҳ");
//		driver.findElement(By.xpath(".//*[@id='summaryNav']/a")).click();
//		  driver.findElement(By.linkText("�ҵ���ҳ")).click();
		Thread.sleep(3000);
		  element.findByLinkTextClick("�ҵ���ҳ");
//		driver.findElement(By.xpath(".//*[@id='pageStatus_chzn']/a/span"))
//		.click();
		// ѭ��5�����Ӵ����ҳ��
		for (int i = 1; i < 6; i++) {
			System.out.println("===testCreateaAtivities== i = " + i);
//			Thread.sleep(2000);
//			driver.findElement(By.xpath(".//*[@id='pageType_chzn']/a/span"))
//					.click();
			// ͨ��������ѡ������Ϊ����
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
			for (int j = 1; j < 4; j++)// ѭ�����СͼƬ
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
//					.sendKeys("��Ӱ��");
			element.findByXpathSendKeys(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[1]/div/p", "��Ӱ��");
			Thread.sleep(2000);
//			driver.findElement(
//					By.xpath(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[3]/span/p"))
//					.sendKeys("��Ӱ��");
			element.findByXpathSendKeys(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[3]/span/p", "��Ӱ��");
			Thread.sleep(2000);
//			driver.findElement(
//					By.xpath(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[4]/div/p"))
//					.sendKeys(
//							"������һ��ĳﱸ�߻����༶������������Ӱ��ʱ�ղ��ġ���"
//									+ "��Ԥ�����ߡ��������������������봩Խ�йصĵ�Ӱ����Ԥ�����ߡ�������ʷ������ת�ĳ�ʹ��"
//									+ "��ʱ �ղ��ġ������Ŷ�ȫ��δ�����㽣���һ���ľ��飬��һ���ĳ��ַ�ʽ����һ���ľ��ʡ�"
//									+ "��������У���Ҳ�����ᵽ��Ӱ���������Ĳ��ף���ҵ��Ž��Ĭ��Ҳ���վ����������Ӱ����"
//									+ "����������������Ӱ�ľ��飬�����������������û��䡣"
//									+ "��Ӱ�ڵ��죬������Ա�����ں�̺�����棬"
//									+ "��ҵ�Ŭ�������˵õ��˿϶�����������Ҫ�Ļ֮һ��Ȼ��Ļ�������ǵ��ഺ��δɢ��");
			String text = "������һ��ĳﱸ�߻����༶������������Ӱ��ʱ�ղ��ġ���"
					+ "��Ԥ�����ߡ��������������������봩Խ�йصĵ�Ӱ����Ԥ�����ߡ�������ʷ������ת�ĳ�ʹ��"
					+ "��ʱ �ղ��ġ������Ŷ�ȫ��δ�����㽣���һ���ľ��飬��һ���ĳ��ַ�ʽ����һ���ľ��ʡ�"
					+ "��������У���Ҳ�����ᵽ��Ӱ���������Ĳ��ף���ҵ��Ž��Ĭ��Ҳ���վ����������Ӱ����"
					+ "����������������Ӱ�ľ��飬�����������������û��䡣"
					+ "��Ӱ�ڵ��죬������Ա�����ں�̺�����棬"
					+ "��ҵ�Ŭ�������˵õ��˿϶�����������Ҫ�Ļ֮һ��Ȼ��Ļ�������ǵ��ഺ��δɢ��";
			element.findByXpathSendKeys(".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[4]/div/p", text);
			Thread.sleep(2000);

			// ������水ť

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
