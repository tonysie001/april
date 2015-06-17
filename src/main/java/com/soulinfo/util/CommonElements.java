package com.soulinfo.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 封装常用方法
 * 
 * @author weiwei.zhang
 * @date 2015.5.5
 * @version 1.0
 */
public class CommonElements {

	Driver d = new Driver();
	WebDriver driver = d.getDriver();
	String SCREENURL = Driver.getPropertyString("SCREENURL");
	String EXTENSION = Driver.getPropertyString("EXTENSION");

	/**
	 * 执行JS脚本
	 * 
	 * @param by
	 * @param parameter
	 */
	public void executeScript(By by, String parameter) {
		WebElement element = driver.findElement(by);
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(parameter, element);
		}
	}


	/**
	 * 截取屏幕
	 * 
	 * @param filepath
	 */
	public void getScreen(String filename) {
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(SCREENURL + getdata()+"\\"+ gettime() +filename
					+ EXTENSION));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 产生1-i随机整数
	 * 
	 * @param i
	 * @return random
	 */
	public int testRandom(int i) {
		int random = (int) (i * Math.random() + 1);
		return random;
	}

	/**
	 * 获取当前系统时间
	 * 
	 * @return String time
	 */
	public String time() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}
	
	/**
	 * 获取当前系统时间
	 * 
	 * @return String time
	 */
	public String getdata() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
	
	/**
	 * 获取当前系统时间
	 * 
	 * @return String time
	 */
	public String gettime() {
		SimpleDateFormat df = new SimpleDateFormat("HH-mm-ss-");
		System.out.println(df.format(new Date()));
		return df.format(new Date());
	}
}
