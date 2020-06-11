package com.softusing.demo.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.softusing.demo.bean.Country;
import com.softusing.demo.bean.EmpInfo;
import com.softusing.demo.bean.Sex;
import com.softusing.demo.form.EmpForm;
import com.softusing.demo.service.CountryService;
import com.softusing.demo.service.EmpService;
import com.softusing.demo.service.SexService;

@Controller
public class AddController {
	@Autowired
	private CountryService countryService;
	@Autowired
	private SexService sexService;
	@Autowired
	private EmpService empService;

	@RequestMapping(value = "/toaddEmp")
	public ModelAndView toAddEmp(@ModelAttribute("form") EmpForm empForm, ModelAndView mv) {
		List<Country> countryList = countryService.listCountry();
		mv.addObject("countryList", countryList);
		List<Sex> sexList = sexService.listSex();
		mv.addObject("sexList", sexList);
		mv.setViewName("add");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addEmp(@ModelAttribute("form") @Valid EmpForm empForm, BindingResult result, ModelAndView mv) {
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			mv.addObject("errorList", errorList);
			List<Country> countryList = countryService.listCountry();
			mv.addObject("countryList", countryList);
			List<Sex> sexList = sexService.listSex();
			mv.addObject("sexList", sexList);
			mv.setViewName("add");
			return mv;
		}
		EmpInfo empinfo = empService.selectEmpCd(empForm.getEmpCd());
		if (empinfo != null) {
			String message = "Éç†T·¬ºÅ¤¬¼È¤Ë´æÔÚ¤¹¤ë";
			mv.addObject("message", message);
			List<Country> countryList = countryService.listCountry();
			mv.addObject("countryList", countryList);
			List<Sex> sexList = sexService.listSex();
			mv.addObject("sexList", sexList);
			mv.setViewName("add");
		} else {
			empService.addEmp(empForm);
			mv.setViewName("redirect:/empList");
		}
		return mv;
	}
}
