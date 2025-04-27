// Time Complexity : O(m * n) where m = no of rows and n = no of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Traverse each cell of the grid.
//   - When a cell with value '1' is found, increment the island count.
//   - Perform DFS to mark all connected '1's as '0' (visited).
//   - Continue traversing the grid.

public class NumberOfIslands {
    //using DFS
    public int numIslands(char[][] grid) {
        int count = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    DFS(grid, i ,j);    //call DFS function with that start point
                }
            }
        }

        return count;
    }

    private void DFS(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';   //change 1 to 0 so that we can know that it is visited
        //next call DFS recursively for up, down, left, right cells
        DFS(grid, i-1, j);    //up
        DFS(grid, i+1, j);    //down
        DFS(grid, i, j-1);    //left
        DFS(grid, i, j+1);    //right
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int numberOfIslands = solution.numIslands(grid);
        System.out.println("Number of islands: " + numberOfIslands);
    }
}


