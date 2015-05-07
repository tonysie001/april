package com.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;

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
	public void getScreen(String filepath) {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		TakesScreenshot ts = (TakesScreenshot) augmentedDriver;
		File screenShotFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(filepath));
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

}
