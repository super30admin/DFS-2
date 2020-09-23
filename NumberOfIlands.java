// Time Complexity : O(n2) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    recurr(grid,i,j);
                    count+=1;
                } 
            }
        }
        return count;
    }
    
    int[][] dirs ={{-1,0},{1,0},{0,1},{0,-1}};
    
    public void recurr(char[][] grid, int i, int j){
        
        grid[i][j]='0';
        
        for(int[] dir: dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]=='1'){
                recurr(grid,r,c);
            }
        }
    }
}