package com.soul.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.soul.entity.YBEntity;

public class MessageCase {

	// ��С�������
	@Test
	public void testCreateMessage(WebDriver driver, String username,
			List<String[][]> list,String classname) throws Exception {

		System.out.println("======����testCreateMessage()����=======");

		System.out.println("ȡ�õ�ǰ�û����֣�username = " + username);

		

		for (int i = 0; i < list.size(); i++) {
			YBEntity yb = new YBEntity();
			String arr[][] = list.get(i);
			// ������ά����
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
				
//				int id = yb.getId();
//				int mList = arr.length-1;
//				System.out.println("mList=" +mList + "getId() = " +yb.getId());
//				
//				if(username.equals(yb.getName())){
//					System.out.println("�����Զ���Ϊ�Լ�ʱʲô��������");
//				}else{
//					System.out.println("��ִ�д˲���");
//					for(int m = id +1 ; m < id+2 ; m++){
//						System.out.println("��ǰ���Զ���id = " + yb.getId());
//						System.out.println("��ǰ���Զ���name  = " + yb.getUsername());
//						
//						if( m > mList){
//							System.out.println("�����Զ��󳬹�50��ʱִ�д������");
//							id = m - mList;
//							System.out.println(" m - mList = " + id);
//							driver.findElement(By.id("groupBtn")).click();
//							Thread.sleep(3000);
//							driver.findElement(By.linkText(yb.getName())).click();
//
//							Thread.sleep(2000);
//							driver.findElement(By.cssSelector("input.onbtnCss03"))
//									.click();
//							Thread.sleep(2000);
//							driver.findElement(By.id("comment")).click();
//							Thread.sleep(2000);
//							driver.findElement(By.id("comment")).clear();
//							driver.findElement(By.id("comment")).sendKeys(
//									yb.getMessage());
//							Thread.sleep(2000);
//							driver.findElement(By.id("addCommentBut")).click();
//							System.out.println("��" + yb.getUsername() + "���Գɹ�");
//							
//						}else{
//							System.out.println("���������ݲ�����50��ʱִ�д������");
//							driver.findElement(By.id("groupBtn")).click();
//							Thread.sleep(3000);
//							driver.findElement(By.linkText(yb.getName())).click();
//
//							Thread.sleep(2000);
//							driver.findElement(By.cssSelector("input.onbtnCss03"))
//									.click();
//							Thread.sleep(2000);
//							driver.findElement(By.id("comment")).click();
//							Thread.sleep(2000);
//							driver.findElement(By.id("comment")).clear();
//							driver.findElement(By.id("comment")).sendKeys(
//									yb.getMessage());
//							Thread.sleep(2000);
//							driver.findElement(By.id("addCommentBut")).click();
//
//							System.out.println("��" + yb.getUsername() + "���Գɹ�");
//						}
//					
//					
//					
//				}	
//					
//				}
//				
				
				int id = yb.getId();
				
	
				if (username.equals(yb.getName())) {
					id++;
					System.out.println("ʲô������Ҫ��");
				} else{
					if (yb.getId() == id) {

						System.out.println(username != yb.getName());
						System.out.println("if  ()  username = " + username);
						System.out.println(" login.getname= " + yb.getName());
						driver.findElement(By.id("groupBtn")).click();
						Thread.sleep(3000);
						driver.findElement(By.linkText(yb.getName())).click();

						Thread.sleep(2000);
						driver.findElement(By.cssSelector("input.onbtnCss03"))
								.click();
						Thread.sleep(2000);
						driver.findElement(By.id("comment")).click();
						Thread.sleep(2000);
						driver.findElement(By.id("comment")).clear();
						driver.findElement(By.id("comment")).sendKeys(
								yb.getMessage());
						Thread.sleep(2000);
						driver.findElement(By.id("addCommentBut")).click();

						System.out.println("��Ҫ����");
					}						
				} 
				driver.findElement(By.id("groupBtn")).click();
				Thread.sleep(3000);
				System.out.println("username = " + username);
				driver.findElement(By.linkText(username)).click();
			}
		}
	}
}
