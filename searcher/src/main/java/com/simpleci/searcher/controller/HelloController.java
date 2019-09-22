package com.simpleci.searcher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	private String getHello() {
		return "HelloFrom Searcher";
	}
}
