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

            // 通过反射获得函数名称，可以为多个测试方法提供数据驱动
            Object[][] o = new Object[][] {};

            // 取用例数据集d1Test的全部数据(excel数据源)
            if (m.getName().equals("com.cases.testLogin")) {
                return new BaseExcelData().getData("Login", "Login.xls",1,1);
            }   
            return o;
        }
}