package com.career.cup;

public class Recursion {

	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9,0};
		int mid = recurse(arr,arr.length);
		System.out.println(arr[arr.length - 1 - mid]);
		
	}
	
	static int recurse(int[] arr, int length){
		int cnt = 0;
		
		if(length == 0 || length == 1){
			
			return length;
		}
		
		 cnt =+ recurse(arr,length-2);
		return cnt + 1;
	}
}
