// Time Complexity :O(N)
// Space Complexity :O(1) + recursion stack
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class NumberOfIsland {
    public int numIslands(char[][] grid) {
        if(null == grid || 0 == grid.length){return 0;}
        int islands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if('1' == grid[i][j]){
                    islands++;
                    System.out.println();
                    dfs(grid,i,j);
                }
            }
        }
        return islands;
    }
    int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(char[][] matrix, int i, int j){
        matrix[i][j] = '0';
        for(int dir[]: dirs){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] != '0'){
                dfs(matrix,x,y);
            }
        }
    }
}