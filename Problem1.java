package DFS-2;

public class Problem1 {
    int[][] dirs;
    int m,n;
    public int numIslands(char[][] grid) {
        this.dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        this.m=grid.length;
        this.n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        grid[i][j]='0';
        for(int[] dir: dirs){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1'){
                dfs(grid,nr,nc);
            }
        }
    }
}
