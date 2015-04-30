package com.soul.logic;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

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
import com.soul.cases.SayCase;
import com.soul.cases.SubmitBookCase;
import com.soul.cases.VoteCase;
import com.soul.entity.YBEntity;

public class CreateBookLogic {

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
	MessageCase messageCase = new MessageCase();
	// 实例化想说内容a
	SayCase sayCase = new SayCase();
	// 实例化参与 投票对象
	VoteCase voteCase = new VoteCase();
	// 实例化上传照片对象
	// 实例化制作个人书页对象
	MyPageCase myPage = new MyPageCase();
	// 实使化班长增加投票页对象
	AddVotesCase addVotes = new AddVotesCase();
	// 实使化全景照片对象
	CreateBigPhotoCase bigPhoto = new CreateBigPhotoCase();
	// 实例化提交书册
	SubmitBookCase submitBook = new SubmitBookCase();

	String code = null;
	String username = null;

	/**
	 * 1、班长登录 2、班长创建新书册 3、拿到新书册邀请码 4、创建新的投票 5、注销登录
	 * 
	 * @param driver
	 * @param list
	 * @param classname
	 * @throws Exception
	 */
	@Test
	public void createBook(WebDriver driver, List<String[][]> list,
			String classname) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			YBEntity yb = new YBEntity();
			String arr[][] = list.get(i);
			// 遍历二维数组
			for (int j = 1; j < arr.length; j++) {

				yb.setId(Integer.parseInt(arr[j][0]));
				yb.setUsername(arr[j][1]);
				yb.setPassword(arr[j][2]);
				yb.setCode(arr[j][3]);
				yb.setName(arr[j][4]);
				yb.setTitle(arr[j][11]);
				yb.setOption1(arr[j][12]);
				yb.setOption2(arr[j][13]);
				yb.setOption3(arr[j][14]);

				if (yb.getName().equals(classname)) {

					// 班长登录方法
					log.testLogin(driver, yb);
					// 班长创建新书册方法
					createBooks.testCreateBooks(driver);
					// 得到邀请码方法
					code = createBooks.testCode(driver);
					System.out.println("code = " + code);

					// 班长创建新投票方法
					createVote.testCreateVote(driver, yb);

					// 注销方法
					log.testLogout(driver);
					break;
				}
			}
		}
		System.out.println("创建新书完成时间：" + new Date(System.currentTimeMillis()));
	}

	/**
	 * 1、普通学生登录 2、普通学生加入新书册 3、注销登录
	 * 
	 * @param driver
	 * @param list
	 * @param classname
	 * @throws Exception
	 */
	@Test
	public void addBook(WebDriver driver, List<String[][]> list,
			String classname) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			YBEntity yb = new YBEntity();
			String arr[][] = list.get(i);
			// 遍历二维数组
			for (int j = 1; j < arr.length; j++) {

				yb.setId(Integer.parseInt(arr[j][0]));
				yb.setUsername(arr[j][1]);
				yb.setPassword(arr[j][2]);
				yb.setCode(arr[j][3]);
				yb.setName(arr[j][4]);

				if (yb.getName().equals(classname)) {
				} else {
					System.out.println(yb.getUsername());
					// 调用登录方法
					log.testLogin(driver, yb);

					// 调用加入新书册方法
					try{
						addbook.testMyBook(driver, code);	
					}catch (Exception e){
						e.printStackTrace();
						log.testLogin(driver, yb);
					}
					

					// 调用注销方法
					log.testLogout(driver);
				}
			}
		}
		System.out.println("加入书册完成时间：" + new Date(System.currentTimeMillis()));
	}

	/**
	 * 1、登录 2、班长打开创建新书册并留言 3、普通学生打开加入新书册，发表想说、投票 4、注销登录
	 * 
	 * @param driver
	 * @param list
	 * @param classname
	 * @throws Exception
	 */
	@Test
	public void addMyBookText(WebDriver driver, List<String[][]> list,
			String classname) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			YBEntity yb = new YBEntity();
			String arr[][] = list.get(i);
			// 遍历二维数组
			for (int j = 1; j < arr.length; j++) {

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

				// 调用登录方法
				log.testLogin(driver, yb);

				username = log.testLoginName(driver);

				// 如果为班长，选择创建新书，如果为班级成员，选择参与新书
				if (yb.getName().equals(classname)) {
					// 调用打开创建新书册方法
					addbook.testOpenCreateBook(driver);
					// 给小伙伴留言方法
					messageCase.testCreateMessage(driver, username, list,
							classname);
				} else {
					// 调用打开参与新书册方法
					addbook.testOpenBook(driver);
				}

				// 调用此刻想说方法
				try {
					sayCase.testCreateSay(driver, yb);
				} catch (Exception e) {
					e.printStackTrace();
				}

				// 参与投票方法
				try {
					voteCase.testCreateVote(driver);
				} catch (Exception e) {
					e.printStackTrace();
				}

				// 上传照片方法
				// photo.testCreatePhoto(driver);

				// 调用注销方法
				log.testLogout(driver);

			}
		}
		System.out.println("发表内容完成时间：" + new Date(System.currentTimeMillis()));
	}

	/**
	 * 1、登录 2、班长打开创建新书 3、普通学生打开加入新书 4、创建个人书页并提交 5、注销登录
	 * 
	 * @param driver
	 * @param list
	 * @param classname
	 * @throws Exception
	 */
	@Test
	public void createMyBook(WebDriver driver, List<String[][]> list,
			String classname) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			YBEntity yb = new YBEntity();
			String arr[][] = list.get(i);
			// 遍历二维数组
			for (int j = 1; j < arr.length; j++) {

				yb.setId(Integer.parseInt(arr[j][0]));
				yb.setUsername(arr[j][1]);
				yb.setPassword(arr[j][2]);
				yb.setCode(arr[j][3]);
				yb.setName(arr[j][4]);

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

				try {
					myPage.testCreateMyPage(driver, yb, classname);
				} catch (Exception e) {
					e.printStackTrace();
				}

				// 调用注销方法
				log.testLogout(driver);

			}
		}
		System.out
				.println("个人书页制作完成时间：" + new Date(System.currentTimeMillis()));
	}

	/**
	 * 1、班长登录 2、打开创建的新书册 3、添加活动页 4、制作活动页并提交5、增加投票页 6、制作投票页 7、制作全景照片 8、提交未提交书页
	 * 9、提交书册 10、注销登录
	 * 
	 * @param driver
	 * @param list
	 * @param classname
	 * @throws Exception
	 */
	@Test
	public void submitBook(WebDriver driver, List<String[][]> list,
			String classname) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			YBEntity yb = new YBEntity();
			String arr[][] = list.get(i);
			// 遍历二维数组
			for (int j = 1; j < arr.length; j++) {

				yb.setId(Integer.parseInt(arr[j][0]));
				yb.setUsername(arr[j][1]);
				yb.setPassword(arr[j][2]);
				yb.setCode(arr[j][3]);
				yb.setName(arr[j][4]);

				if (yb.getName().equals(classname)) {
					System.out.println(yb.getName().equals(classname));
					// 班长登录方法
					log.testLogin(driver, yb);

					// 调用打开创建新书册方法
					addbook.testOpenCreateBook(driver);

					// 班长添加活动页模板方法
					try {
						addActivities.testAddActivities(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// 班长创建活动页对象方法
					try {
						createActivities.testCreateaAtivities(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// 班长增加投票页方法
					try {
						addVotes.testAddVotes(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// 制作提交投票页方法
					try {
						addVotes.testCreateVote(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// 制作全景照片方法
					try {
						bigPhoto.testCreateBigPhoto(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// 班长提交其他未提交页方法
					try {
						submitBook.testSubimitOthers(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// 提交书册方法
					try {
						submitBook.testSubmitBook(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// 注销方法
					log.testLogout(driver);
					break;
				}
			}
		}
		System.out.println("书册提交完成时间：" + new Date(System.currentTimeMillis()));
	}
}
