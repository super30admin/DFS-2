// Time Complexity : O(n x m)
// Space Complexity : O(n x m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//DFS

class Solution {
    int n;
    int m;
    int[][] dirs;

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j); 
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c){
        grid[r][c] = '0';

        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1'){
                dfs(grid, nr, nc);
            }
        }
    }
}


// BFS

// class Solution {
//     public int numIslands(char[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int count = 0;
//         int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < m; j++){
//                 if(grid[i][j] == '1'){
//                     count++;
//                     Queue<int[]> q = new LinkedList<>();
//                     grid[i][j] = '0';
//                     q.add(new int[]{i, j});
//                     while(!q.isEmpty()){
//                         int[] cell = q.poll();
//                         for(int[] dir : dirs){
//                             int nr = cell[0] + dir[0];
//                             int nc = cell[1] + dir[1];
//                             if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1'){
//                                 grid[nr][nc] = '0';
//                                 q.add(new int[]{nr, nc});
//                             }
//                         }
//                     }
                    
                    
//                 }
//             }
//         }
//         return count;
//     }
// }
