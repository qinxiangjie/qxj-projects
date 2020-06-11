package com.softusing.demo.mapperTest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.softusing.demo.SpringBootValidateLoginApplicationTests;
import com.softusing.demo.bean.IUser;
import com.softusing.demo.mapper.UserMapper;

public class UserMapperTest extends SpringBootValidateLoginApplicationTests {

		@Autowired
		private UserMapper userMapper;

		@Test
		public void testQueryUser1() {
			IUser user = userMapper.queryUser("111@softuseing.com");
			Assert.assertEquals("111@softuseing.com", user.getAccountId());
			Assert.assertEquals("000001", user.getPassword());
		}

		@Test
		public void testQueryUser2() {
			IUser user = userMapper.queryUser("1@softuseing.com");
			Assert.assertEquals(null, user);
		}
	}

