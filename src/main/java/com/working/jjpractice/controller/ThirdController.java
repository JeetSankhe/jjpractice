package com.working.jjpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.working.jjpractice.FirstClass;


@RestController
public class ThirdController {

	//@Autowired
	//private FirstController fc;
	//private SecondController sc;
	
	private ThirdController() {
		System.out.println("Third controller constructor creation..");
	}

	@Autowired
	private FirstClass fc;

	@Autowired
	private FirstController fcon;

	@Autowired
	private SecondController sc;
	
	
	public void showThird() {
		System.out.println("I am inside Third now -----------");
		fc.showAll();
		System.out.println(fcon.getString());
		System.out.println(sc.getString());
		System.out.println("I am done with Third now -----------");
	}
	
}
