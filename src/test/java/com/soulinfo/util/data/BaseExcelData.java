package com.soulinfo.util.data;

import java.io.*;
import java.util.ArrayList;



import jxl.*;
import jxl.read.biff.BiffException;

/**
 * 1、实现接口中的方法 2、把excel的数据取出来放到list中，在把list中的数据放到Object[][]数组中
 * 
 * @author weiwei.zhang
 * @version 1.0
 * @Date 2015.05.05
 */

public  class BaseExcelData implements IData {
	// 根目录files（存放excel文件）
	String defaultPath = "files/";

	// 返回Excel文件里所有内容
	public Object[][] getData(String caseName, String dataFile) {
		return getData(caseName, dataFile, 0);
	}

	// 返回Excel文件里指定行数内容（默认从第一行开始，标题不读）
	public Object[][] getData(String caseName, String dataFile, int rowNum) {
		Object[][] data = null;
		try {
			data = addList(caseName, dataFile, rowNum);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	// 返回Excel文件里指定开始行数与结束行数内容（标题不读）
	public Object[][] getData(String caseName, String dataFile,
			int beginRowNum, int endRowNum) {
		Object[][] data = null;
		try {
			data = addListSelect(caseName, dataFile, beginRowNum, endRowNum);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 读取excel文件存入data
	 * 
	 * @param caseName
	 *            Excel文件Sheet名
	 * @param dataFile
	 *            excel文件名
	 * @param rowNum
	 *            行数
	 * @return data
	 * @throws FileNotFoundException
	 */
	private Object[][] addList(String caseName, String dataFile, int rowNum)
			throws FileNotFoundException {
		ArrayList<Object> list = new ArrayList<Object>();
		// 文件路径
		InputStream is = new FileInputStream(defaultPath + dataFile);
		Object[][] data = null;
		try {
			Workbook wb = Workbook.getWorkbook(is);
			Sheet rs = wb.getSheet(caseName);
			// 获取表格总行数
			int rsRows = rs.getRows();
			// 获取表格总列数
			int rsColumns = rs.getColumns();

			if (rs != null) {
				for (int i = 1; i <= rsRows - 1; i++) {
					for (int j = 0; j <= rsColumns - 1; j++) {
						Cell c = rs.getCell(j, i);
						String cz = c.getContents();
						list.add(cz);
					}
				}
				// System.out.println(list);
			}

			// 判断Excel表格是否有内容
			if (rowNum <= 0 || rowNum >= rsRows) {
				data = new Object[rsRows - 1][rsColumns];
				int k = -1;
				// 读取行列，把list的值赋值给object数组
				for (int i = 0; i < rsRows - 1; i++) {
					for (int j = 0; j < rsColumns; j++) {
						if (k < list.size())
							k++;
						data[i][j] = list.get(k);
						// System.out.println("i="+i+","+"j="+j+","+data[i][j]);
					}
				}
			} else {
				int k = -1;
				// 跟据行数及总列数，把list的值赋值给object数组
				data = new Object[rowNum][rsColumns];
				for (int i = 0; i < rowNum; i++) {
					for (int j = 0; j < rsColumns; j++) {
						if (k < list.size())
							k++;
						if (i <= (rowNum - 1)) {
							data[i][j] = list.get(k);
						}
					}
				}
			}
			wb.close();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 
	 * 读取excel文件存入data
	 * 
	 * @param caseName
	 *            Excel文件Sheet名
	 * @param dataFile
	 *            excel文件名
	 * @param beginNum
	 *            开始行数
	 * @param endNum
	 *            结束行数
	 * @return data
	 * @throws FileNotFoundException
	 */
	private Object[][] addListSelect(String caseName, String dataFile,
			int beginNum, int endNum) throws FileNotFoundException {

		ArrayList<Object> list = new ArrayList<Object>();
		// 文件路径
		InputStream is = new FileInputStream(defaultPath + dataFile);
		Object[][] data = null;
		try {
			Workbook wb = Workbook.getWorkbook(is);
			Sheet rs = wb.getSheet(caseName);
			// 获取表格总行数
			int rsRows = rs.getRows();
			// 获取表格总列数
			int rsColumns = rs.getColumns();

			if (rs != null) {
				for (int i = 1; i <= rsRows - 1; i++) {
					for (int j = 0; j <= rsColumns - 1; j++) {
						Cell c = rs.getCell(j, i);
						String cz = c.getContents();
						list.add(cz);
					}
				}
				// System.out.println(list);
			}

			// 取得行数
			int sub = (endNum - beginNum) + 1;
			data = new Object[sub][rsColumns];

			// 判断Excel文件是否有值
			if (beginNum <= 0 || endNum > rsRows) {
				if (beginNum <= 0 && endNum > rsRows) {
					beginNum = 0;
					endNum = rsRows;
					data = new Object[rsRows][rsColumns];
					for (int i = 0; i < sub; i++) {
						for (int j = 0; j < rsColumns; j++) {
							if (beginNum < rsRows * rsColumns)
								data[i][j] = list.get(beginNum);
							beginNum++;
						}
					}
				} else if (beginNum <= 0 && endNum <= rsRows) {
					beginNum = 0;
					sub = (endNum - beginNum);
					data = new Object[endNum][rsColumns];
					for (int i = 0; i < sub; i++) {
						for (int j = 0; j < rsColumns; j++) {
							if (beginNum < sub * rsColumns)
								data[i][j] = list.get(beginNum);
							beginNum++;
						}
					}
				} else {
					endNum = rsRows;
					sub = (endNum - beginNum) + 1;
					data = new Object[sub][rsColumns];
					for (int i = 0; i < sub; i++) {
						for (int j = 0; j < rsColumns; j++) {
							if (beginNum <= sub * rsColumns)
								data[i][j] = list.get(beginNum - 1);
							beginNum++;
						}
					}

				}
			} else {
				int k = 0;
				int a = beginNum * rsColumns;
				// 将指定行列的值赋值给object数组
				for (int i = 0; i < sub; i++) {
					for (int j = 0; j < rsColumns; j++) {
						if (k < sub * rsColumns)
							data[i][j] = list.get(a + k - 3);
						k++;
					}
				}
			}
			wb.close();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}