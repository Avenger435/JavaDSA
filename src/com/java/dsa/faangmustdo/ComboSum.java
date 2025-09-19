package com.java.dsa.faangmustdo;

import java.util.ArrayList;
import java.util.List;

public class ComboSum {
 
	public static void main(String[] args) {
		ComboSum cSum= new ComboSum();
		int[] nums= {2,3,6,7};
		List<List<Integer>> combinationSum = cSum.combinationSum(nums, 7);
	
		System.out.println("combinationSum: "+combinationSum);
	}
	
	public List<List<Integer>> combinationSum(int[] candidates,int target){
		List<List<Integer>> result= new ArrayList<>();
		backtrack(candidates,target,0 , new ArrayList<>(),result);
		return result;
	}

	private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {

		if(target==0) {
			result.add(new ArrayList<>(current));
			return;
		}
		
		for(int i=start;i< candidates.length;i++) {
			if(candidates[i] <= target) {
				current.add(candidates[i]);
				backtrack(candidates, target- candidates[i],i,current,result);
				current.remove(current.size()-1);
			}
		}
		
	}
}
