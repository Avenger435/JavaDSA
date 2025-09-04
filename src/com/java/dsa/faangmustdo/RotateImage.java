package com.java.dsa.faangmustdo;

/**
 * https://leetcode.com/problems/rotate-image/description/
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Rotated Matrix:");
        RotateImage rotateImage= new RotateImage();
        rotateImage.rotate(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose the matrix
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]= temp;
            }
        }
        //reverse each row
        for(int i=0;i<n;i++){
            int left=0;
            int right=n-1;
            while(left<right){
                int temp= matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]= temp;
                left++;
                right--;
            }
        }
    }

}
