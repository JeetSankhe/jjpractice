package com.working.jjpractice.controller;

public class GarbageTest {

	private int id;
	private static int nextid=1;
	
	
	public GarbageTest() {
		this.setId(nextid++);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void showG() {
		System.out.println("Next now:"+nextid);
	}
	
	protected void finalize() {
		nextid--;
	}
}
