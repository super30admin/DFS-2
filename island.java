// Time Complexity : O(MxN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid == null){		// base case
            return 0;
        }
        
        int total = 0;	// to calculate total islands
        
        for(int i = 0; i < grid.length; i++){			// traverse through the whole array to find the islands
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){		// find all the connected 1's or the single 1 that constitute to an island count
                    total += helper(grid, i, j);		// recursively find the islands 
                }
            }
        }
        return total;
    }
    
    private int helper(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){		// base case
            return 0;
        }
        
        grid[i][j] = '0';		// once traversed through the array, replace the 1 with 0, so that we don't traverse through the co-ordinates again.
        
        helper(grid, i + 1, j);		// bottom
        helper(grid, i - 1, j);		// up
        helper(grid, i, j + 1);		// right
        helper(grid, i, j - 1);		// left
        
        return 1;		// return 1 if traversed through all the elements
    }
    
}