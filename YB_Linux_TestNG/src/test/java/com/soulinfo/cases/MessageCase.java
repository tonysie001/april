package com.soulinfo.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.CommonElements;

public class MessageCase {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	BasicElements element = new BasicElements();
	CommonElements common = new CommonElements();

	/**
	 * 给小伙伴留言
	 * 
	 * @param username
	 *            当前登录用户
	 * @param messagename
	 *            需要留言用户
	 * @param message
	 *            留言信息
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "createMessageDate", dataProviderClass = ExcelDataProvider.class)
	public void testCreateMessage(String username, String messagename,
			String message) throws InterruptedException {
	
		logger.info("======进入testCreateMessage()方法=======");

		//点击小伙伴
		element.findByIDClick("groupBtn");
		
		//点击要留言名字
		element.findByLinkTextClick(messagename);
//		common.getScreen("messageuserpage");

		//点击给他/她写赠言
		element.findByCssClick("input.onbtnCss03");
		
		Thread.sleep(3000);
		//清除信息输入留言
		element.findByIDClick("comment");
		
		element.findByIDClear("comment");
		element.findByIDSendKeys("comment", message);
		Thread.sleep(3000);
		
		//点击发表按钮
		element.findByIDClick("addCommentBut");
		
//		common.getScreen("messagesuccess");

		element.findByIDClick("groupBtn");

		element.findByLinkTextClick(username);

		logger.info("给" + messagename + "留言完成");
	}
}
