BFS Solution

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int count = 0;
        int [][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        Queue<int [] > q = new LinkedList<>();
        int m = grid.length; 
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    q.add(new int [] {i,j});
                    count++;
                    grid[i][j] = '0';
                    //calling bfs for every '1' encounter 
                    while(!q.isEmpty()){
                        int [] curr = q.poll();
                        for(int[] d : dirs){
                            int r = d[0] + curr[0];
                            int c = d[1] + curr[1];
                            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){
                                q.add(new int [] {r, c});
                                grid[r][c] = '0';
                            } 
                        }
                        
                    }
                    
                }
            }
        }
        return count;
    }
}

========================================================================================
========================================================================================

DFS Solution

class Solution {
        int [][] dirs ;
        int count = 0;
    public int numIslands(char[][] grid) {
        if(grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        dirs = new int [][] {{1, 0},{-1, 0},{0, 1},{0, -1}};
        
        int m = grid.length; 
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m, n);
                    
                }
            }
        }
        return count;
    }
    
    private void dfs(char [][]grid, int i, int j, int m, int n){
        //base case 
        if(i < 0 || i == m || j < 0 || j == n || grid[i][j] != '1') return;
        
        //logic
        grid[i][j] = '0';
        for(int [] d : dirs){
            int r = d[0] + i;
            int c = d[1] + j;
            dfs(grid, r, c, m, n);
        }
    }
}
