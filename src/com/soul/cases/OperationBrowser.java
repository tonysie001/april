package com.soul.cases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * 
 * @author SionInSoul ²Ù×÷ä¯ÀÀÆ÷
 * 
 */
public class OperationBrowser {
	String baseUrl = "http://192.168.2.185";

	//´ò¿ªä¯ÀÀÆ÷¼°Òä¶ûÍøÕ¾
	@BeforeMethod
	public void beforeMethod(WebDriver driver) {
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	//ÍË³öä¯ÀÀÆ÷
	@AfterMethod
	public void afterMethod(WebDriver driver) {
		driver.quit();
	}
}
