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

		// ʵ������ȡEXCEL����
		String excel2003_2007 = Common.YB_INFO_XLS_PATH;

		// ʵ������¼���󼯺�
		List<YBEntity> list = new ReadExcel().readExcel(excel2003_2007);

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
		MessageCase message = new MessageCase();
		// ʵ������˵����a
		SayCase say = new SayCase();
		// ʵ�������� ͶƱ����
		VoteCase vote = new VoteCase();
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
		String classname = null;
		// ����������
		String code = null;
		// ���崴������
		String bookname = "��case5��";

		// ��ʽ�ȴ�
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// ���ô����������
		browser.beforeMethod(driver);

		// �õ��೤����
		for (YBEntity yb : list) {
			log.testLogin(driver, yb);
			classname = log.testLoginName(driver);
			// ע������
			log.testLogout(driver);
			break;
		}

		// �жϰ೤��¼
		System.out.println(list.get(0).getName());
		for (YBEntity yb : list) {
			if (list.get(0).getName().equals(classname)) {
				System.out.println(list.get(0).getName().equals(classname));
				// �೤��¼����
				log.testLogin(driver, yb);
				// �೤��������᷽��
				createBooks.testCreateBooks(driver);
				// �õ������뷽��
				code = createBooks.testCode(driver);
				System.out.println("main() code = " + code);

				// �೤������ͶƱ����
				createVote.testCreateVote(driver, yb);
				// �೤��ӻҳģ�巽��
				addActivities.testAddActivities(driver);
				//�೤�����ҳ���󷽷�
				createActivities.testCreateaAtivities(driver);

				// ע������
				log.testLogout(driver);
				break;
			}
		}

		System.out.println("===========�˳�forѭ��=============");

			System.out.println("===========��ʼforѭ��=============");
			// ѭ��excel���ֵ

			for (Iterator item = list.iterator(); item.hasNext();) {
				YBEntity yb = (YBEntity) item.next();
				System.out.print(yb.getName());
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

		
			// ѭ��excel���ֵ
			for (YBEntity yb : list) {
				System.out.println(yb.getUsername());
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
				message.testCreateMessage(driver, username, list);

				// ���ô˿���˵����
				say.testCreateSay(driver, yb);

				// ����ͶƱ����
				vote.testCreateVote(driver);

				// �ϴ���Ƭ����
				// photo.testCreatePhoto(driver);

				// ����ע������
				log.testLogout(driver);

			}
			System.out.println("���ǵ�����ѭ�� = ");
	
		
		
		for (YBEntity yb : list) {

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

		//�೤��¼�ύ���
		for (YBEntity yb : list) {
			if (list.get(0).getName().equals(classname)) {
				System.out.println(list.get(0).getName().equals(classname));
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

		// �����˳����������
		browser.afterMethod(driver);
		// log.afterMethod();
	}
}
