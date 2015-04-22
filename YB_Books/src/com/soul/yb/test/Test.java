package com.soul.yb.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import com.soul.cases.VoteCase;

public class Test {
	
	public static void main(String args[]){
//		String url = "D:\\Workspaces\\TestNG+Selenium2";
//		TestNG testNg = new TestNG();
//		List<String> suites = new ArrayList<String>();
//		suites.add(url + File.separator + "src/testng.xml");
//		testNg.setTestSuites(suites);
//		testNg.run();
		
		int  random = 0 ; 
		VoteCase vote = new VoteCase();
		for(int i =1 ;i<10;i++){
		random = vote.testRandom();
		System.out.println(random);
		}
	}

}
