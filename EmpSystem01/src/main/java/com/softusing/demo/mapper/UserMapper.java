package com.softusing.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.softusing.demo.bean.IUser;

@Mapper
public interface UserMapper {
	public IUser queryUser(String accountId);
}
