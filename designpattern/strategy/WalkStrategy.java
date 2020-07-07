package com.designpattern.strategy;

public class WalkStrategy implements IStrategy{

	@Override
	public void planning(String begin, String end) {
		System.out.println("Walking from " + begin + " to " + end);
	}

}
