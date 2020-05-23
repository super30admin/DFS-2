// Time Complexity : O(n) where n is the number of elements in the matrix
// Space Complexity : O(n) (visited matrix) +  O(n) (DFS Recursive stack) = O(n) where n is the number of elements in matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  None
/* Your code here along with comments explaining your approach:  start with the  1's. Maintain a visited matrix, to avoid going there again once visited.
If you find a one, I have reached a island, increment the count, now its my turn to visit that island and complete the tour using dfs. I would be only visiting the 1's since
the island is connected via 1's. As I visit the 1's connected to the island, I mark them in visited. Then the loop will continue to find the next island and I would
tour in the same way.
*/

// DFS 
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){return 0;}
        int count= 0 ;
        boolean[][] visited = new boolean[grid.length][grid[0].length];                     // Visited Matrix to keep a track
        for(int i= 0; i< grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){                            // if I have reached an unvisited island
                    count++;                                                                // Island found => increment the counter
                    dfs(grid, i, j, visited);                                               // Go for a tour via DFS
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i , int j, boolean[][] visited){
        if(i < 0 || j < 0 || i == grid.length ||  j == grid[0].length){return;}
        if(grid[i][j] == '1' && visited[i][j] == false){                                    // Mark the states as visited to avoid visiting again
                visited[i][j] = true;   
                dfs(grid, i+1, j, visited);                                                 // Touring the island in all directions
                dfs(grid, i-1, j, visited);
                dfs(grid, i, j+1, visited);
                dfs(grid, i, j-1, visited);
            }
        }
}

// BFS
class Solution {
    class Pair{                                                                                 // Pair of rows and columns
        int row;
        int col;
        Pair(int r, int c){
            this.row = r;
            this.col = c;
        }
        public int getRow(){ return this.row; }
        public int getCol() { return this.col;}
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){return 0;}                                         // Base Condition
        int count= 0 ;
        int[][] dirs = new int[][]{{0,-1}, {0,1}, {1,0}, {-1,0}};                               // Directions matrix
        Queue<Pair> q = new LinkedList<>();
        for(int m = 0; m < grid.length; m++){
            for(int n = 0; n < grid[0].length; n++){
                if(grid[m][n] == '1'){                                                          // If an island found
                    count++;                                                                     // Count the number of islands
                    grid[m][n] = 0;                                                             // Make the island some arbitary representation to avoid revisit
                    q.add(new Pair(m,n));
                    while(!q.isEmpty()){
                        Pair fetch = q.poll();
                        int r = fetch.getRow();
                        int c = fetch.getCol();
                        for(int[] dir: dirs){
                        int i = r + dir[0];                                                                     // go in updated neighbors
                        int j = c + dir[1];
            if(i >= 0 && j >=0 && i < grid.length && j < grid[0].length && grid[i][j] == '1'){              // Keep touring the island
                          q.add(new Pair(i,j));  
                           grid[i][j] = '0';                                                                // Mark the visited cell as 0 to avoid revisit
                        }
                        }
                    }
                }
            }
        }
            return count;
    }
}