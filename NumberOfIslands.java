package Nov13;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {
	
    public int numIslands(char[][] grid) {
        
/*
  Time Complexity: O(m*n) where m is number of rows and n is number of columns in image grid.
  Because we will iterate through all the nodes of the given matrix.
  
  Space Complexity: O(min(m,n))
  Because queue will keep getting new elements added as the existing elements of it keep getting removed. At any point of time, the queue will contain at max (min(m,n)) elements. Visualise the same using an array as below:

  ______
  |0  1|
  |1  1| 
  |1  1|
  |1  1| 
  |0  1|
  |1  1|
  |1  1| 
  ______
 
  Did this code successfully run on Leetcode : Yes
 
  Any problem you faced while coding this : No
     
  Approach: 
  BFS approach taken.
                        
*/ 
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    // push coordinates of cell with 1 into queue and mark this cell with some no.other than 0 and 1 to facilitate restoration of array to its input state after the count has been found
                    grid[i][j] = '2';
                    queue.add(new int[]{i,j});
    
                    // pop an element from queue and check all its neighbors if they are 1 or 0
                    // If 1, add to queue. If 0 or 2, do nothing.
                    while (!queue.isEmpty()) {
                        int[] curElem = queue.poll();
                        for (int[] dir: dirs) {
                            int row = curElem[0] + dir[0];
                            int col = curElem[1] + dir[1];
                            if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '1') {
                                grid[row][col] = '2'; 
                                queue.add(new int[]{row,col});
                            }
                        }
                    }  
                }
            }
        }
    
        // resetting the grid to same as input by altering 2->1 as earlier.
          for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '2') {
                    grid[i][j] = '1';
                }
            }
          }
        
        return count;
    }
}
