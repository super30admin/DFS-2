/*
Time Complexity : O(M*N) , need to visit each cell in the matrix at least once
Space Complexity : O(M*N), all cells can be in the recursion stack in the worst case
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Approach :

We can solve it using dfs, by starting exploring a cell that has value 1. If its neighbors also have value continue exploring.
Each 1 we encounter, we can make it zero so that we don't have to visit is again. Each time we get a 1 we increment the island count,
check its neighbor and mark all connected components as '0'. At the end, return the count.
*/
public class NumberOfIslands {
    int[][] directions = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == '1'){
                    numberOfIslandsDfs(i,j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void numberOfIslandsDfs(int i, int j, char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(i < 0 || i == rows) return;
        if(j < 0 || j == cols) return;
        // Visit the cell only if it is island.
        if(grid[i][j] != '1') return;

        grid[i][j] = '0';
        for (int[] dir : directions){
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            numberOfIslandsDfs(nr, nc, grid);
        }
    }
}
