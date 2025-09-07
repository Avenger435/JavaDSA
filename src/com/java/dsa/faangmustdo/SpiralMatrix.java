package com.java.dsa.faangmustdo;

import java.util.ArrayList; // Import ArrayList for dynamic array
import java.util.Arrays;    // Import Arrays for array utilities
import java.util.List;      // Import List interface

public class SpiralMatrix {

	public static void main(String[] args) {

		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}}; // Define a 3x3 matrix
		System.out.println(Arrays.deepToString(matrix)); // Print the original matrix
		List<Integer> spiralOrder = spiralOrder(matrix); // Get spiral order traversal
		System.out.println("SpiralOrder: "+ spiralOrder); // Print the spiral order result
	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<>(); // List to store spiral order
		int m=matrix.length; // Number of rows
		int n= matrix[0].length; // Number of columns
		
		if(matrix==null || matrix.length==0)
			return result; // Return empty list if matrix is null or empty
		
		int top=0; // Initialize top boundary
		int bottom= m-1; // Initialize bottom boundary
		int left=0; // Initialize left boundary
		int right= n-1; // Initialize right boundary
		
		//start from top 
		while(top<=bottom && left <=right) { // Continue while boundaries are valid
			for(int col =left;col<=right;col++) { // Traverse from left to right on top row
				result.add(matrix[top][col]); // Add each element to result
			}
			top++; // Move top boundary down
			
			//traverse from top -> bottom
			for(int row=top;row<=bottom;row++) { // Traverse down on rightmost column
				result.add(matrix[row][right]); // Add each element to result
			}
			right--; // Move right boundary left
			
			//traverse from right -> left
			if(top <= bottom) { // Check if there are rows left
				for(int col=right;col>=left;col--) { // Traverse from right to left on bottom row
					result.add(matrix[bottom][col]); // Add each element to result
				}
				bottom--; // Move bottom boundary up
			}
			
			//traverse from bottom to top
			if(left<=right) { // Check if there are columns left
				for(int row=bottom; row>=top;row--) { // Traverse up on leftmost column
					result.add(matrix[row][left]); // Add each element to result
				}
				left++; // Move left boundary right
			}
		}
		
		return result; // Return the spiral order list
	}

}