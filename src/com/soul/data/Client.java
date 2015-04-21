package com.soul.data;

import java.io.IOException;
import java.util.List;

import com.soul.data.Common;
import com.soul.data.ReadExcel;
import com.soul.entity.YBEntity;

public class Client {

	public static void main(String[] args) throws IOException {
		String excel2003_2007 = Common.YB_INFO_XLS_PATH;
		List<YBEntity> list = new ReadExcel().readExcel(excel2003_2007);
		if (list != null) {
			for (YBEntity yb : list) {
				System.out.println("name : " + yb.getUsername()
						+ ",password  : " + yb.getPassword() + ",code  : "
						+ yb.getCode());
				System.out.println("one : " + yb.getSayone() + ",two  : "
						+ yb.getSaytwo() + ",three  : " + yb.getSaythree());
				System.out.println("four : " + yb.getSayfour() + ",five  : "
						+ yb.getSayfive());
			}
		}
		System.out.println("======================================");
	}
}