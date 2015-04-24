package com.soul.data;

import java.io.File;  
import java.io.IOException;  
import java.util.ArrayList;  
import java.util.List;  
  
import jxl.Cell;  
import jxl.Sheet;  
import jxl.Workbook;  
import jxl.read.biff.BiffException;  

public class ReadExcel {  
  
    /** 
     * ����excel�ļ������ȡ�ļ����� 
     * @param file 
     *          excel�ļ����� 
     * @return 
     *          ����List<String[][]> 
     * @throws BiffException 
     * @throws IOException 
     */  
	public List<String[][]> readExcel(File file) throws BiffException, IOException{  
//      ������������List���϶���  
        List<String[][]> contents = new ArrayList<String[][]>();  
//      ����excel�ļ��Ĺ���������book  
        Workbook book = Workbook.getWorkbook(file);  
//      ��ȡexcel�ļ��������Ĺ���������sheets  
        Sheet[] sheets = book.getSheets();  
//      ����ÿ��������洢�Ķ�ά�������  
        String[][] row_contents = null;  
//      ���������ʼ��ȡ  
        for(int sheet_index=0;sheet_index<sheets.length;sheet_index++) {  
//          �������  
//            System.out.println("��ǰΪ"+sheet_index+"����������");  
//          �������������sheet  
            Sheet sheet = sheets[sheet_index];  
//          ��ȡexcel��ǰ�������������  
            int rows = sheet.getRows();  
  
//          ��ȡexcel��ǰ�������������  
             int columns = sheet.getColumns();  
//          �������  
//            System.out.println("��ǰ������һ����"+rows+"�С�"+columns+"��");  
//          ������ǰ������Ĵ洢��ά����  
            row_contents = new String[rows][columns];  
//          ѭ������ǰ���������ݱ��浽������  
//          ѭ����  
            for(int row_index=0;row_index<rows;row_index++) {  
//              ѭ����  
                String[] column_contents = new String[columns];  
                 for(int column_index=0;column_index<columns;column_index++) {  
//                  ��ȡ��ǰ������.row_index,column_index��Ԫ���cell����  
                    Cell cell = sheet.getCell(column_index,row_index);  
//                  ��ȡ����ֵ  
                    column_contents[column_index] = cell.getContents();  
                }  
//              ��ǰsheet,��ǰrow������column,��ŵ�row_contents��ά�����row_indexλ��  
                row_contents[row_index] = column_contents;  
            }  
           /** 
             * ��ȡ�����������Ƭ 
             */  
            //-----------------------------------------------------------------------  
            for(int j=0;j<row_contents.length;j++) {  
                for(int k=0;k<row_contents[j].length;k++){  
//                    System.out.print(row_contents[j][k]+"\t");  
                }  
//                System.out.println();  
            }  
//            System.out.println("---------------------");  
            //-----------------------------------------------------------------------  
//          �����ռ�����  
            contents.add(row_contents);  
        }  
//      ����  
        return contents;  
    }

	
} 