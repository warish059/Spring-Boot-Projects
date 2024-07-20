package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestController {
	
	@GetMapping("/str")
	public String responseObj1() {
		String str = "welcome";
		return str;
	}
	
	@GetMapping("/ent")
	public ResponseEntity<String> responseObj2(){
		String payload = "welcome to rst";
		return new ResponseEntity<>(payload,HttpStatus.OK);
	}
}
