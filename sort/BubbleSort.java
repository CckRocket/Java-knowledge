package com.data.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void sort(int[] arr) {
		int len = arr.length;
		
		for(int i = len - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.print("Bubble sort: " + Arrays.toString(arr));
		System.out.println();
	}
}
