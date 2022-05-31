package com.working.jjpractice;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//Spring annotation will create Bean object with Singleton Scope
@Component 
@Scope(value="singleton")// No need of this line actually it is by default 
public class FirstClass {
	
	private int id;
	private String name;
	private String details;
	
	private static int objCounter=0;
	
	private FirstClass() {
		//As its Singleton it will be created as we run our application
		System.out.println("I am FirstClass constructor..\n"+
		"As you run this App I got Created.");
		objCounter++;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	public void showAll() {
		System.out.println("Show FirstCLASS objCounter="+objCounter);
	}
}
