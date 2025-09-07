package com.java.dsa.faangmustdo;

/**
 * https://leetcode.com/problems/rotate-image/description/
 *
 * Solution Note:
 * To rotate a matrix 90 degrees clockwise in-place:
 * 1. Transpose the matrix (swap rows and columns).
 * 2. Reverse each row.
 * This avoids using extra space and works for square matrices.
 */
public class RotateImage {

    public static void main(String[] args) {
        // Initialize a 3x3 matrix
        int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
        // Print the original matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" "); // Print each element
            }
            System.out.println(); // Newline after each row
        }
        System.out.println("Rotated Matrix:"); // Separator for output
        RotateImage rotateImage= new RotateImage(); // Create RotateImage object
        rotateImage.rotate(matrix); // Rotate the matrix in-place
        // Print the rotated matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" "); // Print each element
            }
            System.out.println(); // Newline after each row
        }
    }

    /**
     * Rotates the given n x n matrix 90 degrees clockwise in-place.
     * @param matrix The input square matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length; // Get matrix size
        // Transpose the matrix (swap rows and columns)
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp= matrix[i][j]; // Store current value
                matrix[i][j]= matrix[j][i]; // Swap with symmetric element
                matrix[j][i]= temp; // Complete the swap
            }
        }
        // Reverse each row to complete the rotation
        for(int i=0;i<n;i++){
            int left=0; // Start index of row
            int right=n-1; // End index of row
            while(left<right){ // Swap until middle is reached
                int temp= matrix[i][left]; // Store left value
                matrix[i][left]=matrix[i][right]; // Move right value to left
                matrix[i][right]= temp; // Move left value to right
                left++; // Move left pointer right
                right--; // Move right pointer left
            }
        }
    }

}