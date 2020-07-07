package com.designpattern.commandchain;

public class ClassHandler extends AbstractHandler{

	public ClassHandler(String name) {
		super(name);
	}
	
	@Override
	public void requestHandler(AbsenceRequest request) {
		if(request.day <= MAX_DAY_FOR_CLASS) {
			System.out.println(request.studentName + " request is approved by " + this.getName());
		}else {
			if(this.getNextHandler() == null) System.out.println(request.studentName + " request is rejected ");
			else {
				this.getNextHandler().requestHandler(request);
			}
		}
	}
}
