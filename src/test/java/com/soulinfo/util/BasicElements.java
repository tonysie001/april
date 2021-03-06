package com.soulinfo.util;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * 封装WebDriver常用元素操作
 * 
 * @author weiwei.zhang
 * @date 2015.5.5
 * @version 1.0
 */
public class BasicElements {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	int ExplicitTime = Integer.parseInt(Driver.getPropertyString("WAIT_TIME"));
	Driver d = new Driver();
	WebDriver driver = d.getDriver();

	/**
	 * 设置10秒等待页面加载后才返回WebElement对象（显式等待）
	 * 
	 * @param by
	 *            对象属性元素
	 * @return 返回WebElement对象
	 */
	private WebElement waitForElement(final By by) {
		WebElement element = null;
		try {
			element = new WebDriverWait(driver, ExplicitTime)
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(by);
						}
					});
		} catch (Exception e) {
			logger.info(by.toString() + "显示等待获取元素失败...已超过等待" + ExplicitTime
					+ "等待时间");
			logger.info(e.getLocalizedMessage());
		}
		return element;
	}

	/**
	 * 查找列表元素组是否存在
	 * 
	 * @param by
	 * @return boolean
	 */
	public boolean elementsExists(By by) {
		return (driver.findElements(by).size()) > 0 ? true : false;
	}

	/**
	 * 判断页面元素是否存在
	 * 
	 * @param by
	 * @return boolean
	 */
	public boolean isElementExist(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			logger.info("显示等待获取元素失败...");
			logger.info(e.getMessage());
			return false;
		}
	}

	/**
	 * 根据id定位页面元素
	 * 
	 * @param id
	 * @return element
	 */
	public WebElement findByID(String id) {
		WebElement element = null;
		waitForElement(By.id(id));
		if (this.isElementExist(By.id(id))) {
			element = driver.findElement(By.id(id));
		}
		return element;
	}

	/**
	 * 根据id定位页面元素并清除内容
	 * 
	 * @param id
	 */
	public void findByIDClear(String id) {
		WebElement element = null;
		waitForElement(By.id(id));
		if (this.isElementExist(By.id(id))) {
			element = driver.findElement(By.id(id));
			element.clear();
		}
	}

	/**
	 * 根据id定位页面元素并点击
	 * 
	 * @param id
	 */
	public void findByIDClick(String id) {
		WebElement element = null;
		waitForElement(By.id(id));
		if (this.isElementExist(By.id(id))) {
			element = driver.findElement(By.id(id));
			element.click();
		}
	}

	/**
	 * 根据id定位页面元素并给元素赋值
	 * 
	 * @param id
	 * @param value
	 */
	public void findByIDSendKeys(String id, String value) {
		WebElement element = null;		
		if (this.isElementExist(By.id(id))) {
			element = driver.findElement(By.id(id));
			element.sendKeys(value);
		}
	}

	/**
	 * 根据name定位页面元素
	 * 
	 * @param name
	 * @return element
	 */
	public WebElement findByName(String name) {
		WebElement element = null;
		waitForElement(By.name(name));
		if (this.isElementExist(By.name(name))) {
			element = driver.findElement(By.name(name));
		}
		return element;
	}

	/**
	 * 根据name定位页面元素并清除内容
	 * 
	 * @param name
	 */
	public void findByNameClear(String name) {
		WebElement element = null;
		waitForElement(By.name(name));
		if (this.isElementExist(By.name((name)))) {
			element = driver.findElement(By.name(name));
			element.clear();
		}
	}

	/**
	 * 根据name定位页面元素并点击
	 * 
	 * @param name
	 */
	public void findByNameClick(String name) {
		WebElement element = null;
		waitForElement(By.name(name));
		if (this.isElementExist(By.name((name)))) {
			element = driver.findElement(By.name(name));
			element.click();
		}
	}

	/**
	 * 根据name定位页面元素并给元素赋值
	 * 
	 * @param name
	 * @param value
	 */
	public void findByNameSendKeys(String name, String value) {
		WebElement element = null;
		waitForElement(By.name(name));
		if (this.isElementExist(By.name((name)))) {
			element = driver.findElement(By.name(name));
			element.sendKeys(value);
		}
	}

	/**
	 * 根据className定位页面元素
	 * 
	 * @param ClassName
	 * @return element
	 */
	public WebElement findByClass(String className) {
		WebElement element = null;
		waitForElement(By.className(className));
		if (this.isElementExist(By.className(className))) {
			element = driver.findElement(By.className(className));
		}
		return element;
	}

	/**
	 * 根据className定位页面元素并清除内容
	 * 
	 * @param className
	 */
	public void findByClassClear(String className) {
		WebElement element = null;
		waitForElement(By.className(className));
		if (this.isElementExist(By.className(className))) {
			element = driver.findElement(By.className(className));
			element.clear();
		}
	}

	/**
	 * 根据className定位页面元素并点击
	 * 
	 * @param className
	 */
	public void findByClassClick(String className) {
		WebElement element = null;
		waitForElement(By.className(className));
		if (this.isElementExist(By.className(className))) {
			element = driver.findElement(By.className(className));
			element.click();
		}
	}

	/**
	 * 根据className定位页面元素并给元素赋值
	 * 
	 * @param className
	 * @param value
	 */
	public void findByClassNameSendKeys(String className, String value) {
		WebElement element = null;
		waitForElement(By.className(className));
		if (this.isElementExist(By.className(className))) {
			element = driver.findElement(By.className(className));
			element.sendKeys(value);
		}
	}

	/**
	 * 根据linkText定位页面元素
	 * 
	 * @param linkText
	 * @return
	 */
	public WebElement findByLinkText(String linkText) {
		WebElement element = null;
		waitForElement(By.linkText(linkText));
		if (this.isElementExist(By.linkText(linkText))) {
			element = driver.findElement(By.linkText(linkText));
		}
		return element;
	}

	/**
	 * 根据linkText定位页面元素并清除内容
	 * 
	 * @param linkText
	 */
	public void findByLinkTextClear(String linkText) {
		WebElement element = null;
		waitForElement(By.linkText(linkText));
		if (this.isElementExist(By.linkText(linkText))) {
			element = driver.findElement(By.linkText(linkText));
			element.clear();
		}
	}

	/**
	 * 根据linkText定位页面元素并点击
	 * 
	 * @param linkText
	 */
	public void findByLinkTextClick(String linkText) {
		WebElement element = null;
		waitForElement(By.linkText(linkText));
		System.out.println(isElementExist(By.linkText(linkText)));
		if (isElementExist(By.linkText(linkText))) {
			element = driver.findElement(By.linkText(linkText));
			element.click();
		}
	}

	/**
	 * 根据cssSelector定位页面元素
	 * 
	 * @param cssSelector
	 * @return
	 */
	public WebElement findByCss(String cssSelector) {
		WebElement element = null;
		waitForElement(By.cssSelector(cssSelector));
		if (this.isElementExist(By.cssSelector((cssSelector)))) {
			element = driver.findElement(By.cssSelector(cssSelector));
		}
		return element;
	}

	/**
	 * 根据cssSelector定位页面元素并清除内容
	 * 
	 * @param cssSelector
	 */
	public void findByCssClear(String cssSelector) {
		WebElement element = null;
		waitForElement(By.cssSelector(cssSelector));
		if (this.isElementExist(By.cssSelector((cssSelector)))) {
			element = driver.findElement(By.cssSelector(cssSelector));
			element.clear();
		}
	}

	/**
	 * 根据cssSelector定位页面元素并点击
	 * 
	 * @param cssSelector
	 */
	public void findByCssClick(String cssSelector) {
		WebElement element = null;
		waitForElement(By.cssSelector(cssSelector));
		if (this.isElementExist(By.cssSelector((cssSelector)))) {
			element = driver.findElement(By.cssSelector(cssSelector));
			element.click();
		}
	}

	/**
	 * 根据cssSelector定位页面元素并给元素赋值
	 * 
	 * @param cssSelector
	 * @param value
	 */
	public void findByCssSendKeys(String cssSelector, String value) {
		WebElement element = null;
		waitForElement(By.cssSelector(cssSelector));
		if (this.isElementExist(By.cssSelector((cssSelector)))) {
			element = driver.findElement(By.cssSelector(cssSelector));
			element.sendKeys(value);
		}
	}

	/**
	 * 根据Xpath定位页面元素
	 * 
	 * @param Xpath
	 * @return
	 */
	public WebElement findByXpath(String xPath) {
		WebElement element = null;
		waitForElement(By.xpath(xPath));
		if (this.isElementExist(By.xpath((xPath)))) {
			element = driver.findElement(By.xpath(xPath));
		}
		return element;
	}

	/**
	 * 根据Xpath定位页面元素并清除内容
	 * 
	 * @param Xpath
	 * @return
	 */
	public void findByXpathClear(String xPath) {
		WebElement element = null;
		waitForElement(By.xpath(xPath));
		if (this.isElementExist(By.xpath((xPath)))) {
			element = driver.findElement(By.xpath(xPath));
			element.clear();
		}
	}

	/**
	 * 根据Xpath定位页面元素并点击
	 * 
	 * @param Xpath
	 * @return
	 */
	public void findByXpathClick(String xPath) {
		WebElement element = null;
		waitForElement(By.xpath(xPath));
		if (this.isElementExist(By.xpath((xPath)))) {
			element = driver.findElement(By.xpath(xPath));
			element.click();
		}
	}

	/**
	 * 根据xPath定位页面元素并给元素赋值
	 * 
	 * @param xPath
	 * @param value
	 */
	public void findByXpathSendKeys(String xPath, String value) {
		WebElement element = null;
		waitForElement(By.xpath(xPath));
		if (this.isElementExist(By.xpath((xPath)))) {
			element = driver.findElement(By.xpath(xPath));
			element.sendKeys(value);
		}
	}

	/**
	 * 根据tagName定位页面元素
	 * 
	 * @param tagName
	 * @return element
	 */
	public WebElement findByTagName(String tagName) {
		WebElement element = null;
		waitForElement(By.tagName(tagName));
		if (this.isElementExist(By.tagName((tagName)))) {
			element = driver.findElement(By.name(tagName));
		}
		return element;
	}

	/**
	 * 1、定位父类元素 2、跟据tagName定位子类元素集
	 * 
	 * @param parentName
	 * @param tagName
	 * @return buttons
	 */
	public List<WebElement> findSelect(By by, String tagName) {
		waitForElement(by);
		WebElement element = driver.findElement(by);
		waitForElement(By.tagName(tagName));
		List<WebElement> buttons = element.findElements(By.tagName(tagName));
		return buttons;
	}

	/**
	 * 查找到某元素并点击
	 * 
	 * @param by
	 */
	public void elementClick(By by) {
		waitForElement(by);
		driver.findElement(by).click();
	}

	/**
	 * 获得元素的文本描述信息
	 * 
	 * @param by
	 * @return
	 */
	public String getText(By by) {
		try {
			waitForElement(by);
			return driver.findElement(by).getText();
		} catch (NoSuchElementException e) {
			return "Text does not exist!";
		}
	}

	/**
	 * 从组元素组中获取需要的某个元素
	 * 
	 * @param by
	 * @param index
	 * @return element
	 */
	public WebElement FindByElements(By by, int index) {
		WebElement element = null;
		waitForElement(by);
		if (this.isElementExist(by)) {
			element = driver.findElements(by).get(index);
		}
		return element;
	}

	/**
	 * 窗口切换
	 * 
	 * @param windowTitile
	 */
	public void switchTowindow(String windowTitile) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handler : windowHandles) {
			driver.switchTo().window(handler);
			String title = driver.getTitle();
			if (windowTitile.equals(title)) {
				break;
			}
		}
	}

	/**
	 * 根据option下拉列表名称找找 查找下拉属性元素位置点击
	 * 
	 * @param id
	 * @return Element
	 */
	public WebElement findSelectById(String Text) {
		WebElement element = null;
		List<WebElement> options = driver.findElements(By.name(Text));
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equals(Text)) {
				options.get(i).click();
			}
		}
		return element;
	}

}
