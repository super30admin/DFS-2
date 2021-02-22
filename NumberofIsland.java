// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//We are using DFS at every element is that element is 1 and making it 0 and increasing the count of no of islands

class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,n,m);
                    count++;
                }
                
            }
        }
        return count;
    }
    
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(char[][] grid,int i,int j,int n, int m){
        grid[i][j] ='0';
        
        for(int[] dir:dirs){
            int r = dir[0]+i;
            int c = dir[1]+j;
            
            if(r>=0&&r<n&&c>=0&&c<m&&grid[r][c]=='1'){
                dfs(grid,r,c,n,m);
            }
        }        
    }
}