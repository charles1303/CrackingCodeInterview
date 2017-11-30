package com.career.cup;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UnsortedArrSwaps {
	
	public static void main(String[] args){
		//[0 1 1 0 0 1 0 1 1 1 1 0 0 1 0 0 1] => 
		
		//[0 1 1 0 0 1 1 1 1 1 1 0 0 0 0 0 1] => 
		
		//[0 1 1 0 1 1 1 1 1 1 1 0 0 0 0 0 0] => 
		
		//[0 0 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0]
		//int[] arr = {0,1,1,0,0,1,0,1,1,1,1,0,0,1,0,0,1};
		
		//System.out.println(maxLength(arr,1,0,0));
		getMaxOnesInMatrix();
		
		/*int[][] arr = {
				{0,0,0,0,0,0,0,1,1,1,1,1},
                {0,0,0,0,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0,0,1,1,1},
                {0,0,0,0,0,0,0,1,1,1,1,1},
                {0,0,0,0,1,1,1,1,1,1,1,1}
                };*/
		
		//doBinarySearch(arr,0,arr.length);
		//int[] arr = {0,0,0,0,0,0,0,1,1,1,1,1};
		//doBinarySearch2(arr,0,arr.length);
	}
	
	static int doBinarySearch2(int[] arr, int start, int end){
		System.out.println("incoming start============="+start);
		System.out.println("incoming end============="+end);
		if(start >= end) return start;
		int index = 0;
		for(int i = 0; i < arr.length; i++){
			System.out.println("i============="+i);
			System.out.println("a[i]============="+arr[i]);
			int mid = (start + end)/2;
			System.out.println("mid============="+mid);
			if(arr[i] > 0){
				end = mid - 1;
				System.out.println("end============="+end);
				index = doBinarySearch2(arr,start,end);
			}else{
				start =  mid + 1;
				System.out.println("start============="+start);
				index = doBinarySearch2(arr,start,end);
			}
		}
		System.out.println("Index============="+index);
		return index;
	}

	static int maxLength(int[] arr, int digit, int maxOccurence, int nextIndex){
		if(nextIndex == arr.length) return maxOccurence - 1;
		int newMaxOccurence = 0;
		int index = 0;
		for(int i = nextIndex; i < arr.length - 1; i++){
			
			if(arr[i] == digit){
				newMaxOccurence++;
				//System.out.println("newMaxOccurence===="+newMaxOccurence);
			}else{
				if(newMaxOccurence > maxOccurence){
					index = i - 1;
				}
				maxOccurence = maxOccurence > newMaxOccurence ? maxOccurence : newMaxOccurence;
				newMaxOccurence = 0;
				//index = maxLength(arr,digit, maxOccurence,i+1);
				//break;
			}
			
			
		}
		System.out.println("maxOccurence===="+maxOccurence);
		System.out.println("index===="+index);
		return maxOccurence;
	}
	
	static void getMaxOnesInMatrix(){
		int max = 0;
		HashMap<Integer,int[]> map = new HashMap<>();
		int[][] arr = {
				{0,0,0,0,0,0,0,1,1,1,1,1},
                {0,0,0,0,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0,0,1,1,1},
                {0,0,0,0,0,0,0,1,1,1,1,1},
                {0,0,0,0,1,1,1,1,1,1,1,1}
                };
		int cnt = 0;
		for(int i = 0; i < arr.length; i++){
			System.out.println("i********"+i);
			int j = arr[i].length-1;
			while(arr[i][j] != 0){
				//System.out.println("j====="+j);
				j--;
			}
			System.out.println("arr[i].length-1 - j====="+(arr[i].length-1 - j));
			cnt++;
			int[] val = {i+1,(arr[i].length-1 - j)};
			map.put(cnt,val);
			if(arr[i].length-1 - j > max) max = arr[i].length-1 - j;
			
		}
		
		System.out.println("max===="+max);
		
		for(Integer e: map.keySet()){
			if(map.get(e)[1] >= max)
			//System.out.println("key====="+e);
			System.out.println(Arrays.toString(map.get(e)));
		}
	}
	
	static int doBinarySearch(int[][] arr, int start, int end){
		if(start >= end) return start;
		int index = 0;
		for(int i = 0; i < arr.length; i++){
			System.out.println("i============="+i);
			int mid = (start + end)/2;
			System.out.println("mid============="+mid);
			if(arr[i][mid] > 0){
				end = mid - 1;
				System.out.println("end============="+end);
				index = doBinarySearch(arr,start,end);
			}else{
				start =  mid + 1;
				System.out.println("start============="+start);
				index = doBinarySearch(arr,start,end);
			}
		}
		System.out.println("Index============="+index);
		return index;
	}
	
	
}
