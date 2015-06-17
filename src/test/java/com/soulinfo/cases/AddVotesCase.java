package com.soulinfo.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.BrowserElements;
import com.soulinfo.util.CommonElements;

public class AddVotesCase {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	BasicElements element = new BasicElements();
	BrowserElements browser = new BrowserElements();
	CommonElements common = new CommonElements();
	
	/**
	 * 增加投票页
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddVotes() throws Exception {
		logger.info("======进入testAddVotes()方法=======");

		// 点击书册管理
		element.findByXpathClick(".//*[@id='infori']/h1/input[1]");
		Thread.sleep(3000);

		// 点击页面管理
		element.findByLinkTextClick("页面管理");
		Thread.sleep(1000);

		// 点击举手投票
		element.findByXpathClick(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[6]");

		// 循环添加N个默认模板
		for (int i = 1; i < 3; i++) {
			element.findByLinkTextClick("添加页面");
			element.findByXpathClick("html/body/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[2]");
			
			common.getScreen("addvote"+i);
			
			logger.info("班长增第" + i + "张投票页成功");
		}

		// 点击制作书页按钮
		element.findByXpathClick(".//*[@id='topBar']/div/ul/li[1]/a");

	}

	/**
	 * 制作提交投票页
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateVote() throws Exception {
		logger.info("======进入testCreateVote()方法=======");

//		element.findByLinkTextClick("我的书页");
		// 循环3次制作投票页面
		for (int i = 1; i < 2; i++) {

			// 通过下拉框选择类型为投票
			element.findByXpathClick(".//*[@id='pageType_chzn']/a/span");
			element.findByXpathClick(".//*[@id='pageType_chzn_o_11']");
			Thread.sleep(1000);

			// 点击编辑按钮
			element.findByXpathClick("//*[@id='itemContainer']/li[" + i
					+ "]/div/div/a[2]");

			// 点击 第一个选择按钮
			element.findByXpathClick("//div[@id='pageinfo']/div/ul/li/div/div/a/img");
			testSure();
			// 点击 第二个选择按钮
			element.findByXpathClick("//div[@id='pageinfo']/div/ul/li[3]/div/div/a/img");
			testSure();
			// 点击第三个选择按钮
			element.findByXpathClick("//div[@id='pageinfo']/div/ul/li[5]/div/div/a/img");
			testSure();

			common.getScreen("createvote"+i);
			
			// 点击保存按钮
			element.findByCssClick("input.btnCss03.pageSave");
			
			Thread.sleep(1000);			
			browser.refresh();
			Thread.sleep(2000);

			// 通过下拉列表选择投票项
			element.findByCssClick("#pageType_chzn > a.chzn-single > div > b");
			element.findByIDClick("pageType_chzn_o_11");
			Thread.sleep(1000);		
			
			// 点击提交
			element.findByXpathClick(".//*[@id='itemContainer']/li[" + i
					+ "]/input");

			// 点击确定
			element.findByCssClick("button.aui_state_highlight");
			
			Thread.sleep(1000);		
			common.getScreen("createvote"+i+"submit");
			browser.refresh();
			Thread.sleep(2000);

			logger.info("制作第" + i + "张投票页成功");
		}
	}

	@Test
	public void testSure() throws InterruptedException {
		// 选择第一个投票
		element.findByXpathClick("//div[@id='voteSl']/div/div/input");

		// 确定按钮
		element.findByClassClick("sure");
		Thread.sleep(500);
	}
}
