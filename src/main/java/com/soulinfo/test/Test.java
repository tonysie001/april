package com.soulinfo.test;

import java.io.File;
import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

import com.soulinfo.cases.BrowserCase;
import com.soulinfo.logic.CreateBookLogic;
import com.soulinfo.util.Driver;
import com.soulinfo.util.ReadExcel;

public class Test {

	public static void main(String args[]) throws Exception {
		
		File logbackFile = new File("test-classes/logback.xml");
        if (logbackFile.exists()) {
            LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(lc);
            lc.reset();
            try {
                configurator.doConfigure(logbackFile);
            }
            catch (JoranException e) {
                e.printStackTrace(System.err);
                System.exit(-1);
            }
        }
		
		// 实例化操作浏览器对象
		BrowserCase browser = new BrowserCase();
		// 实例化读取EXCEL对象
		File file = new File(Driver.getPropertyString("EXCEL_PATH"));
		// 实例化登录对象集合
		List<String[][]> list = new ReadExcel().readExcel(file);
		// 实例化创建新书逻辑类
		CreateBookLogic logic = new CreateBookLogic();
		
		browser.openBrowser();
		
		// 班长创建新书
		logic.createBook(list);
		// 50学生加入新书
		logic.addBook(list);
		// 50学生发表想说、投票
		logic.addMyBookText(list);
		// 50学生制作个人书页
		logic.createMyBook(list);
		// 班长提交书册
		logic.submitBook(list);
		
		browser.closeBrowser();

	}
}
