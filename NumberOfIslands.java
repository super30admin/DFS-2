//Time Complexity: O(n2) 
//Space Complexity: O(1)

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                // if the value is '1' than do dfs and increment the count because we have encountered the island
                if(grid[i][j] == '1'){
                    helper(grid, i, j);
                    count++;
                }
            }
        }
        return count;        
    }
    
    int[][] directions = new int[][]{{0,-1}, {-1,0}, {0,1}, {1,0}};
    public void helper(char[][] grid, int i, int j){
        // make element from 1 -> 0
        grid[i][j] = '0';
        for(int[] dir: directions){
            // move up, down, right left
            int r = dir[0]+i;
            int c = dir[1]+j;
            // now check at new index if its one then recurse
            if(r>=0 && r< grid.length && c>=0 && c<grid[r].length&& grid[r][c] == '1')
                helper(grid, r, c);
        }
    }
}