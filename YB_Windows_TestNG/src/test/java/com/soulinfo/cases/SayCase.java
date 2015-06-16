package com.soulinfo.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.BrowserElements;
import com.soulinfo.util.CommonElements;

public class SayCase {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	BasicElements element = new BasicElements();
	BrowserElements browser = new BrowserElements();
	CommonElements common = new CommonElements();

	/**
	 * 此刻想说
	 * 
	 * @param say1
	 * @param say2
	 * @param say3
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "createSayDate", dataProviderClass = ExcelDataProvider.class)
	public void testCreateSay(String say1, String say2, String say3) throws InterruptedException {
		logger.info("======进入testCreateSay()方法=======");
		System.out.println("======进入testCreateSay()方法=======");

		// 点击接下去的打算？
		
		element.findByLinkTextClick("接下去的打算？");
		testCreateMySay();
		// 向文本框输入信息
		element.findByCssSendKeys("textarea.speak.isayinput", say1);
		testCreateSayButton(1);

		element.findByLinkTextClick("结束语");
		testCreateMySay();
		// 向文本框输入信息
		element.findByCssSendKeys("textarea.speak.isayinput", say2);
		testCreateSayButton(2);

		element.findByLinkTextClick("在这个集体中最值得回忆的？");
		testCreateMySay();
		// 向文本框输入信息
		element.findByCssSendKeys("textarea.speak.isayinput", say3);
		testCreateSayButton(3);
	}

	@Test
	public void testCreateMySay() {
		element.findByLinkTextClick("我也说");
		// 清空文本框信息
		element.findByCssClear("textarea.speak.isayinput");
	}

	@Test
	public void testCreateSayButton(int i) throws InterruptedException {		
		common.getScreen("say"+i);
		element.findByLinkTextClick("确认");
		logger.info("想说内容发表成功");
		Thread.sleep(2000);
	}
}
