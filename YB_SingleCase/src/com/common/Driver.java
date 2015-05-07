package com.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * ����WebDriver��̬�飬ȫ��ʹ�� ��װ��������ò���
 * 
 * @author weiwei.zhang
 * @date 2015.5.5-2015.5.6
 * @version 1.0
 */
public class Driver {

	//IE����
	public static String type = getPropertyString("BROWSER_TYPE");
	//��ĿURL
	public static String url = getPropertyString("BASE_URL");
	//���徲̬driver
	static WebDriver driver;

	/**
	 * ��̬����飬�жϵ�ǰ�����������
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
	}

	/**
	 * ����driverֵ
	 * 
	 * @return driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * ��ȡproperties�ļ��е�valueֵ
	 * 
	 * @param key
	 * @return result
	 */
	public static String getPropertyString(String key) {
		// ����ļ�·��
		String propertyFileName = System.getProperty("user.dir")
				+ "\\src\\com\\common\\Driver.properties";
		Properties properties = new Properties();
		// ��ȡ�ļ��е�����
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
		// ȡkey��valueֵ
		try {
			result = properties.getProperty(key);
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * �������ָ��url
	 * 
	 * @param url
	 */
	public void openBrowser() {
		getDriver().get(url);
		getDriver().manage().window().maximize();
		//������ʽ�ȴ�
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * ������˳�
	 */
	public void closeBrowser() {
		getDriver().quit();
	}

	/**
	 * �����ˢ��
	 */
	public void refresh() {
		getDriver().navigate().refresh();
	}

	/**
	 * ���������
	 */
	public void back() {
		getDriver().navigate().back();
	}

	/**
	 * �����ǰ��
	 */
	public void forward() {
		getDriver().navigate().forward();
	}
}
