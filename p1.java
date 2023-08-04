// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

//DFS

class Solution {
    //directions array
    int[][] dirs;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dirs = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};
        //Count the number of islands
        int count =0;

        //Go over all the elements in the grid
        //Call DFS if you find a 1
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    // grid[i][j] == '0'
                    dfs(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, int m, int n){
        //base condition
        //If element is equal to '1', make it as zero so we won't visit it again
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == '0') return;
        else{
            grid[i][j] = '0';
        }

        //Call DFS on neighboring elements
        for(int[] dir: dirs){
            int k = i+dir[0];
            int l = j+dir[1];
            dfs(grid, k, l, m, n);
        }

    }
}