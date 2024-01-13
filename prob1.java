// Time Complexity : O(m*n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : took some time to get the dfs solution right

// Explain your approach: using dfs, for every grid element that is '1', increase count and go into the depth
// using dirs array

// similar in bfs, use queue and dirs array, for every grid element that is '1', increase count, go to neighbors

public class prob1 {
    int m, n, count;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        count = 0;
        dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        m = grid.length; n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private int dfs(char[][] grid, int i, int j){
        //base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1') return count;
        //logic
        grid[i][j] = '0'; 
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);
        }
        return count;
    }
    
}
/* BFS
 class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int [][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int m = grid.length; int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    q.add(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir: dirs){
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1'){
                                grid[r][c] = '0';
                                q.add(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        return count;
        
    }
}
 */