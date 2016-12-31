/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/android-unlock-patterns/
 */ 

public class AndroidUnlockPattern {
    
    private int DFS(boolean[] visited, int[][] skip, int current, int remaining) {
        //if(remaining < 0) return 0; 
        if(remaining == 0) return 0; 
        if(remaining == 1) return 1;
        visited[current] = true; 
        int val = 0; 
        for(int i=1; i<=9; i++){
            if(!visited[i] && (skip[current][i] == 0 || visited[skip[current][i]])) {
                val += DFS(visited, skip, i, remaining-1); 
            }
        }
        visited[current] = false; 
        return val; 
    }
    
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10]; 
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;  
         
        boolean[] visited = new boolean[10]; 
        int count = 0; 
        for(int i=m; i<=n; i++){
            count += DFS(visited, skip, 1, i)*4; // Corners 
            count += DFS(visited, skip, 2, i)*4; // Middle 
            count += DFS(visited, skip, 5, i); // Center
        }
        return count; 
    }
}