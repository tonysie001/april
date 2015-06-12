package com.soulinfo.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.BrowserElements;
import com.soulinfo.util.CommonElements;

public class CreateActivitiesCase {
	private final static Logger logger = LoggerFactory.getLogger(CreateActivitiesCase.class);
	BasicElements element = new BasicElements();
	BrowserElements browser = new BrowserElements();
	CommonElements common = new CommonElements();

	/**
	 * 制作集体活动页
	 * 
	 * @throws InterruptedException
	 */
	
	public void testCreateaAtivities() throws InterruptedException {
		logger.info("======进入testCreateaAtivities()方法=======");

		element.findByLinkTextClick("制作书页");
		element.findByLinkTextClick("我的书页");

		// 循环3次增加创建活动页面
		for (int i = 1; i < 4; i++) {
			// 通过下拉框选择类型为集体活动
			element.findByXpathClick(".//*[@id='pageType_chzn']/a/span");
			element.findByXpathClick(".//*[@id='pageType_chzn_o_15']");
			Thread.sleep(3000);

			// 点击编辑按钮
			element.findByXpathClick("//*[@id='itemContainer']/li[" + i
					+ "]/div/div/a[2]");

			// 点击顶部大图上传图片按钮
			element.findByIDClick("imgMask0");

			// 点击网络上传按钮
			element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");

			// 输入网络地址
			element.findByIDSendKeys("imgSrc",
					"http://192.168.2.185/img/static/memento/online/book_banner.png");
			element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");
			element.findByXpathClick(".//*[@id='imgSure']/input[1]");
			element.findByCssClick(".aui_close");
			element.findByCssClick(".aui_state_highlight");
			element.findByCssClick(".progress>div>canvas");

			for (int j = 1; j < 4; j++)// 循环添加小图片
			{
				// 点击上传小图按钮
				element.findByIDClick("imgMask" + j);
				element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");
				element.findByIDSendKeys("imgSrc",
						"http://192.168.2.185/img/static/memento/online/book_banner.png");
				element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");
				element.findByXpathClick(".//*[@id='imgSure']/input[1]");
				element.findByXpathClick("(//button[@type='button'])[2]");
				element.findByCssClick(".progress>div>canvas");

				Thread.sleep(1000);
				logger.info("增加第" + i + "张集体活动页的第" + j + "张小图片");
			}

			element.findByXpathSendKeys(
					".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[1]/div/p",
					"电影节");
			element.findByXpathSendKeys(
					".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[3]/span/p",
					"电影节");
			String text = "经过近一年的筹备策划，班级进行了两部电影《时空博弈》、"
					+ "《预定航线》的拍摄与制作。两部与穿越有关的电影，《预定航线》充满历史不可逆转的沉痛，"
					+ "《时 空博弈》则有着对全新未来的憧憬，不一样的剧情，不一样的呈现方式，不一样的精彩。"
					+ "拍摄过程中，大家不仅体会到电影拍摄制作的不易，大家的团结和默契也与日俱增。拍摄电影给大"
					+ "家留下拍摄制作电影的经验，还有无数难忘的美好回忆。" + "电影节当天，主创人员的室内红毯别开生面，"
					+ "大家的努力付出了得到了肯定。高中最重要的活动之一虽然落幕，但我们的青春仍未散场";
			element.findByXpathSendKeys(
					".//*[@id='pageinfo']/div/div/div[2]/div[1]/div[4]/div/p",
					text);

			common.getScreen("createActivities"+i);
			
			// 点击保存按钮
			element.findByCssClick("input.btnCss03.pageSave");
			
			Thread.sleep(2000);
			browser.refresh();
			Thread.sleep(2000);

			// 点击下拉列表选择集体活动
			element.findByCssClick("#pageType_chzn > a.chzn-single > div > b");
			element.findByIDClick("pageType_chzn_o_15");
			Thread.sleep(3000);

//			// 点击下拉列表选择集体活动第二次（因为当前状态为正在生成，需等待时间过后重新选择）
//			element.findByCssClick("#pageType_chzn > a.chzn-single > div > b");
//			element.findByIDClick("pageType_chzn_o_15");

			// 点击提交按钮
			element.findByXpathClick(".//*[@id='itemContainer']/li[" + i
					+ "]/input");
			//点击确定按钮
			element.findByCssClick("button.aui_state_highlight");
			
			Thread.sleep(2000);
			common.getScreen("createActivities"+i+"submit");						
			browser.refresh();
			Thread.sleep(2000);
			
			
			logger.info("增加第" + i + "张集体活动页提交完成");
		}
		Thread.sleep(3000);		
	}
}
