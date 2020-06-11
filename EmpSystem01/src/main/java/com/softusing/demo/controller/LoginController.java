package com.softusing.demo.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.softusing.demo.form.UserForm;
import com.softusing.demo.service.UserService;

@Controller
public class LoginController {
	@Resource
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("form") UserForm form, Model model) {
		return ("/login");
	}

	@PostMapping("/auth")
	public ModelAndView auth(@ModelAttribute("form") @Valid UserForm userForm, BindingResult result, ModelAndView mv) {
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			mv.addObject("errorList", errorList);
			mv.setViewName("login");
			return mv;
		}
		List<String> errorlist = userService.getResult(userForm);
		if (!(errorlist.size() == 0)) {
			mv.addObject("message", errorlist.get(0));
			mv.setViewName("login");
			return mv;
		} else {
			mv.setViewName("redirect:/empList");
			return mv;
		}
	}
}