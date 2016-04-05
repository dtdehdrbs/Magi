package magi.point.controller;

public class PointBean {
	private int num;
	private String brand;
	private String phone;
	private int pluspoint;
	private int minuspoint;
	private String indate;
	
	///////////////////페이징
	private int start;
	private int gap;
	
	
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getGap() {
		return gap;
	}
	public void setGap(int gap) {
		this.gap = gap;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPluspoint() {
		return pluspoint;
	}
	public void setPluspoint(int pluspoint) {
		this.pluspoint = pluspoint;
	}
	public int getMinuspoint() {
		return minuspoint;
	}
	public void setMinuspoint(int minuspoint) {
		this.minuspoint = minuspoint;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	
}
