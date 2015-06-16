package com.soulinfo.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.BrowserElements;
import com.soulinfo.util.CommonElements;

public class AddActivitiesCase {

	private final static Logger logger = LoggerFactory.getLogger(AddActivitiesCase.class);
	BasicElements element = new BasicElements();
	BrowserElements browser = new BrowserElements();
	CommonElements common = new CommonElements();

	/**
	 * 增加集体活动页面
	 * 
	 * @throws Exception
	 */

	public void testAddActivities() throws Exception {
		logger.info("======进入testAddActivities()方法=======");

		// 点击书册管理
		element.findByXpathClick(".//*[@id='infori']/h1/input[1]");
		Thread.sleep(3000);

		// 点击页面管理
		element.findByLinkTextClick("页面管理");
		Thread.sleep(1000);

		// 点击集体活动
		element.findByXpathClick(".//*[@id='bookManagefream']/div[2]/div[1]/section/div/ul/li[7]");
		Thread.sleep(1000);

		// 添加默认模板
		for (int i = 1; i < 3; i++) {

			// 点击添加页面按钮
			element.findByLinkTextClick("添加页面");

			// 点击默认模板按钮
			element.findByXpathClick("html/body/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[2]");

			common.getScreen("addActivities" + i);
			logger.info("添加第" + i + "张集体活动模板成功");
		}
	}
}
