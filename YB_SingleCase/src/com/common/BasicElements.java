package com.common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * ��װWebDriver����Ԫ�ز���
 * 
 * @author weiwei.zhang
 * @date 2015.5.5
 * @version 1.0
 */
public class BasicElements {
	
	Driver d = new Driver();
	WebDriver driver = d.getDriver();

	/**
	 * �����б�Ԫ�����Ƿ����
	 * 
	 * @param by
	 * @return boolean
	 */
	public boolean elementsExists(By by) {
		return (driver.findElements(by).size()) > 0 ? true : false;
	}

	/**
	 * �ж�ҳ��Ԫ���Ƿ����
	 * 
	 * @param by
	 * @return boolean
	 */
	public boolean isElementExist(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return false;
		}
	}

	/**
	 * ����id��λҳ��Ԫ��
	 * 
	 * @param id
	 * @return element
	 */
	public WebElement findByID(String id) {
		WebElement element = null;
		if (this.isElementExist(By.id(id))) {
			element = driver.findElement(By.id(id));
		}
		return element;
	}

	/**
	 * ����id��λҳ��Ԫ�ز��������
	 * 
	 * @param id
	 */
	public void findByIDClear(String id) {
		WebElement element = null;
		if (this.isElementExist(By.id(id))) {
			element = driver.findElement(By.id(id));
		}
		element.clear();
	}

	/**
	 * ����id��λҳ��Ԫ�ز����
	 * 
	 * @param id
	 */
	public void findByIDClick(String id) {
		WebElement element = null;
		if (this.isElementExist(By.id(id))) {
			element = driver.findElement(By.id(id));
		}
		element.click();
	}

	/**
	 * ����id��λҳ��Ԫ�ز���Ԫ�ظ�ֵ
	 * 
	 * @param id
	 * @param value
	 */
	public void findByIDSendKeys(String id, String value) {
		WebElement element = null;
		if (this.isElementExist(By.id(id))) {
			element = driver.findElement(By.id(id));
		}
		element.sendKeys(value);
	}

	/**
	 * ����name��λҳ��Ԫ��
	 * 
	 * @param name
	 * @return element
	 */
	public WebElement findByName(String name) {
		WebElement element = null;
		if (this.isElementExist(By.name(name))) {
			element = driver.findElement(By.name(name));
		}
		return element;
	}

	/**
	 * ����name��λҳ��Ԫ�ز��������
	 * 
	 * @param name
	 */
	public void findByNameClear(String name) {
		WebElement element = null;
		if (this.isElementExist(By.name((name)))) {
			element = driver.findElement(By.name(name));
		}
		element.clear();
	}

	/**
	 * ����name��λҳ��Ԫ�ز����
	 * 
	 * @param name
	 */
	public void findByNameClick(String name) {
		WebElement element = null;
		if (this.isElementExist(By.name((name)))) {
			element = driver.findElement(By.name(name));
		}
		element.click();
	}

	/**
	 * ����name��λҳ��Ԫ�ز���Ԫ�ظ�ֵ
	 * 
	 * @param name
	 * @param value
	 */
	public void findByNameSendKeys(String name, String value) {
		WebElement element = null;
		if (this.isElementExist(By.name((name)))) {
			element = driver.findElement(By.name(name));
		}
		element.sendKeys(value);
	}

	/**
	 * ����className��λҳ��Ԫ��
	 * 
	 * @param ClassName
	 * @return element
	 */
	public WebElement findByClass(String className) {
		WebElement element = null;
		if (this.isElementExist(By.className(className))) {
			element = driver.findElement(By.className(className));
		}
		return element;
	}

	/**
	 * ����className��λҳ��Ԫ�ز��������
	 * 
	 * @param className
	 */
	public void findByClassClear(String className) {
		WebElement element = null;
		if (this.isElementExist(By.className(className))) {
			element = driver.findElement(By.className(className));
		}
		element.clear();
	}

	/**
	 * ����className��λҳ��Ԫ�ز����
	 * 
	 * @param className
	 */
	public void findByClassClick(String className) {
		WebElement element = null;
		if (this.isElementExist(By.className(className))) {
			element = driver.findElement(By.className(className));
		}
		element.click();
	}

	/**
	 * ����className��λҳ��Ԫ�ز���Ԫ�ظ�ֵ
	 * 
	 * @param className
	 * @param value
	 */
	public void findByClassNameSendKeys(String className, String value) {
		WebElement element = null;
		if (this.isElementExist(By.className(className))) {
			element = driver.findElement(By.className(className));
		}
		element.sendKeys(value);
	}

	/**
	 * ����linkText��λҳ��Ԫ��
	 * 
	 * @param linkText
	 * @return
	 */
	public WebElement findByLinkText(String linkText) {
		WebElement element = null;
		if (this.isElementExist(By.linkText(linkText))) {
			element = driver.findElement(By.linkText(linkText));
		}
		return element;
	}

	/**
	 * ����linkText��λҳ��Ԫ�ز��������
	 * 
	 * @param linkText
	 */
	public void findByLinkTextClear(String linkText) {
		WebElement element = null;
		if (this.isElementExist(By.linkText(linkText))) {
			element = driver.findElement(By.linkText(linkText));
		}
		element.clear();
	}

	/**
	 * ����linkText��λҳ��Ԫ�ز����
	 * 
	 * @param linkText
	 */
	public void findByLinkTextClick(String linkText) {
		System.out.println("findByLinkTextClick");
		WebElement element = null;
		System.out.println(isElementExist(By.linkText(linkText)));
		if (isElementExist(By.linkText(linkText))) {
			element = driver.findElement(By.linkText(linkText));
		}
		element.click();
	}

	/**
	 * ����cssSelector��λҳ��Ԫ��
	 * 
	 * @param cssSelector
	 * @return
	 */
	public WebElement findByCss(String cssSelector) {
		WebElement element = null;
		if (this.isElementExist(By.cssSelector((cssSelector)))) {
			element = driver.findElement(By.cssSelector(cssSelector));
		}
		return element;
	}

	/**
	 * ����cssSelector��λҳ��Ԫ�ز��������
	 * 
	 * @param cssSelector
	 */
	public void findByCssClear(String cssSelector) {
		WebElement element = null;
		if (this.isElementExist(By.cssSelector((cssSelector)))) {
			element = driver.findElement(By.cssSelector(cssSelector));
		}
		element.clear();
	}

	/**
	 * ����cssSelector��λҳ��Ԫ�ز����
	 * 
	 * @param cssSelector
	 */
	public void findByCssClick(String cssSelector) {
		WebElement element = null;
		if (this.isElementExist(By.cssSelector((cssSelector)))) {
			element = driver.findElement(By.cssSelector(cssSelector));
		}
		element.click();
	}

	/**
	 * ����cssSelector��λҳ��Ԫ�ز���Ԫ�ظ�ֵ
	 * 
	 * @param cssSelector
	 * @param value
	 */
	public void findByCssSendKeys(String cssSelector, String value) {
		WebElement element = null;
		if (this.isElementExist(By.cssSelector((cssSelector)))) {
			element = driver.findElement(By.cssSelector(cssSelector));
		}
		element.sendKeys(value);
	}

	/**
	 * ����Xpath��λҳ��Ԫ��
	 * 
	 * @param Xpath
	 * @return
	 */
	public WebElement findByXpath(String xPath) {
		WebElement element = null;
		if (this.isElementExist(By.xpath((xPath)))) {
			element = driver.findElement(By.xpath(xPath));
		}
		return element;
	}

	/**
	 * ����Xpath��λҳ��Ԫ�ز��������
	 * 
	 * @param Xpath
	 * @return
	 */
	public void findByXpathClear(String xPath) {
		WebElement element = null;
		if (this.isElementExist(By.xpath((xPath)))) {
			element = driver.findElement(By.xpath(xPath));
		}
		element.clear();
	}

	/**
	 * ����Xpath��λҳ��Ԫ�ز����
	 * 
	 * @param Xpath
	 * @return
	 */
	public void findByXpathClick(String xPath) {
		WebElement element = null;
		if (this.isElementExist(By.xpath((xPath)))) {
			element = driver.findElement(By.xpath(xPath));
		}
		element.click();
	}

	/**
	 * ����xPath��λҳ��Ԫ�ز���Ԫ�ظ�ֵ
	 * 
	 * @param xPath
	 * @param value
	 */
	public void findByXpathSendKeys(String xPath, String value) {
		WebElement element = null;
		if (this.isElementExist(By.xpath((xPath)))) {
			element = driver.findElement(By.xpath(xPath));
		}
		element.sendKeys(value);
	}

	/**
	 * ����tagName��λҳ��Ԫ��
	 * 
	 * @param tagName
	 * @return element
	 */
	public WebElement findByTagName(String tagName) {
		WebElement element = null;
		if (this.isElementExist(By.tagName((tagName)))) {
			element = driver.findElement(By.name(tagName));
		}
		return element;
	}

	/**
	 * 1����λ����Ԫ�� 2������tagName��λ����Ԫ�ؼ�
	 * 
	 * @param parentName
	 * @param tagName
	 * @return buttons
	 */
	public List<WebElement> findSelect(By by, String tagName) {
		WebElement element = null;
		List<WebElement> buttons = null;
		element = driver.findElement(by);
		if (this.isElementExist(By.name(tagName))) {
			buttons = element.findElements(By.name(tagName));
		}
		return buttons;
	}

	/**
	 * ���ҵ�ĳԪ�ز����
	 * 
	 * @param by
	 */
	public void elementClick(By by) {
		driver.findElement(by).click();
	}

	/**
	 * ���Ԫ�ص��ı�������Ϣ
	 * 
	 * @param by
	 * @return
	 */
	public String getWebText(By by) {
		try {
			return driver.findElement(by).getText();
		} catch (NoSuchElementException e) {
			return "Text does not exist!";
		}
	}

	/**
	 * ����Ԫ�����л�ȡ��Ҫ��ĳ��Ԫ��
	 * 
	 * @param by
	 * @param index
	 * @return element
	 */
	public WebElement FindByElements(By by, int index) {
		WebElement element = null;
		if (this.isElementExist(by)) {
			element = driver.findElements(by).get(index);
		}
		return element;
	}

	/**
	 * �����л�
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
	 * ����option�����б��������� ������������Ԫ��λ�õ��
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
