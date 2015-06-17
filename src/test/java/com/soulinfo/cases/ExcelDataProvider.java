package com.soulinfo.cases;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.soulinfo.util.data.BaseExcelData;

/**
 * @author weiwei.zhang
 * @version 1.0
 * @Date 2015.05.06
 * 
 * @param one
 *            sheet名
 * @param two
 *            Excel文件名
 * @param three
 *            开始行数
 * @param four
 *            结束行数
 */

public class ExcelDataProvider {

	// 学生登录数据源
	@DataProvider(name = "testLoginStuDate")
	public static Object[][] testLoginStuDate(Method m)
			throws FileNotFoundException {

		// 通过反射获得函数名称，可以为多个测试方法提供数据驱动
		Object[][] o = new Object[][] {};
		// 取用例数据集d1Test的全部数据(excel数据源)

		if (m.getName().equals("testStuLogin")) {
			return new BaseExcelData().getData("LoginStu", "YB_Data.xls");
		}
		return o;
	}

	// 班长登录数据源
	@DataProvider(name = "testLoginClaDate")
	public static Object[][] testLoginClaDate(Method m)
			throws FileNotFoundException {

		// 通过反射获得函数名称，可以为多个测试方法提供数据驱动
		Object[][] o = new Object[][] {};
		// 取用例数据集d1Test的全部数据(excel数据源)

		if (m.getName().equals("testClaLogin")) {
			return new BaseExcelData().getData("LoginCla", "YB_Data.xls", 1, 1);
		}
		return o;
	}

	// 创建投票数据源
	@DataProvider(name = "createVoteDate")
	public static Object[][] createVoteDate(Method m)
			throws FileNotFoundException {

		// 通过反射获得函数名称，可以为多个测试方法提供数据驱动
		Object[][] o = new Object[][] {};

		// 取用例数据集d1Test的全部数据(excel数据源)
		if (m.getName().equals("testCreateVote")) {
			return new BaseExcelData().getData("CreateVote", "YB_Data.xls");
		}
		return o;
	}

	// 学生加书数据源
	@DataProvider(name = "testAddCodeData")
	public static Object[][] testAddCode(Method m) throws FileNotFoundException {

		// 通过反射获得函数名称，可以为多个测试方法提供数据驱动
		Object[][] o = new Object[][] {};
		// 取用例数据集d1Test的全部数据(excel数据源)

		if (m.getName().equals("testAddBook")) {
			return new BaseExcelData().getData("sheet1", "Code.xls");
		}
		return o;
	}

	// 创建想说数据源
	@DataProvider(name = "createSayDate")
	public static Object[][] createSayDate(Method m)
			throws FileNotFoundException {

		// 通过反射获得函数名称，可以为多个测试方法提供数据驱动
		Object[][] o = new Object[][] {};

		// 取用例数据集d1Test的全部数据(excel数据源)
		if (m.getName().equals("testCreateSay")) {
			return new BaseExcelData().getData("CreateSay", "YB_Data.xls");
		}
		return o;
	}

	// 创建留言数据源
	@DataProvider(name = "createMessageDate")
	public static Object[][] createMessageDate(Method m)
			throws FileNotFoundException {

		// 通过反射获得函数名称，可以为多个测试方法提供数据驱动
		Object[][] o = new Object[][] {};

		// 取用例数据集d1Test的全部数据(excel数据源)
		if (m.getName().equals("testCreateMessage")) {
			return new BaseExcelData().getData("CreateMessage", "YB_Data.xls",
					1, 1);
		}
		return o;
	}

	// 创建个人书页数据源
	@DataProvider(name = "testCreateClaMyPage")
	public static Object[][] createClaMyBookPageDate(Method m)
			throws FileNotFoundException {

		// 通过反射获得函数名称，可以为多个测试方法提供数据驱动
		Object[][] o = new Object[][] {};

		// 取用例数据集d1Test的全部数据(excel数据源)
		if (m.getName().equals("testCreateClaMyPage")) {
			return new BaseExcelData()
					.getData("CreateClaMyPage", "YB_Data.xls");
		}
		return o;
	}

	// 创建个人书页数据源
	@DataProvider(name = "createMyBookPageDate")
	public static Object[][] createMyBookPageDate(Method m)
			throws FileNotFoundException {

		// 通过反射获得函数名称，可以为多个测试方法提供数据驱动
		Object[][] o = new Object[][] {};

		// 取用例数据集d1Test的全部数据(excel数据源)
		if (m.getName().equals("testCreateMyPage")) {
			return new BaseExcelData().getData("CreateMyPage", "YB_Data.xls");
		}
		return o;
	}

	// 创建代金券数据源
	@DataProvider(name = "createVouchersDate")
	public static Object[][] createVouchersDate(Method m)
			throws FileNotFoundException {

		// 通过反射获得函数名称，可以为多个测试方法提供数据驱动
		Object[][] o = new Object[][] {};

		// 取用例数据集d1Test的全部数据(excel数据源)
		if (m.getName().equals("testSubmitOrder")) {
			return new BaseExcelData().getData("Vouchers", "YB_Data.xls");
		}
		return o;
	}
}