// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    //intialize the row an col gloably to be accessed everywhere
    int m; int n;
    public int numIslands(char[][] grid) {
        //edge 
        if(grid == null || grid.length == 0) return 0;
        //get the row 
        m = grid.length;
        n = grid[0].length;
        //have a count to see how many islands there are (whenever we encounter a 1)
        int count = 0;
        //start a for loop to find the 1's in the matrix
        for(int i =  0; i < m; i++){
            for(int j = 0; j < n; j++){
                //see if the val = 1
                if(grid[i][j] == '1'){
                    //found an island increase the count
                    count++;
                    //call dfs to make the surrounding 1's into 0's so we don't run acorss this again in our iteration becasue we have already counted it
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        //base 
        //boundary check
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
        //logic
        //have a directions array to check neihbors
        int [][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        //make the current palce 0
        grid[i][j] = '0';
        //now make all the neigbors 0
        for(int [] direc : dirs){
            int row = direc[0] + i;
            int col = direc[1] + j;
            //call dfs
            dfs(grid, row, col);
        }
        
    }
}