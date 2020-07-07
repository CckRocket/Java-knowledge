package com.designpattern.strategy;

public class DrivingStrategy implements IStrategy{

	@Override
	public void planning(String begin, String end) {
		System.out.println("Driving from " + begin + " to " + end);
	}
}
