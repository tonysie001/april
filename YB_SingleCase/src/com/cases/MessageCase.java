package com.cases;

import org.testng.annotations.Test;

import com.common.BasicElements;

public class MessageCase {
	BasicElements element = new BasicElements();
	// ��С�������
	@Test(dataProvider = "createMessageDate", dataProviderClass = ExcelDataProvider.class)
	public void testCreateMessage(String username,String messagename,String message) throws Exception {

		System.out.println("======����testCreateMessage()����=======");

		// System.out.println("ȡ�õ�ǰ�û����֣�username = " + username);

		// System.out.println("if  ()  username = " + username);
		// System.out.println(" login.getname= " + yb.getName());
//		driver.findElement(By.id("groupBtn")).click();
		element.findByIDClick("groupBtn");
		Thread.sleep(3000);
//		driver.findElement(By.linkText(messagename)).click();
		element.findByLinkTextClick(messagename);

		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input.onbtnCss03")).click();
		element.findByCssClick("input.onbtnCss03");
		Thread.sleep(2000);
//		driver.findElement(By.id("comment")).click();
		element.findByIDClick("comment");
		Thread.sleep(2000);
//		driver.findElement(By.id("comment")).clear();
		element.findByIDClear("comment");
//		driver.findElement(By.id("comment")).sendKeys(message);
		element.findByIDSendKeys("comment", message);
		Thread.sleep(2000);
//		driver.findElement(By.id("addCommentBut")).click();
		element.findByIDClick("addCommentBut");

		System.out.println("��Ҫ����");

//		driver.findElement(By.id("groupBtn")).click();
		element.findByIDClick("groupBtn");
		Thread.sleep(3000);
//		System.out.println("username = " + username);
//		driver.findElement(By.linkText(username)).click();
		element.findByLinkTextClick(username);

	}
}
