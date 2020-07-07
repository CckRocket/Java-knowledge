package com.designpattern.commandchain;

public class CommandChainTest {

	public static void main(String[] args) {
		
		AbsenceRequest request = new AbsenceRequest(30, "cck");
		
		AbstractHandler classHandler = new ClassHandler("class leader");
		AbstractHandler departmentHandler = new DepartmentHandler("department leader");
		AbstractHandler collegeHandler = new CollegeHandler("college leader");
		
		classHandler.setNextHandler(departmentHandler);
		departmentHandler.setNextHandler(collegeHandler);
		collegeHandler.setNextHandler(null);
		
		classHandler.requestHandler(request);
	}

}
