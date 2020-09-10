package com.zc.week12.util;

import java.io.Serializable;

public class AddressObject implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String tel;
	private String qq;
	
	public AddressObject(String name,String tel,String qq) {
		this.name=name;
		this.tel=tel;
		this.qq=qq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}

}
