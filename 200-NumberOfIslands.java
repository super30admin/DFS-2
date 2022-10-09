//Approach-1: Using BFS
//Overall Time Complexity: O(M*N)
//Overall Space Complexity: O(Min(M, N))
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        int count = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    q.add(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] temp = q.poll();
                        for(int[] dir : dirs){
                            int nr = temp[0] + dir[0];
                            int nc = temp[1] + dir[1];
                            
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }
                }                
            }
        }
        
        return count;
     }
}




//Approach-1: Using DFS
//Overall Time Complexity: O(2*(M*N)) = 
//O((M*N) + (M*N)) - One for matrix iteration and another for the DFS 
//Overall Space Complexity: O(M*N)
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        int count = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, m, n, i, j, dirs);
                }                
            }
        }
        
        return count;
     }
    
    
    public void dfs(char[][] grid, int m, int n, int nr, int nc, int[][] dirs){
        if(nr < 0 || nr == m || nc < 0 || nc == n || grid[nr][nc] != '1') return;
        
        grid[nr][nc] = '0';
        for(int[] dir: dirs){
            dfs(grid, m, n, nr+dir[0], nc+dir[1], dirs);
        }
        
        return;
    }
}

