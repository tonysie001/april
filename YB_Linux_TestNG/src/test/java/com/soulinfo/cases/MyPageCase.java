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

public class MyPageCase {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	BasicElements element = new BasicElements();
	BrowserElements browser = new BrowserElements();
	CommonElements common = new CommonElements();

	/**
	 * 制作班长个人书页
	 * 
	 * @param username
	 *            学生姓名
	 * @param classname
	 *            班长姓名
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "testCreateClaMyPage", dataProviderClass = ExcelDataProvider.class)
	public void testCreateClaMyPage(String username, String classname)
			throws InterruptedException {

		logger.info("======进入testCreateMyPage()方法=======");		
		myPage(username, classname);
	}

	/**
	 * 制作个人书页
	 * 
	 * @param username
	 *            学生姓名
	 * @param classname
	 *            班长姓名
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "createMyBookPageDate", dataProviderClass = ExcelDataProvider.class)
	public void testCreateMyPage(String username, String classname)
			throws InterruptedException {

		logger.info("======进入testCreateMyPage()方法=======");
		myPage(username, classname);
	}

	@Test
	public void myPage(String username, String classname)
			throws InterruptedException {

		// 单击个人书页
		element.findByClassClick("watermark2");

		// 上传照片（顶部大图）
		addBigPhoto(classname);

		// 调用增加留言方法
//		try {
//			addMessage();
//		} catch (Exception e) {
//			logger.error("增加留言内容失败" + e.getLocalizedMessage());
//		}

		// 调用增加想说方法
		try {
			addSay();
		} catch (Exception e) {
			logger.error("增加想说内容失败" + e.getLocalizedMessage());
		}

		// 上传照片（底部三张小图）
//		for (int i = 1; i < 4; i++) {
//			addThreePhoto(i);
//		}
		
//		common.getScreen("mypage");

		// 点击保存按钮
		element.findByCssClick("input.btnCss03.pageSave");
		if (username.equals(classname)) {
			List<WebElement> submitButton = element.findSelect(
					By.id("itemContainer"), "input");
			submitButton.get(4).click();
		} else {
			element.findByCssClick("input.btnCss02.submitPage.fr");
		}

		// 点击确定按钮
		element.findByCssClick("button.aui_state_highlight");
		
//		common.getScreen("mypagesubmit");

		logger.info("班长" + username + "制作 个人书页完成");
		
		browser.refresh();
		Thread.sleep(3000);		
		
		// 返回首页
		element.findByLinkTextClick("返回首页");
	}

	@Test
	public void addBigPhoto(String classname) throws InterruptedException {

		logger.info("======进入addBigPhoto()方法=======");

		element.findByCssClick("img.upaction");
		element.findByXpathClick("//input[@value='网络地址']");
		element.findByIDClear("imgSrc");
		element.findByIDSendKeys("imgSrc",
				"http://192.168.2.185/img/static/memento/online/book_banner.png");
		Thread.sleep(3000);
		element.findByXpathClick("//input[@value='网络地址']");
		Thread.sleep(3000);
		element.findByXpathClick("//input[@value='确定']");
		element.findByXpathClick("(//button[@type='button'])[2]");
		element.findByCssClick("button.aui_state_highlight");
		element.findByCssClick("canvas");
		logger.info("个人书页顶部大图增加成功");
	}

	// 增加三张小图
	@Test
	public void addThreePhoto(int i) throws InterruptedException {

		logger.info("======进入addThreePhoto()方法=======");

		// 单击上传图片小按钮
		Thread.sleep(500);
		element.findByCssClick("#imgMask" + i + " > p > img.upaction");
		// 单击网络上传
		element.findByXpathClick("//input[@value='网络地址']");
		// 输入网络地址
		element.findByIDSendKeys("imgSrc",
				"http://192.168.2.185/img/static/memento/online/book_banner.png");
		// 单击网络地址
		element.findByXpathClick(".//*[@id='popupDiv']/div/div[2]/input[3]");
		// 单击确定上传按钮
		Thread.sleep(1000);
		element.findByXpathClick(".//*[@id='imgSure']/input[1]");
		// 单击取消剪裁按钮
		element.findByXpathClick("(//button[@type='button'])[2]");
		// 单击图片上确定按钮
		element.findByCssClick("div.progress > div > div");

		Thread.sleep(500);
		logger.info("个人书页底部第" + i + "张小图增加成功");
	}

	/**
	 * 选择多条留言
	 */
	@Test
	public void addMessage() throws Exception {

		logger.info("======进入addMessage()方法=======");

		// 单击增加留言图片
		element.findByCssClick("img[title=\"增加留言\"]");

		List<WebElement> checkboxMessage = element.findSelect(
				By.id("sayToMeSl"), "input");

		if (checkboxMessage.size() == 0) {
			logger.info("没有可选择的留言内容，内容为：" + checkboxMessage.size());
		} else {
			for (int i = 0; i < 1; i++) {
				checkboxMessage.get(i).click();
			}
		}
		// 点击确定按钮，提交留言
		element.findByLinkTextClick("确定");

		logger.info("个人书页留言内容增加成功");
	}

	/**
	 * 选择多条想说
	 */
	@Test
	public void addSay() throws Exception {
		logger.info("======进入addSay()方法=======");

		// 单击增加想说图片
		Thread.sleep(500);
		element.findByCssClick("img[title=\"增加想说\"]");

		List<WebElement> checkboxSay = element.findSelect(By.id("iSaySl"),
				"input");

		if (checkboxSay.size() == 0) {
			logger.info("没有可选择的想说内容，内容为：" + checkboxSay.size());
		} else {
			for (int i = 0; i < 1; i++) {
				checkboxSay.get(i).click();
			}
		}
		// 点击确定按钮，提交想说
		element.findByLinkTextClick("确定");

		logger.info("个人书页想说内容增加成功");
	}
}
