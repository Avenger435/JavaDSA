package com.java.dsa.google;

public class NumArray {

	private int[] nums;
	private int[] tree;

	public NumArray(int[] nums) {
		this.nums = nums;
		this.tree = new int[nums.length + 1];
		// build tree
		for (int i = 0; i < nums.length; i++) {
			updateTree(i + 1, nums[i]);
		}
	}

	private void updateTree(int index, int val) {
		while (index < tree.length) {
			tree[index] = val;
			index += index & (-index);
		}
	}

	private int prefixSum(int index) {
		int sum = 0;

		while (index > 0) {
			sum += tree[index];
			index -= index & (-index);
		}
		return sum;

	}

	public void update(int index, int val) {
		int diff = val - nums[index];
		nums[index] = val;
		updateTree(index + 1, diff);
	}

	public int sumRange(int left, int right) {
		return prefixSum(right + 1) - prefixSum(left);
	}

	public static void main(String[] args) {

		int[] nums = { 1, 3, 5 };

		int index = 0;
		int val = 2;
		int left = 1, right = 2;

		NumArray obj = new NumArray(nums);
		obj.update(index, val);
		int param_2 = obj.sumRange(left, right);
		System.out.println(param_2);
	}
}
