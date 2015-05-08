package com.cases;

import org.testng.annotations.Test;

import com.common.BasicElements;
import com.common.BrowserElements;

public class SayCase {
	
	BasicElements element = new BasicElements();
	BrowserElements browser = new BrowserElements();
	// 此刻想说
	@Test(dataProvider = "createSayDate", dataProviderClass = ExcelDataProvider.class)
	public void testCreateSay(String say1,String say2,String say3) throws Exception {

		System.out.println("======进入testCreateSay()方法=======");
		Thread.sleep(2000);
		// 点击接下去的打算？
//		driver.findElement(By.linkText("接下去的打算？")).click();
		element.findByLinkTextClick("接下去的打算？");
//		System.out.println(driver.findElement(By.linkText("接下去的打算？")));

		try {
			testCreateMySay();
		} catch (Exception e) {

			// 刷新页面
			browser.refresh();
			Thread.sleep(1000);
			// 点击接下去的打算？
//			driver.findElement(By.linkText("接下去的打算？")).click();
			element.findByLinkTextClick("接下去的打算？");
			testCreateMySay();
		}

		// 向文本框输入信息
//		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
//				.sendKeys(yb.getSayone());
		element.findByCssSendKeys("textarea.speak.isayinput", say1);
		testCreateSayButton();

//		driver.findElement(By.linkText("结束语")).click();
		element.findByLinkTextClick("结束语");
//		System.out.println(driver.findElement(By.linkText("结束语")));

		try {
			testCreateMySay();
		} catch (Exception e) {

			// 刷新页面
			browser.refresh();
			Thread.sleep(1000);
			// 结束语
//			driver.findElement(By.linkText("结束语")).click();
			element.findByLinkTextClick("结束语");
			testCreateMySay();
		}
		// 向文本框输入信息
//		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
//				.sendKeys(yb.getSaytwo());
		element.findByCssSendKeys("textarea.speak.isayinput", say2);
		
		testCreateSayButton();

//		driver.findElement(By.linkText("在这个集体中最值得回忆的？")).click();
		element.findByLinkTextClick("在这个集体中最值得回忆的？");
//		System.out.println(driver.findElement(By.linkText("在这个集体中最值得回忆的？")));

		try {
			testCreateMySay();
		} catch (Exception e) {

			// 刷新页面
			browser.refresh();
			Thread.sleep(1000);
			// 在这个集体中最值得回忆的？
//			driver.findElement(By.linkText("在这个集体中最值得回忆的？")).click();
			element.findByLinkTextClick("在这个集体中最值得回忆的？");
			testCreateMySay();
		}
		
		// 向文本框输入信息
//		driver.findElement(By.cssSelector("textarea.speak.isayinput"))
//				.sendKeys(yb.getSaythree());
		element.findByCssSendKeys("textarea.speak.isayinput", say3);
		testCreateSayButton();

	}

	@Test
	public void testCreateMySay() {
		try {
			Thread.sleep(1000);
			// 点击我也说
//			driver.findElement(By.linkText("我也说")).click();
			element.findByLinkTextClick("我也说");
			Thread.sleep(1000);
			// 清空文本框信息
//			driver.findElement(By.cssSelector("textarea.speak.isayinput")).clear();
			element.findByCssClear("textarea.speak.isayinput");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testCreateSayButton() {
		try {
			Thread.sleep(1000);
			// 点击确定
//			driver.findElement(By.linkText("确认")).click();
			element.findByLinkTextClick("确认");
			Thread.sleep(1000);
			// 刷新页面
			browser.refresh();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
