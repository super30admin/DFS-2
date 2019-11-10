/*
Author: Akhilesh Borgaonkar
Problem: LC 200. Number of Islands (DFS-2)
Approach: Using recursive DFS approach here to find the neighbors having value 1. If valid island found then increment count and explore its
	neighboring indexes till all surrounded by 0.
Time Complexity: O(m*n) where m and n are lengths of input grid.
Space complexity: O(1) constant. (If we ignore the recursion stack space)
LC verified.
*/

class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        if(m == 0)			//empty grid found
            return 0;
        int n = grid[0].length;
        int islands = 0;	//counter for number of islands in the grid
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){			//if index with 1 value found
                    islands++;					//then increment the counter, 
                    grid[i][j]='0';				//make it 0 to avoid repetitive processing of the same index
                    helper(grid, i, j, m, n);	//call recursive dfs function on the index
                }
            }
        }
        return islands;		//return the count of islands
    }
    
    private void helper(char[][] grid, int i, int j, int m, int n){
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};	//directions array to easy find the neighboring indexes
            
        for(int[] dir : dirs){
        	//generate the indexes of neighbors
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x >=0 && y>=0 && x<m && y<n && grid[x][y]=='1'){		//if the coordinates are valid and value '1' is found 
                grid[x][y] = '0';									//then make it 0
                helper(grid, x, y, m, n);							//and call recursive dfs function on it to explore its further neighbors
            }
        }
    }
}