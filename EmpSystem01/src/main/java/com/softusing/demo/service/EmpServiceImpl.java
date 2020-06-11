package com.softusing.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import com.softusing.demo.bean.EmpInfo;
import com.softusing.demo.form.EmpForm;
import com.softusing.demo.form.UpdateForm;
import com.softusing.demo.mapper.EmpMapper;

@MapperScan({"mapper"})
@Service

public class EmpServiceImpl implements EmpService {
	@Resource
	private EmpMapper empMapper;

	@Override
	public List<EmpInfo> listEmp(){
		return empMapper.listEmp();
	}
	
	@Override
	public List<EmpInfo> selectEmp(String keyWord){
		return empMapper.selectEmp("%" + keyWord + "%");
	}
	
	@Override
	public void addEmp(EmpForm empForm) {
		empMapper.addEmp(empForm);
		}
	
	@Override
	public EmpInfo selectEmpCd(String empCd) {
		return empMapper.selectEmpCd(empCd);
	}
	
	@Override
	public void updateEmp(UpdateForm updateForm) {
		empMapper.updateEmp(updateForm);
	}
	
	@Override
	public void deleteEmp(String empCd) {
		empMapper.deleteEmp(empCd);
	}
}
