package com.cases;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.common.data.BaseExcelData;

/**
 * @author weiwei.zhang
 * @version 1.0
 * @Date 2015.05.06
 * 
 *       ����˵�� һsheet�� ��xls�ļ��� ����ʼ���� �Ľ�������
 */

public class ExcelDataProvider {

	// ѧ����¼����Դ
	@DataProvider(name = "testLoginStuDate")
	public static Object[][] testLoginStuDate(Method m)
			throws FileNotFoundException {

		System.out.println("==========testLoginStuDate==============");
		// ͨ�������ú������ƣ�����Ϊ������Է����ṩ��������
		Object[][] o = new Object[][] {};
		// ȡ�������ݼ�d1Test��ȫ������(excel����Դ)

		if (m.getName().equals("testStuLogin")) {
			return new BaseExcelData().getData("LoginStu", "YB_Data.xls");
		}

		return o;
	}
	
	// �೤��¼����Դ
	@DataProvider(name = "testLoginClaDate")
	public static Object[][] testLoginClaDate(Method m)
			throws FileNotFoundException {

		System.out.println("==========testLoginClaDate==============");
		// ͨ�������ú������ƣ�����Ϊ������Է����ṩ��������
		Object[][] o = new Object[][] {};
		// ȡ�������ݼ�d1Test��ȫ������(excel����Դ)

		if (m.getName().equals("testClaLogin")) {
			return new BaseExcelData().getData("LoginCla", "YB_Data.xls", 1, 1);
		}

		return o;
	}

	// ����ͶƱ����Դ
	@DataProvider(name = "createVoteDate")
	public static Object[][] createVoteDate(Method m)
			throws FileNotFoundException {

		System.out.println("==========createVoteDate==============");
		// ͨ�������ú������ƣ�����Ϊ������Է����ṩ��������
		Object[][] o = new Object[][] {};

		// ȡ�������ݼ�d1Test��ȫ������(excel����Դ)
		if (m.getName().equals("testCreateVote")) {
			return new BaseExcelData().getData("CreateVote", "YB_Data.xls");
		}
		return o;
	}

	// ������˵����Դ
	@DataProvider(name = "createSayDate")
	public static Object[][] createSayDate(Method m)
			throws FileNotFoundException {

		System.out.println("==========createSayDate==============");
		// ͨ�������ú������ƣ�����Ϊ������Է����ṩ��������
		Object[][] o = new Object[][] {};

		// ȡ�������ݼ�d1Test��ȫ������(excel����Դ)
		if (m.getName().equals("testCreateSay")) {
			return new BaseExcelData().getData("CreateSay", "YB_Data.xls");
		}
		return o;
	}

	// ������������Դ
	@DataProvider(name = "createMessageDate")
	public static Object[][] createMessageDate(Method m)
			throws FileNotFoundException {

		System.out.println("==========createSayDate==============");
		// ͨ�������ú������ƣ�����Ϊ������Է����ṩ��������
		Object[][] o = new Object[][] {};

		// ȡ�������ݼ�d1Test��ȫ������(excel����Դ)
		if (m.getName().equals("testCreateMessage")) {
			return new BaseExcelData().getData("CreateMessage", "YB_Data.xls",
					1, 1);
		}
		return o;
	}
	
	
	// ����������ҳ����Դ
	@DataProvider(name = "testCreateClaMyPage")
	public static Object[][] createClaMyBookPageDate(Method m)
			throws FileNotFoundException {

		System.out.println("==========createMyBookPageDate==============");
		// ͨ�������ú������ƣ�����Ϊ������Է����ṩ��������
		Object[][] o = new Object[][] {};

		// ȡ�������ݼ�d1Test��ȫ������(excel����Դ)
		if (m.getName().equals("testCreateClaMyPage")) {
			return new BaseExcelData().getData("CreateClaMyPage", "YB_Data.xls");
		}
		return o;
	}
	

	// ����������ҳ����Դ
	@DataProvider(name = "createMyBookPageDate")
	public static Object[][] createMyBookPageDate(Method m)
			throws FileNotFoundException {

		System.out.println("==========createMyBookPageDate==============");
		// ͨ�������ú������ƣ�����Ϊ������Է����ṩ��������
		Object[][] o = new Object[][] {};

		// ȡ�������ݼ�d1Test��ȫ������(excel����Դ)
		if (m.getName().equals("testCreateMyPage")) {
			return new BaseExcelData().getData("CreateMyPage", "YB_Data.xls");
		}
		return o;
	}

}