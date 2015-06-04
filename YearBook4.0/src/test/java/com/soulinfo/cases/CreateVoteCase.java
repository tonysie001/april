package com.soulinfo.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.CommonElements;

public class CreateVoteCase {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	BasicElements element = new BasicElements();
	CommonElements common = new CommonElements();

	/**
	 * 创建新投票
	 * 
	 * @param title
	 *            标题
	 * @param option1
	 *            选项一
	 * @param option2
	 *            选项二
	 * @param option3
	 *            选项三
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "createVoteDate", dataProviderClass = ExcelDataProvider.class)
	public void testCreateVote(String title, String option1, String option2,
			String option3) throws InterruptedException {
		logger.info("======进入testCreateVote()方法=======");

		element.findByLinkTextClick("制作书页");
		element.findByLinkTextClick("举手投票");

		for (int i = 1; i < 4; i++) {
			logger.info("班长创建第" + i + "个投票");
			element.findByCssClick(".onbtnCss03");

			element.findByXpathSendKeys(
					".//*[@id='popupDiv']/div/div[1]/table/tbody/tr[1]/td[2]/input",
					title);
			element.findByXpathSendKeys(
					".//*[@id='popupDiv']/div/div[1]/table/tbody/tr[2]/td[2]/input",
					option1);
			element.findByXpathSendKeys(
					".//*[@id='popupDiv']/div/div[1]/table/tbody/tr[3]/td[2]/input",
					option2);
			element.findByXpathSendKeys(
					".//*[@id='popupDiv']/div/div[1]/table/tbody/tr[4]/td[2]/input",
					option3);
			
			element.findByIDClick("createVote");

			common.getScreen("createvote");
			Thread.sleep(2000);
		}
		element.findByLinkTextClick("返回首页");
	}
}
