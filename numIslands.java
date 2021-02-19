// Time Complexity : O(m*n)
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    
    int dir[] = new int[]{1,-1};
    
    public int numIslands(char[][] board) {

     int ans = 0;
         
        // DFS for every 1 found
        for(int i = 0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == '1') {
                    dfs(board,i,j);
                    ans++;
                }
                
            }
        }
        return ans;
    }
    
    public void dfs(char[][] b, int i,int j) {
        
        if(i==b.length || j==b[0].length || i<0 || j<0 || b[i][j] == '0') return;
        
        b[i][j] = '0';
        
        for(int d : dir) {
            dfs(b,i+d,j);
            dfs(b,i,j+d);
        }
    }
}
