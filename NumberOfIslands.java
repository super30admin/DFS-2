class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    callBFS(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void callBFS(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='0' ){
            return;
        }
        grid[i][j]='0';
        callBFS(grid,i+1,j);
        callBFS(grid,i-1,j);
        callBFS(grid,i,j+1);
        callBFS(grid,i,j-1);
    }
    
}

    private void dfs(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0')
            return;
        grid[i][j] = '0';
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] dir : dirs){
            int r = dir[0]+i;
            int c = dir[1]+j;
            dfs(grid, r, c);
        }
    }

Time complexity - O(M*N) where M is the number of rows, N is the number of columns
Space complexity - O(M*N)
