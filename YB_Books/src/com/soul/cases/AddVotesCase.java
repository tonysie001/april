package com.soul.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddVotesCase {

	// �೤����ͶƱҳ
	@Test
	public void testAddVotes(WebDriver driver) throws Exception {
		
		System.out.println("======����testAddVotes()����=======");
		
		driver.findElement(By.xpath(".//*[@id='infori']/h1/input[1]")).click();
		driver.findElement(By.linkText("ҳ�����")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[6]"))
				.click();
		// ѭ�����N��Ĭ��ģ��
		// Thread.sleep(3000);
		for (int i = 0; i < 3; i++) {
			driver.findElement(By.linkText("���ҳ��")).click();
			driver.findElement(
					By.xpath("html/body/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[2]"))
					.click();
		}
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='topBar']/div/ul/li[1]/a"))
				.click();
	}

	// �����ύͶƱҳ
	@Test
	public void testCreateVote(WebDriver driver) throws Exception {
				
		System.out.println("======����testCreateVote()����=======");
		
		driver.findElement(By.xpath(".//*[@id='summaryNav']/a")).click();
		// ѭ��2������ͶƱҳ��
		for (int i = 1; i < 4; i++) {
			Thread.sleep(500);
			driver.findElement(By.xpath(".//*[@id='pageType_chzn']/a/span"))
					.click();// ͨ��������ѡ������ΪͶƱ
			driver.findElement(By.xpath(".//*[@id='pageType_chzn_o_11']"))
					.click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//*[@id='itemContainer']/li[" + i
							+ "]/div/div/a[2]")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//div[@id='pageinfo']/div/ul/li/div/div/a/img"))
					.click();// ��һ��ѡ��ť
			driver.findElement(By.xpath("//div[@id='voteSl']/div/div/input"))
					.click();// radio button1
			driver.findElement(By.className("sure")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//div[@id='pageinfo']/div/ul/li[3]/div/div/a/img"))
					.click();// �ڶ���ѡ��ť
			driver.findElement(By.xpath("//div[@id='voteSl']/div/div/input"))
					.click();
			driver.findElement(By.className("sure")).click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//div[@id='pageinfo']/div/ul/li[5]/div/div/a/img"))
					.click();// ������ѡ��ť
			driver.findElement(By.xpath("//div[@id='voteSl']/div/div/input"))
					.click();
			driver.findElement(By.className("sure")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".btnCss03.pageSubmit")).click();
			driver.findElement(By.cssSelector(".aui_state_highlight")).click();// �ύ���
			Thread.sleep(1000);
			// div[@id='voteSl']div[2]/div/input
		}

	}
}
