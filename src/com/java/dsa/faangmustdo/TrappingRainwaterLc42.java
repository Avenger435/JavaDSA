/**
 * 
 */
package com.java.dsa.faangmustdo;

/**
 * 
 */
public class TrappingRainwaterLc42 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] height1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] height2 = { 4, 2, 0, 3, 2, 5 };

		System.out.println(trap(height1));
		System.out.println(trap(height2));

		System.out.println(trapAlternate(height1));
		System.out.println(trapAlternate(height2));

	}

	public static int trapAlternate(int[] height) {
		int trapped = 0;
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];

		int max = height[0];

		// calculate maximums

		for (int i = 0; i < height.length; i++) {
			if (max < height[i])
				max = height[i];
			leftMax[i] = max;
		}

		max = height[height.length - 1];

		for (int i = height.length - 1; i >= 0; i--) {
			if (max < height[i])
				max = height[i];
			rightMax[i] = max;
		}

		for (int i = 0; i < height.length; i++) {
			trapped += Math.min(rightMax[i], leftMax[i]) - height[i];
		}

		return trapped;
	}

	public static int trap(int[] height) {

		if (height == null || height.length < 1) {
			return 0;
		}

		int water = 0;
		int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;

		while (left < right) {
			if (height[left] < height[right]) {
				leftMax = Math.max(leftMax, height[left]);
				water += leftMax - height[left];
				left++;
			} else {
				rightMax = Math.max(rightMax, height[right]);
				water += rightMax - height[right];
				right--;
			}
		}

		return water;
	}

}
