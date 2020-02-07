// S30 Big N Problem #64 {Medium}
// 200. Number of Islands
// Time Complexity :O(m*n)
// Space Complexity :O(m*n) {recursive stack} (worst case when all are zeroes)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
class Solution {
    //int count=0;
    //Queue<int []> q=new LinkedList<>();
    int m=0;
    int n=0;
    int [][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int count=0;
        m=grid.length;
        if(grid==null || m==0) return count;
        n=grid[0].length;
        
        
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
    
    
    private void dfs(char[][] grid, int r, int c){
        //base  case
        if(r<0 || r>=m || c<0 ||c>=n || grid[r][c]=='0') return;
        
        //logic
        grid[r][c]='0';
        for(int [] dir:dirs){
            int rn=r+dir[0];
            int cn=c+dir[1];
            //q.add(new int []{i,j});
            dfs(grid,rn,cn);
        }
        
    }
}