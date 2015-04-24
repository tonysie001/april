package com.soul.yb.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.read.biff.BiffException;

import org.testng.TestNG;

import com.soul.cases.MessageCase;
import com.soul.cases.VoteCase;
import com.soul.data.Common;
import com.soul.data.ReadExcel;
import com.soul.entity.YBEntity;

public class Test {

	public static void main(String args[]) throws IOException, BiffException {

		// 实例化读取EXCEL对象
		File file = new File(Common.YB_MESSAGE_PATH);

		// 实例化登录对象集合
		List<String[][]> list = new ReadExcel().readExcel(file);
		for (int i = 0; i < list.size(); i++) {
			YBEntity yb = new YBEntity();
			String arr[][] = list.get(i);
			// 遍历二维数组
			for (int j = 1; j < arr.length; j++) {
				String[] arr1 = arr[j];
				yb.setId(Integer.parseInt(arr[j][0]));
				yb.setUsername(arr[j][1]);
				yb.setPassword(arr[j][2]);
				yb.setCode(arr[j][3]);
				yb.setName(arr[j][4]);
				yb.setMessage(arr[j][5]);

				yb.setSayone(arr[j][6]);
				yb.setSaytwo(arr[j][7]);
				yb.setSaythree(arr[j][8]);
				yb.setSayfour(arr[j][9]);
				yb.setSayfive(arr[j][10]);

				yb.setTitle(arr[j][11]);
				yb.setOption1(arr[j][12]);
				yb.setOption2(arr[j][13]);
				yb.setOption3(arr[j][14]);

				System.out.println("yb.getId() = " +yb.getId()+ "yb.getUsername() = " + yb.getUsername()+ "yb.getPassword() = " +yb.getPassword());
			
			}
		}
	}
}
