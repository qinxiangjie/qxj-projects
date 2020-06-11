package com.softusing.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.softusing.demo.bean.IUser;
import com.softusing.demo.form.UserForm;
import com.softusing.demo.mapper.UserMapper;

@Service("userService")
public class UserService {
	@Resource
	private UserMapper userMapper;
	@Autowired
	private MessageSource messageSource;
	private Locale locale = Locale.getDefault();

	public List<String> getResult(UserForm userForm) {
		IUser user = userMapper.queryUser(userForm.getAccountId());
		List<String> errorlist = new ArrayList<String>();
		if (user == null) {
			errorlist.add(messageSource.getMessage("login.message.accountId.error", null, locale));
		} else if (!user.getPassword().equals(userForm.getPassword())) {
			errorlist.add(messageSource.getMessage("login.message.password.error", null, locale));
		}
		return errorlist;
	}
}
