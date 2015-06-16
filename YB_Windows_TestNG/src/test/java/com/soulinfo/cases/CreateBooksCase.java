package com.soulinfo.cases;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.soulinfo.util.BasicElements;
import com.soulinfo.util.CommonElements;

public class CreateBooksCase {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	BasicElements element = new BasicElements();
	CommonElements comment = new CommonElements();
	CommonElements common = new CommonElements();
	String code = null;
	String bookname = null;

	/**
	 * 创建新书册
	 * @throws InterruptedException 
	 */
	@Test
	public void test1CreateBooks() throws InterruptedException {
		logger.info("======进入testCreateBooks()方法=======");

		// 点击我的书库
		element.findByLinkTextClick("我的书库");			

		// 点击创建新书
		element.findByXpathClick(".//*[@id='frameContent']/div/div/input[1]");
//		common.getScreen("newbook");

		// 点击校园纪念册
		element.findByLinkTextClick("校园纪念册");
		// 输入学校名/社团名
		element.findByIDSendKeys("gradeName", "mySchool");
		// 输入班级/小组
		element.findByIDSendKeys("groupName", "myClass");
		// 输入书名
		element.findByIDSendKeys("bookName", comment.time());
		String js = "document.getElementById('time').removeAttribute('readOnly');"
				+ "document.getElementById('time').setAttribute('value','2015-12-30');";
		// 输入预计完成时间
		comment.executeScript(By.id("time"), js);

//		common.getScreen("newbooktext");
		
		// 点击完成
		element.findByIDClick("createBookButton");
		Thread.sleep(2000);
		
		// 点击进入按钮
		element.findByIDClick("intoBookBtn");
		
//		common.getScreen("intoBoot");

		logger.info("班长登录创建新书成功");
	}

	/**
	 * 邀请码并写入Excel文件中
	 * 
	 * @throws IOException
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	@Test
	public void test2Code() throws IOException, RowsExceededException,
			WriteException {

		logger.info("======进入testCode()方法=======");

		// 点击书册管理
		element.findByCssClick("input.btnCss01.bookManagement");

		code = element.getText(By.className("color2"));
		logger.info("拿到用户管理界面中我的邀请码：" + code);

		// 点击配置管理
//		element.findByLinkTextClick("配置管理");
		// 拿到书名
//		bookname = element.findByID("bookName").getAttribute("value");

		// 打开文件
		WritableWorkbook book = Workbook.createWorkbook(new File(
				"files/Code.xls"));
		// 生成名为“sheet1”的工作表，参数0表示这是第一页
		WritableSheet sheet = book.createSheet("sheet1", 0);
		// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0),单元格内容为string
		Label label1 = new Label(0, 0, "code");
		// 将定义好的单元格添加到工作表中
		sheet.addCell(label1);

		// 生成一个保存数字的单元格,单元格位置是第二列，第一行，单元格的内容为1234.5
		// String string = new String(0, 1, "df97dfdf97df98df9d");
		Label label3 = new Label(0, 1, code);
		sheet.addCell(label3);

		// 写入数据并关闭文件
		book.write();
		book.close();
	}
}
