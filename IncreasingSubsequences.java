/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/increasing-subsequences/
 */ 

public class Increasingsubsequnces {
    public void wrapper(int[] nums, int index, List<List<Integer>> lists, List<Integer> list) {
        
        if(list.size() >= 2) { 
            lists.add(new ArrayList<Integer>(list));
        }
        HashSet<Integer> hs = new HashSet<Integer>();     
        for(int i=index; i<=nums.length-1; i++) {
            if((list.size() == 0 || nums[i] >= list.get(list.size()-1)) && !hs.contains(nums[i])) {
                hs.add(nums[i]);
                list.add(nums[i]);
                wrapper(nums, i+1, lists, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>(); 
        if(nums == null || nums.length < 2) return lists; 
        List<Integer> list = new ArrayList<>(); 
        wrapper(nums,0,lists,list);
        return lists; 
    }
}