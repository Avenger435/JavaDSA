/**
 * 
 */
package com.java.dsa.arrays;

/**
 * https://leetcode.com/problems/remove-element
 */
public class RemoveElementArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums = { 3, 2, 2, 3 };
		int removeElement = removeElement(nums, 3);
		int[] nums1 = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int removeElement1 = removeElement(nums1, 2);

		System.out.println("removeElement: " + removeElement);
		System.out.println("removeElement1: " + removeElement1);

	}

	/**
	 * Slow pointer nums[slow] keeps the track of the value(keeper) that is not
	 * equal to the val(asked to remove) Fast pointer traverses the arrays and
	 * checks if it is not equal to the val(asked to remove) if yes, move it to the
	 * nums[slow] -> increment slow.
	 * 
	 * return slow as it has the number of values that are replaced.
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */

	public static int removeElement1(int[] nums, int val) {
		// Two pointers:
		// 'fast' scans every element,
		// 'slow' marks where to overwrite next valid element
		int fast = 0;
		int slow = 0;

		// Iterate through the entire array
		while (fast < nums.length) {
			// If current element is not the one to remove
			if (nums[fast] != val) {
				// Place valid element at 'slow' index
				nums[slow] = nums[fast];
				slow++; // Move 'slow' forward for next valid write
			}
			// Always move 'fast' forward
			fast++;
		}

		// Final 'slow' value is the new length of array with 'val' removed
		return slow;
	}

	public static int removeElement(int[] nums, int val) {

		int fast = 0;
		int slow = 0;

		while (fast < nums.length) {
			if (nums[fast] != val) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		return slow;
	}

}
