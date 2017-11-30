package com.java.geeksforgeeks;

import java.util.Arrays;

public class ArrayPeak {

	public static void main(String[] args){
		int[] arr = {2,3,4,5,6,7,8,9,7,3,2};
		//getPeak(arr);
		System.out.println(findMaximum(arr, 0, arr.length-1));
	}
	
	public static void getPeak(int[] arr){
		if(arr.length <= 1) return;
		int mid = arr.length/2;
		//System.out.println(mid);
		int[] left = new int[mid];
		int[] right = new int[(arr.length - left.length)];
		
		System.arraycopy(arr, 0, left, 0, left.length);
		System.arraycopy(arr,left.length,right,0,right.length);
		
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		
		System.out.println("left[mid-1]==="+left[mid-1]);
		System.out.println("right[0]===="+right[0]);
		System.out.println("arr[mid]==="+arr[mid]);
		System.out.println("arr[mid + 1]===="+arr[mid + 1]);
		System.out.println("arr[mid - 1]===="+arr[mid - 1]);
		
		//if ( arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
		//if(left[mid - 1] > left[mid-2] && left[mid - 1] < right[0]){
			//System.out.println("****"+right[0]);
		if(left[mid-1] < right[0]){
			getPeak(right);
		}else if(left[mid-1] > right[0]){
			getPeak(left);
		}
	}
	
	static int findMaximum(int arr[], int low, int high)
	{
	 
		System.out.println(Arrays.toString(arr));
		System.out.println("low===="+low);
		System.out.println("high===="+high);
		System.out.println("arr[low]===="+arr[low]);
		System.out.println("arr[high]===="+arr[high]);
		
	   /* Base Case: Only one element is present in arr[low..high]*/
	   if (low == high)
	     return arr[low];
	 
	   /* If there are two elements and first is greater then
	      the first element is maximum */
	   if ((high == low + 1) && arr[low] >= arr[high])
	      return arr[low];
	 
	   /* If there are two elements and second is greater then
	      the second element is maximum */
	   if ((high == low + 1) && arr[low] < arr[high])
	      return arr[high];
	 
	   int mid = (low + high)/2;   /*low + (high - low)/2;*/
	 
	   /* If we reach a point where arr[mid] is greater than both of
	     its adjacent elements arr[mid-1] and arr[mid+1], then arr[mid]
	     is the maximum element*/
	   if ( arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
	      return arr[mid];
	 
	   /* If arr[mid] is greater than the next element and smaller than the previous 
	    element then maximum lies on left side of mid */
	   if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
	     return findMaximum(arr, low, mid-1);
	   else // when arr[mid] is greater than arr[mid-1] and smaller than arr[mid+1]
	     return findMaximum(arr, mid + 1, high);
	}
}
