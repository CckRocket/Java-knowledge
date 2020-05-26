package com.data.sort;

import java.util.Arrays;

public class ShellSort {
	public static void sort(int[] arr) {
		int len = arr.length;

		for(int gap = len/2; gap > 0; gap /= 2) {
			for(int i = gap; i < len; i++) {
				if(arr[i] < arr[i-gap]) {
					int temp = arr[i];
					int j = i - gap;
					while(j >= 0 && arr[j] > temp) {
						arr[j+gap] = arr[j];
						j -= gap;
					}
					arr[j+gap] = temp;
				}

			}
		}

		System.out.print("Shell sort:  " + Arrays.toString(arr));
		System.out.println();
	}
}
