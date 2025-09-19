package com.java.dsa.arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        // Output: [[-1, -1, 2], [-1, 0, 1]]

        var result = threeSum(nums);
        System.out.println("Three Sum Result: " + result);
    }

    /**
     * Finds all unique triplets in the array that sum to zero.
     *
     * @param nums the input array of integers
     * @return a list of lists containing the unique triplets
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // Initialize the result list to store unique triplets
        List<List<Integer>> result = new ArrayList<>();
        // Edge case: if the array is null or has less than 3 elements, return empty
        // result
        if (nums == null || nums.length < 3) {
            return result;
        }
        // Sort the array to facilitate finding triplets
        // This helps in skipping duplicates and using two-pointer technique
        Arrays.sort(nums);
        // Iterate through the array to find triplets
        // We use index + 2 to ensure we have at least two more elements to form a
        // triplet

        for (var index = 0; index + 2 < nums.length; index++) {
            // We also skip duplicates by checking if the current element is the same as the
            // previous one
            // This prevents counting the same triplet multiple times
            // Skip duplicates for the current index
            // This ensures that we do not consider the same number at the current index
            // again

            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }

            // Initialize two pointers: left and right
            // Left starts just after the current index, and right starts at the end of the
            // array
            int left = index + 1;
            int right = nums.length - 1;

            // Use a while loop to find pairs that, together with the current number,
            // sum to zero
            while (left < right) {
                // Calculate the sum of the current number and the two pointers
                // If the sum is zero, we found a valid triplet
                final int sum = nums[index] + nums[left] + nums[right];
                // If the sum is zero, add the triplet to the result list
                // We also skip duplicates for the left and right pointers to ensure unique
                if (sum == 0) {
                    // Add the triplet to the result list
                    result.add(Arrays.asList(nums[index], nums[left++], nums[right--]));
                    // Move the left pointer to the right and the right pointer to the left
                    while (left < right && nums[left] == nums[left - 1])
                        ++left;
                    // Move the right pointer to the left
                    // This ensures we do not count the same number at the left pointer again
                    while (left < right && nums[right] == nums[right + 1])
                        --right;

                } else if (sum < 0) {
                    // If the sum is less than zero, we need a larger number
                    // Move the left pointer to the right to increase the sum
                    ++left;
                } else {
                    // If the sum is greater than zero, we need a smaller number
                    // Move the right pointer to the left to decrease the sum
                    --right;
                }

            }
        }
        // Return the list of unique triplets that sum to zero
        // This will contain all the unique triplets found in the input array
        return result;

    }

    /**
     * Dynamic Programming approach to find all unique triplets that sum to zero.
     * This is for educational purposes and is not optimal for large arrays.
     *
     * @param nums the input array of integers
     * @return a list of lists containing the unique triplets
     */
    public static List<List<Integer>> threeSumDP(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return result;
        int n = nums.length;
        Arrays.sort(nums);
        // Use a set to avoid duplicate triplets
        java.util.Set<List<Integer>> set = new java.util.HashSet<>();
        // dp[i][j][sum] = true if sum can be formed with j elements from first i numbers
        // To avoid large memory, use a map for sum
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            java.util.Set<Integer> seen = new java.util.HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int complement = -nums[i] - nums[j];
                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], complement, nums[j]);
                    triplet.sort(Integer::compareTo);
                    set.add(triplet);
                }
                seen.add(nums[j]);
            }
        }
        result.addAll(set);
        return result;
    }

}