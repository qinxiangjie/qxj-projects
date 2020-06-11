package com.softusing.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.softusing.demo.bean.EmpInfo;
import com.softusing.demo.form.EmpForm;
import com.softusing.demo.form.UpdateForm;

@Mapper
public interface EmpMapper {
	public List<EmpInfo> listEmp();
	public List<EmpInfo> selectEmp(String keyWord);
	public void addEmp(EmpForm empForm);
	public EmpInfo selectEmpCd(String empCd);
	public void updateEmp(UpdateForm updateForm);
	public void deleteEmp(String empCd);
}
