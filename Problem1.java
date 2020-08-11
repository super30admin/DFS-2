// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.LinkedList;
import java.util.Queue;
// Your code here along with comments explaining your approach
// Approach 1: Using DFS
// Time Complexity : O(2*nm) = O(nm)
//      n: number of rows
//      m: number of columns
//    Worst case the entire matrix is filled with 1s. 2nd time you just need to check if any 1s left.
// Space Complexity : O(h) = O(nm)
//      n: number of rows
//      m: number of columns
//      h: height of the tree
//    Worst case the entire matrix is filled with 1s so entire matrix is recursive stack
class Problem1S1 {
    
    // global 
    char[][] grid;
    int[][] neighbors;
    int n, m;

    /** find number of islands */
    public int numIslands(char[][] grid) { 
        int result = 0;

        // edge case
        if(grid != null && grid.length != 0){
            
            // initialize
            n = grid.length;
            m = grid[0].length;
            this.grid = grid;
            //  left, right, up, down
            neighbors = new int[][] {{0,-1}, {0,1}, {-1, 0},{1, 0}};
            
            // iterate all the elements
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){ 
                    // value is 1
                    if(grid[i][j] == '1'){
                        // increase count and mark 1s -> 0s
                        result++;
                        depthFirst(i,j);
                    }
                }
            }
            
        }
        //return result
        return result;
    }
    /** DFS traversal We mark processed nodes as 0s so we don't require visited*/
    private void depthFirst(int i, int j){
        // no base case as we handling it before calling
        grid[i][j] = '0';
        // iterate all neighbors
        for(int[] neighbor: neighbors){
            int row = i + neighbor[0];
            int col = j + neighbor[1];

            // check in bound and value is 1
            if(row >= 0 && row< n && col>=0 && col < m && grid[row][col]== '1')
                depthFirst(row, col);
        }
    }
}

// Your code here along with comments explaining your approach
// Approach 1: Using BFS
// Time Complexity : O(2*nm) = O(nm)
//      n: number of rows
//      m: number of columns
//    Worst case the entire matrix is filled with 1s. 2nd time you just need to check if any 1s left.
// Space Complexity : O(w) = O(min(n, m))
//      n: number of rows
//      m: number of columns
//      w: width of the tree
//    Worst case the entire matrix is filled with 1s.
// Note: Make sure to process the location and then add to queue otherwise duplicate entries.
class Problem1S2 {

    // global
    int n, m;
    char[][] grid;
    int[][] neighbors;

    /** find number of islands */
    public int numIslands(char[][] grid) { 
        int result = 0;

        // edge case
        if(grid != null && grid.length != 0){
            
            // initilaize
            n = grid.length;
            m = grid[0].length;
            this.grid = grid;
           
            //  left, right, up, down
            neighbors = new int[][] {{0,-1}, {0, 1}, {-1, 0},{1, 0}};
            Queue<int[]> myQueue = new LinkedList<>();
            
            // iterate all the elements
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){ 
                    // value is 1
                    if(grid[i][j] == '1'){
                        // increase count and mark 1s -> 0s
                        result++;
                        // process and then add to queue
                        grid[i][j] = '0';
                        myQueue.add(new int[] {i, j});
                        
                        // do bfs
                        breadthFirst(myQueue);
                    }
                }
            }
            
        }
        //return result
        return result;
    }
    
    /** BFS traversal */
    private void breadthFirst(Queue<int[]> myQueue){
        // in level order
        while(!myQueue.isEmpty()){

            int[] current = myQueue.poll();
            // iterate all the neighbors
            for(int[] neighbor: neighbors){
                int row = current[0] + neighbor[0];
                int col = current[1] + neighbor[1];

                // check in bound and value is 1
                if(row >= 0 && row< n && col>=0 && col < m && grid[row][col]== '1'){
                    // process and then add to queue
                    grid[row][col] = '0';
                    myQueue.add(new int[]{row, col});
                }
            }
        }
    }
    
}