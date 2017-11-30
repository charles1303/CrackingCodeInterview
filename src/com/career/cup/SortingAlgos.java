package com.career.cup;

import java.util.Arrays;

public class SortingAlgos {
	
	void selectionSort(int[] arr){
		for(int i = 0; i < arr.length - 1;i++){
			int minPos = i;
			for(int j = i+1; j < arr.length; j++){
				if(arr[j] > arr[minPos]){
					minPos = j;
				}
			}
			swap(arr, i,minPos);
		}
	}

	void swap(int[] arr, int i, int j){
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	void insertionSort(int[] arr){
		for(int i = 1; i < arr.length; i++){
			int next = arr[i];
			int j = i;
			while(j > 0 && arr[j-1] > next){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = next;
		}
	}

	int[] mergeSort(int[] arr){
		if(arr.length <= 1) return arr;

		int[] first = new int[arr.length/2];
		int[] second = new int[arr.length - first.length];
		System.arraycopy(arr, 0, first, 0, first.length);
		System.arraycopy(arr,first.length,second,0,second.length);

		mergeSort(first);
		mergeSort(second);

		return merge(first,second,arr);
	}

	int[] merge(int[] first, int[] second, int[] arr){
		int iFirst = 0;

		int iSecond = 0;

		int j = 0;

		while(iFirst < first.length && iSecond < second.length){
			if(first[iFirst] < second[iSecond]){
				arr[j] = first[iFirst];
				iFirst++;
			} else{
				arr[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}
		System.arraycopy(first,iFirst,arr,j,first.length - iFirst);
		System.arraycopy(second,iSecond,arr,j,second.length - iSecond);
		return arr;
	}

	void quickSort(int[] arr, int from, int to){
		if(from >= to) return;

		int pivot = arr[from];
		int i = from -1;
		int j = to + 1;

		while(i < j){
			i++;
			while(arr[i] < pivot) i++;

			j--;
			while(arr[j] > pivot) j--;
			
			if(i < j) swap(arr,i,j);
		}
		quickSort(arr,from,j);
		quickSort(arr,j+1,to);
	}
	
	public int[] quicksort(int [] list) {
        quickSort(list, 0, list.length-1);
        return list;
    }

	void bubbleSort(int[] arr){
		for(int i = arr.length - 1; i >= 0; i--){
			for(int j = 1; j <= i; j++){
				if(arr[j-i] > arr[j]){
					/*
					 * int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					 */
					swap(arr, j,j-1);
					
				}
			}
		}
	}
	
	public static int[] bubbleSort2(int arr[])
	 {
	  for (int i = 0; i < arr.length; i++) {
	   for (int j = 0; j < arr.length-1; j++) {
	   
	    if(arr[j]>arr[j+1])
	    {
	     int temp=arr[j];
	     arr[j]=arr[j+1];
	     arr[j+1]=temp;
	    }
	   }
	   System.out.print("Iteration "+(i+1)+": ");
	   //printArray(arr);
	  }
	  return arr;
	 }

	void bucketSort(int[] arr){
		int[] bucket = new int[arr.length + 1];
		Arrays.fill(bucket,0);

		for(int i = 0; i < arr.length; i++){
			bucket[arr[i]]++;
		}
		
		int k = 0;
		for(int i = 0; i < bucket.length; i++){
			for(int j = 0; j < bucket[i]; j++){
				arr[k++] = i;
			}
		}
	}

}
