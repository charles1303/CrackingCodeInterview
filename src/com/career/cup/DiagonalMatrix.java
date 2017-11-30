package com.career.cup;

public class DiagonalMatrix{
	
	public static void main(String[] args){
		//i is downward while j is sideways
		//1 2 4 7 5 3 6 8 9 
		//(0,0),(0,1),(1,0),(2,0),(1,1),(0,2),(1,2),(2,1),(2,2)
		int[][] arr = {{1, 2, 3},
                	   {4, 5, 6},
                	   {7, 8, 9}
                	  };
		print(arr);
	}
	
	static void print(int[][] arr){
		int elements = arr.length * arr.length;
		int k = 0;
		
	}
	
	static void print(int[][] arr, int n)
	{
	    // Initialize indexes of element to be printed next
	    int i = 0, j = 0 ;
	 
	    // Direction is initially from down to up
	    boolean isUp = true;
	 
	    // Traverse the matrix till all elements get traversed
	    for (int k=0; k<n*n;)
	    {
	        // If isUp = true then traverse from downward
	        // to upward
	        if (isUp)
	        {
	            for ( ; i>=0 && j<n ; j++, i--)
	            {
	                
	                System.out.println(arr[i][j]);
	                k++;
	            }
	 
	            // Set i and j according to direction
	            if (i < 0 && j<=n-1)
	                i = 0;
	            if (j == n)
	                i = i+2 ; j--;
	        }
	 
	        // If isUp = 0 then traverse up to down
	        else
	        {
	            for ( ; j >= 0 && i<n ; i++ , j--)
	            {
	            	System.out.println(arr[i][j]);
	                k++;
	            }
	 
	            // Set i and j according to direction
	            if (j < 0 && i<=n-1)
	                j = 0;
	            if (i == n)
	                j = j + 2 ; i--;
	        }
	 
	        // Revert the isUp to change the direction
	        isUp = !isUp;
	    }
	}
}
