// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class NumberOfIslandsDFS {
    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        //dfs
        if(grid == null || grid.length == 0){
            return 0;
        }
        int total = 0;

        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};


        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    total++;
                    dfs(grid, i, j);
                }
            }
        }

        return total;
    }

    private void dfs(char[][] grid, int sr, int sc){
        if(sr < 0 || sr == m || sc < 0 || sc == n || grid[sr][sc] == '0'){
            return;
        }

        grid[sr][sc] = '0';
        for(int[] dir: dirs){
            dfs(grid, sr+dir[0],sc+dir[1]);
        }
    }
}
