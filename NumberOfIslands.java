//Time Complexity: O(mxn)
//Space Complexity: O(mxn)

class Solution {
    
    //createing a directions matrix that will help us travel in the four directions
    int [][] dirs; 
    
    public int numIslands(char[][] grid) {
        
        //null case check
        if(grid == null || grid.length == 0) return 0;
        
        //calculating the row and column lengths
        int m = grid.length;
        int n = grid[0].length;
        
        //initializing the directions matrix
        dirs = new int [][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        //we'll use this count variable to keep track of the islands
        int count = 0;
        
        //looping through each element of the matrix
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //if the element we encounter is a '1'
                //we increment the count as we have encountered an island
                //we then call the dfs function to iterate to the four directions of that 1
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        //we end the function if the element is out of bounds
        //we also end the function if the element is '0'
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
        
        //now given that the element is a '1'
        //we first change it to a '0' as we move ahead to the four directions
        //this is so that we do not worry about encountoring the same '1' again
        grid[i][j] = '0';
        //using a for loop to move in all four directions
        //and call the dfs function recursively on all of the four neighbours
        for(int [] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c, m, n);
        }
    }
}