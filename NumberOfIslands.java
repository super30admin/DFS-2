class Solution {
    int row = 0;
    int col = 0;
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int count = 0;
        
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                    // bfs(grid, i, j, row, col);
                }
            }
        }
        return count;
    }
    
    // Time Complexity: O(mn)
    // Space Complexity: O(mn)
    private void dfs(char[][] grid,int i,int j){
        if(i < 0 || j < 0 || i >= row || j >= col) return;
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
        }
    }

    // Time Complexity: O(mn)
    // Space Complexity: O(min(m,n))

    private void bfs(char[][] grid,int i,int j, int m, int n){
        Queue<int []> q = new LinkedList<>();
        int dirs[][] = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};


        q.add(new int[]{i,j});
        while(!q.isEmpty()){

            int curr[] = q.poll();

            for(int dir[]: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                if(r >=0 && c>=0 && r<m && c < n && grid[r][c]=='1'){
                    grid[r][c] = '0';
                    q.add(new int[]{r, c});
                }
            }
        }
    }
}