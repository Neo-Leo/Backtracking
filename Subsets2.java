/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/subsets-ii/
 */ 


public class Subsets2 {
    public void wrapper(int[] nums, int start, List<Integer> list, List<List<Integer>> lists){
        lists.add(new ArrayList<Integer>(list)); 
        for(int i=start; i<=nums.length-1; i++){
            if((i!=start) && (nums[i]==nums[i-1])) continue; 
            list.add(nums[i]);
            wrapper(nums,i+1,list,lists); 
            list.remove(list.size()-1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return lists;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>(); 
        wrapper(nums,0,list,lists);
        return lists;
    }
}