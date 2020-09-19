/*
 * #200. Number of Islands
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]

Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]

Output: 3

 */


/*
 *e.g: [
 *[1 1 1 1 1],
 *[1 1 1 1 1],
 *[1 1 1 1 1],
 *[1 1 1 1 1]
 *]
 *O (m*n) -> To traverse through each cell in a matrix
 *O (m*n) -> for above example, since all the cells are land '1', recursive function will be called on each cell to explore all its branches/directions
 * Time Complexity: O (m*n) + O (m*n)
 * 
 *e.g: [
 *[1 1 1 1 1],
 *[1 1 1 1 1],
 *[1 1 1 1 1],
 *[1 1 1 1 1]
 *]
 *In this case, we will call recursion on each cell to explore all the branches, so all the elements in matrix will be stored in recursive stack
 * Space Complexity: O (m*n) 
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.DFS2;

public class NumberOfIslands {
	 public int numIslands(char[][] grid) {
	        
	        // #1. Base condition
	        if(grid == null || grid.length == 0 || grid[0].length == 0){
	            return 0;
	        }
	        
	        // #2. Initialize number of islands count to 0
	        int noOfIslands = 0;
	        
	        // #3. Traverse through each cell of a character 2D matrix
	        /*
	        * 1. For a cell, check if it is a land -> '1'
	        *       - If yes, means we encountered new 1 which marks start of a new island, increment the island count and make recursive call on that cell (explore all branches from that cell in DFS) and inside recursive function, mark the cell as visited
	        *       - If not, meaning either it is visited or it is a water -> '0', don't process go to next cell until we find '1' or done traversing all the cells in matrix
	        * 2. If we find a new '1', then repeat step 1.   
	        *    else, after done traversing all the cells in matrix, return number of islands
	        */
	        
	        for(int i = 0; i < grid.length; i++){
	            for(int j = 0; j < grid[0].length; j++){
	                if(grid[i][j] == '1'){
	                    noOfIslands++;
	                    recurr(grid, i, j);
	                }
	            }
	        }
	        
	        return noOfIslands;
	        
	    }
	    
	    // Global directions array to explore all four directions from a cell in matrix
	    int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
	    
	    public void recurr(char[][] grid, int i, int j){
	        // Mark the cell as visited
	        grid[i][j] = '2';
	        
	        // explore all the branches/directions
	        for(int[] dir : dirs){
	            // compute the 'i'th and 'j'th index of the direction to explore
	            int r = i + dir[0];
	            int c = j + dir[1];
	            
	            // Check if the direction to explore is not outofbounds and the cell in that direction is a land -> '1', if yes, then only make a recursive call on that cell (in one of the four directions)
	            // If not a land '1', then control will be returned to calling function (numIslands)
	            // Then, the for loop will again run starting from current ith and jth index until it finds a new '1'.
	            // Once, a new '1' is found, the count of islands will be incremented and recursive call on that cell will be made. 
	            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1'){
	                recurr(grid, r, c);
	            }
	            
	        } 
	        
	    }
	    
}
