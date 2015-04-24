package com.soul.yb.test;

import java.io.File;
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

		// ʵ������ȡEXCEL����
		File file = new File(Common.YB_MESSAGE_PATH);

		// ʵ������¼���󼯺�
		List<String[][]> list = new ReadExcel().readExcel(file);

		// ʵ����driver����
		WebDriver driver = new FirefoxDriver();

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
		PhotoCase photo = new PhotoCase();
		// ʵ��������������ҳ����
		MyPageCase myPage = new MyPageCase();
		//ʵʹ���೤����ͶƱҳ����
		AddVotesCase addVotes = new AddVotesCase();
		//ʵʹ��ȫ����Ƭ����
		CreateBigPhotoCase bigPhoto = new CreateBigPhotoCase();
		//ʵ�����ύ���
		SubmitBookCase submitBook = new SubmitBookCase();
		
		// ������ͨ�༶��Ա����
		String username = null;
		// ����೤����
		String classname = "soulTest450";
		// ����������
		String code = null;
		// ���崴������
		String bookname = "��case5��";

		// ��ʽ�ȴ�
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// ���ô����������
		browser.beforeMethod(driver);	

		// �жϰ೤��¼
		for (int i = 0; i < list.size(); i++) {
			YBEntity yb = new YBEntity();
			String arr[][] = list.get(i);			
			//������ά����
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
					System.out.println(yb.getName().equals(classname));
					// �೤��¼����
					log.testLogin(driver, yb);
					// �೤��������᷽��
					createBooks.testCreateBooks(driver);
					// �õ������뷽��
					code = createBooks.testCode(driver);
					System.out.println("main() code = " + code);

					// �೤������ͶƱ����
					createVote.testCreateVote(driver,yb);
					// �೤��ӻҳģ�巽��
					addActivities.testAddActivities(driver);
					//�೤�����ҳ���󷽷�
					createActivities.testCreateaAtivities(driver);

					// ע������
					log.testLogout(driver);
					break;
				}
				
				
				
			}
		}
		
	


		System.out.println("===========�˳�forѭ��=============");

			System.out.println("===========��ʼforѭ��=============");
			// ѭ��excel���ֵ
			
			for (int i = 0; i < list.size(); i++) {
				YBEntity yb = new YBEntity();
				String arr[][] = list.get(i);
				//������ά����
				for (int j = 1; j < arr.length; j++) {
					String[] arr1 = arr[j];		
					
					yb.setId(Integer.parseInt(arr[j][0]));
					yb.setUsername(arr[j][1]);
					yb.setPassword(arr[j][2]);
					yb.setCode(arr[j][3]);
					yb.setName(arr[j][4]);
					
					if (yb.getName().equals(classname)) {
						System.out.println("if (){}");

					} else {
						System.out.println(yb.getUsername());
						// ���õ�¼����
						log.testLogin(driver, yb);

						// ���ü�������᷽��

						addbook.testMyBook(driver, code, bookname);

						// ����ע������
						log.testLogout(driver);
					}
					
				}
			}
			
			
			
		
			// ѭ��excel���ֵ
			
			for (int i = 0; i < list.size(); i++) {
				YBEntity yb = new YBEntity();
				String arr[][] = list.get(i);
				//������ά����
				for (int j = 1; j < arr.length; j++) {
					String[] arr1 = arr[j];		
					
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
					} else {
						// ���ô򿪲�������᷽��
						addbook.testOpenBook(driver);
					}

					// ��С������Է���
					System.out.println("main() username = " + username);
//					System.out.println("list ===== " + list.size());
					messageCase.testCreateMessage(driver, username, list,classname);

					// ���ô˿���˵����
					sayCase.testCreateSay(driver, yb);

					// ����ͶƱ����
					voteCase.testCreateVote(driver);

					// �ϴ���Ƭ����
					// photo.testCreatePhoto(driver);

					// ����ע������
					log.testLogout(driver);
					
				}
			}
			
					
		
			System.out.println("���ǵ�����ѭ�� = ");
	
		
			for (int i = 0; i < list.size(); i++) {
				YBEntity yb = new YBEntity();
				String arr[][] = list.get(i);
				//������ά����
				for (int j = 1; j < arr.length; j++) {
					String[] arr1 = arr[j];		
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
					myPage.testCreateMyPage(driver,yb,classname);

					// ����ע������
					log.testLogout(driver);
					
				}
				}
			
			
			
			
			
			

		//�೤��¼�ύ���
			
			
			for (int i = 0; i < list.size(); i++) {
				YBEntity yb = new YBEntity();
				String arr[][] = list.get(i);
				//������ά����
				for (int j = 1; j < arr.length; j++) {
					String[] arr1 = arr[j];		
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
									
						// �೤����ͶƱҳ����
						addVotes.testAddVotes(driver);
						// �����ύͶƱҳ����
						addVotes.testCreateVote(driver);
						
						//����ȫ����Ƭ����
						bigPhoto.testCreateBigPhoto(driver);
						
						//�೤�ύ����δ�ύҳ����
						submitBook.testSubimitOthers(driver);
						//�ύ��᷽��
						submitBook.testSubmitBook(driver);

						// ע������
						log.testLogout(driver);
						break;
					}
				}
			}		

		// �����˳����������
		browser.afterMethod(driver);
	}
}
