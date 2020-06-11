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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softusing.demo.bean.Country;
import com.softusing.demo.bean.EmpInfo;
import com.softusing.demo.bean.Sex;
import com.softusing.demo.form.UpdateForm;
import com.softusing.demo.service.CountryService;
import com.softusing.demo.service.EmpService;
import com.softusing.demo.service.SexService;

@Controller
public class ChangeController {
	@Autowired
	private CountryService countryService;
	@Autowired
	private SexService sexService;
	@Autowired
	private EmpService empService;

	@RequestMapping(value = "/tochange")
	public ModelAndView tochange(@ModelAttribute("form") UpdateForm updateForm,
			@RequestParam(value = "empCd") String empCd, ModelAndView mv) {
		EmpInfo empinfo = empService.selectEmpCd(empCd);
		updateForm.setEmpCd(empinfo.getEmpCd());
		updateForm.setName(empinfo.getName());
		updateForm.setBirthday(empinfo.getBirthday());
		updateForm.setCountryCd(empinfo.getCountry().getCountryCd());
		updateForm.setSexCd(empinfo.getSex().getSexCd());
		List<Country> countryList = countryService.listCountry();
		mv.addObject("countryList", countryList);
		List<Sex> sexList = sexService.listSex();
		mv.addObject("sexList", sexList);
		mv.setViewName("change");
		return mv;
	}

	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public ModelAndView updateEmp(@ModelAttribute("form") @Valid UpdateForm updateForm, BindingResult result,
			@RequestParam(value = "empCd", required = false) String empCd, ModelAndView mv) {
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			mv.addObject("errorList", errorList);
			EmpInfo empinfo = empService.selectEmpCd(empCd);
			updateForm.setEmpCd(empinfo.getEmpCd());
			updateForm.setName(empinfo.getName());
			updateForm.setBirthday(empinfo.getBirthday());
			updateForm.setCountryCd(empinfo.getCountry().getCountryCd());
			updateForm.setSexCd(empinfo.getSex().getSexCd());
			List<Country> countryList = countryService.listCountry();
			mv.addObject("countryList", countryList);
			List<Sex> sexList = sexService.listSex();
			mv.addObject("sexList", sexList);
			mv.setViewName("change");
			return mv;
		} else {
			empService.updateEmp(updateForm);
			mv.setViewName("redirect:/empList");
		}
		return mv;
	}
}
