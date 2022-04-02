// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)  return 0;
        
        int m = grid.length; 
        int n = grid[0].length;
        
        int[][] directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1} };
        int numIslands = 0;
        
        Queue<int []> queue = new LinkedList<>();
        
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == '1'){ //If cell value is 1 -> Increase islands counter by 1
                    numIslands++;
                    queue.add(new int[]{i,j}); //Add that cell into queue and make is 0
                    grid[i][j] = '0';
                   
                    
                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        
                        for(int[] d : directions){ //Check all 4 neuighbours of cell
                            int row = temp[0] + d[0];
                            int col = temp[1] + d[1];
                            if(row >= 0 && col >= 0 && row < m && col < n && grid[row][col] == '1'){ // If cell is 1
                                queue.add(new int[]{row, col}); //Add indices pair into the queue
                                grid[row][col] = '0'; //THEN MAKE it 0
                            }   
                        }
                    }
                    
                }
            }
        }
        
        return numIslands;
    }
}

/*
//DFS 

// Time Complexity : O[2(m*n)]
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// class Solution {
//     int[][] directions;
//     int m,n;
//     public int numIslands(char[][] grid) {
//         if(grid == null || grid.length == 0)  return 0;
        
//         m = grid.length; 
//         n = grid[0].length;
        
//         directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1} };
//         int numIslands = 0;
//         for(int i = 0; i< m; i++){
//             for(int j = 0; j< n; j++){
//                 if(grid[i][j] == '1'){
//                     numIslands++;
//                     helper(grid, i, j);
//                 }
//             }
//         }
        
//         return numIslands;
//     }
//     public void helper(char[][] grid, int i, int j){
//         //base case
//         if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1')   return;
        
//         grid[i][j] = '0';
//         for(int[] d : directions){
//             int row = i + d[0];
//             int col = j + d[1];
//             helper(grid, row, col);
//         }
//     }
// }


*/