package com.soul.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.soul.entity.YBEntity;

public class ReadExcel {

	/**
	 * read the Excel file
	 * 
	 * @param path
	 *            the path of the Excel file
	 * @return
	 * @throws IOException
	 */
	public List<YBEntity> readExcel(String path) throws IOException {
		if (path == null || Common.EMPTY.equals(path)) {
			return null;
		} else {
			String postfix = Util.getPostfix(path);
			if (!Common.EMPTY.equals(postfix)) {
				if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return readXls(path);
				} else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					return readXlsx(path);
				}
			} else {
				System.out.println(path + Common.NOT_EXCEL_FILE);
			}
		}
		return null;
	}

	/**
	 * Read the Excel 2010
	 * 
	 * @param path
	 *            the path of the excel file
	 * @return
	 * @throws IOException
	 */
	public List<YBEntity> readXlsx(String path) throws IOException {
		System.out.println(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		YBEntity yb = null;
		List<YBEntity> list = new ArrayList<YBEntity>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					yb = new YBEntity();
					XSSFCell username = xssfRow.getCell(0);
					XSSFCell password = xssfRow.getCell(1);
					XSSFCell code = xssfRow.getCell(2);
					XSSFCell sayone = xssfRow.getCell(3);
					XSSFCell saytwo = xssfRow.getCell(4);
					XSSFCell saythree = xssfRow.getCell(5);
					XSSFCell sayfour = xssfRow.getCell(6);
					XSSFCell sayfive = xssfRow.getCell(7);
					XSSFCell name = xssfRow.getCell(8);
					XSSFCell message = xssfRow.getCell(9);
					XSSFCell title = xssfRow.getCell(10);
					XSSFCell option1 = xssfRow.getCell(11);
					XSSFCell option2 = xssfRow.getCell(12);
					XSSFCell option3 = xssfRow.getCell(13);

					yb.setUsername(getValue(username));
					yb.setPassword(getValue(password));
					yb.setCode(getValue(code));
					yb.setSayone(getValue(sayone));
					yb.setSaytwo(getValue(saytwo));
					yb.setSaythree(getValue(saythree));
					yb.setSayfour(getValue(sayfour));
					yb.setSayfive(getValue(sayfive));
					yb.setName(getValue(name));
					yb.setMessage(getValue(message));
					yb.setTitle(getValue(title));
					yb.setOption1(getValue(option1));
					yb.setOption2(getValue(option2));
					yb.setOption3(getValue(option3));
					

					list.add(yb);
				}
			}
		}
		return list;
	}

	/**
	 * Read the Excel 2003-2007
	 * 
	 * @param path
	 *            the path of the Excel
	 * @return
	 * @throws IOException
	 */
	public List<YBEntity> readXls(String path) throws IOException {
		System.out.println(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		YBEntity yb = null;
		List<YBEntity> list = new ArrayList<YBEntity>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					yb = new YBEntity();
					HSSFCell username = hssfRow.getCell(0);
					HSSFCell password = hssfRow.getCell(1);
					HSSFCell code = hssfRow.getCell(2);
					HSSFCell sayone = hssfRow.getCell(3);
					HSSFCell saytwo = hssfRow.getCell(4);
					HSSFCell saythree = hssfRow.getCell(5);
					HSSFCell sayfour = hssfRow.getCell(6);
					HSSFCell sayfive = hssfRow.getCell(7);
					HSSFCell name = hssfRow.getCell(8);
					HSSFCell message = hssfRow.getCell(9);
					HSSFCell title = hssfRow.getCell(10);
					HSSFCell option1 = hssfRow.getCell(11);
					HSSFCell option2 = hssfRow.getCell(12);
					HSSFCell option3 = hssfRow.getCell(13);

					yb.setUsername(getValue(username));
					yb.setPassword(getValue(password));
					yb.setCode(getValue(code));
					yb.setSayone(getValue(sayone));
					yb.setSaytwo(getValue(saytwo));
					yb.setSaythree(getValue(saythree));
					yb.setSayfour(getValue(sayfour));
					yb.setSayfive(getValue(sayfive));
					yb.setName(getValue(name));
					yb.setMessage(getValue(message));
					yb.setTitle(getValue(title));
					yb.setOption1(getValue(option1));
					yb.setOption2(getValue(option2));
					yb.setOption3(getValue(option3));

					list.add(yb);
				}
			}
		}
		return list;
	}

	@SuppressWarnings("static-access")
	private String getValue(XSSFCell xssfRow) {
		if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfRow.getBooleanCellValue());
		} else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
			return String.valueOf(xssfRow.getNumericCellValue());
		} else {
			return String.valueOf(xssfRow.getStringCellValue());
		}
	}

	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}
}