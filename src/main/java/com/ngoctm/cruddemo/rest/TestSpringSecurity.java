package com.ngoctm.cruddemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class TestSpringSecurity {

	@GetMapping("/a")
	public String intoSecurity() {
		
		return "security active";
	}
}
