package com.soulinfo.cases;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soulinfo.util.BrowserElements;
import com.soulinfo.util.CommonElements;

public class BrowserCase {
	private final static Logger logger = LoggerFactory.getLogger(BrowserCase.class);
	BrowserElements browser = new BrowserElements();
	CommonElements common = new CommonElements();

	/**
	 * 打开浏览器
	 */
	
	public void openBrowser() {
		browser.openBrowser();
		logger.info("打开浏览器时间：" + new Date(System.currentTimeMillis()));
	}

	/**
	 * 退出浏览器
	 */
	
	public void closeBrowser() {
		logger.info("关闭浏览器时间：" + new Date(System.currentTimeMillis()));
		browser.closeBrowser();
	}
}
