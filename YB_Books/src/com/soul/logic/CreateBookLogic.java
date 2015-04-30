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

	// ʵ�����������������
	OperationBrowser browser = new OperationBrowser();
	// ʵ������¼����
	LoginCase log = new LoginCase();
	// ʵ����������������
	CreateBooksCase createBooks = new CreateBooksCase();
	// ʵ����������ͶƱ����
	CreateVoteCase createVote = new CreateVoteCase();
	// ʵ�������ӻģ��ҳ����
	AddActivitiesCase addActivities = new AddActivitiesCase();
	// ʵ���������ҳ����
	CreateActivitiesCase createActivities = new CreateActivitiesCase();
	// ʵ��������������
	AddBookCase addbook = new AddBookCase();
	// ʵ�������Զ���
	MessageCase messageCase = new MessageCase();
	// ʵ������˵����a
	SayCase sayCase = new SayCase();
	// ʵ�������� ͶƱ����
	VoteCase voteCase = new VoteCase();
	// ʵ�����ϴ���Ƭ����
	// ʵ��������������ҳ����
	MyPageCase myPage = new MyPageCase();
	// ʵʹ���೤����ͶƱҳ����
	AddVotesCase addVotes = new AddVotesCase();
	// ʵʹ��ȫ����Ƭ����
	CreateBigPhotoCase bigPhoto = new CreateBigPhotoCase();
	// ʵ�����ύ���
	SubmitBookCase submitBook = new SubmitBookCase();

	String code = null;
	String username = null;

	/**
	 * 1���೤��¼ 2���೤��������� 3���õ������������ 4�������µ�ͶƱ 5��ע����¼
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
			// ������ά����
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

					// �೤��¼����
					log.testLogin(driver, yb);
					// �೤��������᷽��
					createBooks.testCreateBooks(driver);
					// �õ������뷽��
					code = createBooks.testCode(driver);
					System.out.println("code = " + code);

					// �೤������ͶƱ����
					createVote.testCreateVote(driver, yb);

					// ע������
					log.testLogout(driver);
					break;
				}
			}
		}
		System.out.println("�����������ʱ�䣺" + new Date(System.currentTimeMillis()));
	}

	/**
	 * 1����ͨѧ����¼ 2����ͨѧ����������� 3��ע����¼
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
			// ������ά����
			for (int j = 1; j < arr.length; j++) {

				yb.setId(Integer.parseInt(arr[j][0]));
				yb.setUsername(arr[j][1]);
				yb.setPassword(arr[j][2]);
				yb.setCode(arr[j][3]);
				yb.setName(arr[j][4]);

				if (yb.getName().equals(classname)) {
				} else {
					System.out.println(yb.getUsername());
					// ���õ�¼����
					log.testLogin(driver, yb);

					// ���ü�������᷽��
					try{
						addbook.testMyBook(driver, code);	
					}catch (Exception e){
						e.printStackTrace();
						log.testLogin(driver, yb);
					}
					

					// ����ע������
					log.testLogout(driver);
				}
			}
		}
		System.out.println("����������ʱ�䣺" + new Date(System.currentTimeMillis()));
	}

	/**
	 * 1����¼ 2���೤�򿪴�������Ტ���� 3����ͨѧ���򿪼�������ᣬ������˵��ͶƱ 4��ע����¼
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
			// ������ά����
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

				// ���õ�¼����
				log.testLogin(driver, yb);

				username = log.testLoginName(driver);

				// ���Ϊ�೤��ѡ�񴴽����飬���Ϊ�༶��Ա��ѡ���������
				if (yb.getName().equals(classname)) {
					// ���ô򿪴�������᷽��
					addbook.testOpenCreateBook(driver);
					// ��С������Է���
					messageCase.testCreateMessage(driver, username, list,
							classname);
				} else {
					// ���ô򿪲�������᷽��
					addbook.testOpenBook(driver);
				}

				// ���ô˿���˵����
				try {
					sayCase.testCreateSay(driver, yb);
				} catch (Exception e) {
					e.printStackTrace();
				}

				// ����ͶƱ����
				try {
					voteCase.testCreateVote(driver);
				} catch (Exception e) {
					e.printStackTrace();
				}

				// �ϴ���Ƭ����
				// photo.testCreatePhoto(driver);

				// ����ע������
				log.testLogout(driver);

			}
		}
		System.out.println("�����������ʱ�䣺" + new Date(System.currentTimeMillis()));
	}

	/**
	 * 1����¼ 2���೤�򿪴������� 3����ͨѧ���򿪼������� 4������������ҳ���ύ 5��ע����¼
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
			// ������ά����
			for (int j = 1; j < arr.length; j++) {

				yb.setId(Integer.parseInt(arr[j][0]));
				yb.setUsername(arr[j][1]);
				yb.setPassword(arr[j][2]);
				yb.setCode(arr[j][3]);
				yb.setName(arr[j][4]);

				// ���õ�¼����
				log.testLogin(driver, yb);

				// ���Ϊ�೤��ѡ�񴴽����飬���Ϊ�༶��Ա��ѡ���������
				if (yb.getName().equals(classname)) {
					// ���ô򿪴�������᷽��
					addbook.testOpenCreateBook(driver);
				} else {
					// ���ô򿪲�������᷽��
					addbook.testOpenBook(driver);
				}

				// ��������������ҳ����

				try {
					myPage.testCreateMyPage(driver, yb, classname);
				} catch (Exception e) {
					e.printStackTrace();
				}

				// ����ע������
				log.testLogout(driver);

			}
		}
		System.out
				.println("������ҳ�������ʱ�䣺" + new Date(System.currentTimeMillis()));
	}

	/**
	 * 1���೤��¼ 2���򿪴���������� 3����ӻҳ 4�������ҳ���ύ5������ͶƱҳ 6������ͶƱҳ 7������ȫ����Ƭ 8���ύδ�ύ��ҳ
	 * 9���ύ��� 10��ע����¼
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
			// ������ά����
			for (int j = 1; j < arr.length; j++) {

				yb.setId(Integer.parseInt(arr[j][0]));
				yb.setUsername(arr[j][1]);
				yb.setPassword(arr[j][2]);
				yb.setCode(arr[j][3]);
				yb.setName(arr[j][4]);

				if (yb.getName().equals(classname)) {
					System.out.println(yb.getName().equals(classname));
					// �೤��¼����
					log.testLogin(driver, yb);

					// ���ô򿪴�������᷽��
					addbook.testOpenCreateBook(driver);

					// �೤��ӻҳģ�巽��
					try {
						addActivities.testAddActivities(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// �೤�����ҳ���󷽷�
					try {
						createActivities.testCreateaAtivities(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// �೤����ͶƱҳ����
					try {
						addVotes.testAddVotes(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// �����ύͶƱҳ����
					try {
						addVotes.testCreateVote(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// ����ȫ����Ƭ����
					try {
						bigPhoto.testCreateBigPhoto(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// �೤�ύ����δ�ύҳ����
					try {
						submitBook.testSubimitOthers(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// �ύ��᷽��
					try {
						submitBook.testSubmitBook(driver);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// ע������
					log.testLogout(driver);
					break;
				}
			}
		}
		System.out.println("����ύ���ʱ�䣺" + new Date(System.currentTimeMillis()));
	}
}
