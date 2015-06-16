package com.soulinfo.cases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.CommonElements;
import com.soulinfo.util.Driver;

public class SubmitOrder {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	BasicElements element = new BasicElements();
	CommonElements common = new CommonElements();
	Driver d = new Driver();
	WebDriver driver = d.getDriver();

	@Test(dataProvider = "createVouchersDate", dataProviderClass = ExcelDataProvider.class)
	public void testSubmitOrder(String vouchers) throws InterruptedException {

		logger.info("=============testSubmitOrder=================");

		// 点击书册管理按钮
		element.findByXpathClick(".//*[@id='infori']/h1/input[1]");
		Thread.sleep(2000);
		// 点击订单管理标签
		element.findByLinkTextClick("订单管理");

		// 输入书册数量
		element.findByNameClear("bookNum");
		element.findByNameSendKeys("bookNum", "1");

		// 点击下单按钮
		element.findByXpathClick("//input[@value='下单']");
		// 点击确定创建按钮
		element.findByCssClick("button.aui_state_highlight");
		// 点击预览确认
		element.findByCssClick("input.onbtnCss05");
		Thread.sleep(2000);
		// 点击确定按钮
		element.findByIDClick("orderConfirm");

		// 点击付款按钮
		element.findByCssClick("input.onbtnCss05");
		Thread.sleep(1000);
		// 点击新建收货地址
		element.findByNameClick("addAddress");
		// 选择省份
		new Select(element.findByID("J_Province")).selectByVisibleText("江苏省");
		// 选择城市
		new Select(element.findByID("J_City")).selectByVisibleText("无锡市");
		// 选择区
		new Select(element.findByID("J_Area")).selectByVisibleText("滨湖区");
		// 输入详细地址
		element.findByIDSendKeys("J_Street", "国家软件园");
		// 输入邮政编码
		element.findByIDSendKeys("J_PostCode", "014520");
		// 输入收件人姓名
		element.findByIDSendKeys("J_Name", "张女士");
		// 输入电话号码
		element.findByIDSendKeys("J_Mobile", "15854210254");
		// 点击保存按钮
		element.findByCssClick("button.short-btn");
		// 点击确定按钮
		element.findByCssClick("button.aui_state_highlight");

		// 输入优惠券
		element.findByIDSendKeys("vouchercode01", vouchers);
		// 点击确定按钮
		element.findByIDClick("checkVoucher");
		// 点击确定使用代金券按钮
		element.findByIDClick("commitVoucher");
		Thread.sleep(1000);
		
//		common.getScreen("pay");
		
		// 点击付款按钮
		element.findByIDClick("pay");
		
//		common.getScreen("address");
		
		// 核对信息点击确定按钮
		element.findByIDClick("goToPay");
		// 点击确定支付按钮
		element.findByClassClick("aui_state_highlight");

		// 获取当前窗口句柄
		String currentWindow = driver.getWindowHandle();
		System.out.println("currentWindow =  " + currentWindow);
		// 获取所有窗口句柄
		Set<String> handles = driver.getWindowHandles();
		// 遍历名柄
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
				continue;
			}
			// 切换到新窗口
			WebDriver window = driver.switchTo().window(it.next());
			System.out.println("New page title is:" + window.getTitle());
			
//			common.getScreen("paysuccess");
			
			// 支付成功点击关闭窗口
			element.findByClassClick("bottom");
		}

		// 回到原来页面
		driver.switchTo().window(currentWindow);

		// 点击已完成支付按钮
		element.findByIDClick("showOrderId");
		
//		common.getScreen("ordersubmit");

		logger.info("通过代金券付款成功");
	}

}
