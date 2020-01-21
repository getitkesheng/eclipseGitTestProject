package org.ks.entity;

public class loginInformation {
	private String stu_id;
	private String stu_name;
	private int stu_age;
	private String pwd;
	
	
	public loginInformation() {
		
	}

	public loginInformation(String stu_name, String pwd) {
		this.stu_name = stu_name;
		this.pwd = pwd;
	}

	public String getStu_id() {
		return stu_id;
	}


	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}


	public String getStu_name() {
		return stu_name;
	}


	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}


	public int getStu_age() {
		return stu_age;
	}


	public void setStu_age(int stu_age) {
		this.stu_age = stu_age;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	

	
	
	
	
	
	
	
}
