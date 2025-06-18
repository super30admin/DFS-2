class Solution {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(n,m,i,j,grid);
                }
            }
        }
        return count;
    }

    private void dfs(int n, int m,int cr, int cc, char grid[][]){
        //base
        if(cr<0 || cc<0 || cr>=n || cc>=m || grid[cr][cc]=='0'){
            return;
        }
        //logic
        grid[cr][cc] = '0';

        for(int[] dir: dirs){
            int nr = dir[0] + cr;   
            int nc = dir[1] + cc;
            dfs(n,m,nr,nc,grid);
        }
    }
}