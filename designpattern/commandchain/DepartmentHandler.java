package com.designpattern.commandchain;

public class DepartmentHandler extends AbstractHandler {

	public DepartmentHandler(String name) {
		super(name);
	}
	
	@Override
	public void requestHandler(AbsenceRequest request) {
		if(request.day <= MAX_DAY_FOR_DEPARTMENT) {
			System.out.println(request.studentName + " request is approved by " + this.getName());
		}else {
			if(this.getNextHandler() == null) System.out.println(request.studentName + " request is rejected ");
			else {
				this.getNextHandler().requestHandler(request);
			}
		}
	}

}
