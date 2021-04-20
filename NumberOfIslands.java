/*
Thought Process: 
Use DFS or BFS approach to loop through the entire grid once. Find 1 and start processing. Use directinal 2D array to traverse in bounds and find the one's. If found mark it visited as making it 0. Once we find all one's in that graph come back to main loops and search for next 1. Increment counter here and return it.

TC -> O(V+E) 
SC -> O(V+E) total size of 2D grid
*/

class NumberOfIslands {
    int m=0, n=0;
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null || grid.length==0) return count;
        
        m = grid.length;
        n = grid[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        
        // Made mistake in declaring dirs and had to google search and check professor's video on it.
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int k =0; k<dirs.length; k++){
            int r = i + dirs[k][0];
            int c = j + dirs[k][1];
            if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == '1')
                dfs(grid, r, c);
        }
    }
}