// Time Complexity : O(M*N) M*N-> Size of grid
// Space Complexity : O(N) N-> Queue size/Recursive stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Iterative
class Solution {
    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int res = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    queue.add(new int[]{i,j});
                }
                while(!queue.isEmpty()) {
                    int[] temp = queue.poll();

                    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

                    for(int dir[]: dirs) {
                        int row = temp[0] + dir[0];
                        int col = temp[1] + dir[1];

                        if(row>=0 && row<m && col>=0 && col<n && grid[row][col] == '1') {
                            grid[row][col] = '0';
                            queue.add(new int[]{row,col});
                        }

                    }

                }
            }
        }
        return res;

    }
}

// Recursive
class Solution {
    int res;
    int dirs[][];
    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0)
            return 0;
        res = 0;
        int m = grid.length, n = grid[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return res;
    }
    private void dfs(char[][] grid, int r, int c, int m, int n) {

        if(r<0 || r>= m || c < 0 || c >=n || grid[r][c] !='1')
            return;
        else
            grid[r][c] = '0';

        // logic
        for(int[] dir: dirs) {
            int row = dir[0] + r;
            int col = dir[1] + c;

            dfs(grid, row, col, m, n);
        }
    }
}