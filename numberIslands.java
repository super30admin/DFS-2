// Time Complexity : O(MxN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int numIslands(char[][] grid) {
	//edge
        if(grid == null || grid.length == 0) return 0;   
    
        int numIslands = 0;    //Calculate no. of islands
        for(int i = 0; i < grid.length; i++){		
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){			// find all the connected 1's or the single 1 that constitute to an island count
                    numIslands += dfs(grid, i, j);	// recursively find the islands 
                }
            }
        }
        return numIslands;
    }
    private int dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0'){ 
            return 0;
        }
        grid[i][j] = '0';		// after traversed through the array once, replace 1 with 0, so we don't traverse through the same again.
        //Down
        dfs(grid, i + 1, j);
        //Up
        dfs(grid, i - 1, j);
        //Right
        dfs(grid, i, j + 1);
        //Left
        dfs(grid, i, j - 1);

        return 1;		// return 1 if traversed through all the elements
    }
}