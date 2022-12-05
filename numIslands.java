// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
class Solution {
    int m, n;;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
         m= grid.length;
        n= grid[0].length;
        int res=0;
        dirs=new int[][]{{-1,0} , {1,0} , {0,-1} , {0,1}}; //U D L R   
        
        //DFS Solution
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return res;
    }
    
    private void dfs(char[][] grid, int r, int c){
        //base
        if(r<0 || c<0 || r==m || c==n || grid[r][c]=='0') return;
        
        //logic
        grid[r][c]='0';
            for(int[] dir:dirs){
                    int rn= r + dir[0];
                    int cn= c + dir[1];
                    dfs(grid,rn,cn);
            }
        }
    
}