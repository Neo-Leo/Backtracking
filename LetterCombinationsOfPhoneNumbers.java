/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */ 

public class LetterCombinationsOfPhoneNumbers {
    
    HashMap<Character, String> hm = new HashMap<Character, String>(); 
    
    LetterCombinationOfPhoneNumbers() {
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
    }
    
    public void letterCombinationsWrapper(String digits, int index, StringBuilder sb, List<String> list){
        if(index == digits.length()) {
            list.add(new String(sb));
            return; 
        }
        
        char key = digits.charAt(index); 
        String value = hm.get(key);
        for(int i=0; i<=value.length()-1; i++) {
            sb.append(value.charAt(i));
            letterCombinationsWrapper(digits,index+1,sb,list);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<String>();
        if(digits == null || digits.length() == 0) return list;
        StringBuilder sb = new StringBuilder(); 
        letterCombinationsWrapper(digits,0,sb,list);
        return list; 
    }
}