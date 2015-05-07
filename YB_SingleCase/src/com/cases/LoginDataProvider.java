package com.cases;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.common.data.BaseExcelData;

/**
 * @author  weiwei.zhang
 * @version 1.0
 * @Date 2015.05.06
 */


public class LoginDataProvider {

        @DataProvider(name = "GetDataFromXml")
        public static Object[][] getTestDataFromXml(Method m) throws FileNotFoundException {

            // ͨ�������ú������ƣ�����Ϊ������Է����ṩ��������
            Object[][] o = new Object[][] {};

            // ȡ�������ݼ�d1Test��ȫ������(excel����Դ)
            if (m.getName().equals("com.cases.testLogin")) {
                return new BaseExcelData().getData("Login", "Login.xls",1,1);
            }   
            return o;
        }
}