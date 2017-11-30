package com.career.cup;

import java.util.Arrays;

public class UnsortedMedian {
	
	//static int[] A = new int[Integer.MAX_VALUE];
	static int partitions(int[] A, int low,int high)
	{
	    int p=low,r=high,x=A[r],i=p-1;
	    for(int j=p;j<=r-1;j++)
	    {
	        if (A[j]<=x)
	        {

	            i=i+1;
	            swap(A[i],A[j]);
	        }
	    }
	    swap(A[i+1],A[r]);
	    return i+1;
	}
	static int selection_algorithm(int[] A,int left,int right)
	{
		int n = (left+right)/2;
	    for(;;)
	    {
	        int pivotIndex=partitions(A,left,right);          //Select the Pivot Between Left and Right
	        int len=pivotIndex-left+1;

	        if(n==len)
	            return A[pivotIndex];

	        else if(n<len)
	            right=pivotIndex-1;

	        else
	        {
	            n=n-len;
	            left=pivotIndex+1;
	        }
	    }
	}
	
	private static void swap(int i,int j){
		int temp = i;
		i = j;
		j = temp;
	}
	
	public static void main(String[] args){ 
        //int[] a = {1,9,-4,7,6,11,3,2,10};
		//int[] arr = {3, 8, 10, 35, 54, 84, 101,103,105};
		int[] arr = {105,103,101,54,35,10,8,3};
		
		
		System.out.println(selection_algorithm(arr, 0, arr.length-1));
		
        int median; 

        median = findMedian(arr,0,arr.length-1); 
        System.out.println("median======"+median);
        if(arr.length%2 != 0) 
            System.out.print("the median is 1 : "+arr[median]);
        else 
            System.out.print("the median is 2 : "+(arr[median] + arr[median + 1])/2);
    } 
	
	public static int findMedian(int[] arr,int left,int right){ 
        int index = 0; 
        int mid = (left+right)/2; 
        index = partition(arr,left,right); 
        //System.out.println("mid====="+mid);
        //System.out.println("index====="+index);
        while( index != mid){ 
            if(index < mid) 
                index = partition(arr,mid,right); 
            else index = partition(arr,left,mid); 
        } 
        //System.out.println("index2====="+index);
        return index; 
    } 
    public static int partition(int[] arr,int i,int j ){ 
        int pivot = (i+j)/2; 
        int temp; 
        while(i <= j){ 
            while(arr[i] < arr[pivot]) 
                i++; 
            while(arr[j] > arr[pivot]) 
                j--; 
            if(i <= j){ 
                temp = arr[i]; 
                arr[i]=arr[j]; 
                arr[j] = temp; 
                i++;j--; 
            } 
        } 
        System.out.println(Arrays.toString(arr));
        return pivot; 
    } 


}
