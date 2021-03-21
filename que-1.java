// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class Solution {
    char[][]islandGrid;
    public int numIslands(char[][] grid) {
        int islands = 0;
        islandGrid =grid;
        for (int i=0; i<grid.length; i++)
            for (int j=0; j<grid[i].length; j++)
                islands += sink(i, j);
        return islands;
    }
    int sink(int i, int j) {
        if (i < 0 || i == islandGrid.length || j < 0 || j == islandGrid[i].length || islandGrid[i][j] == '0')
            return 0;
        islandGrid[i][j] = '0';
        sink(i+1, j); 
        sink(i-1, j); 
        sink(i, j+1); 
        sink(i, j-1);
        return 1;
    }
}