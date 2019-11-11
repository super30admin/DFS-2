// Time Complexity : O(N)
// Space Complexity : O(1) (O(N) if we take into account recursive stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class Solution {
    int rowLength;
    int columnLength;
    public int numIslands(char[][] grid) {
        rowLength = grid.length;
        if(rowLength == 0) return 0;
        columnLength = grid[0].length;
        int size = 0;
        for(int i = 0; i< rowLength; i++){
            for(int j = 0; j < columnLength; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    size++;
                }
            }
        }
        return size;
    }
    
    private void dfs(char[][] grid, int sr, int sc){
        //base case
        if(sr < 0 || sr >= rowLength || sc < 0 || sc >= columnLength || grid[sr][sc] == '0') return;
        
        grid[sr][sc] = '0';
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int[] dir : dirs){
            int row = dir[0] + sr;
            int col = dir[1] + sc;
            dfs(grid, row, col);
        }
    }
}