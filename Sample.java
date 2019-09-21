// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach: Idea is to group all connected ones together and see how many such groups exist.
// DFS helps to find all connected 1s, the ones that aren't visited during the traversal are not connected.
// Run DFS, whenever we visit a 1, we mark it as 0. Do the same for all 1s in matrix.
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='0') return;
        grid[i][j]='0';
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        
    }
}
