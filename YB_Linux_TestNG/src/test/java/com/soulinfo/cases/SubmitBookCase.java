package com.soulinfo.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.BrowserElements;
import com.soulinfo.util.CommonElements;

public class SubmitBookCase {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	BasicElements element = new BasicElements();
	BrowserElements browser = new BrowserElements();
	CommonElements common = new CommonElements();

	/**
	 * 班长提交其他未提交页
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSubimitOthers() throws Exception {

		logger.info("======进入testSubimitOthers()方法=======");

		// 在首页点击我的书页
//		element.findByLinkTextClick("我的书页");

		// 循环两次用来提交第二页内容
//		for (int i = 0; i < 2; i++) {
			// 通过下拉列表选择未提交数据
			element.findByXpathClick(".//*[@id='pageStatus_chzn']/a/span");
			element.findByXpathClick(".//*[@id='pageStatus_chzn_o_2']");
			Thread.sleep(500);
			List<WebElement> submit = element.findSelect(
					By.id("itemContainer"), "li");
			common.getScreen("submitdata"+submit.size());
			
			for (int j = 0; j < submit.size(); j++) {
				// 点击提交按钮
				element.findByXpathClick(".//*[@id='itemContainer']/li[1]/input");
				// 点击确定按钮
				element.findByCssClick(".aui_state_highlight");
				Thread.sleep(2000);
			}
//			browser.refresh();
//			Thread.sleep(3000);
//		}
	}

	/**
	 * 班长提交留言及书册
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSubmitBook() throws Exception {

		logger.info("======进入testSubmitBook()方法=======");

		// 点击书册管理
		element.findByXpathClick(".//*[@id='infori']/h1/input[1]");
		Thread.sleep(2000);

		// 点击页面管理
		element.findByLinkTextClick("页面管理");

		// 提交留言
		element.findByXpathClick(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[8]/p[2]");
		Thread.sleep(1000);
		// 点击确定提交按钮
		element.findByXpathClick(".//*[@id='bookManagefream']/div[2]/div[2]/div[1]/section/div/div/div/div[2]/a[3]");
		// 点击确定按钮
		element.findByCssClick(".icon8.submitPage");
		// 失去留言项焦点
		element.findByCssClick(".aui_state_highlight");

		// 点击提交书册按钮
		element.findByCssClick(".btnCss03.bookSubmitBtn");
		// 点击确定按钮
		element.findByCssClick(".aui_state_highlight");
		
		browser.refresh();
		Thread.sleep(3000);		

		logger.info("提交书册成功");
	}
}