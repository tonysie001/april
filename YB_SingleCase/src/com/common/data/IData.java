package com.common.data;

/**
 * ���ļ���Ҫ�ṩͳһ�Ľӿ�
 * �����ӿڷ���Object[][]���ͣ���ΪtestNG��������excelֻʶ��Object[][]��Iterator<Object[]>���ͣ�
 * 
 * @author weiwei.zhang
 * @version 1.0
 * @Date 2015.05.05
 * 
 * @param caseName
 *            Excel�ļ�Sheet��
 * @param dataFile
 *            excel�ļ���
 * @param colNum
 *            ����
 * @param beginNum
 *            ��ʼ����
 * @param endNum
 *            ��������
 * @return Object[][]
 */
public interface IData {

	public Object[][] getData(String caseName, String dataFile);

	public Object[][] getData(String caseName, String dataFile, int colNum);

	public Object[][] getData(String caseName, String dataFile, int beginNum,int endNum);

}
