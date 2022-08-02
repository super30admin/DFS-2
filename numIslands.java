//TC - O(nxm);
//SC - O(nxm);

class Solution {
    int n,m;
    int[][] drs;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m= grid[0].length;
        int count=0;
        
        drs = new int [][] {{1,0},{0,1},{-1,0},{0,-1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);                    
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int i, int j, char[][] grid){
        
        //base
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] == '0') return;
        //logic
        grid[i][j] = '0';
        
        for(int[] dr : drs){
            int nr = dr[0] + i;
            int nc = dr[1] + j;
            
            dfs(nr,nc,grid);
        }
    }
}