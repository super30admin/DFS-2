// Time Complexity : O(n)
// Space Complexity : O(n) considering the recursive stack.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class IslandCount {
    
    public int numIslands(char[][] grid) {
        
        int numIsland = 0;
        
        if(grid == null || grid.length==0) return numIsland;
        
        // Directions array to navigate in 4 directions from the given cell.
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        // Traverse all the cells in the given grid.
        // If the value of the grid is land then start a bfs to process all the cells tied with the current island.
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                numIsland += dfs(dirs, grid, i, j);
            }
        }
        
        // Finally return the total count of the island found.
        return numIsland;
    }
    
    public int dfs(int[][] dirs, char[][] grid, int i, int j){
        // base case
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0'){
            return 0;
        }
        
        // logic
        // Update the neighboring cell value to 0.
        grid[i][j]='0';
        
        // Traverse all the cells that are connected to given island.
        for(int[] dir: dirs){
            dfs(dirs, grid, i+dir[0], j+dir[1]);
        }
        
        // Once the current island is processed return 1.
        // This indicated that 1 island is processed.
        return 1;
    }

}
