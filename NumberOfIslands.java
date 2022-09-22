// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Loop through the grid, whenever 1 is found, perform dfs. to mark visited sink the island=='0'
check on all four sides, if water found on all sides, increment count
*/
class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && dfs(grid,i,j)) count++;
            }
        }

        return count;
    }

    private boolean dfs(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]=='0') return true;

        grid[i][j]='0';
        boolean top= dfs(grid,i-1,j);
        boolean bottom= dfs(grid,i+1,j);
        boolean left= dfs(grid,i,j-1);
        boolean right= dfs(grid,i,j+1);

        return top && bottom && left && right;
    }
}