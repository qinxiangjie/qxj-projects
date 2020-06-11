package com.softusing.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.softusing.demo.bean.Country;

@Mapper
public interface CountryMapper {
	public List<Country> listCountry();
}
