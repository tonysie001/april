package com.soul.yb.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.soul.cases.AddActivitiesCase;
import com.soul.cases.AddBookCase;
import com.soul.cases.AddVotesCase;
import com.soul.cases.CreateActivitiesCase;
import com.soul.cases.CreateBigPhotoCase;
import com.soul.cases.CreateBooksCase;
import com.soul.cases.CreateVoteCase;
import com.soul.cases.LoginCase;
import com.soul.cases.MessageCase;
import com.soul.cases.MyPageCase;
import com.soul.cases.OperationBrowser;
import com.soul.cases.PhotoCase;
import com.soul.cases.SayCase;
import com.soul.cases.SubmitBookCase;
import com.soul.cases.VoteCase;
import com.soul.data.Common;
import com.soul.data.ReadExcel;
import com.soul.entity.YBEntity;

public class LoginTest {

	public static void main(String args[]) throws Exception {

		// 实例化读取EXCEL对象
		String excel2003_2007 = Common.YB_INFO_XLS_PATH;

		// 实例化登录对象集合
		List<YBEntity> list = new ReadExcel().readExcel(excel2003_2007);

		// 实例化driver对象
		WebDriver driver = new FirefoxDriver();

		// 实例化操作浏览器对象
		OperationBrowser browser = new OperationBrowser();
		// 实例化登录对象
		LoginCase log = new LoginCase();
		// 实例化创建新书册对象
		CreateBooksCase createBooks = new CreateBooksCase();
		// 实例化创建新投票对象
		CreateVoteCase createVote = new CreateVoteCase();
		// 实例化增加活动模板页对象
		AddActivitiesCase addActivities = new AddActivitiesCase();
		// 实例化创建活动页对象
		CreateActivitiesCase createActivities = new CreateActivitiesCase();
		// 实例化加入书册对象
		AddBookCase addbook = new AddBookCase();
		// 实例化留言对象
		MessageCase message = new MessageCase();
		// 实例化想说内容a
		SayCase say = new SayCase();
		// 实例化参与 投票对象
		VoteCase vote = new VoteCase();
		// 实例化上传照片对象
		PhotoCase photo = new PhotoCase();
		// 实例化制作个人书页对象
		MyPageCase myPage = new MyPageCase();
		//实使化班长增加投票页对象
		AddVotesCase addVotes = new AddVotesCase();
		//实使化全景照片对象
		CreateBigPhotoCase bigPhoto = new CreateBigPhotoCase();
		//实例化提交书册
		SubmitBookCase submitBook = new SubmitBookCase();
		
		

		// 定义普通班级成员名字
		String username = null;
		// 定义班长名字
		String classname = null;
		// 定义邀请码
		String code = null;
		// 定义创建书名
		String bookname = "《case5》";

		// 隐式等待
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 调用打开浏览器方法
		browser.beforeMethod(driver);

		// 得到班长名字
		for (YBEntity yb : list) {
			log.testLogin(driver, yb);
			classname = log.testLoginName(driver);
			// 注销方法
			log.testLogout(driver);
			break;
		}

		// 判断班长登录
		System.out.println(list.get(0).getName());
		for (YBEntity yb : list) {
			if (list.get(0).getName().equals(classname)) {
				System.out.println(list.get(0).getName().equals(classname));
				// 班长登录方法
				log.testLogin(driver, yb);
				// 班长创建新书册方法
				createBooks.testCreateBooks(driver);
				// 得到邀请码方法
				code = createBooks.testCode(driver);
				System.out.println("main() code = " + code);

				// 班长创建新投票方法
				createVote.testCreateVote(driver, yb);
				// 班长添加活动页模板方法
				addActivities.testAddActivities(driver);
				//班长创建活动页对象方法
				createActivities.testCreateaAtivities(driver);

				// 注销方法
				log.testLogout(driver);
				break;
			}
		}

		System.out.println("===========退出for循环=============");

			System.out.println("===========开始for循环=============");
			// 循环excel表格值

			for (Iterator item = list.iterator(); item.hasNext();) {
				YBEntity yb = (YBEntity) item.next();
				System.out.print(yb.getName());
				if (yb.getName().equals(classname)) {
					System.out.println("if (){}");

				} else {
					System.out.println(yb.getUsername());
					// 调用登录方法
					log.testLogin(driver, yb);

					// 调用加入新书册方法

					addbook.testMyBook(driver, code, bookname);

					// 调用注销方法
					log.testLogout(driver);
				}

			}

		
			// 循环excel表格值
			for (YBEntity yb : list) {
				System.out.println(yb.getUsername());
				// 调用登录方法
				log.testLogin(driver, yb);

				username = log.testLoginName(driver);

				// 如果为班长，选择创建新书，如果为班级成员，选择参与新书
				if (yb.getName().equals(classname)) {
					// 调用打开创建新书册方法
					addbook.testOpenCreateBook(driver);
				} else {
					// 调用打开参与新书册方法
					addbook.testOpenBook(driver);
				}

				// 给小伙伴留言方法
				System.out.println("main() username = " + username);
				message.testCreateMessage(driver, username, list);

				// 调用此刻想说方法
				say.testCreateSay(driver, yb);

				// 参与投票方法
				vote.testCreateVote(driver);

				// 上传照片方法
				// photo.testCreatePhoto(driver);

				// 调用注销方法
				log.testLogout(driver);

			}
			System.out.println("这是第三个循环 = ");
	
		
		
		for (YBEntity yb : list) {

			// 调用登录方法
			log.testLogin(driver, yb);

			// 如果为班长，选择创建新书，如果为班级成员，选择参与新书
			if (yb.getName().equals(classname)) {
				// 调用打开创建新书册方法
				addbook.testOpenCreateBook(driver);
			} else {
				// 调用打开参与新书册方法
				addbook.testOpenBook(driver);
			}

			// 调用制作个人书页方法
			myPage.testCreateMyPage(driver,yb,classname);

			// 调用注销方法
			log.testLogout(driver);

		}

		//班长登录提交书册
		for (YBEntity yb : list) {
			if (list.get(0).getName().equals(classname)) {
				System.out.println(list.get(0).getName().equals(classname));
				// 班长登录方法
				log.testLogin(driver, yb);
		
				// 调用打开创建新书册方法
				addbook.testOpenCreateBook(driver);
							
				// 班长增加投票页方法
				addVotes.testAddVotes(driver);
				// 制作提交投票页方法
				addVotes.testCreateVote(driver);
				
				//制作全景照片方法
				bigPhoto.testCreateBigPhoto(driver);
				
				//班长提交其他未提交页方法
				submitBook.testSubimitOthers(driver);
				//提交书册方法
				submitBook.testSubmitBook(driver);

				// 注销方法
				log.testLogout(driver);
				break;
			}
		}

		// 调用退出浏览器方法
		browser.afterMethod(driver);
		// log.afterMethod();
	}
}
