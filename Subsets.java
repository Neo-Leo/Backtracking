/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/subsets/
 */ 

/*
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if(nums == null){
            return resultList;
        }
        // Sort the array in acsending order
        Arrays.sort(nums);
        
        // Take a number temp, and keep decrementing it till it becomes 0. 
        int bitVector = (int)Math.pow(2,nums.length)-1;
        int temp,i;
        
        while(bitVector >= 0) {
            temp = bitVector;
            i=0;            
            List<Integer> tempList = new ArrayList<Integer>();
            while(temp>0){
                if((temp&1)!=0){
                    tempList.add(nums[i]);
                }
                i++;
                temp=temp>>1;
            }
            resultList.add(tempList);
            bitVector--;
        }
        return resultList;
    }
}
*/

/*
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null){
            return lists;
        }
        // Sort the array in acsending order
        Arrays.sort(nums);
        List<Integer> emptyList = new ArrayList<Integer>(); 
        lists.add(emptyList);
        for(int i=0; i<=nums.length-1; i++){
            List<List<Integer>> tempLists = new ArrayList<List<Integer>>();
            for(List<Integer> list : lists){
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(nums[i]);
                tempLists.add(newList);
            }
            for(List<Integer> list : tempLists){
                lists.add(list);
            }
        }
        return lists;
    }
}
*/


public class Subsets {
    public void wrapper(int[] nums, int start, List<Integer> list, List<List<Integer>> lists){
        lists.add(new ArrayList<Integer>(list)); 
        for(int i=start; i<=nums.length-1; i++){
            list.add(nums[i]);
            wrapper(nums,i+1,list,lists); 
            list.remove(list.size()-1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
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