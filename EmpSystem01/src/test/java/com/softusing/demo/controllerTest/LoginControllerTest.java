package com.softusing.demo.controllerTest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.ObjectError;

import com.softusing.demo.SpringBootValidateLoginApplicationTests;
import com.softusing.demo.controller.LoginController;

public class LoginControllerTest extends SpringBootValidateLoginApplicationTests {

	@Resource
	@InjectMocks
	private LoginController loginController;
	@Autowired
	private MessageSource messageSource;

	private Locale locale = Locale.getDefault();


	MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}

	@Test
	public void testLoginSuccess() throws Exception {

		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "111@softuseing.com")
				.param("password", "000001");

		ResultActions results = mockMvc.perform(getRequest);

		results.andDo(print());
		results.andExpect(view().name("/success"));
		results.andExpect(model().errorCount(0));
	}

	@Test
	public void testAccountIdIsEmpty() throws Exception {

		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "")
				.param("password", "000001");

		ResultActions results = mockMvc.perform(getRequest);

		results.andDo(print());
		results.andExpect(view().name("/login"));
		results.andExpect(model().errorCount(1));
		@SuppressWarnings("unchecked")
		List<ObjectError> errorList = (List<ObjectError>) results.andReturn().getModelAndView().getModel()
				.get("errorList");
		String message = errorList.get(0).getDefaultMessage();
		assertTrue(message.contains("login.error.accountId.notEmpty"));

	}

	@Test
	public void testAccountIdNotMail() throws Exception {

		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "111")
				.param("password", "000001");

		ResultActions results = mockMvc.perform(getRequest);

		results.andDo(print());
		results.andExpect(view().name("/login"));
		results.andExpect(model().errorCount(1));

		@SuppressWarnings("unchecked")
		List<ObjectError> errorList = (List<ObjectError>) results.andReturn().getModelAndView().getModel()
				.get("errorList");
		String message = errorList.get(0).getDefaultMessage();
		assertTrue(message.contains("login.error.accountId.isEmail"));
	}

	@Test
	public void testPasswordIsEmpty() throws Exception {

		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "111@softuseing.com")
				.param("password", "");

		ResultActions results = mockMvc.perform(getRequest);

		results.andDo(print());
		results.andExpect(view().name("/login"));
		results.andExpect(model().errorCount(2));

		@SuppressWarnings("unchecked")
		List<ObjectError> errorList = (List<ObjectError>) results.andReturn().getModelAndView().getModel()
				.get("errorList");

		List<String> messages = new ArrayList<>();
		for(ObjectError error:errorList) {
			String message = error.getDefaultMessage();
			messages.add(message);
		}
		assertTrue(messages.contains("{login.error.password.notEmpty}"));
	}

	@Test
	public void testPasswordLength() throws Exception {

		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "111@softuseing.com")
				.param("password", "0000000");

		ResultActions results = mockMvc.perform(getRequest);

		results.andDo(print());
		results.andExpect(view().name("/login"));
		results.andExpect(model().errorCount(1));

		@SuppressWarnings("unchecked")
		List<ObjectError> errorList = (List<ObjectError>) results.andReturn().getModelAndView().getModel()
				.get("errorList");
		String message = errorList.get(0).getDefaultMessage();
		assertTrue(message.contains("login.error.password.length"));
	}

	@Test
	public void testLoginAccountError() throws Exception {

		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "111@softuseing")
				.param("password", "000001");

		ResultActions results = mockMvc.perform(getRequest);

		results.andDo(print());
		results.andExpect(view().name("/login"));
		results.andExpect(model().errorCount(0));
		String message = (String) results.andReturn().getModelAndView().getModel().get("message");
		assertEquals(messageSource.getMessage("login.message.accountId.error", null, locale), message);
	}

	@Test
	public void testLoginPasswordError() throws Exception {

		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/auth")
				.param("accountId", "111@softuseing.com")
				.param("password", "000002");

		ResultActions results = mockMvc.perform(getRequest);

		results.andDo(print());
		results.andExpect(view().name("/login"));
		results.andExpect(model().errorCount(0));
		String message = (String) results.andReturn().getModelAndView().getModel().get("message");
		assertEquals(messageSource.getMessage("login.message.password.error", null, locale), message);
	}
}
