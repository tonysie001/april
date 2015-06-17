package com.soulinfo.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 

import com.soulinfo.entity.YBEntity;
import com.soulinfo.util.BasicElements;
import com.soulinfo.util.CommonElements;

public class MessageCase {
	private final static Logger logger = LoggerFactory.getLogger(MessageCase.class);
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
	public void testCreateMessage(YBEntity yb) throws InterruptedException {
	
		logger.info("======进入testCreateMessage()方法=======");

		//点击小伙伴
		element.findByIDClick("groupBtn");
		
		//点击要留言名字
		element.findByLinkTextClick(yb.getMessagename());
		common.getScreen("messageuserpage");

		//点击给他/她写赠言
		element.findByCssClick("input.onbtnCss03");
		
		Thread.sleep(3000);
		//清除信息输入留言
		element.findByIDClick("comment");
		
		element.findByIDClear("comment");
		element.findByIDSendKeys("comment", yb.getMessage());
		Thread.sleep(3000);
		
		//点击发表按钮
		element.findByIDClick("addCommentBut");
		
		common.getScreen("messagesuccess");

		element.findByIDClick("groupBtn");

		element.findByLinkTextClick(yb.getUsername());

		logger.info("给" + yb.getMessagename() + "留言完成");
	}
}
