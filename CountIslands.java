// Time Complexity : O(n*m)
// Space Complexity : O(n*m) for recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    recur(grid,i, j);
                    count+=1;
                }
            }
        }
        return count;
    }
    int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};
    private void recur(char[][] grid, int i , int j){
        grid[i][j]='0';
        
        for(int[] dir:directions){
            int r=dir[0]+i;
            int c=dir[1]+j;
            if(r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&grid[r][c]=='1'){
                recur(grid, r,c);
            }
        }
    }
}