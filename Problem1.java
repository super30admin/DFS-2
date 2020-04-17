
Time Complexity : O(m*n)
Space Complexity : O(m*n)

class Solution {
    int[] dirX=new int[]{1,-1,0,0};
    int[] dirY = new int[]{0,0,1,-1};
    
    public int numIslands(char[][] grid) {
        
        if(grid==null || grid.length<=0){
            return 0;
        }
        
        int r = grid.length;
        int c = grid[0].length;
        
        int count=0;
        boolean[][] visited = new boolean[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0; j<c;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfs(grid, visited, i,j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, boolean[][] visited, int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4;i++){
            int x_new = x + dirX[i];
            int y_new = y + dirY[i];
            if(x_new >=0 && y_new >=0 && x_new < grid.length && y_new < grid[0].length && !visited[x_new][y_new] && grid[x_new][y_new]=='1'){
                dfs(grid,visited,x_new,y_new);
            }
        }
    }
}