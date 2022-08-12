// Time Complexity : o(mn)
// Space Complexity : o(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    int[][] dirs;
    int m,n;
    public int numIslands(char[][] grid) {
        if(grid==null) return 0;
        Queue<int[]> q = new LinkedList<>();
        m=grid.length;
        n=grid[0].length;
        int count=0; //number of island
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}}; // U D L R t 
        
        for(int i=0;i<m;i++){   // traversing matrix i(row) j(column)
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){  // finding first one two start bfs
                    count++; //increasing island count
                    //grid[i][j]='0';
                    dfs(grid,i,j);
                }                
            }
        }
        return count;
    }
    private void dfs(char[][] grid,int r,int c){
        //base case
        if(r<0 || c<0 || r==m || c==n || grid[r][c]!='1') return;
        
        
        //logic
        grid[r][c]='0';
        for(int[] dir : dirs){
            int nr = dir[0]+r;
            int nc = dir[1]+c;
            dfs(grid,nr,nc);
        }
    }
}