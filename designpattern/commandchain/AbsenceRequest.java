package com.designpattern.commandchain;

public class AbsenceRequest {
	public int day;
	public String studentName;
	
	public AbsenceRequest(int day, String studentName) {
		this.day = day;
		this.studentName = studentName;
	}
}
