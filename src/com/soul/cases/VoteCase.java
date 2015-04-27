package com.soul.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VoteCase {

	// 投票
	@Test
	public void testCreateVote(WebDriver driver) throws Exception {

		System.out.println("======进入testCreateVote()方法=======");

		// 鼠标移动到四叶草后点击举手投樯
		driver.findElement(By.linkText("举手投票")).click();
		Thread.sleep(2000);

		/**
		 * 第一个投票
		 */

		// 获取投票父类元素
		WebElement element = driver.findElement(By.className("spitem"));
		// 获取投票子类元素
		List<WebElement> buttons = element.findElements(By.tagName("span"));

		System.out.println(buttons.size());
		// 选择投票内容单选框
		buttons.get(testRandom()).click();
		// 单击投票按钮
		driver.findElement(By.cssSelector("div.votbtn > input.btnCss05"))
				.click();
		Thread.sleep(2000);

		/**
		 * 第二个投票
		 */

		// 获取投票父类元素
		WebElement element1 = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[2]/div[2]"));
		// 获取投票子类元素
		List<WebElement> buttons1 = element1.findElements(By.tagName("span"));

		System.out.println(buttons1.size());
		// 选择投票内容单选框
		buttons1.get(testRandom()).click();
		// 单击投票按钮
		// driver.findElement(By.cssSelector("div.votbtn > input.btnCss05")).click();
		driver.findElement(By.xpath("(//input[@value='投票'])[2]")).click();

		Thread.sleep(2000);

		// 选择返回首页
		driver.findElement(By.linkText("返回首页")).click();
		Thread.sleep(2000);

	}

	// 产生1-3随机整数
	@Test
	public int testRandom() {
		int random = (int) (3 * Math.random() + 1);
		return random;
	}
}
