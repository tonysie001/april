package com.soulinfo.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.BrowserElements;
import com.soulinfo.util.CommonElements;

public class CreateBigPhotoCase {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	BrowserElements browser = new BrowserElements();
	BasicElements element = new BasicElements();
	CommonElements common = new CommonElements();

	/**
	 * 制作全景照片
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testCreateBigPhoto() throws InterruptedException {

		logger.info("======进入testCreateBigPhoto()方法=======");

		// 在首页点击我的书页
		element.findByLinkTextClick("我的书页");

		// 通过下拉框选择类型为全景照片
		element.findByXpathClick(".//*[@id='pageType_chzn']/a/span");
		element.findByXpathClick(".//*[@id='pageType_chzn_o_16']");
		Thread.sleep(500);

		//点击编辑按钮
		element.findByXpathClick("//*[@id='itemContainer']/li[1]/div/div/a[2]");
		Thread.sleep(500);
		element.findByIDClick("imgMask0");
		element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");
		element.findByIDSendKeys("imgSrc",
				"http://192.168.2.185/img/static/memento/online/book_banner.png");
		element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");
		element.findByXpathClick(".//*[@id='imgSure']/input[1]");
		element.findByCssClick(".aui_close");
		element.findByCssClick(".aui_state_highlight");

		common.getScreen("bigphoto");	
		
		element.findByCssClick(".progress>div>canvas");
		element.findByXpathClick(".//*[@id='frameContent']/div[2]/div[2]/input[3]");
		element.findByCssClick(".aui_state_highlight");
		
		browser.refresh();
		Thread.sleep(3000);		

		logger.info("全景照片制作完成");
	}
}
