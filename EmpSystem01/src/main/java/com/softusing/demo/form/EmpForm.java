package com.softusing.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmpForm {
	@NotEmpty(message = "社員番号を入力してください")
	@Size(min = 6, max = 6, message = "社員番号欄に6桁数字を入力してください")
	@Pattern(regexp = "^[0-9]*$", message = "社員番号は数字入力してください")
	private String empCd;

	@NotEmpty(message = "名前を入力してください")
	@Pattern(regexp = "^[\\u4e00-\\u9fa5ァ-ンぁ-んa-zA-Z]*$", message = "姓名は漢字（ひらがな）、カタカナ、英語を入力してください")
	@Size(max = 20, message = "姓名は20文字以内を入力してください")
	private String name;

	@NotEmpty(message = "生年月日を入力してください")
	private String birthday;

	@NotEmpty(message = "国籍を選択してください")
	private String countryCd;

	@NotEmpty(message = "性別を選択してください")
	private String sexCd;
	public String getEmpCd() {
		return empCd;
	}

	public void setEmpCd(String empCd) {
		this.empCd = empCd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCountryCd() {
		return countryCd;
	}

	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}

	public String getSexCd() {
		return sexCd;
	}

	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
}
