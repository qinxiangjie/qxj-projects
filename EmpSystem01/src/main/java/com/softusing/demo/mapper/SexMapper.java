package com.softusing.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.softusing.demo.bean.Sex;

@Mapper
public interface SexMapper {
	public List<Sex> listSex();
}
