package com.soulinfo.cases;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.read.biff.BiffException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soulinfo.entity.CodeEntity;
import com.soulinfo.util.BasicElements;
import com.soulinfo.util.CommonElements;
import com.soulinfo.util.Driver;
import com.soulinfo.util.ReadExcel;

public class AddBookCase {
	private final static Logger logger = LoggerFactory.getLogger(AddBookCase.class);
	BasicElements element = new BasicElements();
	CreateBooksCase book = new CreateBooksCase();
	CommonElements common = new CommonElements();

	/**
	 * 加入新书
	 * 
	 * @param code
	 *            邀请码
	 * @throws IOException
	 * @throws BiffException
	 */
	public void testAddBook() throws BiffException, IOException {
		logger.info("======进入testAddBook()方法=======");

		// 点击我的书库
		element.findByLinkTextClick("我的书库");

		// 点击加入新书册
		element.findByXpathClick("//*[@id='addBook']");

		// 清空邀请码输入框的值
		element.findByIDClear("keyword");

		File file = new File(Driver.getPropertyString("CODE_PATH"));
		List<String[][]> list = new ReadExcel().readExcel(file);

		for (int i = 0; i < list.size(); i++) {
			CodeEntity code = new CodeEntity();
			String arr[][] = list.get(i);
			// 遍历二维数组
			for (int j = 1; j < arr.length; j++) {
				code.setCode(arr[j][0]);

				// 输入邀请码
				element.findByIDSendKeys("keyword", code.getCode());

				common.getScreen(code.getCode());

				// 点击进入按钮
				element.findByIDClick("checkBut");

				logger.info("拿到邀请码：" + code.getCode() + "加入书册成功");
			}
		}
	}

	/**
	 * 打开参与新书
	 * 
	 */
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
