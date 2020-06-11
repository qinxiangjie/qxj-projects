package com.softusing.demo.bean;

import java.sql.Date;

public class EmpInfo {
	private String empCd;
	private String name;
	private Date birthday;
	private Country country;
	private Sex sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getEmpCd() {
		return empCd;
	}

	public void setEmpCd(String empCd) {
		this.empCd = empCd;
	}
}
