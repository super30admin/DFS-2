/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent 
lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

//DFS Solution
// T: O(N * M)
// S: O(1)

class Solution {
    
    // Declare variables as global to save memory by not storing in stack
    
    int rowLength;
    int colLength;
    char[][] g;
    int count = 0;
    
    public int numIslands(char[][] grid) {
        
        // When we come across 1, mark it as visited by making it '0' and check all adjacent sides.
        
        rowLength = grid.length;
        if(rowLength == 0) return 0;
        
        colLength = grid[0].length;
        if(colLength == 0)  return 0;
        
        g = grid;
        
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                
                if(g[i][j] == '1'){
                    dfs(i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void dfs(int i, int j){
        if(i > rowLength - 1 || j > colLength - 1 || i < 0 || j < 0 || g[i][j] == '0')  return;
        
        g[i][j] = '0';
        
        dfs(i - 1, j);
        dfs(i, j - 1);
        dfs(i + 1, j);
        dfs(i, j + 1);
    }
}