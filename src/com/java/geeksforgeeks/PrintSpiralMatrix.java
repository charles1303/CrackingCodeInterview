package com.java.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralMatrix {
	
	public static void main(String[] args){
		int[][] matrix = {
				{ 1, 2, 3 },
              { 4, 5, 6 },
              { 7, 8, 9 }
		};
		List<Integer> result = spiralOrder(matrix);
		for(Integer r: result){
			System.out.println(r);
		}
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
	    List<Integer> result = new ArrayList<Integer>();
	    if(matrix==null||matrix.length==0||matrix[0].length==0)
	        return result;
	 
	    int m = matrix.length;
	    int n = matrix[0].length;
	 
	    int left=0;
	    int right=n-1;
	    int top = 0;
	    int bottom = m-1;
	 
	    while(result.size()<m*n){
	        for(int j=left; j<=right; j++){
	            result.add(matrix[top][j]);
	        }
	        top++;
	 
	        for(int i=top; i<=bottom; i++){
	            result.add(matrix[i][right]);
	        }
	        right--;
	        //prevent duplicate row
	        if(bottom<top)
	            break;
	 
	        for(int j=right; j>=left; j--){
	            result.add(matrix[bottom][j]);
	        }
	        bottom--;
	        // prevent duplicate column
	        if(right<left)
	            break;
	 
	        for(int i=bottom; i>=top; i--){
	            result.add(matrix[i][left]);
	        }
	        left++;
	    }
	 
	    return result;
	}
}
