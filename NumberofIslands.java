// Time Complexity : O(N) - As we traverse through all the elements in the grid
// Space Complexity : O(N) - As we use a internal stack for DFS function
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int islands = 0 ;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == '1'){
                    DFS(grid,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void DFS(char[][] grid,int i,int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        DFS(grid,i + 1,j);
        DFS(grid,i,j + 1);
        DFS(grid,i - 1,j);
        DFS(grid,i,j - 1);
    }
}
// Your code here along with comments explaining your approach