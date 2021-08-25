/* Time Complexity : O(m*n) 
   Space Complexity : O(m*n)  
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    int[][] dirs;
    int count;
    public int numIslands(char[][] grid) {
        count=0;
        dirs=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int r,int c){
        grid[r][c]='0';
        for(int[] dir:dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1')
            dfs(grid,nr,nc);
        }
    }
}