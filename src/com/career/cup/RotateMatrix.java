package com.career.cup;

public class RotateMatrix {
	/*
  * 1 2 3
	4 5 6
	7 8 9

	7 4 1
	8 5 2
	9 6 3

int[i][j]

(0,0) = (0,2)
(0,1) = (1,1)
(0,2) = (2,2)

(1,0) = (0,1)
(1,1) = (1,0)
(1,2) = (2,1)


(2,0) = (0,0)
(2,1) = (1,2)
(2,2) = (2,0)

	 */
	
	public static void main(String[] args){
		int[][] arr = {{1, 2, 3},
		     	   {4, 5, 6},
		     	   {7, 8, 9}
		     	  };
		rotate(arr);
	}
	
	static void rotate(int[][] arr){
		int[][] temp = new int[3][3];
		int arrLen = arr.length;
		for(int i = 0; i < arrLen;i++){
			 int arrayLength = arrLen - (i+1);
			for(int j = 0; j < arrLen; j++){
				if(j == (arrLen-1))
					arrayLength = arrLen - (i+1);
				if(arrayLength < 0)
					arrayLength = arrLen - 1;
				
				System.out.println("***"+i+","+j+"==="+j+","+arrayLength);
				temp[j][arrayLength] = arr[i][j];
				arrayLength--;
				
			}
		}
		
		for(int i = 0; i < arr.length;i++){
			for(int j = 0; j < arr[i].length;j++){
				System.out.println(arr[i][j]+"==="+i+","+j);
			}
		}
		
		System.out.println("***************************");
		
		for(int i = 0; i < temp.length;i++){
			for(int j = 0; j < temp[i].length;j++){
				System.out.println(temp[i][j]+"==="+i+","+j);
			}
		}
	}
}
