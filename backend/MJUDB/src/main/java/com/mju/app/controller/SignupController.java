package com.mju.app.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mju.app.domain.Employee;
import com.mju.app.service.EmployeeService;

@Controller
@RequestMapping("/signup")
public class SignupController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public @ResponseBody Employee signup(@RequestBody Map<String, Object> map){
		logger.info("Signup Controller IN==>" + map.get("empRrn"));
		
		String empRrn = map.get("empRrn").toString();
		return this.employeeService.signupEmployee(empRrn);
	}
}
