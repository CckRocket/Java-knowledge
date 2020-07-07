package com.designpattern.commandchain;

public abstract class AbstractHandler {
	
	protected static final int MAX_DAY_FOR_CLASS = 3;
	protected static final int MAX_DAY_FOR_DEPARTMENT = 10;
	protected static final int MAX_DAY_FOR_COLLEGE = 30;
	
	private String name;
	private AbstractHandler nextHandler;
	
	public AbstractHandler(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AbstractHandler getNextHandler() {
		return nextHandler;
	}

	public void setNextHandler(AbstractHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public void requestHandler(AbsenceRequest request) {
	}
}
