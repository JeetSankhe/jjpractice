package com.working.jjpractice.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//Spring annotation will create Bean object
@Service
@Scope(value="prototype") // This annotation will convert the scope to prototype, now we can create multiple objects 
public class SecondController {
	
	private static int objectcounter=0;

	private int innerInt;
	
	public SecondController() {
		objectcounter++;
		this.innerInt=objectcounter;
		System.out.println("SecondController Constructor.. objectcounter="+objectcounter + "  innerInt="+innerInt);
	}
	
	public String getString() {
		return "Hello I am Second Controller with prototype scope having objectcounter="+objectcounter + "  innerInt="+innerInt;
	}
}
