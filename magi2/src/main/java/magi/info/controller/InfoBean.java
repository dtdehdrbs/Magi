package magi.info.controller;

public class InfoBean {
	private String name, phone, grade, indate;
	private int password, totalpoint;
	public InfoBean(){
		super();
	}
	public InfoBean(String name, String phone, int password, int totalpoint, String grade, String indate){
		super();
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.totalpoint = totalpoint;
		this.grade = grade;
		this.indate = indate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getTotalpoint() {
		return totalpoint;
	}
	public void setTotalpoint(int totalpoint) {
		this.totalpoint = totalpoint;
	}
}
