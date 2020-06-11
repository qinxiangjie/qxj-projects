package com.softusing.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softusing.demo.bean.Sex;
import com.softusing.demo.mapper.SexMapper;

@Service("sexService")
public class SexService {

	@Resource
	private SexMapper sexMapper;
	
	public List<Sex> listSex(){
		return sexMapper.listSex();
	}
}
