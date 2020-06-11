package com.softusing.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softusing.demo.bean.EmpInfo;
import com.softusing.demo.service.EmpServiceImpl;

@Controller
@ComponentScan({ "service" })
public class ListController {
	@Autowired
	private EmpServiceImpl empService;

	@RequestMapping("/empList")
	public ModelAndView listEmp(ModelAndView mv) {
		List<EmpInfo> empList = empService.listEmp();
		mv.addObject("empList", empList);
		mv.setViewName("emplist");
		return mv;
	}

	@RequestMapping("/select")
	public ModelAndView selectEmp(@RequestParam(value = "keyWord") String keyWord, ModelAndView mv) {
		List<EmpInfo> empList = empService.selectEmp(keyWord);
		mv.addObject("empList", empList);
		mv.setViewName("emplist");
		return mv;
	}

	@RequestMapping("/delete")
	public ModelAndView deleteEmp(@RequestParam(value = "empCd") String empCd, ModelAndView mv) {
		empService.deleteEmp(empCd);
		mv.setViewName("redirect:/empList");
		return mv;
	}

	@RequestMapping("/showDetails")
	public ModelAndView showDetails(@RequestParam(value = "empCd") String empCd, ModelAndView mv) {
		EmpInfo empinfo = empService.selectEmpCd(empCd);
		mv.addObject("empinfo", empinfo);
		mv.setViewName("showDetails");
		return mv;
	}
}
