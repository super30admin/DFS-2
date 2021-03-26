class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        
        
        int count  = 0;
        int m= grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int r, int c){
         int m= grid.length;
         int n = grid[0].length;
        //base case
        if(r < 0 || r == m || c < 0 || c == n || grid[r][c] == '0'){
            return;
        }
        
        //logic
        grid[r][c] = '0';
        for(int[] dir: dirs) {
            int nr = r+ dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc);
        }
    }
}

// Time Complexity: O(n*m)
//Space Complexity: O(min(m,n))