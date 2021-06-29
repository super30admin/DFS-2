// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Use DFS to count the number of islands inthe given grid
// when we find a '1' make all the surrounding '1' '0' to avoid considering them again 
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i =0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] ==  '1')
                {
                    count++;
                    checkSides(grid,i,j);
                }
            }
        
        return count;
    }
    
    public void checkSides(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0' )
            return;
        
        grid[i][j] = '0';
        checkSides(grid,i+1,j);
        checkSides(grid,i-1,j);
        checkSides(grid,i,j+1);
        checkSides(grid,i,j-1);
    }
}