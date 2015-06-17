package com.soulinfo.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.CommonElements;

public class AddBookCase {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	BasicElements element = new BasicElements();
	CreateBooksCase book = new CreateBooksCase();
	CommonElements common = new CommonElements();

	/**
	 * 加入新书
	 * 
	 * @param code
	 *            邀请码
	 */
	@Test(dataProvider = "testAddCodeData", dataProviderClass = ExcelDataProvider.class)
	public void testAddBook(String code) {
		logger.info("======进入testAddBook()方法=======");

		// 点击我的书库
		element.findByLinkTextClick("我的书库");

		// 点击加入新书册aa
		element.findByXpathClick("//*[@id='addBook']");

		// 清空邀请码输入框的值
		element.findByIDClear("keyword");

		// 输入邀请码
		element.findByIDSendKeys("keyword", code);
		
		common.getScreen(code);

		// 点击进入按钮
		element.findByIDClick("checkBut");

		logger.info("拿到邀请码：" + code + "加入书册成功");
	}

	/**
	 * 打开参与新书
	 * 
	 */
	@Test
	public void testOpenBook() {
		logger.info("======进入testOpenBook()方法=======");

		// 点击我的书库
		element.findByLinkTextClick("我的书库");

		common.getScreen("stumybook");
		
		// 点击刚加入的新书册
//		element.findByCssClick("html body div#frameContent.content div.perrig_home ul.booklist li.mypage div a img");
		element.findByXpathClick(".//*[@id='frameContent']/div/ul/li[1]/div[2]/a/img");

		logger.info("学生打开参与新书");
	}

	/**
	 * 打开创建新书
	 * @throws InterruptedException 
	 * 
	 */
	@Test
	public void testOpenCreateBook() throws InterruptedException {
		logger.info("======进入testOpenCreateBook()方法=======");

		// 点击我的书库
		element.findByLinkTextClick("我的书库");
		
		common.getScreen("clamybook");

		Thread.sleep(3000);
		// 点击刚创建的新书册（上方无参与书册）
		 element.findByXpathClick(".//*[@id='frameContent']/div/ul/li[1]/div[2]/a/img");		 						   

		// 点击刚创建的新书册（上方有参与书册）
//		element.findByXpathClick(".//*[@id='frameContent']/div/ul[2]/li[1]/div[2]/a/img");

		logger.info("班长打开创建新书");
	}
}
