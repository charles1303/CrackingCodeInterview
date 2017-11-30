package com.career.cup;

import java.util.ArrayList;

public class PondSize {

	ArrayList<Integer> computePondSizes(int[][] land) {
		boolean[][] visited = new boolean[land.length][land[0].length];
		ArrayList<Integer> pondSizes = new ArrayList<Integer>();
		for (int r = 0; r < land.length; r++) {
			for (int c = 0; c < land[r].length; c++) {
				int size = computeSize(land, visited, r, c);
				if (size > 0) {
					pondSizes.add(size);

				}
			}
		}
		return pondSizes;
	}

	int computeSize(int[][] land, boolean[][] visited, int row, int col) {
		/* If out of bounds or already visited. */
		if (row < 0 || col < 0 || row >= land.length || col >= land[row].length
				|| visited[row][col] || land[row][col] != 0) {
			return 0;
		}
		int size = 1;
		visited[row][col] = true;
		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				size += computeSize(land, visited, row + dr, col + dc);
			}
		}
		return size;
	}

	ArrayList<Integer> computePondSizes2(int[][] land) {
		ArrayList<Integer> pondSizes = new ArrayList<Integer>();
		for (int r = 0; r < land.length; r++) {
			for (int c = 0; c < land[r].length; c++) {
				if (land[r][c] == 0) {// Optional. Would return anyway.
					int size = computeSize(land, r, c);
					pondSizes.add(size);
				}
			}
		}
		return pondSizes;
	}

	int computeSize(int[][] land, int row, int col) {

		/* If out of bounds or already visited. */
		if (row < 0 || col < 0 || row >= land.length || col >= land[row].length
				|| land[row][col] != 0) {// visited or not water
			return 0;

		}
		int size = 1;
		land[row][col] = -1; // Mark visited
		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				size += computeSize(land, row + dr, col + dc);
			}
		}
		return size;
	}
	
	public void surroundingMatrixPts(int[][] matrix){
		
		for(int i = 0; i< matrix.length; i++){
			for(int j = 0; j <matrix[i].length;j++){
				getNeighbours(matrix,i,j);
			}
		}
	}
	/*
	 * int[][] arr = {{1, 2, 3},
               		  {4, 5, 6},
                      {7, 8, 9}
                	  };
	 */
	//left => i is constant and j +1
	//up => i is const and j - 1
	//down => i is const and j+1
	//right = i+1 and j is const
	
	//diagonal up left = i -1 and j - 1
	//diagonal up right => i +1 and j -1
	//diagonal down right => i+1 and j+1
	//diagonal down left = i -1 and j +1
		
	
	
	private void getNeighbours(int[][] matrix,int i,int j){
		int k = i;
		int l = j;
		for(;k< matrix.length; k++){
			for(; l <matrix[k].length;k++){
				
			}
		}
	}
}
