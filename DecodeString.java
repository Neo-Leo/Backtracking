/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/decode-string/
 */ 

public class Solution {
    private StringBuilder wrapper(String s, int[] index){
        StringBuilder current = new StringBuilder();
        while(index[0] <= s.length()-1){
            if(Character.isDigit(s.charAt(index[0]))){
                int count = 0;
                while(index[0] <= s.length()-1 && Character.isDigit(s.charAt(index[0]))){
                    count = count*10 + s.charAt(index[0])-'0';
                    index[0]++; 
                }
                index[0]++; // Skipping the '['
                StringBuilder nested = wrapper(s,index); 
                while(count != 0) {
                    current.append(nested);
                    count--; 
                }
            } else if(s.charAt(index[0]) == ']') {
                index[0]++;
                return current; 
            } else {
                current.append(s.charAt(index[0]++));
            }
        }
        return current; 
    }
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return ""; 
        int[] index = new int[1]; 
        return new String(wrapper(s,index));  
    }
}