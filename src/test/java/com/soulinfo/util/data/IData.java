package com.soulinfo.util.data;

/**
 * 该文件主要提供统一的接口
 * 创建接口返回Object[][]类型（因为testNG数据驱动excel只识别Object[][]或Iterator<Object[]>类型）
 * 
 * @author weiwei.zhang
 * @version 1.0
 * @Date 2015.05.05
 * 
 * @param caseName
 *            Excel文件Sheet名
 * @param dataFile
 *            excel文件名
 * @param colNum
 *            行数
 * @param beginNum
 *            开始行数
 * @param endNum
 *            结束行数
 * @return Object[][]
 */
public interface IData {

	public Object[][] getData(String caseName, String dataFile);

	public Object[][] getData(String caseName, String dataFile, int colNum);

	public Object[][] getData(String caseName, String dataFile, int beginNum,int endNum);

}
