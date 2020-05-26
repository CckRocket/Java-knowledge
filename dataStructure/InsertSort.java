package com.data.sort;

import java.util.Arrays;

public class InsertSort {
	public static void sort(int[] arr) {
		int len = arr.length;
		
		for(int i = 1; i < len; i++) {
			if(arr[i] < arr[i-1]) {
				int temp = arr[i];
				int j = i-1;
				while (j >= 0 && arr[j] > temp) {
					arr[j+1] = arr[j];
					j--;
				}
				arr[j+1] = temp;
			}
		}
		
		System.out.print("Insert sort: " + Arrays.toString(arr));
		System.out.println();
	}
}
