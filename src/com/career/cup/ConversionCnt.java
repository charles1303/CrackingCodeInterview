package com.career.cup;

import java.util.Arrays;

public class ConversionCnt{
	
	public static void main(String[] args){
		int arr[] = {1, 20, 6, 4, 5};
		int arr2[] = {2, 4, 1, 3, 5};
		
		mergeSort(arr);
	}
	
	static int[] mergeSort(int[] arr){
		if(arr.length <= 1) return arr;
		int[] first = new int[arr.length/2];
		int[] second = new int[arr.length -first.length];
		System.arraycopy(arr,0,first,0,first.length);
		System.arraycopy(arr,first.length,second,0,second.length);
		

		//mergeSort(first);
		System.out.println("first====="+Arrays.toString(mergeSort(first)));
		//mergeSort(second);
		System.out.println("second===="+Arrays.toString(mergeSort(second)));
		
		System.out.println("Final first====="+Arrays.toString((first)));
		System.out.println("Final second===="+Arrays.toString((second)));
		return merge(first,second,arr);
	}

	static int[] merge(int[] first, int[] second, int[] arr){
		
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;

		while(iFirst < first.length && iSecond < second.length){
			if(first[iFirst] < second[iSecond]){
				arr[j] = first[iFirst];
				iFirst++;
			}else{
				arr[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}
		System.arraycopy(first,iFirst,arr,j,first.length - iFirst);
		System.arraycopy(second,iSecond,arr,j,second.length - iSecond);

		System.out.println("j======="+(iSecond+1));
		System.out.println("iFirst======="+(iFirst));
		
		System.out.println("Final arr===="+Arrays.toString((arr)));
		
		

		return arr;
	}
}
