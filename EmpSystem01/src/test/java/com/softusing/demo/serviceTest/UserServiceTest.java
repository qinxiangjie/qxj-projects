package com.softusing.demo.serviceTest;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.softusing.demo.SpringBootValidateLoginApplicationTests;
import com.softusing.demo.form.UserForm;
import com.softusing.demo.service.UserService;

public class UserServiceTest extends SpringBootValidateLoginApplicationTests {

	@Resource
	private UserService userService;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private Locale locale;

	@Test
	public void testGetResult1() throws Exception {
		UserForm loginForm = new UserForm();
		loginForm.setAccountId("111@softuseing.com");
		loginForm.setPassword("000001");
		List<String> errors = null;
		errors = userService.getResult(loginForm);
		Assert.assertEquals(0, errors.size());
	}

	@Test
	public void testGetResult2() throws Exception {
		UserForm loginForm = new UserForm();
		loginForm.setAccountId("111@softuseing");
		loginForm.setPassword("000001");
		List<String> errors = null;
		errors = userService.getResult(loginForm);
		Assert.assertEquals(messageSource.getMessage("login.message.accountId.error", null, locale), errors.get(0));
	}

	@Test
	public void testGetResult3() throws Exception {
		UserForm loginForm = new UserForm();
		loginForm.setAccountId("111@softuseing.com");
		loginForm.setPassword("000002");
		List<String> errors = null;
		errors = userService.getResult(loginForm);
		Assert.assertEquals(messageSource.getMessage("login.message.password.error", null, locale), errors.get(0));
	}
}