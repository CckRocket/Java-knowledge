package com.designpattern.commandchain;

public class CollegeHandler extends AbstractHandler {

	public CollegeHandler(String name) {
		super(name);
	}
	
	@Override
	public void requestHandler(AbsenceRequest request) {
		if(request.day <= MAX_DAY_FOR_COLLEGE) {
			System.out.println(request.studentName + " request is approved by " + this.getName());
		}else {
			System.out.println(request.studentName + " request is rejected ");
		}
	}

}
