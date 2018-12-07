package com.example.demo.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.db.entity.EmployeeEntity;
import com.example.demo.db.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloCtrl {

	@Autowired
	private EmployeeService service;

	@GetMapping("/hello")
	public String getHello() {
		log.debug("hello was called. method is get.");
		return ("hello");
	}

	@PostMapping("/hello")
	public String postHello(@RequestParam("input-text") String inputValue, Model model) {
		log.debug("hello was called. method is post. request parameter is [{}].", inputValue);
		model.addAttribute("sample", inputValue);
		return ("hello");
	}

	@PostMapping("/hello/db")
	public String postHelloDb(@RequestParam("input-text") String inputValue, Model model) {
		log.debug("hello/db was called. method is post. request parameter is [{}].", inputValue);
		EmployeeEntity entity = service.findOne(Integer.parseInt( inputValue));
		model.addAttribute("sample", inputValue);
		if (entity == null) {
			model.addAttribute("sample", inputValue + ": there is no employee.");
			return ("hello");
		}
		model.addAttribute("id", entity.getId());
		model.addAttribute("name", entity.getName());
		model.addAttribute("age", entity.getAge());

		return ("hello");
	}
}
