/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/binary-watch/
 */ 

public class BinaryWatch {
    
    public void getHours(int hours, List<Integer> hourList, boolean[] mask, int start){
        if(start > mask.length) return; 
        
        int element = 0, one = 1;
        if(hours == 0){
            for(int i=0; i<=3; i++){
                if(mask[i]){
                    element = element | one; 
                }
                one = one << 1; 
            }
            if(element < 12)
                hourList.add(element);
            return; 
        }
        
        for(int i=start; i<=mask.length-1; i++) {
            mask[i] = true; 
            getHours(hours-1, hourList, mask, i+1); 
            mask[i] = false;
        }
    }
    
    public void getMinutes(int minutes, List<Integer> minuteList, boolean[] mask, int start){
        if(start > mask.length) return; 
        
        int element = 0, one = 1;
        if(minutes == 0){
            for(int i=0; i<=5; i++){
                if(mask[i]){
                    element = element | one; 
                }
                one = one << 1; 
            }
            if(element < 60)
                minuteList.add(element);
            return; 
        }
        
        for(int i=start; i<=mask.length-1; i++) {
            mask[i] = true; 
            getMinutes(minutes-1, minuteList, mask, i+1); 
            mask[i] = false;
        }
    }
    
    public List<String> readBinaryWatch(int n) {
        List<String> list = new LinkedList<String>(); 
        if(n >=10) {
            return list; 
        }
        for(int hours=0; hours<=3; hours++){
            int minutes = n - hours; 
            if(minutes >= 6) {
                continue; 
            }
            
            boolean[] hourMask = new boolean[4]; 
            List<Integer> hourList = new LinkedList<Integer>(); 
            getHours(hours, hourList, hourMask, 0); 
            
            boolean[] minuteMask = new boolean[6]; 
            List<Integer> minuteList = new LinkedList<Integer>(); 
            getMinutes(minutes, minuteList, minuteMask, 0); 
            
            for(int i : hourList) {
                for(int j : minuteList){
                    StringBuilder sb = new StringBuilder();
                    sb.append(i); 
                    sb.append(":"); 
                    if(j <= 9) {
                        sb.append(0);
                    }
                    sb.append(j);
                    list.add(new String(sb)); 
                }
            }
            minuteList.clear(); 
        }
        
        return list; 
    }
}