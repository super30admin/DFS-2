// Time Complexity :O(2mn) m and n is the length and breadth of the grid
// Space Complexity : O(mn) m and n is the length and breadth of the grid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int[][] dirs;
    int n, m;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0) return 0;
        dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        n = grid.length; m = grid[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j){
        //base case
        if(i>=n || i<0 || j>=m || j<0 || grid[i][j] == '0') return;
        
        //logic
        grid[i][j] = '0';
        for(int[] dir : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(grid,r,c);
        }
    }
}