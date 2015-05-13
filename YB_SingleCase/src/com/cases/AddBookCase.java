package com.cases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.common.BasicElements;

public class AddBookCase {
	BasicElements element = new BasicElements();
	CreateBooksCase book = new CreateBooksCase();
	

	// �����ҵ����
	@Test
	public void testMyBook()throws Exception {
		System.out.println("======����testMyBook()����=======");
			// ����ҵ����
		
//			driver.findElement(By.linkText("�ҵ����")).click();
			element.findByLinkTextClick("�ҵ����");
	}

	// ��������
	@Parameters({"code"})
	@Test
	public void testAddBook(String code) throws Exception {
		Thread.sleep(3000);

		System.out.println("======����testAddBook()����=======");
		System.out.println("code == " +  code);
		// ������������
//		driver.findElement(By.xpath("//*[@id='addBook']")).click();
		element.findByXpathClick("//*[@id='addBook']");
		Thread.sleep(1000);

		// ���������������ֵ
//		driver.findElement(By.id("keyword")).clear();
		element.findByIDClear("keyword");
		Thread.sleep(500);

		// ����������
//		driver.findElement(By.id("keyword")).sendKeys(code);
	
		element.findByIDSendKeys("keyword", code);
		Thread.sleep(500);

		// ������밴ť
//		driver.findElement(By.id("checkBut")).click();
		element.findByIDClick("checkBut");
		Thread.sleep(3000);

	}

	// �򿪲�������
	@Test
	public void testOpenBook() throws Exception {

		System.out.println("======����testOpenBook()����=======");

		// ����ҵ����
//		driver.findElement(By.linkText("�ҵ����")).click();
		element.findByLinkTextClick("�ҵ����");
		Thread.sleep(3000);

		// ����ռ���������
//		driver.findElement(
//				By.cssSelector("html body div#frameContent.content div.perrig_home ul.booklist li.mypage div a img"))
//				.click();
		element.findByCssClick("html body div#frameContent.content div.perrig_home ul.booklist li.mypage div a img");
		Thread.sleep(3000);
	}

	// �򿪴�������
	@Test
	public void testOpenCreateBook() throws Exception {
		
		System.out.println("======����testOpenCreateBook()����=======");
		
		// ����ҵ����
//		driver.findElement(By.linkText("�ҵ����")).click();
		element.findByLinkTextClick("�ҵ����");
		Thread.sleep(3000);
		// ����մ���������ᣨ�Ϸ��޲�����ᣩ
//		driver.findElement(By.xpath(".//*[@id='frameContent']/div/ul/li[1]/div[2]/a/img")).click();
		//����մ���������ᣨ�Ϸ��в�����ᣩ
//		driver.findElement(By.xpath(".//*[@id='frameContent']/div/ul[2]/li[1]/div[2]/a/img")).click();
		element.findByXpathClick(".//*[@id='frameContent']/div/ul[2]/li[1]/div[2]/a/img");
	}
}
