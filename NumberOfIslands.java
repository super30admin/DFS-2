// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int r, int c){
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        for(int[] d:dirs){
            int nr = d[0]+r;
            int nc = d[1]+c;
            if(nr >=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc] == '1'){
                grid[nr][nc] = '0';
                dfs(grid,nr,nc);
            }
        }
    }
}
