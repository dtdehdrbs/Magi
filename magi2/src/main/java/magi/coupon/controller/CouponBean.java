package magi.coupon.controller;


public class CouponBean {
	
	private int c_num, c_seq;
	private String c_group, c_brand, c_name, c_price;
	private String c_img ;
	private String phone;
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private String searchValue;//검색을 위한 멤버

	public int getC_seq() {
		return c_seq;
	}

	public void setC_seq(int c_seq) {
		this.c_seq = c_seq;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public String getC_group() {
		return c_group;
	}

	public void setC_group(String c_group) {
		this.c_group = c_group;
	}

	public String getC_brand() {
		return c_brand;
	}

	public void setC_brand(String c_brand) {
		this.c_brand = c_brand;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_price() {
		return c_price;
	}

	public void setC_price(String c_price) {
		this.c_price = c_price;
	}

	public String getC_img() {
		return c_img;
	}

	public void setC_img(String c_img) {
		this.c_img = c_img;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
}
