package com.soulinfo.logic;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 

import com.soulinfo.cases.AddActivitiesCase;
import com.soulinfo.cases.AddBookCase;
import com.soulinfo.cases.AddVotesCase;
import com.soulinfo.cases.CreateActivitiesCase;
import com.soulinfo.cases.CreateBigPhotoCase;
import com.soulinfo.cases.CreateBooksCase;
import com.soulinfo.cases.CreateVoteCase;
import com.soulinfo.cases.LoginCase;
import com.soulinfo.cases.MessageCase;
import com.soulinfo.cases.MyPageCase;
import com.soulinfo.cases.SayCase;
import com.soulinfo.cases.SubmitBookCase;
import com.soulinfo.cases.SubmitOrder;
import com.soulinfo.cases.VoteCase;
import com.soulinfo.entity.YBEntity;
import com.soulinfo.util.Driver;

/**
 * 创建校园纪念册整体用例流程
 * 
 * @author SoulTest
 * 
 */
public class CreateBookLogic {

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
	// 实例化提交订单
	SubmitOrder order = new SubmitOrder();

	private final static Logger logger = LoggerFactory.getLogger(CreateBookLogic.class);

	// 定义邀请码
	String code = null;
	// 定义姓名
	String username = null;

	String classname = Driver.getPropertyString("CLASS_NAME");

	/**
	 * 1、班长登录 2、班长创建新书册 3、拿到新书册邀请码 4、创建新的投票 5、注销登录
	 * 
	 * @param driver
	 * @param list
	 * @param classname
	 * @throws Exception
	 */
	public void createBook(List<String[][]> list) throws Exception {

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
				yb.setMessagename(arr[j][5]);
				yb.setMessage(arr[j][6]);
				yb.setSayone(arr[j][7]);
				yb.setSaytwo(arr[j][8]);
				yb.setSaythree(arr[j][9]);
				yb.setTitle(arr[j][10]);
				yb.setOption1(arr[j][11]);
				yb.setOption2(arr[j][12]);
				yb.setOption3(arr[j][13]);
				System.out.println("username = " + yb.getName());
				System.out.println("classname = " + classname);
				if (yb.getName().equals(classname)) {

					// 班长登录方法
					try {
						log.testLogin(yb);
					} catch (Exception e) {
						logger.info(yb.getUsername() + "登录失败");
						logger.info(e.getLocalizedMessage());
					}

					// 班长创建新书册方法并拿到邀请码
					try {
						createBooks.testCreateBooks();
						createBooks.testCode();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "创建新书册失败");
						logger.info(e.getLocalizedMessage());
					}

					// 班长创建新投票方法
					try {
						createVote.testCreateVote(yb);
					} catch (Exception e) {
						logger.info(yb.getUsername() + "创建新书册失败");
						logger.info(e.getLocalizedMessage());
					}

					// 注销方法
					log.testLogout();
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
	public void addBook(List<String[][]> list) throws Exception {
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
					try {
						log.testLogin(yb);
					} catch (Exception e) {
						logger.info(yb.getUsername() + "登录失败");
						logger.info(e.getLocalizedMessage());
					}

					// 调用加入新书册方法

					try {
						addbook.testAddBook();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "加入新书册失败");
						logger.info(e.getLocalizedMessage());
					}

					// 调用注销方法
					log.testLogout();
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
	public void addMyBookText(List<String[][]> list) throws Exception {
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
				yb.setMessagename(arr[j][5]);
				yb.setMessage(arr[j][6]);
				yb.setSayone(arr[j][7]);
				yb.setSaytwo(arr[j][8]);
				yb.setSaythree(arr[j][9]);
				yb.setTitle(arr[j][10]);
				yb.setOption1(arr[j][11]);
				yb.setOption2(arr[j][12]);
				yb.setOption3(arr[j][13]);

				// 调用登录方法
				try {
					log.testLogin(yb);
				} catch (Exception e) {
					logger.info(yb.getUsername() + "登录失败");
					logger.info(e.getLocalizedMessage());
				}

				// 如果为班长，选择创建新书，如果为班级成员，选择参与新书
				if (yb.getName().equals(classname)) {
					// 调用打开创建新书册方法
					try {
						addbook.testOpenCreateBook();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "打开创建新书册失败");
						logger.info(e.getLocalizedMessage());
					}
				} else {
					// 调用打开参与新书册方法

					try {
						addbook.testOpenBook();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "打开参与新书册失败");
						logger.info(e.getLocalizedMessage());
					}
				}
				// 给小伙伴留言方法

				try {
					messageCase.testCreateMessage(yb);
				} catch (Exception e) {
					logger.info(yb.getUsername() + "给" + yb.getMessagename()
							+ "留言失败");
					logger.info(e.getLocalizedMessage());
				}

				// 调用此刻想说方法

				try {
					sayCase.testCreateSay(yb);
				} catch (Exception e) {
					logger.info(yb.getUsername() + "发表此刻想说失败");
					logger.info(e.getLocalizedMessage());
				}

				// 参与投票方法

				try {
					voteCase.testCreateVote();
				} catch (Exception e) {
					logger.info(yb.getUsername() + "发表投票失败");
					logger.info(e.getLocalizedMessage());
				}

				// 上传照片方法
				// photo.testCreatePhoto(driver);

				// 调用注销方法
				log.testLogout();
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
	public void createMyBook(List<String[][]> list) throws Exception {
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
				try {
					log.testLogin(yb);
				} catch (Exception e) {
					logger.info(yb.getUsername() + "登录失败");
					logger.info(e.getLocalizedMessage());
				}

				// 如果为班长，选择创建新书，如果为班级成员，选择参与新书
				if (yb.getName().equals(classname)) {
					// 调用打开创建新书册方法
				
					try {
						addbook.testOpenCreateBook();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "打开创建新书册失败");
						logger.info(e.getLocalizedMessage());
					}
				} else {
					// 调用打开参与新书册方法					
					try {
						addbook.testOpenBook();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "打开参与新书册失败");
						logger.info(e.getLocalizedMessage());
					}
				}

				// 调用制作个人书页方法
				try {
					myPage.testCreateMyPage(yb, classname);
				} catch (Exception e) {
					logger.info(yb.getUsername() + "提交个人书页失败");					
				}
				// 调用注销方法
				log.testLogout();
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
	public void submitBook(List<String[][]> list) throws Exception {
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

					// 班长登录方法
					try {
						log.testLogin(yb);
					} catch (Exception e) {
						logger.info(yb.getUsername() + "登录失败");
						logger.info(e.getLocalizedMessage());
					}

					// 调用打开创建新书册方法
					try {
						addbook.testOpenCreateBook();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "打开创建新书册失败");
						logger.info(e.getLocalizedMessage());
					}

					// 班长添加活动页模板方法
					try {
						addActivities.testAddActivities();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "添加活动页模板失败");
						logger.info(e.getLocalizedMessage());
					}

					// 班长创建活动页对象方法
					try {
						createActivities.testCreateaAtivities();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "创建活动页失败");
						logger.info(e.getLocalizedMessage());
					}

					// 班长增加投票页方法
					try {
						addVotes.testAddVotes();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "增加投票页失败");
						logger.info(e.getLocalizedMessage());
					}

					// 制作提交投票页方法
					try {
						addVotes.testCreateVote();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "提交投票页失败");
						logger.info(e.getLocalizedMessage());
					}

					// 制作全景照片方法
					try {
						bigPhoto.testCreateBigPhoto();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "制作全景照片失败");
						logger.info(e.getLocalizedMessage());
					}

					// 班长提交其他未提交页方法
					try {
						submitBook.testSubimitOthers();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "提交其他未提交页失败");
						logger.info(e.getLocalizedMessage());
					}

					// 提交书册方法
					try {
						submitBook.testSubmitBook();
					} catch (Exception e) {
						logger.info(yb.getUsername() + "提交书册失败");
						logger.info(e.getLocalizedMessage());
					}

					// 提交订单
//					try {
//						order.testSubmitOrder();
//					} catch (Exception e) {
//						logger.info(yb.getUsername() + "提交订单失败");
//						logger.info(e.getLocalizedMessage());
//					}

					// 注销方法
					log.testLogout();
					break;
				}
			}
		}
		System.out.println("书册提交完成时间：" + new Date(System.currentTimeMillis()));
	}
}
