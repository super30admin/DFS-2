// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//200. Number of Islands
//https://leetcode.com/problems/number-of-islands/

class Solution {
    // DFS approach
    // time: O(mxn)
    // space: O(mxn)
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numIslands(char[][] grid) {
        int count = 0; // counts the number of islands
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        // base
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0')
            return;

        // logic

        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            dfs(grid, row, col, m, n);
        }
    }
}

/*
 * class Solution {
 * Queue<int []> q = new LinkedList<>();
 * int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
 * 
 * public int numIslands(char[][] grid) {
 * 
 * int count = 0; // counts the number of islands
 * int m = grid.length;
 * int n = grid[0].length;
 * for(int i=0; i<m; i++){
 * for(int j=0; j<n; j++){
 * if(grid[i][j] == '1'){
 * count++;
 * //System.out.println(grid[i][j] + " " + i + " " + j);
 * bfs(grid, i, j, m, n);
 * }
 * }
 * }
 * return count;
 * }
 * 
 * private void bfs(char[][] grid, int i, int j, int m, int n){
 * 
 * q.add(new int[]{i,j});
 * grid[i][j] = '0';
 * int tempI = i;
 * int tempJ = j;
 * while(!q.isEmpty()){
 * //int size = q.size();
 * //for(int k = 0; k< size; k++){
 * int c = 0;
 * for(int l : q.peek()){
 * if(c == 0)tempI = l;
 * if(c == 1)tempJ = l;
 * c++;
 * }
 * for(int[] dir : dirs){
 * int row = tempI + dir[0];
 * int col = tempJ + dir[1];
 * if((row >= 0 && col >= 0 && row < m && col < n) && (grid[row][col] == '1')){
 * q.add(new int[]{row,col}); //System.out.println(grid[row][col] + " " + row +
 * " " + col);
 * grid[row][col] = '0';
 * }
 * }
 * q.remove();
 * //}
 * }
 * }
 * }
 */