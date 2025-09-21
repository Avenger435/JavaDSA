package com.java.dsa.faangmustdo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElements {

	public static void main(String[] args) {

		int[] nums = { 5, 2, 5, 5, 2, 1, 4, 4, 2, 4 };
		int[] result = topKFrequent(nums, 3);

		System.out.println(Arrays.toString(result));

	}

	public static int[] topKFrequent(int[] nums, int k) {

		// step 1 : freq map
		Map<Integer, Integer> freqMap = new HashMap<>();

		for (int num : nums)
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

		// step2 bucket Array (index==freq)
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new ArrayList[nums.length + 1];
		for (int key : freqMap.keySet()) {
			int freq = freqMap.get(key);

			if (buckets[freq] == null) {
				buckets[freq] = new ArrayList<>();
			}
			buckets[freq].add(key);
		}

		System.out.println(Arrays.toString(buckets));

		// step 3: collect top k elements
		List<Integer> result = new ArrayList<>();
		for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
			if (buckets[i] != null) {
				result.addAll(buckets[i]);
			}
		}

		// Step 4: return first k elements
		return result.stream().limit(k).mapToInt(i -> i).toArray();
	}

}
