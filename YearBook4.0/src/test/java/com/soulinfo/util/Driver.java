package com.soulinfo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * 创建WebDriver静态块，全局使用 封装浏览器常用操作
 * 
 * @author weiwei.zhang
 * @date 2015.5.5-2015.5.6
 * @version 1.0
 */
public class Driver {

	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	public static String type = getPropertyString("BROWSER_TYPE");
	static WebDriver driver;

	/**
	 * 静态代码块，判断当前打开浏览器类型
	 */
	static {
		if (type.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			driver = new InternetExplorerDriver(ieCapabilities);		
		} else if (type.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		logger.info("当前使用浏览器为"+type);
	}

	/**
	 * 返回静态代码块WebDriver值
	 * 
	 * @return driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * 读取properties文件中的value值
	 * 
	 * @param key
	 * @return result
	 */
	public static String getPropertyString(String key) {
		// 获得文件路径
		String propertyFileName = System.getProperty("user.dir")
				+ "\\src\\test\\resource\\Driver.properties";
		Properties properties = new Properties();
		// 获取文件中的内容
		try {
			properties.load(new FileInputStream(propertyFileName));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (key == null || key.equals("") || key.equals("null")) {
			return "";
		}
		String result = "";
		// 取key的value值
		try {
			result = properties.getProperty(key);
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
		return result;
	}
}
