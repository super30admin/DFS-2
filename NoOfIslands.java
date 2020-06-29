// Time Complexity :
// BFS : 0(2*m*n), m : row length, n : col length
// DFS : 0(m*n), m : row length, n : col length
// Space Complexity : 
// BFS : 0(min(m,n))
// DFS : 0(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//Solution : BFS
class Solution {
    public int numIslands(char[][] grid) {
        //if grid is null or empty return 0
        if(grid == null || grid.length == 0) return 0;
        //row and column length of grid
        int m = grid.length;
        int n = grid[0].length;
        //initiliaze count to 0
        int count = 0;
        //Queue (add first grid cell with value 1, find connected components (cells with value 1))
        Queue<int[]> q = new LinkedList<>();
        //4-directional array to find the neighbors (down,top,right,left)
        int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        
        //for loop to iterate the grid
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //first 1 cell 
                if(grid[i][j] == '1') {
                    //make it = 0
                    grid[i][j] = '0';
                    //add it to queue
                    q.add(new int[] {i,j});  
                    //while q is not empty, find the neighbors of the cell in front of queue
                    //each time queue becomes empty, there are no more grid cells in that island
                    //so control goes back to the for loops and the matrix is 
                    //iterated to find the next cell with value 1
                    //we make each cell with value 1, 0 as we add to queue, 
                    //to avoid visiting and counting it as an island
                    while(!q.isEmpty()) {
                        //get the front of queue
                        int[] currgrid = q.poll();
                        //find its neighbors
                        for(int[] dir : dirs) {
                            //position of the neighbor cells
                            int r = dir[0] + currgrid[0];
                            int c = dir[1] + currgrid[1];
                            //check for boundary condition and if cell value = 1
                            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {
                                //make it = 0
                                grid[r][c] = '0';
                                //and add it to queue
                                q.add(new int[] {r,c});                                                           
                            }                         
                        }
                    } //increase the count of island (when q becomes empty, a island is found)
                    //no more cells with value 1 can be traversed using this island cells
                    count++; 
                } 
            }
        } //return count value (number of Islands) 
        return count;         
    }
}





//////////////////////////////





//Solution : DFS
class Solution {
    int m; int n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        //if grid is null or empty return 0
        if(grid == null || grid.length == 0) return 0;
        //row and column length of grid
        m = grid.length;
        n = grid[0].length;
        //initiliaze count to 0
        //not globally declared as we count/update in this function itself
        int count = 0; 
        //4-directional array to find the neighbors (down,top,right,left)
        dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        
        //for loop to iterate the grid
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //find the 1st cell with value 1, 
                //dfs to find the other cells of the same island
                //increase the count by 1 (each island)
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j); 
                } 
            }  
        }return count;
    }
    
    //void method to change same islands cells to 0 
    private void dfs (char[][] grid, int i, int j) {
        //base
        //if out of bounds or cell value = 0, return
        if( i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
            
        //logic
        //first make the cell 0 (1st dfs (i,j) from numIslands is made 0 too)
        grid[i][j] = '0';      
        //go to all four neighbors and check if they are 1, if 1 make it 0
        for(int[] dir : dirs) {
            //position of the neighbor cells
            int r = dir[0] + i;
            int c = dir[1] + j;              
            dfs(grid, r, c);
        }
        //after all the cells of island is made 0
        //control is sent back
        //from numIslands another islands first cell is found and this repeats 
        //dfs is called separately for each island 
    }
}



