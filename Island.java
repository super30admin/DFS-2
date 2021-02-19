/*
Time Complexity : m*n 
 Space Complexity : No additional space
recursive space m *n 
m = number of rows
n = number of cols
Worked on Leetcode :  YES
*/
class Solution {
    int level;
    int m;
    int n;
    int dirs[][];
    public int numIslands(char[][] grid) {
        level = 0;
        dirs  = new int [][] {{0,1},{0,-1},{1,0},{-1,0}};
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        m = grid.length;
        n = grid[0].length;
        for(int i =0; i< grid.length;i++) {
            for (int j=0; j< grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i, j);   
                    level++;
                }
                
            }
        }
        
        return level;
    }
    
    private void dfs(char[][]grid, int i , int j) {
             if( grid[i][j] == '0') {
                    // level++;
                    return;
                }
                if(grid[i][j] == '1') {
                    grid[i][j] = '2';
            }
        

        
        for(int [] dir : dirs) {
            int r = dir[0] + i;
            int c  = dir[1] + j;
            if(r>=0 && r< m && c >=0  && c < n && grid[r][c] != '2') {
                dfs(grid, r,c);    
            } 
            
        }
    }
}
