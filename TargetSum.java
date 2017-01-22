/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/target-sum/
 */ 


public class TargetSum {
    
    public void wrapper(int[] nums, int[] count, int index, int sum, int S){
        if(index == nums.length) {
            if(sum == S){
                count[0]++; 
            }
            return; 
        }
        wrapper(nums, count, index+1, sum+nums[index], S);
        wrapper(nums, count, index+1, sum-nums[index], S);
    }
    
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0; 
        int[] count = new int[1];
        wrapper(nums,count,0, 0, S);
        return count[0];
    }
}