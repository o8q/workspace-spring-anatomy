package com.example.demo.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloCtrl {

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

}
