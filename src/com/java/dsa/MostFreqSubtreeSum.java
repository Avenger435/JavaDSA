package com.java.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.dsa.util.TreeNode;

public class MostFreqSubtreeSum {

	public static void main(String[] args) {
		MostFreqSubtreeSum obj = new MostFreqSubtreeSum();
		Integer[] arr = { 5, 2, -3 };
		TreeNode root = TreeNode.createTreeFromArray(arr);
		int[] result = obj.findFrequentTreeSum(root);
		System.out.println(Arrays.toString(result));
	}

	Map<Integer, Integer> sumCount = new HashMap<>();
	int maxFreq = 0;

	public int[] findFrequentTreeSum(TreeNode root) {
		dfs(root);
		System.out.println(sumCount);
		List<Integer> result = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : sumCount.entrySet()) {
			if (entry.getValue() == maxFreq) {
				result.add(entry.getKey());
			}
		}
		return result.stream().mapToInt(i -> i).toArray();
	}

	private int dfs(TreeNode node) {
		if (node == null)
			return 0;
		int leftSum = dfs(node.left);
		int rightSum = dfs(node.right);
		int currentSum = node.val + leftSum + rightSum;
		sumCount.put(currentSum, sumCount.getOrDefault(currentSum, 0) + 1);
		maxFreq = Math.max(maxFreq, sumCount.get(currentSum));
		return currentSum;

	}
}