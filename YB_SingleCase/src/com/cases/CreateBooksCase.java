package com.cases;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.common.BasicElements;
import com.common.CommonElements;

public class CreateBooksCase {
	BasicElements element = new BasicElements();
	CommonElements comment = new CommonElements();
	String code = null;

	// 创建新书册
	@Test
	public void test1CreateBooks() throws Exception {
	
		System.out.println("======进入testCreateBooks()方法=======");
		//点击我的新书
		element.findByLinkTextClick("我的书库");
		// driver.findElement(By.linkText("我的书库")).click();
		// Thread.sleep(1000);
		element.findByXpathClick(".//*[@id='frameContent']/div/div/input[1]");
		// driver.findElement(
		// By.xpath(".//*[@id='frameContent']/div/div/input[1]")).click();
		// Thread.sleep(1000);
		element.findByLinkTextClick("校园纪念册");
		// driver.findElement(By.linkText("校园纪念册")).click();
		// Thread.sleep(1000);
		element.findByIDSendKeys("gradeName", "mySchool");
		// driver.findElement(By.id("gradeName")).sendKeys("mySchool");
		Thread.sleep(1000);
		element.findByIDSendKeys("groupName", "myClass");
		// driver.findElement(By.id("groupName")).sendKeys("myClass");
		// Thread.sleep(1000);
		// driver.findElement(By.id("bookName")).sendKeys("myBook");
		element.findByIDSendKeys("bookName", comment.time());
		// driver.findElement(By.id("bookName")).sendKeys(time());

		// Thread.sleep(1000);
		String js = "document.getElementById('time').removeAttribute('readOnly');"
				+ "document.getElementById('time').setAttribute('value','2015-12-30');";
		// WebElement text1 = driver.findElement(By.id("time"));
		comment.executeScript(By.id("time"), js);

		// if (driver instanceof JavascriptExecutor) {
		// ((JavascriptExecutor) driver)
		// .executeScript(
		// ,
		// text1);
		// }
		element.findByIDClick("createBookButton");
		// driver.findElement(By.id("createBookButton")).click();
		// Thread.sleep(1000);
		element.findByIDClick("intoBookBtn");
		// driver.findElement(By.id("intoBookBtn")).click();
//		element.findByCssClick("input.btnCss01.bookManagement");
	}

	@Test
	public void  test2Code() throws Exception {

		System.out.println("======进入testCode()方法=======" );
		Thread.sleep(500);
//		driver.findElement(By.cssSelector("input.btnCss01.bookManagement"))
//				.click();
		element.findByCssClick("input.btnCss01.bookManagement");
//		String code = driver.findElement(By.className("color2")).getText();
		code = element.getText(By.className("color2"));
		System.out.println("code = " + code);
		
		// 打开文件
		WritableWorkbook book = Workbook
				.createWorkbook(new File("files/Code.xls"));
		// 生成名为“sheet1”的工作表，参数0表示这是第一页
		WritableSheet sheet = book.createSheet("sheet1", 0);
		// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0),单元格内容为string
		Label label = new Label(0, 0, "code");
	
		// 将定义好的单元格添加到工作表中
		sheet.addCell(label);
		// 生成一个保存数字的单元格,单元格位置是第二列，第一行，单元格的内容为1234.5
//		String string = new String(0, 1, "df97dfdf97df98df9d");
		Label labe2 = new Label(0, 1, code);
		sheet.addCell(labe2);

		// 写入数据并关闭文件
		book.write();
		book.close();
	}	
	
}
