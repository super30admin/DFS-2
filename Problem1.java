// Time Complexity : T:O(N) , N is total size of grid
// Space Complexity : S:O(N)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N


// Your code here along with comments explaining your approach

class Solution {
    int R;
    int C;
    public int numIslands(char[][] grid) {

        R = grid.length;
        C = grid[0].length;

        int count = 0;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]=='1'){ //check for island
                    dfs(i,j,grid);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j,char[][] grid){
        if(i<0 || j<0 ||i>=R ||j>=C || grid[i][j]=='0')
            return;

        grid[i][j]='0'; //mark visited

        dfs(i+1,j,grid); //4 directions
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
        dfs(i-1,j,grid);
    }
}