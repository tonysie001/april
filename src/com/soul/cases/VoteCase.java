package com.soul.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VoteCase {

	// ͶƱ
	@Test
	public void testCreateVote(WebDriver driver) throws Exception {

		System.out.println("======����testCreateVote()����=======");

		// ����ƶ�����Ҷ�ݺ�������Ͷ��
		driver.findElement(By.linkText("����ͶƱ")).click();
		Thread.sleep(2000);

		/**
		 * ��һ��ͶƱ
		 */

		// ��ȡͶƱ����Ԫ��
		WebElement element = driver.findElement(By.className("spitem"));
		// ��ȡͶƱ����Ԫ��
		List<WebElement> buttons = element.findElements(By.tagName("span"));

		System.out.println(buttons.size());
		// ѡ��ͶƱ���ݵ�ѡ��
		buttons.get(testRandom()).click();
		// ����ͶƱ��ť
		driver.findElement(By.cssSelector("div.votbtn > input.btnCss05"))
				.click();
		Thread.sleep(2000);

		/**
		 * �ڶ���ͶƱ
		 */

		// ��ȡͶƱ����Ԫ��
		WebElement element1 = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[2]/div[2]"));
		// ��ȡͶƱ����Ԫ��
		List<WebElement> buttons1 = element1.findElements(By.tagName("span"));

		System.out.println(buttons1.size());
		// ѡ��ͶƱ���ݵ�ѡ��
		buttons1.get(testRandom()).click();
		// ����ͶƱ��ť
		// driver.findElement(By.cssSelector("div.votbtn > input.btnCss05")).click();
		driver.findElement(By.xpath("(//input[@value='ͶƱ'])[2]")).click();

		Thread.sleep(2000);

		// ѡ�񷵻���ҳ
		driver.findElement(By.linkText("������ҳ")).click();
		Thread.sleep(2000);

	}

	// ����1-3�������
	@Test
	public int testRandom() {
		int random = (int) (3 * Math.random() + 1);
		return random;
	}
}
