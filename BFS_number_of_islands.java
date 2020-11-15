// Time Complexity : O(m*n), where m is the number of rows and n is the number of columns in the grid (in the worst case O(2m*n))
// Space Complexity :O(m), where m is the minimum of the rows and colmns in the grid (space for the queue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I wanted to know is it ok to use the same letter with different meanings in the time and
                                            //space complexities?? As "m" in the number of rows in the time complexity and in the
                                            //space complexity "m" denotes the minimum of the rows and column.
                                            //Or should I be using different letters?

//Three liner explanation of your approach in plain english
//1. Keep Iterating over the enitre grid till you find 1(land), make it 0 and add it to the queue, also check if any of its 
            //4-neighbours are 1(land), if yes make it 0 and add it to the queue
//2. Continue doing this till the queue is empty, if yes you found 1 island, so increment the count variable
//3. Continue the iteration of the grid to search 1(start of another island) and keep performing the BFS on them. Once the traversal
            //of the grid is finished, return the count variable representing the number of islands

// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {
        
        //rows and columns in the grid
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        //create a queue to store all the neighbours of the current cell that are 1(land)
        Queue<int []> q = new LinkedList<>();
        
        //create a directions array to explore all the neighbours of a cell
        int[][] dirs = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        
        //traverse the entire grid to check for land(1)
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    //start the BFS for the cell instered in the queue
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir : dirs){
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];
                            //if the neighbour is 1(land), add it to the and make it 0
                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c]=='1'){
                                q.add(new int[]{r,c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                    //increment the count once the queue is empty(that is you found 1 island)
                    count++;
                }
            }
        }
        //return the count of islands
        return count;
    }
}