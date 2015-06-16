package com.soulinfo.entity;

/**
 * Excel表格对应实体类（要和Excel表格横排顺序一至）
 * 
 * @author SoulTest
 * 
 */
public class YBEntity {

	// 1编号
	private int id;
	// 2用户名
	private String username;
	// 3密码
	private String password;
	// 4验证码
	private String code;
	// 5姓名
	private String name;
	
	//6留言姓名
	private String messagename;

	// 7留言
	private String message;

	// 8想说问题一
	private String sayone;
	// 9想说问题二
	private String saytwo;
	// 10想说问题三
	private String saythree;

	// 11投票标题
	private String title;
	// 12选项一
	private String option1;
	// 13选项二
	private String option2;
	// 14选项三
	private String option3;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSayone() {
		return sayone;
	}

	public void setSayone(String sayone) {
		this.sayone = sayone;
	}

	public String getSaytwo() {
		return saytwo;
	}

	public void setSaytwo(String saytwo) {
		this.saytwo = saytwo;
	}

	public String getSaythree() {
		return saythree;
	}

	public void setSaythree(String saythree) {
		this.saythree = saythree;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessagename() {
		return messagename;
	}

	public void setMessagename(String messagename) {
		this.messagename = messagename;
	}

}