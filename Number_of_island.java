// Time Complexity : O(mxn)
// Space Complexity : O(mxn) : DFS , O(Max 3) BFS since at time max 3 element in queue
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Iterate over grid by choosing first element and trvelling in all 4 direction of that element. mark visited element. 
// Increment count for each patch 
//DFS
// class Solution {
//     int count;
//     int m ,n;
//     int dirs [][];
//     public int numIslands(char[][] grid) {
//         if(grid == null || grid.length == 0){
//             return 0;
//         }

//         dirs = new int [][]{{-1,0}, {1,0},{0,-1},{0,1}}; //U D L R
//         m = grid.length;//row
//         n = grid[0].length;//col

//         for(int i = 0; i<m; i++){
//             for(int j =0; j<n; j++){
//                 if(grid[i][j] == '1')
//                 {
//                     count++;
//                     dfs(grid, i , j);
//                 }
//             }
//         }
//         return count;
//     }
//     private void dfs(char [][] grid, int row, int col){
//         //base
//         if(row < 0 || row == m || col<0 || col == n || grid[row][col] != '1'){
//             return;
//         }

//         //logic
//         grid[row][col] = '2';
//         for (int []dir : dirs){
//             int nr = row + dir[0];
//             int nc = col + dir[1];
//             dfs(grid, nr, nc); 
//         }
//     }
// }

// BFS
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
             return 0;
        }
        int m = grid.length; // row
        int n = grid[0].length; // col
        int count=0;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // U D L R
        
        for(int i = 0; i<m; i++){
             for(int j =0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i,j});
                    grid[i][j] = '2';

                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int []dir : dirs){
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];
                            if(nr>=0 && nr <m && nc>=0 && nc < n && grid[nr][nc] == '1'){
                                q.add(new int[]{nr,nc});
                                grid[nr][nc] = '2';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}