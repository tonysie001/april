package com.soul.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.soul.entity.YBEntity;

public class MessageCase {

	// 给小伙伴留言
	@Test
	public void testCreateMessage(WebDriver driver, String username,
			List<String[][]> list,String classname) throws Exception {

		System.out.println("======进入testCreateMessage()方法=======");

		System.out.println("取得当前用户名字：username = " + username);

		int id = 0;

		for (int i = 0; i < list.size(); i++) {
			YBEntity yb = new YBEntity();
			String arr[][] = list.get(i);
			// 遍历二维数组
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

				if (username.equals(yb.getName())) {
					id = yb.getId();
					id++;
					System.out.println("什么都不需要做");
				} else if (yb.getId() == id) {

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

					System.out.println("我要留言");
				}else{
					driver.findElement(By.id("groupBtn")).click();
					Thread.sleep(3000);
					driver.findElement(By.linkText(classname)).click();

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

					System.out.println("我要留言");
					
				}
				driver.findElement(By.id("groupBtn")).click();
				Thread.sleep(3000);
				System.out.println("username = " + username);
				driver.findElement(By.linkText(username)).click();
			}
		}
	}
}
