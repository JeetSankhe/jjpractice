package com.working.jjpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.working.jjpractice.FirstClass;

//Spring annotation will create Bean object with Singleton Scope

@RestController
@RequestMapping("jjpractice")
public class FirstController {
	
	private static int objCounter=0;
	
	private FirstController() {
		objCounter=objCounter+1;
		System.out.println("First controller constructor creation.. objCounter="+ objCounter);
	}
	
	@Autowired
	private FirstClass myFC;
	
	@GetMapping("")
	public String defaultString() {
		System.out.println("I am by default call"+ objCounter);
		myFC.showAll();
		System.out.println("end of FirstFC");
		return "Hello I am jjpractice ByDefault Call";
	}

	@GetMapping("/*")
	public String getString() {
		System.out.println("call to FirstFC.. objCounter="+ objCounter);
		myFC.showAll();
		System.out.println("end of FirstFC");
		return "Hello I am jjpractice CCCC";
	}
}
