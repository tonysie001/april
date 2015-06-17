package com.soulinfo.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.CommonElements;

public class VoteCase {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	BasicElements element = new BasicElements();
	CommonElements comment = new CommonElements();

	/**
	 * 投票
	 */
	@Test
	public void testCreateVote() {

		logger.info("======进入testCreateVote()方法=======");

		// 鼠标移动到四叶草后点击举手投樯
		element.findByLinkTextClick("举手投票");

		// 第一个投票
		List<WebElement> buttons = element.findSelect(By.className("spitem"),
				"span");
		// 选择投票内容单选框
		buttons.get(comment.testRandom(3)).click();
		// 单击投票按钮
		element.findByCssClick("div.votbtn > input.btnCss05");

//		// 第二个投票
//		List<WebElement> buttons1 = element.findSelect(
//				By.xpath("/html/body/div[8]/div[2]/div[2]/div[2]"), "span");
//		// 选择投票内容单选框
//		buttons1.get(comment.testRandom(3)).click();
//		// 单击投票按钮
//		element.findByXpathClick("(//input[@value='投票'])[2]");

		// 选择返回首页
		element.findByLinkTextClick("返回首页");

		logger.info("投票成功");
	}
}
