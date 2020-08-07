/*
// Time Complexity : O(n) n = all nodes in matrix.
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
//nope

// Your code here along with comments explaining your approach
//if an island found walk it, as we are walking mark walked area as 0.
*/
class Solution {
    public int numIslands(char[][] grid) {
        int ret = 0;

        if(grid.length == 0)
            return ret;

        //look at grid.
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                //if land found walk island.
                //and increase island count.
                if(grid[i][j] == '1'){
                    ret++;
                    walkIsland(grid, i, j);
                }
            }
        }
        return ret;
    }

    private void walkIsland(char[][] grid, int sr, int sc){
        if(sr < 0 || sr >= grid.length ||
           sc < 0 || sc >= grid[0].length ||
           grid[sr][sc] == '0')
            return;

        //mark land as 0 , so we consider it seen.
        //walk neighbour land if any.
        grid[sr][sc] = '0';
        walkIsland(grid, sr, sc+1);
        walkIsland(grid, sr+1, sc);
        walkIsland(grid, sr, sc-1);
        walkIsland(grid, sr-1, sc);
    }
}
