public class NumberOfIslands {
    //Time complexity :O(M×N) where M is the number of rows and N is the number of columns.
    //
    //Space complexity : worst case O(M×N)
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        dirs = new int[][]{{1,0},{0,1},{-1,0}, {0,-1}};
        int count = 0;
        for(int i=0; i < m;i++){
            for(int j=0; j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, int m, int n){
        //base
        if(i <0 || j<0 || i==m || j==n || grid[i][j]=='0' )return;
        //logic
        grid[i][j] = '0';
        for(int[] dir: dirs){
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid, nr, nc, m, n);
        }
    }
}
