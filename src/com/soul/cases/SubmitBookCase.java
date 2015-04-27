package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SubmitBookCase {

	//�೤�ύ����δ�ύҳ
	@Test
	public void testSubimitOthers(WebDriver driver) throws Exception {
		
		System.out.println("======����testSubimitOthers()����=======");
		
		// driver.findElement(By.xpath(".//*[@id='summaryNav']/a")).click();//����ҳ����ҵ���ҳ
		driver.findElement(By.xpath(".//*[@id='pageStatus_chzn']/a/span"))
				.click();
		driver.findElement(By.xpath(".//*[@id='pageStatus_chzn_o_2']")).click();
		Thread.sleep(500);
		try {
			while (true) {
				driver.findElement(
						By.xpath(".//*[@id='itemContainer']/li[1]/input"))
						.click();
				driver.findElement(By.cssSelector(".aui_state_highlight"))
						.click();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException e) {
			return;
		}
	}

	//�೤�ύNote������
	@Test
	public void testSubmitBook(WebDriver driver) throws Exception {
		
		
		System.out.println("======����testSubmitBook()����=======");

		driver.findElement(By.xpath(".//*[@id='infori']/h1/input[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("tab02")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[8]"))
				.click();// �ύnoteҳ
		Thread.sleep(2000);
		// driver.findElement(By.xpath(".//*[@id='bookManagefream']/div[2]/div[2]/div[1]/section/div/div/div/div[2]/a[3]")).click();
		driver.findElement(By.cssSelector(".icon8.submitPage")).click();
		driver.findElement(By.cssSelector(".aui_state_highlight")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btnCss03.bookSubmitBtn")).click();
		driver.findElement(By.cssSelector(".aui_state_highlight")).click();
		Thread.sleep(2000);
	}
}
