//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
// m = rows for grid, n = columns of grid.
/* Approach : To get count of 1's with sorounding 0's we are going to traverse through the grid.
And check if the cell is 1 then it will be marked as 0 to indicate it is counted and also its neighbouring cells
with 1 will be marked as 0 until we hit a cell with 0. Everytime we hit 1 for first time after a 0 we simply increment
the count.
 */

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;                                          // Initializing count variable to track how many 1's are present
        if(grid == null || grid.length == 0 ) return count;     // checking if grid is empty
        int m = grid.length;                                    // grid's row length
        int n = grid[0].length;                                 // grid's column length
        int [][] directions = {{0,1},{0,-1},{-1,0},{1,0}};      // to traverse in all directions to find 1's in grid

        for(int i=0; i<m; i++){                                 // traverse over grid's row length
            for(int j=0; j<n; j++){                             // traverse over grid's column length
                if(grid[i][j] == '1'){                          // check for cell which is 1
                    count++;                                    // count is incremented whenever cell with 1 is found.
                    Queue<Integer> q = new LinkedList<>();      // initializing of queue
                    q.add(i);                                   // add row index to queue
                    q.add(j);                                   // add column index to queue
                    grid[i][j] = '0';                           // update to cell to 0 inorder indicate it is counted.
                    while(!q.isEmpty()){                        // validate if queue is not empty
                        int cr = q.poll();                      // get current row index out of queue
                        int cc = q.poll();                      // get current column index out of queue
                        for(int [] dir : directions){           // traverse over directions to get neighbouring cells with value 1
                            int nr = cr + dir[0];               // get neighbouring row by incrmenting directions with current row
                            int nc = cc + dir[1];               // get neighbouring column by incrmenting directions with current column
                            if(nr >=0 && nc >= 0 && nr < m      // validate if neghibouring row and columns are in bounds of grid also the cell is 1
                            && nc < n && grid[nr][nc] == '1'){
                                q.add(nr);                      // add the neighbouring row to queue
                                q.add(nc);                      // add the neighbouring column to queue
                                grid[nr][nc] = '0';             // update to neighbouirng cell to 0 inorder indicate it is counted.
                            }
                        }
                    }
                }
            }
        }
        return count;                                           // return count of 1's 
    }
}