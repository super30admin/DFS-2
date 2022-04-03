class NumberOfIslands {
  /**
    Approach - 2 DFS
    
    Time Complexity : O(m * n)
    
    Exact Time Complexity: O(m * n) + O(m * n)
    
    Space complexity: O(m * n)
        The recursive stack can grow as big as O(m * n), when all elements in matrix are '1'

    Were you able to solve this on leetcode? Yes
    
    */
    int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
    void dfs(char[][] grid, int x, int y, int count){
        // base
        if(x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] != '1'){
            return;
        }
        
        // logic
        // count++;
        grid[x][y] = '0';
        
        for(int[] dir : dirs){
            int nr = dir[0] + x;
            int nc = dir[1] + y;
            dfs(grid, nr, nc, count);
        }   
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    // grid[i][j] = '0';
                    dfs(grid, i, j, count);
                }
            }
        }
        
        return count;
    }
    
    /**
    Approach - 1 BFS
    
    Time Complexity : O(m * n)
    
    Exact Time Complexity: O(m * n) + O(m * n)
    
    Space Complexity: O(Math.min(m, n))
     Explanation: At any given point, we would only have Math.min(m, n) number of elements in the queue. 
    
    */
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        
        int islandCount = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    islandCount++;
                    grid[i][j] = '0';
                    queue.add(new int[]{i, j});
                    
                    // go breadth first and make all connected islands 0
                    while(!queue.isEmpty()){
                        int[] curr = queue.remove();
                        for(int[] dir : dirs) {
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];
                            
                            if(nr >= 0 && nc >=0 && nr < m && nc < n && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                queue.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        
        return islandCount;
    }
}
