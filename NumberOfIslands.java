// TC- O(n), SC - O(n)

// Using DFS;

class Solution {
    public int numIslands(char[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0){
            return 0;
        }
        // calculating rows and cols of grid
        int rows = grid.length;
        int cols = grid[0].length;
        // Initializing ct of num of islands to 0
        int numIslands = 0;
        // Iterating through each element in grid
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                // If current val in grid is 1 we call dfs function and increment ct else continue
                if(grid[i][j] == '1'){
                    numIslands++;
                    numIslands(grid, i, j, rows, cols);
                }
            }
        }
        return numIslands;
    }
    
    private void numIslands(char[][] grid, int row, int col, int rows, int cols){
        // check out of bounds if grid current val is 0, just return, we dont need to visit
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0'){
            return;
        }
        // chnage the current val of grid to 0 and call dfs function for all the 4 directions.
        grid[row][col] = '0';
        numIslands(grid, row+1, col, rows, cols);
        numIslands(grid, row-1, col, rows, cols);
        numIslands(grid, row, col+1, rows, cols);
        numIslands(grid, row, col-1, rows, cols);
        return;
    }
}


// Using BFS

// class Solution {
//     public int numIslands(char[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int ct = 0;
//         int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
//         Queue<Pair<Integer, Integer>> q = new LinkedList<>();
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(grid[i][j] == '1'){
//                     ct++;
//                     grid[i][j] = '0';
//                     q.add(new Pair<Integer, Integer>(i, j));
//                     while(!q.isEmpty()){
//                         Pair<Integer, Integer> pair = q.remove();
//                         int rowIdx = pair.getKey();
//                         int colIdx = pair.getValue();
//                         for(int[] dir : dirs){
//                             int newRowIdx = rowIdx + dir[0];
//                             int newColIdx = colIdx + dir[1];
//                             if(newRowIdx >=0 && newRowIdx < m && newColIdx >= 0 && newColIdx < n && grid[newRowIdx][newColIdx] == '1'){
//                                 grid[newRowIdx][newColIdx] = '0';
//                                 q.add(new Pair<Integer, Integer>(newRowIdx, newColIdx));
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return ct;
//     }
// }
