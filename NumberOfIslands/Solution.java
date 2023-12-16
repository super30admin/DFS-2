// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * BFS. Find a '1' and run BFS from that index until all neightbouring 1's are traversed. Turn those 1's to 0's. Repeat this process for the
 * entire matrix.
 */
class Solution {

    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }

            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});
        grid[i][j] = '0';

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            for(int[] dir: dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];

                if(row>=0 && col>=0 && row<m && col<n && grid[row][col] == '1') {
                    grid[row][col] = '0';
                    q.add(new int[]{row, col});
                }
            }
        }
    }
}

/**
 * DFS
 */
// Time Complexity : O(m*n)
// Space Complexity : Leetcode : O(min(m,n)), My analysis: O(m) where m -> rows
/*
class Solution {

    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }

            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {

        for(int[] dir: dirs) {
            int row = i + dir[0];
            int col = j + dir[1];

            if(row>=0 && col>=0 && row<m && col<n && grid[row][col] == '1') {
                grid[row][col] = '0';
                dfs(grid, row, col);
            }
        }
    }
}*/
