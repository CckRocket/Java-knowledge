package com.designpattern.strategy;

public class BikingStrategy implements IStrategy{

	@Override
	public void planning(String begin, String end) {
		System.out.println("Biking from " + begin + " to " + end);
	}

}
