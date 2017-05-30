package com.myBean;

public class AdbooksData {
	private String name;
	private String sex;
	private String address;
	private String phone;
	private String email;
	
	//时秀兵 男 15967153342 2994143266@qq.com 钱江湾39幢601 
	
	public AdbooksData(String name, String sex,String phone,String email,String address) {
		super();
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
