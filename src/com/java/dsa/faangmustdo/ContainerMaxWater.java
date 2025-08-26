/**
 * 
 */
package com.java.dsa.faangmustdo;

/**
 * 
 */
public class ContainerMaxWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		int maxArea1 = maxArea(height);
		System.out.println("maxArea1: " + maxArea1);
	}

	public static int maxArea(int[] height) {

		// edge case
		if (height == null || height.length == 0)
			return 0;

		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {

			// width
			int width = right - left;

			int currentHeight = Math.min(height[right], height[left]);
			// calc area
			int area = width * currentHeight;

			maxArea = Math.max(area, maxArea);

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}

}
