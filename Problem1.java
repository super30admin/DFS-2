// Time Complexity : O(M*N)
// Space Complexity : O(min(M,N))
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {

    public int numIslands(char[][] a) {
        
        int count = 0;
        
        if(a == null) {
            return count;
        }
        
        for(int i = 0; i< a.length; i++){
            for(int j = 0; j<a[0].length; j++){
                
                if(a[i][j] == '1'){
                    count++;
                    coverIsland(a, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void coverIsland(char[][] a, int i, int j){
        
        if(i < 0 || i>= a.length || j <0 || j>= a[0].length || 
           a[i][j] == '0'){
            return;
        }
        a[i][j] = '0';
        
        coverIsland(a, i+1, j);
        coverIsland(a, i-1, j);
        coverIsland(a, i, j+1);
        coverIsland(a, i, j-1);
    }
    }